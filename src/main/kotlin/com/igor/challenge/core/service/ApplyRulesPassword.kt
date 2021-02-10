package com.igor.challenge.core.service

import com.igor.challenge.core.entities.ValidatorStatus

interface ApplyRulesPassword {
    fun executeRule(password: String) : ValidatorStatus
}