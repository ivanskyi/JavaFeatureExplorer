# Java Memory Model (JMM) 
Defines rules for visibility and ordering of memory operations in multithreaded 
<br> Java programs to ensure correct synchronization and prevent data races.

## Volatile

`volatile` is a variable modifier that ensures visibility of changes between threads without caching.

It does **not** guarantee atomicity for compound operations (e.g., `i++`), only visibility.

Values of a `volatile` variable are read from and written directly to main memory, so all threads see the latest updates.
