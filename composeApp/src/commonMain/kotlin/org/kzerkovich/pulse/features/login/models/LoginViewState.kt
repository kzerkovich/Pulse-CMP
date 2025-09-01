package org.kzerkovich.pulse.features.login.models

data class LoginViewState(
    val emailValue: String = "",
    val passwordValue: String = "",
    val isSending: Boolean = false
)