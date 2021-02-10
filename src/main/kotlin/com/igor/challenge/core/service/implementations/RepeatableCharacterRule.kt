package com.igor.challenge.core.service.implementations

import com.igor.challenge.core.entities.ValidatorStatus
import com.igor.challenge.core.service.ApplyRulesPassword
import com.igor.challenge.core.utils.ValidatorMessages
import com.igor.challenge.core.utils.allUnique

class RepeatableCharacterRule  : ApplyRulesPassword {
    override fun executeRule(password: String): ValidatorStatus {
        return if(password.allUnique())
            ValidatorStatus(isValid = true)
        else
            ValidatorStatus(ValidatorMessages.NON_REPEATABLE_CHARACTERS_REQUIRED, isValid = false)
    }
}