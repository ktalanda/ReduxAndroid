This is a sample project for Redux based library for Android. It is inspired by Javascript implementation of Redux: https://github.com/reactjs/redux.

![Alt text](https://user-images.githubusercontent.com/5991481/28999668-2e161f5a-7a93-11e7-999d-373db2e93eb5.png "Redux Schema.")

This implementation is intended to be used in Presentation layer of the application. Presenters shouldn't be talking to the IO devices such as Database or Network directly, but should use abstract interfaces to access data.

Library is based on unidirectional data flow. All the visual `State` of the application is stored in the `Store`. `State` can be modified only via `Action`s. `State` is an immutable object, so any time we make change to it we need to create new one by reducing it. There can be only one `Store` in the application.

Elements of the library:

1. `Store` - contains the visual `State` of the application represented by `ViewModel`s. Via `Reducer` it reduces the actions and triggers the `update` event via reactive streams to any Observable connected.
2. `Reducer` - responsible for creating new state based on current state and passed action.
3. `Action` - simple object which contains type of action and state to be updated.
4. `Presenter` - creates the actions and dispatches them in the `Store`. It interacts with the `View` receiving interactions and updating it based on current application `State`. This is the place where the layer below should be called to interact with IO devices such as database, network etc.

### License
MIT
