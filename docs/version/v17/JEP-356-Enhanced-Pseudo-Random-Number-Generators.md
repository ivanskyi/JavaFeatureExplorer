# JEP 356 — Enhanced Pseudo-Random Number Generators
Powerful and flexible framework for pseudo-random number generation, supporting modern and high-quality algorithms.

---

## `RandomGenerator` — the Interface

- A unified interface for all types of random number generators.
- Provides methods like `nextInt()`, `nextLong()`, `nextDouble()`.
- Abstracts both legacy (`Random`, `SplittableRandom`, `ThreadLocalRandom`) and new, high-performance algorithms under a common API.

```java
RandomGenerator rng = RandomGeneratorFactory.of("L32X64MixRandom").create();
int number = rng.nextInt();
