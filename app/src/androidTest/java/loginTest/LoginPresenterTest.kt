package loginTest
import ar.com.wolox.android.example.network.repository.UserRepository
import ar.com.wolox.android.example.ui.login.LoginPresenter
import ar.com.wolox.android.example.ui.login.LoginView
import ar.com.wolox.android.example.utils.UserSession
import ar.com.wolox.wolmo.core.tests.CoroutineTestRule
import ar.com.wolox.wolmo.core.tests.WolmoPresenterTest
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.times
import org.mockito.Mockito.verify

class LoginPresenterTest : WolmoPresenterTest<LoginView, LoginPresenter>() {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule(runOnAllTests = true)

    @Mock
    lateinit var userSession: UserSession
    lateinit var userRepository: UserRepository
    override fun getPresenterInstance() = LoginPresenter(userSession, userRepository)

    @Test
    fun missingCredentials() {
        // Given the three possible cases of missing credentials (NO EMAIL-NO PASSWORD, NO EMAIL, NO PASSWORD)
        val email = "hello@mail.com"
        val password = "password"
        presenter.onLoginButtonClicked(email, "")
        presenter.onLoginButtonClicked("", password)
        presenter.onLoginButtonClicked("", "")
        verify(view.showEmptyPasswordError(), times(2))
        verify(view.showEmptyEmailError(), times(2))
    }

    @Test
    fun invalidEmail() {
        // Idea : Declare multiple emails and test them here
        val email = "aaaaa"
        val password = "123456"

        presenter.onLoginButtonClicked(email, password)
        verify(view.showEmailInvalidError(), times(1))
    }

    @Test
    fun nonExistingEmail() = runBlocking {
        // Given a non existing email, response should result on 'invalid credentials' message.

        // GIVEN
        val nonExistingEmail = "nonexistingemail@mail.com"
        val password = "password"

        // WHEN
        presenter.onLoginButtonClicked(nonExistingEmail, password)

        // EXPECT
        verify(view.showIncorrectCredentialsToast(), times(1))
    }

    @Test
    fun incorrectPassword() = runBlocking {
        // Given an existing email, but a wrong password, response should result on 'invalid credentials' message.

        // GIVEN
        val nonExistingEmail = "clinton.harris59@mail.com"
        val password = "password"

        // WHEN
        presenter.onLoginButtonClicked(nonExistingEmail, password)

        // EXPECT
        verify(view.showIncorrectCredentialsToast(), times(1))
    }

    @Test
    fun existingEmail() = runBlocking {
        // Given a correct email and password, response should result on going to HomeActivity.

        // GIVEN
        val existingEmail = "clinton.harris59@example"
        val password = "123456"

        // WHEN
        presenter.onLoginButtonClicked(existingEmail, password)

        verify(view.goToHomePage(), times(1))
    }
}