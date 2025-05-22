# JEP 409: Sealed Classes

They allow the author of a class or interface to control which other classes or interfaces may extend or implement it.

## Purpose
- Provide control over type hierarchies.
- Improve code safety and predictability.
- Enhance pattern matching.

## Syntax
```java
public sealed class Shape permits Circle, Square, Triangle {}

public final class Circle extends Shape {}
public non-sealed class Square extends Shape {}
public sealed class Triangle extends Shape permits Equilateral, Isosceles {}
```

## Keywords
- `sealed` — restricts extension to permitted subclasses.
- `permits` — lists allowed subclasses.
- `final` — prevents further inheritance.
- `non-sealed` — lifts restrictions, allowing unrestricted inheritance.

## Constraints
- All `permits` classes must be in the same module or package.
- Each subclass must declare itself as `sealed`, `final`, or `non-sealed`.

## Benefits
- Controlled type hierarchies.
- Better integration with `switch` and pattern matching.
- Fewer errors during refactoring.
