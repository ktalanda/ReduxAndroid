package pl.k2net.ktalanda.redux

import com.nhaarman.mockito_kotlin.mock
import io.reactivex.subjects.PublishSubject
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PresenterTest{

    val store: Store = Store(mock(), PublishSubject.create(), HashMap<String, ViewModel>())
    lateinit var presenter: PresenterTestImplementation

    @Before
    fun setUp() {
        presenter = PresenterTestImplementation(store)
    }

    @Test
    fun WhenBind_ShouldSetViewInterface() {
        presenter.bind("ViewInterface")
        Assert.assertEquals("ViewInterface", presenter.view)
    }

    @Test
    fun WhenBind_ShouldSubscribeToStore() {
        presenter.bind("ViewInterface")
        Assert.assertNotNull(presenter.disposable)
    }

    @Test
    fun WhenBind_ShouldInvokeUpdate() {
        presenter.bind("ViewInterface")
        Assert.assertTrue(presenter.hasUpdateBeenInvoked)
    }

    class PresenterTestImplementation(store: Store) : Presenter<String>(store) {
        var hasUpdateBeenInvoked: Boolean = false

        override fun update() {
            hasUpdateBeenInvoked = true
        }
    }
}
