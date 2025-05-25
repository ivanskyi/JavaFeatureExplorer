# `var` Usage Summary

## Where `var` **can** be used:

- **Local variables** inside methods, constructors, or blocks:
  ```java
  var name = "Java";
  ```

- **Loops**:
  ```java
  for (var item : list) { ... }
  ```

- **Try-with-resources**:
  ```java
  try (var stream = new FileInputStream("file.txt")) { ... }
  ```

---

## Where `var` **can't** be used:

- As a **class field**:
  ```java
  // Not allowed
  var name = "Company";
  ```

- As a **method parameter**:
  ```java
  // Not allowed
  public void setName(var name) { ... }
  ```

- As a **method return type**:
  ```java
  // Not allowed
  public var getName() { ... }
  ```

---

## Summary:

`var` is only allowed for **local variables** with an explicit initializer.
