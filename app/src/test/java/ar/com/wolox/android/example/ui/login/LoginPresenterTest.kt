package ar.com.wolox.android.example.ui.login

import org.junit.Test
import org.junit.Rule
import org.mockito.Mockito.times

// Wolmo and project imports
import ar.com.wolox.android.example.network.repository.UserRepository
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.tests.CoroutineTestRule
import ar.com.wolox.wolmo.core.tests.WolmoPresenterTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.mockito.Mock
import org.mockito.Mockito.verify

@ExperimentalCoroutinesApi
class LoginPresenterTest : WolmoPresenterTest<LoginView, LoginPresenter>() {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule(runOnAllTests = true)

    @Mock
    lateinit var userSession: UserSession
    @Mock
    lateinit var userRepository: UserRepository
    override fun getPresenterInstance() = LoginPresenter(userSession, userRepository)

    @Test
    fun `empty credentials - all cases`() = runBlocking {
        val email = "example@mail.com"
        val password = "password"
        presenter.onLoginButtonClicked("", password)
        verify(view, times(1)).showEmptyEmailError()
        presenter.onLoginButtonClicked(email, "")
        verify(view, times(1)).showEmptyEmailError()
        presenter.onLoginButtonClicked("", "")
        verify(view, times(1)).showEmptyEmailError()
        verify(view, times(1)).showEmptyPasswordError()
    }

    @Test
    fun onSignUpButtonClicked() {
    }

    @Test
    fun onWoloxTermsAndConditionsClicked() {
    }
}