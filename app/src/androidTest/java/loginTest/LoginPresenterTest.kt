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

class LoginPresenterTest : WolmoPresenterTest<LoginView, LoginPresenter>() {
    @get:Rule
    val coroutineTestRule = CoroutineTestRule(runOnAllTests = true)

    @Mock
    lateinit var userSession: UserSession
    lateinit var userRepository: UserRepository
    override fun getPresenterInstance() = LoginPresenter(userSession, userRepository)

    @Test
    fun missingCredentials() {
        // TODO(To implement)
    }

    @Test
    fun invalidEmail() {
        // Idea : Declare multiple emails and test them here
        // TODO(To implement)
    }

    @Test
    fun nonExistingEmail() = runBlocking {
        // Given a non existing email, response should result on 'invalid credentials' message.
        val nonExistingEmail = "nonexistingemail@mail.com"
        val password = "password"
        // presenter.onLoginButtonClicked(nonExistingEmail, password)
        // TODO In the next card error toast will be implemented, and tested here.
        // verify(view, times(1))
    }

    @Test
    fun incorrectPassword() = runBlocking {
        // TODO In the next card error toast will be implemented, and tested here.
    }

    @Test
    fun noInternetConnection() = runBlocking {
        // Todo In the next card error toast will be implemented, and tested here.
    }

    @Test
    fun existingEmail() = runBlocking {
        val existingEmail = "clinton.harris59@example"
        val password = "123456"
    }
}