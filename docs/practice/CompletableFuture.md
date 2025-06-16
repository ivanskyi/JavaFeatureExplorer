# CompletableFuture

`CompletableFuture` is a class in Java used for writing asynchronous (non-blocking) code. <br> 
It allows you to run tasks in background threads, process results, build chains of operations, <br> 
and handle errors, all without blocking the main thread.<br> 

- `runAsync()` — Runs an async task without a return value.
- `supplyAsync(Supplier<T>)` — Runs an async task that returns a result.
- `thenApply(Function)` — Transforms the result (returns a new CompletableFuture).
- `thenAccept(Consumer)` — Consumes the result (returns void).
- `thenRun(Runnable)` — Runs a task after completion (no access to result).
