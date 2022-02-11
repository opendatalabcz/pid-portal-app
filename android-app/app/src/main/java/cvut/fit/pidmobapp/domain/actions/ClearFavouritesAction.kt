package cvut.fit.pidmobapp.domain.actions

import cvut.fit.pidmobapp.repository.AppRepository

class ClearFavouritesAction(private val appRepository: AppRepository) {

    suspend fun execute() {
        return appRepository.clearFavourites()
    }
}