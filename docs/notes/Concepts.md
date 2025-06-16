# Boilerplate

#### 1. `Boilerplate` is repetitive code that is often written but does not contain unique logic.

```java
if (obj instanceof String) {
    String s = (String) obj;  // boilerplate — type casting
    System.out.println(s);
}
```

#### 2. `Proxy object` - is an object that wraps another object to simplify its management or to extend its functionality

#### 3. High Cohesion, Low Coupling

`High Cohesion` – performs a clearly defined task, and all its parts are closely related to each other.

```java
class AuthService {
    boolean login(String user, String pass) { ... }
    void logout() { ... }
}
```

`Low Coupling` – when a class has minimal dependency on others and interacts with them <br>
only through interfaces, without knowing their implementation details.

```java
class Notifier {
    private final Sender sender;

    Notifier(Sender sender) {
        this.sender = sender;
    }

    void notifyUser(String msg) {
        sender.send(msg);
    }
}
```
