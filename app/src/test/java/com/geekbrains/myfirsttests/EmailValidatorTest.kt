package com.geekbrains.myfirsttests

import org.junit.Assert.*
import org.junit.Test

class EmailValidatorTest {

    val sm = SomeClass()

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator.isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail(null))
    }

    //task1

    @Test
    fun emailValidator_EmptyDomainAndInvalidPoint_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("mail@...com"))
    }

    @Test
    fun emailValidator_InvalidPoint_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("mail@mail..com"))
    }

    @Test
    fun emailValidator_NoneDogAndSpace_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name mail.com"))
    }

    @Test
    fun emailValidator_WithSpace_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name mail@mail.com"))
    }

    //task 3

    @Test
    fun emailValidator_CorrectEmail_ReturnNotNull(){
        assertNotNull(EmailValidator.isValidEmail("name@email.com"))
    }

    @Test
    fun emailValidator_IncorrectEmail_ReturnNull(){
        assertNull(sm.getString())
    }

    @Test
    fun emailValidator_EqualsEmail_ReturnTrue(){
        assertEquals(EmailValidator.isValidEmail(null), EmailValidator.isValidEmail(null))
    }

    @Test
    fun emailValidator_NotEqualsEmail_ReturnTrue(){
        assertNotEquals(EmailValidator.isValidEmail(null),EmailValidator.isValidEmail("name@mail.com"))
    }

    @Test
    fun emailValidator_ArrayEqualsEmail_ReturnTrue(){
        assertArrayEquals(sm.array1, sm.array2)
    }

    @Test
    fun emailValidator_SameEmail_ReturnTrue(){
        assertSame(sm.getKey(1), sm.getKey(1))
    }

    @Test
    fun emailValidator_NotSameEmail_ReturnTrue(){
        assertNotSame(sm.getKey(1), sm.getKey(2))
    }

}
