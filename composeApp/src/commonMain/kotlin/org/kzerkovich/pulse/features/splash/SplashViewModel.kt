package org.kzerkovich.pulse.features.splash

import org.kzerkovich.pulse.base.BaseViewModel
import org.kzerkovich.pulse.features.login.domain.IsUserAuthorizedUseCase
import org.kzerkovich.pulse.features.splash.models.SplashAction

class SplashViewModel(
    private val isUserAuthorizedUseCase: IsUserAuthorizedUseCase = IsUserAuthorizedUseCase()
) : BaseViewModel<Unit, SplashAction, Unit>(initialState = Unit) {

    init {
        checkUserAuthorized()
    }

    override fun obtainEvent(viewEvent: Unit) {

    }

    private fun checkUserAuthorized() {
        viewAction = if (isUserAuthorizedUseCase.execute()) {
            SplashAction.ShowMainScreen
        } else {
            SplashAction.ShowLoginScreen
        }
    }
}