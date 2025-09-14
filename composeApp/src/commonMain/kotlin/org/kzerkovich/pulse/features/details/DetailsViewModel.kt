package org.kzerkovich.pulse.features.details

import org.kzerkovich.pulse.base.BaseViewModel
import org.kzerkovich.pulse.features.details.models.DetailsAction
import org.kzerkovich.pulse.features.details.models.DetailsEvent
import org.kzerkovich.pulse.features.details.models.DetailsViewState

class DetailsViewModel : BaseViewModel<DetailsViewState, DetailsAction, DetailsEvent>
    (initialState = DetailsViewState()){
    override fun obtainEvent(viewEvent: DetailsEvent) {

    }
}