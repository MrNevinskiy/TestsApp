package com.geekbrains.myfirsttests

import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class EmailValidatorTest {

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

    @Test
    fun emailValidator_EmptyDomain_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("mail@...com"))
    }

    @Test
    fun emailValidator_NullDomain_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("mail@mail..com"))
    }

    @Test
    fun emailValidator_NoneDog_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name mail.com"))
    }

    @Test
    fun emailValidator_WithSpace_ReturnsFalse() {
        assertFalse(EmailValidator.isValidEmail("name mail@mail.com"))
    }
}
