package pl.k2net.ktalanda.redux

import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.never
import com.nhaarman.mockito_kotlin.verify
import io.reactivex.subjects.PublishSubject
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class StoreTest {

    private lateinit var store: Store
    private lateinit var viewModelMock: ViewModel
    private lateinit var reducerMock: Reducer
    private lateinit var state: Map<String, ViewModel>

    @Before
    fun setUp() {
        viewModelMock = mock()
        reducerMock = mock { on { reduce(any(), any()) } doReturn mock<ViewModel>() }
        state = mapOf(Pair("Main", viewModelMock))
        store = Store(reducerMock, PublishSubject.create(), mock(), state)
    }

    @Test
    @Throws(Exception::class)
    fun GivenActionWithExistingViewModelType_WhenReduce_ShouldReduceTheViewModel() {
        val mainAction: Action = mock { on { type() } doReturn "Main" }
        store.reduce(mainAction)
        verify(reducerMock).reduce(viewModelMock, mainAction)
    }

    @Test
    fun GivenActionWithExistingViewModelType_WhenReduce_ShouldUpdateState() {
        val mainAction: Action = mock { on { type() } doReturn "Main" }
        store.reduce(mainAction)
        Assert.assertNotEquals(store.state["Main"], state["Main"])
    }

    @Test
    @Throws(Exception::class)
    fun GivenActionWithNotExistingViewModelType_WhenReduce_ShouldNotReduceTheViewModel() {
        val mainAction: Action = mock { on { type() } doReturn "Second" }
        store.reduce(mainAction)
        verify(reducerMock, never()).reduce(viewModelMock, mainAction)
    }

    @Test
    fun GivenActionWithNotExistingViewModelType_WhenReduce_ShouldNotUpdateState() {
        val mainAction: Action = mock { on { type() } doReturn "Second" }
        store.reduce(mainAction)
        Assert.assertEquals(store.state["Main"], state["Main"])
    }

    @Test
    @Throws(Exception::class)
    fun dispatch() {
    }
}