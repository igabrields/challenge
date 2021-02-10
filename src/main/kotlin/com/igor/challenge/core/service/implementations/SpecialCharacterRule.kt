package com.igor.challenge.core.service.implementations

import com.igor.challenge.core.entities.ValidatorStatus
import com.igor.challenge.core.service.ApplyRulesPassword
import com.igor.challenge.core.utils.ValidatorMessages
import com.igor.challenge.core.utils.containsSpecialCharacters

class SpecialCharacterRule : ApplyRulesPassword {

    companion object {
        const val SPECIAL_CHARACTERS: String = "!@#\$%^&*()-+"
    }

    override fun executeRule(password: String): ValidatorStatus {
        return if(SPECIAL_CHARACTERS.containsSpecialCharacters(password))
            ValidatorStatus( isValid = true)
        else
            ValidatorStatus(ValidatorMessages.SPECIAL_CHARACTERS_REQUIRED, isValid = false)
    }

}

