package com.igor.challenge.core.entities

import com.igor.challenge.core.utils.ValidatorMessages

data class ValidatorStatus(val message: String = ValidatorMessages.NON_VALIDATION_ERROR_FOUND, override var isValid: Boolean) : Status