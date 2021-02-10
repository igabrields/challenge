package com.igor.challenge.core.service.implementations

import com.igor.challenge.core.entities.ValidatorStatus
import com.igor.challenge.core.service.ApplyRulesPassword
import com.igor.challenge.core.utils.ValidatorMessages

class EmptyRule : ApplyRulesPassword {
    override fun executeRule(password: String): ValidatorStatus {
        return if(password.isEmpty())
            ValidatorStatus(ValidatorMessages.NON_EMPTY_REQUIRED, isValid = false)
        else
            ValidatorStatus(isValid = true)
    }
}