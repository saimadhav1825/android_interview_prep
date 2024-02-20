//You can run many coroutines on a single thread due to support for suspension, which doesn't block the thread where the coroutine is running.
// Suspending saves memory over blocking while supporting many concurrent operations.

//viewModelScope is a predefined CoroutineScope that is included with the ViewModel KTX extensions. Note that all coroutines must run in a scope. A CoroutineScope manages one or more related coroutines.
//launch is a function that creates a coroutine and dispatches the execution of its function body to the corresponding dispatcher.
//Dispatchers.IO indicates that this coroutine should be executed on a thread reserved for I/O operations.

//launch starts a new coroutine and doesn't return the result to the caller. Any work that is considered "fire and forget" can be started using launch.
//async starts a new coroutine and allows you to return a result with a suspend function called await.

//A function with a ‘suspend’ modifier is known as suspending function.
//
//The suspending functions are only allowed to be called from a coroutine or from another suspending function.

fun main(){

}

