package com.igor.challenge.core.service

import com.igor.challenge.core.entities.DataTransferRequestPassword
import com.igor.challenge.core.entities.DataTransferResponsePassword

interface ValidatorResourcesService {
    fun executeValidatorPasswordAndFilter(password: DataTransferRequestPassword) : DataTransferResponsePassword
}