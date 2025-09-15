package org.kzerkovich.pulse.features.draft.domain

import app.softwork.uuid.Uuidv7
import org.kzerkovich.pulse.features.draft.data.DraftDAO
import org.kzerkovich.pulse.features.draft.data.DraftEntity
import kotlin.random.Random
import kotlin.time.ExperimentalTime
import kotlin.uuid.ExperimentalUuidApi


class SaveDraftUseCase(
    private val draftDao: DraftDAO
) {

    @OptIn(ExperimentalUuidApi::class, ExperimentalTime::class)
    suspend fun execute(title: String, text: String) {
        draftDao.insert(
            DraftEntity(
                draftId = Uuidv7(random = Random).toString(),
                title = title,
                text = text
            )
        )
    }
}