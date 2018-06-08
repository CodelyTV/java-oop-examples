# Object-Oriented Programming concepts recap

## Concept

* Software development paradigm
* We should represent our system concepts using classes
* Classes deals with common behaviour to all of its different instances (objects):
![Classes vs objects](resources/blueprint-vs-house.png)
* Objects have their own memory
* Object communicate between them sending and receiving messages

## Visibility and inheritance

### `public`, `protected`, and `private`
* When do you use each one?
* Question:
    * Which would be the output of the `Child#visibilityTest` method?
    * Solution: `ChildShould`  

### `static`
* What is it for?
* Question:
    * Which would be the output?
```java
Counter counterA = new Counter();
Counter counterB = new Counter();
Counter counterC = new Counter();

counterA.increaseTotal();
counterA.increaseTotal();
counterA.increaseTotal();

counterB.increaseTotal();
counterB.increaseTotal();

counterC.increaseTotal();

counterA.getTotal(); // ???
counterB.getTotal(); // ??
counterC.getTotal(): // ?
```
    * Solution: `CounterShould`
   
### `final`
* What does it do in methods and classes?
* When we should use it?

### `abstract` vs `interface`
* What's the difference?
* When we should use `abstract` classes?
* When we should use `interfaces`?
* What about multiple inheritance?

Example:
* Context:
    * We have a Builder system in order to build our applications
    * We want to notify the development team once the build is ready to be deployed
    * We're testing different messaging apps such as Slack and HipChat
    * In order to do not miss our notifications, we want to be notified through the `#dev-notifications` Slack channel, and through the `dev-notifications@codely.tv` mailing list
* Questions:
    * How would you model these different classes and their interactions?
