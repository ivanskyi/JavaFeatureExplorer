# JSR 166 – Concurrency Utilities

---
# Semaphore in Java

A **Semaphore** is a concurrency utility used to control access to a shared resource by multiple threads. It maintains a set number of permits, threads must acquire a permit before proceeding and release it when done.

### What is a Semaphore?

Think of a semaphore as a gatekeeper with a limited number of tokens. Only threads with a token can proceed, others must wait until one is released.

### How to Create a Semaphore:

```java
Semaphore semaphore = new Semaphore(3); // Allows up to 3 concurrent accesses
```

### Where to Declare It?

Declare the semaphore as a **class-level variable** if it is shared across multiple threads. Use a **method-level variable** only for isolated, short-lived concurrency.

### Acquiring a Permit:

```java
semaphore.acquire(); // Blocks if no permits are available
```

### Releasing a Permit:

```java
semaphore.release(); // Signals that the thread has finished
```
---
