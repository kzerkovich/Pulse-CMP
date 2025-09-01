package org.kzerkovich.pulse.features.login.models

sealed class LoginAction {
    data object OpenMainScreen : LoginAction()
}