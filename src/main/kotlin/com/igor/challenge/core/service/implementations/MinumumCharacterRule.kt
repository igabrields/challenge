package com.igor.challenge.core.service.implementations

import com.igor.challenge.core.entities.ValidatorStatus
import com.igor.challenge.core.service.ApplyRulesPassword
import com.igor.challenge.core.utils.ValidatorMessages

class MinumumCharacterRule : ApplyRulesPassword {
    override fun executeRule(password: String): ValidatorStatus {
        return if(password.length < 9)
            ValidatorStatus(ValidatorMessages.MININUM_CHARACTERS_REQUIRED, isValid = false)
        else
            ValidatorStatus(isValid = true)
    }
}