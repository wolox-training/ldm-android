package ar.com.wolox.android.example.ui.login

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class LoginModule {

    @ContributesAndroidInjector
    internal abstract fun exampleActivity(): LoginActivity

    @ContributesAndroidInjector
    internal abstract fun exampleFragment(): LoginFragment
}
