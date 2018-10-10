package com.newsapp.ui.main.detail.validator

import com.newsapp.ui.validator.Validator

class MinLengthValidator(private val value: String) : Validator {

    override fun isValid() = value.count() > 3
}
