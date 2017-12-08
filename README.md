This is a sample project for Redux based library for Android. It is inspired by Javascript implementation of Redux: https://github.com/reactjs/redux.

![Alt text](https://user-images.githubusercontent.com/5991481/28999668-2e161f5a-7a93-11e7-999d-373db2e93eb5.png "Redux Schema.")

Redux library can be found in the `redux` module. https://github.com/ktalanda/ReduxAndroid/tree/master/redux/src/main/java/pl/k2net/ktalanda/redux

The library is intended to be used in Presentation layer of the application. Presenters shouldn't be talking to the IO devices such as Database or Network directly, but should use abstract interfaces to access data, so any change to the `State` will be accessible form any part of the app.

## 1. Description.
Library is based on unidirectional data flow. All the visual `State` of the application is stored in the `Store`. `State` can be modified only via `Action`s. `State` is an immutable object, so any time we make change to it we need to create new one by reducing it.

### 1.1. Elements of the library.

* `Store` - contains the visual `State` of the application represented by `ViewModel`s. Via `Reducer` it reduces the actions and triggers the `update` event via reactive streams to any `Presenter` binded. 
* `Reducer` - responsible for creating new state based on current state and passed action.
* `Action` - simple object which contains type of action and state to be updated.
* `Presenter` - creates the actions and dispatches them in the `Store`. It interacts with the `View` receiving interactions and updating it based on current application `State`. This is the place where the layer below should be called to interact with IO devices such as database, network etc.

## 2. Usage.
Sample usage can be found in the `app` module. It is an Android app using Dagger as a Dependency Injection framework. https://github.com/ktalanda/ReduxAndroid/tree/master/app/src/main/java/pl/k2net/ktalanda/maroubrascanner. 

* Define `ViewModel`s for your visual state. It should be a `Data Class` in Kotlin and has to implement `ViewModel` interface from `redux` library. https://github.com/ktalanda/ReduxAndroid/blob/master/app/src/main/java/pl/k2net/ktalanda/maroubrascanner/main/details/DetailsViewModel.kt

* Define `Action`s which represent every change that could happen in your UI. It has to implement `Action` interface from `redux` library and can contain extra information about the the state change. https://github.com/ktalanda/ReduxAndroid/blob/master/app/src/main/java/pl/k2net/ktalanda/maroubrascanner/main/details/UpdateDetailsListAction.kt

* Define `Reducer` which is responsible for changing the `State` based on passed `Action`. It has to extend `Reducer` class from `redux` library. 
https://github.com/ktalanda/ReduxAndroid/blob/master/app/src/main/java/pl/k2net/ktalanda/maroubrascanner/MaroubraReducer.kt

* Define `Logger` which is responsible for logs inside of the `redux` library.
https://github.com/ktalanda/ReduxAndroid/blob/master/app/src/main/java/pl/k2net/ktalanda/maroubrascanner/AppLogger.kt

* Define `Store` as a `Singleton` somewhere in your application. Pass the `Reducer`, `Logger` and `State` via constructor. `State` is a simple `Map` where `key` has to be `ViewModel` class name, and value has to be the `ViewModel` itself. When creating the `State` object you are defining the default state of the application. In the sample app it is provided by dagger. https://github.com/ktalanda/ReduxAndroid/blob/master/app/src/main/java/pl/k2net/ktalanda/maroubrascanner/AppModule.kt#L24

* For every `View` create a `Presenter` which has to extend `Presenter` class from `redux` library. `Store` singleton instance has to be passed to the `Presenter` via constructor. Every `Presenter` has to implement `update()` method, which is being called as a callback function on every `State` change in the `Store`. `update` function has to contain all bindings to the view. In sample app this binding has been done via `ViewInterface`s.
https://github.com/ktalanda/ReduxAndroid/blob/master/app/src/main/java/pl/k2net/ktalanda/maroubrascanner/main/MainPresenter.kt

## License
MIT
