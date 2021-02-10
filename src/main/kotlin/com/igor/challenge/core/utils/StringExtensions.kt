package com.igor.challenge.core.utils

fun String.containsLowerCaseCharacters() : Boolean {
    var containsLowerCase = false
    this.toCharArray().forEach {
        if(it.isLowerCase()) {
            containsLowerCase = true
            return containsLowerCase
        }
    }
    return containsLowerCase
}

fun String.containsSpecialCharacters(password: String) : Boolean {
    var containsSpecialCharacter = false
    this.toCharArray().forEach {
        if(password.contains(it)) {
            containsSpecialCharacter = true
            return containsSpecialCharacter
        }
    }
    return containsSpecialCharacter
}

fun String.containsUpperCaseCharacters() : Boolean {
    var containsUpperCase = false
    this.toCharArray().forEach {
        if(it.isUpperCase()) {
            containsUpperCase = true
            return containsUpperCase
        }
    }
    return containsUpperCase
}

fun String.allUnique(): Boolean = all(hashSetOf<Char>()::add)



