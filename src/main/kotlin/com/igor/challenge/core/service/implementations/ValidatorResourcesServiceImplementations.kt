package com.igor.challenge.core.service.implementations

import com.igor.challenge.core.entities.DataTransferRequestPassword
import com.igor.challenge.core.entities.DataTransferResponsePassword
import com.igor.challenge.core.entities.ValidatorStatus
import com.igor.challenge.core.factory.ValidatorFactory
import com.igor.challenge.core.service.ValidatorResourcesService
import com.igor.challenge.core.utils.RulesType
import org.springframework.stereotype.Service

@Service
class ValidatorResourcesServiceImplementations : ValidatorResourcesService {
    override fun executeValidatorPasswordAndFilter(password: DataTransferRequestPassword): DataTransferResponsePassword {

        val validatorDetails: MutableList<ValidatorStatus> = mutableListOf(
                ValidatorFactory.createValidator(RulesType.BLANK_SPACE).executeRule(password.password),
                ValidatorFactory.createValidator(RulesType.EMPTY).executeRule(password.password),
                ValidatorFactory.createValidator(RulesType.LOWER_CASE_CHARACTERS).executeRule(password.password),
                ValidatorFactory.createValidator(RulesType.MINIMUM_CHARACTERS).executeRule(password.password),
                ValidatorFactory.createValidator(RulesType.REPETEABLE_CHARACTERS).executeRule(password.password),
                ValidatorFactory.createValidator(RulesType.CONTAINS_SPECIAL_CHARACTERS).executeRule(password.password),
                ValidatorFactory.createValidator(RulesType.UPPER_CASE_CHARACTERS).executeRule(password.password)
        )

        val validatorDetailsFilterInconsistencies = validatorDetails
                .filter { !it.isValid }
                .map { it.message }.toMutableList()

        return DataTransferResponsePassword(password.password, !validatorDetailsFilterInconsistencies.any(), validatorDetailsFilterInconsistencies)

    }
}