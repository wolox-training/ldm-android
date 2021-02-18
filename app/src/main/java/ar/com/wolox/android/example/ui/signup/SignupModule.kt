package ar.com.wolox.android.example.ui.signup

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class SignupModule {
    @ContributesAndroidInjector
    internal abstract fun signUpActivity(): SignupActivity

    @ContributesAndroidInjector
    internal abstract fun signUpFragment(): SignupFragment
}