package org.kzerkovich.pulse.features.login

import org.kzerkovich.pulse.base.BaseViewModel
import org.kzerkovich.pulse.features.login.models.LoginAction
import org.kzerkovich.pulse.features.login.models.LoginEvent
import org.kzerkovich.pulse.features.login.models.LoginViewState

class LoginViewModel :
    BaseViewModel<LoginViewState, LoginAction, LoginEvent>(initialState = LoginViewState()) {

    override fun obtainEvent(viewEvent: LoginEvent) {
        when (viewEvent) {
            is LoginEvent.EmailChanged -> viewState = viewState.copy(emailValue = viewEvent.newValue)
            is LoginEvent.PasswordChanged -> viewState = viewState.copy(passwordValue = viewEvent.newValue)
        }
    }

}