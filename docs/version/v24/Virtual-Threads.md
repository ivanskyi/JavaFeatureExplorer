# Virtual Threads

### What's the difference between a simple thread and a virtual thread?
A virtual thread is lightweight and managed by the JVM, allowing you to run thousands of them,
simple (platform) threads are heavyweight and tied to OS threads.

Both regular and virtual threads in Java are instances of `java.lang.Thread`. 
The main difference lies in how they are created and managed by the JVM.

---

### Why do we use `startVirtualThread()`?
To create and start a virtual thread directly.

### Why do we use `thread.join()`?
To wait for a thread to finish before continuing.

### Why do we use `Thread.currentThread().interrupt()`?
To restore the interrupt status and signal that the current thread was interrupted.

### Why do we use `Thread.isVirtual()`?
To check if a thread is a virtual thread.
