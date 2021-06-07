package com.geekbrains.myfirsttests

class SomeClass {

    var nullString: String? = null

    var array1 = arrayOf("String1", "String2", "String3")
    var array2 = arrayOf("String1", "String2", "String3")

    fun getKey(key: Int) {
        array1[key]
    }

    fun getString(): String? {
        return nullString
    }

}
