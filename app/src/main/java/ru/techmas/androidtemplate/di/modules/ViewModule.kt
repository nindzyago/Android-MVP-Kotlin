package ru.techmas.androidtemplate.di.modules

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import ru.techmas.androidtemplate.App
import ru.techmas.androidtemplate.utils.AnimationHelper

/**
 * Date: 04.06.2017
 * Time: 10:18
 * Project: Android Template

 * @author Alex Bykov
 * *         You can contact me at me@alexbykov.ru
 */

@Module
class ViewModule(app: App) {


    private val animationHelper: AnimationHelper = AnimationHelper(app)

    @Provides
    @Singleton
    internal fun provideAnimationHelper(): AnimationHelper {
        return animationHelper
    }
}
