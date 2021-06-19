import android.content.Context
import android.content.Intent
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SdkSuppress
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@SdkSuppress(minSdkVersion = 18)
class UIAutomatorTest {

    private val uiDevice: UiDevice =
        UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())

    private val context = ApplicationProvider.getApplicationContext<Context>()

    private val packageName = context.packageName

    /**
     * Pixel 2 API 23 *

    uiDevice.pressHome()

    val allAppsButton: UiObject = uiDevice.findObject(UiSelector().description("Apps"))
    allAppsButton.clickAndWaitForNewWindow()

    val appViews = UiScrollable(UiSelector().scrollable(true))

    val testApp = appViews.getChildByText(
    UiSelector().className(TextView::class.java.name), "Tests")

    testApp.clickAndWaitForNewWindow()

     */
    //Запускаем наше приложение и чистим бэкстек нашего приложения
    @Before
    fun test_OpenApp() {
        uiDevice.pressHome()
        val intent = context.packageManager
            .getLaunchIntentForPackage(packageName)
            ?.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)

        context.startActivity(intent)
        uiDevice.wait(Until.hasObject(By.pkg(packageName).depth(0)), TIMEOUT)
    }

    //Убеждаемся, что именно наше приложение открыто
    @Test
    fun test_packageName() {
        val testValidation = uiDevice.findObject(UiSelector().packageName(packageName))
        Assert.assertTrue(testValidation.exists())
    }

    //Поиск searchEditText на экране и проверить его на null при запуске
    @Test
    fun test_MainActivityIsStarted() {
        val editText = uiDevice.findObject(By.res(packageName, "searchEditText"))
        Assert.assertNotNull(editText)
    }

    //Убеждаемся, что поиск работает как ожидается
    @Test
    fun test_SearchIsPositive() {
        val editText = uiDevice.findObject(By.res(packageName, "searchEditText"))


        editText.text = "UiAutomator"

        val buttonSearch = uiDevice.findObject(By.res(packageName, "button_search"))
        buttonSearch.click()

        val changedText = uiDevice.wait(
            Until.findObject(By.res(packageName, "totalCountTextView")), TIMEOUT)

        val totalCount = changedText.text.toString()
        Assert.assertEquals(totalCount, NUMBER_OF_RESULTS)
    }

    //Убеждаемся, что при пустом searchEditText поле totalCountTextView не отображается после нажатия на button_search
    @Test
    fun test_TotalCountTextView_InvisibleAfterSearchButtonPressed_IfSearchEditTextEmpty() {
        val searchButton = uiDevice.findObject(By.res(packageName, "button_search"))
        searchButton.click()

        val totalCountTextView = uiDevice.wait(
            Until.findObject(By.res(packageName, "totalCountTextView")),TIMEOUT)

        Assert.assertNull(totalCountTextView)
    }

    //Убеждаемся, что DetailsScreen открывается
    @Test
    fun test_OpenDetailsScreen() {
        val toDetails = uiDevice.findObject(By.res(packageName, "toDetailsActivityButton"))

        toDetails.click()

        val changedText = uiDevice.wait(
            Until.findObject(By.res(packageName, "detailsTotalCountTextView")), TIMEOUT)

        Assert.assertEquals(changedText.text, "Number of results: 0")
    }

    //Убеждаемся, что DetailsScreen отображает верное количество репозиториев
    @Test
    fun test_DetailsTotalCountTextView_DisplaysCorrectCount() {
        val editText = uiDevice.findObject(By.res(packageName, "searchEditText"))
        editText.text = "UiAutomator"

        val searchButton = uiDevice.findObject(By.res(packageName, "button_search"))
        searchButton.click()

        val mainPageTextView = uiDevice.wait(
            Until.findObject(By.res(packageName, "totalCountTextView")), TIMEOUT)

        val mainPageCount = mainPageTextView.text.toString()

        val toDetails = uiDevice.findObject(By.res(packageName, "toDetailsActivityButton"))
        toDetails.click()

        val detailsPageTextView = uiDevice.wait(
            Until.findObject(By.res(packageName, "detailsTotalCountTextView")), TIMEOUT)

        val detailsPageCount = detailsPageTextView.text.toString()
        Assert.assertEquals(detailsPageCount, mainPageCount)
    }

    //Убеждаемся, что DetailsScreen incrementButton увличивает значение detailsTotalCountTextView
    @Test
    fun test_IncrementButton_IncrementDetailsTotalCountTextView() {
        val toDetails = uiDevice.findObject(By.res(packageName, "toDetailsActivityButton"))
        toDetails.click()

        val detailsPageTextView = uiDevice.wait(Until.findObject(By.res(packageName, "detailsTotalCountTextView")),
            TIMEOUT)
        val incrementButton = uiDevice.findObject(By.res(packageName, "incrementButton"))

        repeat((0.rangeTo(4)).count()) {
            incrementButton.click()
        }
        Assert.assertEquals(detailsPageTextView.text.toString(), "Number of results: 5")
    }

    //Убеждаемся, что DetailsScreen decrementButton уменьшает значение detailsTotalCountTextView
    @Test
    fun test_DecrementButton_DecrementDetailsTotalCountTextView() {
        val toDetails = uiDevice.findObject(By.res(packageName, "toDetailsActivityButton"))

        toDetails.click()

        val detailsPageTextView = uiDevice.wait(
            Until.findObject(By.res(packageName, "detailsTotalCountTextView")), TIMEOUT
        )

        val decrementButton = uiDevice.findObject(By.res(packageName, "decrementButton"))

        repeat(0.rangeTo(4).count()) {
            decrementButton.click()
        }

        Assert.assertEquals(detailsPageTextView.text.toString(), "Number of results: -5")
    }

    companion object {
        private const val TIMEOUT = 5000L
        private const val NUMBER_OF_RESULTS = "Number of results: 673"
    }

}