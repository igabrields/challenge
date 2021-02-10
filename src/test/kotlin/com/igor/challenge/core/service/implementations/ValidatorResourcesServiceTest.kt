package com.igor.challenge.core.service.implementations

import com.igor.challenge.core.entities.DataTransferRequestPassword
import com.igor.challenge.core.service.ValidatorResourcesService
import com.igor.challenge.core.utils.ValidatorMessages
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class ValidatorResourcesServiceTest {

    @Autowired
    private lateinit var service: ValidatorResourcesService

    @Test
    fun blankSpaceRuleTest() {
        val password: DataTransferRequestPassword = DataTransferRequestPassword(
                password = "AbTp9 fok"
        )
        val responseValidation = service.validatePasswordAndFilter(password)
        assertFalse(responseValidation.isValid)
        assertTrue(responseValidation.inconsistencies.filter { it.equals(ValidatorMessages.NON_EMPTY_CHARACTERS_REQUIRED) }.any())
    }

    @Test
    fun emptyRuleTest() {
        val password: DataTransferRequestPassword = DataTransferRequestPassword(
                password = ""
        )
        val responseValidation = service.validatePasswordAndFilter(password)
        assertFalse(responseValidation.isValid)
        assertTrue(responseValidation.inconsistencies.filter { it.equals(ValidatorMessages.NON_EMPTY_REQUIRED) }.any())
    }

    @Test
    fun lowerCaseCharacterRuleTest() {
        val password: DataTransferRequestPassword = DataTransferRequestPassword(
                password = "ABT9FOKW!"
        )
        val responseValidation = service.validatePasswordAndFilter(password)
        assertFalse(responseValidation.isValid)
        assertTrue(responseValidation.inconsistencies.filter { it.equals(ValidatorMessages.LOWER_CASE_CHARACTERS_REQUIRED) }.any())
    }

    @Test
    fun minumumCharacterRuleTest() {
        val password: DataTransferRequestPassword = DataTransferRequestPassword(
                password = "AAAbbbC!"
        )
        val responseValidation = service.validatePasswordAndFilter(password)
        assertFalse(responseValidation.isValid)
        assertTrue(responseValidation.inconsistencies.filter { it.equals(ValidatorMessages.MININUM_CHARACTERS_REQUIRED) }.any())
    }

    @Test
    fun repeatableCharacterRuleTest() {
        val password: DataTransferRequestPassword = DataTransferRequestPassword(
                password = "AAAbbbC!w"
        )
        val responseValidation = service.validatePasswordAndFilter(password)
        assertFalse(responseValidation.isValid)
        assertTrue(responseValidation.inconsistencies.filter { it.equals(ValidatorMessages.NON_REPEATABLE_CHARACTERS_REQUIRED) }.any())
    }

    @Test
    fun specialCharacterRuleTest() {
        val password: DataTransferRequestPassword = DataTransferRequestPassword(
                password = "AAAbbbCc"
        )
        val responseValidation = service.validatePasswordAndFilter(password)
        assertFalse(responseValidation.isValid)
        assertTrue(responseValidation.inconsistencies.filter { it.equals(ValidatorMessages.SPECIAL_CHARACTERS_REQUIRED) }.any())
    }

    @Test
    fun upperCaseCharacterRuleTest() {
        val password: DataTransferRequestPassword = DataTransferRequestPassword(
                password = "aaabbbcc!"
        )
        val responseValidation = service.validatePasswordAndFilter(password)
        assertFalse(responseValidation.isValid)
        assertTrue(responseValidation.inconsistencies.filter { it.equals(ValidatorMessages.UPPER_CASE_CHARACTERS_REQUIRED) }.any())
    }
}
