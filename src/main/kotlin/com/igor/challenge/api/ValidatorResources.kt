package com.igor.challenge.api

import com.igor.challenge.core.entities.DataTransferRequestPassword
import com.igor.challenge.core.entities.DataTransferResponsePassword
import com.igor.challenge.core.service.ValidatorResourcesService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/validator")
class ValidatorResources(val service: ValidatorResourcesService)  {

    @PostMapping("/password")
    fun validatePassword(@RequestBody value: DataTransferRequestPassword): ResponseEntity<DataTransferResponsePassword>
            = ResponseEntity.ok(service.executeValidatorPasswordAndFilter(value))
}