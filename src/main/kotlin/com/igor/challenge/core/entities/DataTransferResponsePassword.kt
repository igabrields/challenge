package com.igor.challenge.core.entities

data class DataTransferResponsePassword(
        val password: String, override var isValid: Boolean, val inconsistencies: MutableList<String>
) : Status