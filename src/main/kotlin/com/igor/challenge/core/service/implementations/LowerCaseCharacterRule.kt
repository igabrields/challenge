package com.igor.challenge.core.service.implementations

import com.igor.challenge.core.entities.ValidatorStatus
import com.igor.challenge.core.service.ApplyRulesPassword
import com.igor.challenge.core.utils.ValidatorMessages
import com.igor.challenge.core.utils.containsLowerCaseCharacters

class LowerCaseCharacterRule : ApplyRulesPassword {
    override fun executeRule(password: String): ValidatorStatus {
        return if(password.containsLowerCaseCharacters())
            ValidatorStatus(isValid = true)
        else
            ValidatorStatus(ValidatorMessages.LOWER_CASE_CHARACTERS_REQUIRED, isValid = false)
    }
}