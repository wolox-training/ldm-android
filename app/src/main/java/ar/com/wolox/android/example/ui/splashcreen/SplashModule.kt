package ar.com.wolox.android.example.ui.splashcreen

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SplashModule {
    @ContributesAndroidInjector
    internal abstract fun splashActivity(): SplashActivity

    @ContributesAndroidInjector
    internal abstract fun splashFragment(): SplashFragment
}