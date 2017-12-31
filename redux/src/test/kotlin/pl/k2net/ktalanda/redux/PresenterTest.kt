package pl.k2net.ktalanda.redux

import com.nhaarman.mockito_kotlin.mock
import io.reactivex.subjects.PublishSubject
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class PresenterTest {

    private val store: Store = Store(mock(), PublishSubject.create(), mock(), HashMap<String, ViewModel>())
    private lateinit var presenter: PresenterTestImplementation

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
        var hasInvoked = false
        presenter.updateActionList = mutableListOf(
                {
                    hasInvoked = true
                    return@mutableListOf
                })
        presenter.bind("ViewInterface")
        Assert.assertTrue(hasInvoked)
    }

    @Test
    fun GivenNotEmptyList_WhenUpdate_ShouldExecuteAllActionsInUpdateActionList() {
        var counter = 0
        presenter.updateActionList = mutableListOf(
                {
                    counter++
                    return@mutableListOf
                },
                {
                    counter++
                    return@mutableListOf
                }
        )
        presenter.update()
        Assert.assertEquals(2, counter)
    }

    @Test
    fun WhenUpdate_ShouldEmptyUpdateActionList() {
        presenter.updateActionList = mutableListOf({}, {})
        presenter.update()
        Assert.assertEquals(0, presenter.updateActionList.size)
    }

    @Test
    fun WhenAddAction_ShouldAppendActionToTheActionList() {
        presenter.updateActionList = mutableListOf({}, {})
        presenter.addToUpdateList { }
        Assert.assertEquals(3, presenter.updateActionList.size)
    }

    class PresenterTestImplementation(store: Store) : Presenter<String>(store)
}
