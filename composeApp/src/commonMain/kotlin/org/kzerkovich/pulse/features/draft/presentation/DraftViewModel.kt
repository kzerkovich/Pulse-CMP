package org.kzerkovich.pulse.features.draft.presentation

import org.kzerkovich.pulse.core.di.InjectProvider
import org.kzerkovich.pulse.features.draft.domain.SaveDraftUseCase

class DraftViewModel(

) {
    private val saveDraftUseCase =
        SaveDraftUseCase(draftDao = InjectProvider.getDataBase().getDraftDao())
}