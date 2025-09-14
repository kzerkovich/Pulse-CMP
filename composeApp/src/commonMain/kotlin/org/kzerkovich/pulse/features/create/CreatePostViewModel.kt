package org.kzerkovich.pulse.features.create

import org.kzerkovich.pulse.base.BaseViewModel
import org.kzerkovich.pulse.features.create.models.CreatePostAction
import org.kzerkovich.pulse.features.create.models.CreatePostEvent
import org.kzerkovich.pulse.features.create.models.CreatePostViewState

class CreatePostViewModel : BaseViewModel<CreatePostViewState, CreatePostAction, CreatePostEvent>
    (initialState = CreatePostViewState()) {
    override fun obtainEvent(viewEvent: CreatePostEvent) {

    }
}