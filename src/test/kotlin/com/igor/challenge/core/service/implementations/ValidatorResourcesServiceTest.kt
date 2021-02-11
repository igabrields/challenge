package com.igor.challenge.core.service.implementations

import com.igor.challenge.core.entities.DataTransferRequestPassword
import com.igor.challenge.core.factory.ValidatorFactory
import com.igor.challenge.core.service.ValidatorResourcesService
import com.igor.challenge.core.utils.RulesType
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
    fun executeValidatorPasswordAndFilterTest() {

        val password: DataTransferRequestPassword = DataTransferRequestPassword(
                password = "ABT9FOKW!"
        )
        val responseValidation = service.executeValidatorPasswordAndFilter(password)
        assertFalse(responseValidation.isValid)
        assertTrue(responseValidation.inconsistencies.filter { it.equals(ValidatorMessages.LOWER_CASE_CHARACTERS_REQUIRED) }.any())

    }

    @Test
    fun blankSpaceRuleTest() {

        val validationStatus = ValidatorFactory
                .createValidator(RulesType.BLANK_SPACE)
                .executeRule("AbTp9 fok")

        assertFalse(validationStatus.isValid)
        assertTrue(validationStatus.message == ValidatorMessages.NON_EMPTY_CHARACTERS_REQUIRED)

    }

    @Test
    fun emptyRuleTest() {

        val validationStatus = ValidatorFactory
                .createValidator(RulesType.EMPTY)
                .executeRule("")

        assertFalse(validationStatus.isValid)
        assertTrue(validationStatus.message == ValidatorMessages.NON_EMPTY_REQUIRED)

    }

    @Test
    fun lowerCaseCharacterRuleTest() {

        val validationStatus = ValidatorFactory
                .createValidator(RulesType.LOWER_CASE_CHARACTERS)
                .executeRule("ABT9FOKW!")

        assertFalse(validationStatus.isValid)
        assertTrue(validationStatus.message == ValidatorMessages.LOWER_CASE_CHARACTERS_REQUIRED)

    }

    @Test
    fun minumumCharacterRuleTest() {

        val validationStatus = ValidatorFactory
                .createValidator(RulesType.MINIMUM_CHARACTERS)
                .executeRule("AAAbbbC!")

        assertFalse(validationStatus.isValid)
        assertTrue(validationStatus.message == ValidatorMessages.MININUM_CHARACTERS_REQUIRED)

    }

    @Test
    fun repeatableCharacterRuleTest() {

        val validationStatus = ValidatorFactory
                .createValidator(RulesType.REPETEABLE_CHARACTERS)
                .executeRule("AAAbbbC!w")

        assertFalse(validationStatus.isValid)
        assertTrue(validationStatus.message == ValidatorMessages.NON_REPEATABLE_CHARACTERS_REQUIRED)

    }

    @Test
    fun specialCharacterRuleTest() {

        val validationStatus = ValidatorFactory
                .createValidator(RulesType.CONTAINS_SPECIAL_CHARACTERS)
                .executeRule("AAAbbbCc")

        assertFalse(validationStatus.isValid)
        assertTrue(validationStatus.message == ValidatorMessages.SPECIAL_CHARACTERS_REQUIRED)

    }

    @Test
    fun upperCaseCharacterRuleTest() {

        val validationStatus = ValidatorFactory
                .createValidator(RulesType.UPPER_CASE_CHARACTERS)
                .executeRule("aaabbbcc")

        assertFalse(validationStatus.isValid)
        assertTrue(validationStatus.message == ValidatorMessages.UPPER_CASE_CHARACTERS_REQUIRED)

    }
}
