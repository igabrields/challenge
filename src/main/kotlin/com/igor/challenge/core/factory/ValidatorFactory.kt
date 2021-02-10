package com.igor.challenge.core.factory

import com.igor.challenge.core.service.ApplyRulesPassword
import com.igor.challenge.core.service.implementations.*
import com.igor.challenge.core.utils.RulesType

class ValidatorFactory {
    companion object {
        fun createValidator(rulesType: RulesType): ApplyRulesPassword {
            return when (rulesType) {
                RulesType.EMPTY -> EmptyRule()
                RulesType.BLANK_SPACE -> BlankSpaceRule()
                RulesType.MINIMUM_CHARACTERS -> MinumumCharacterRule()
                RulesType.REPETEABLE_CHARACTERS -> RepeatableCharacterRule()
                RulesType.CONTAINS_SPECIAL_CHARACTERS -> SpecialCharacterRule()
                RulesType.LOWER_CASE_CHARACTERS -> LowerCaseCharacterRule()
                RulesType.UPPER_CASE_CHARACTERS -> UpperCaseCharacterRule()
            }
        }
    }
}