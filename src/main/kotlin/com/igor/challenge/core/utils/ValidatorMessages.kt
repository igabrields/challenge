package com.igor.challenge.core.utils

class ValidatorMessages {
    companion object {
        const val MININUM_CHARACTERS_REQUIRED = "A senha deve conter nove ou mais caracteres"
        const val LOWER_CASE_CHARACTERS_REQUIRED  ="A senha deve conter ao menos 1 letra minúscula"
        const val UPPER_CASE_CHARACTERS_REQUIRED = "A senha deve conter ao menos 1 letra maiúscula"
        const val SPECIAL_CHARACTERS_REQUIRED = "A senha deve conter ao menos 1 caractere especial: !@#$%^&*()-+"
        const val NON_REPEATABLE_CHARACTERS_REQUIRED = "A senha não deve conter caracteres repetidos"
        const val NON_EMPTY_CHARACTERS_REQUIRED = "A senha não pode conter espaços em branco"
        const val NON_EMPTY_REQUIRED = "A senha deve conter ao menos um dígito"

        const val NON_VALIDATION_ERROR_FOUND = "Validação não encontrou erros"
    }
}