# Object-Oriented Programming concepts recap

## Concept

* Software development paradigm
* We should represent our system concepts using classes
* Classes deals with common behaviour to all of its different instances (objects):

![Classes vs objects](resources/blueprint-vs-house.png)
* Objects have their own memory
* Object communicate between them sending and receiving messages

## Visibility and inheritance

### `public`, `protected`, and `private` visibility keywords
* When do you use each one?
    * Guilt presumption
    * Simplify our classes API (exposed methods) => Easier to understand, easier to be SRP compliant, avoid having to maintain public methods because others are coupled to them
* Question:
    * Which would be the output of the `Child#visibilityTest` method?
    * Solution: `ChildShould`. Possible answers:
```
        "Child#privateMethod Child#protectedMethod Child#publicMethod" // a
        "Parent#privateMethod Child#protectedMethod Child#publicMethod" // b
        "Parent#privateMethod Parent#protectedMethod Child#publicMethod" // c
        "Parent#privateMethod Child#protectedMethod Parent#publicMethod" // d
        "Parent#privateMethod Parent#protectedMethod Parent#publicMethod" // e
        // It doesn't compile // f
```

### `static` keyword
* What is it for?
* Question:
    * Which would be the output for the following `getTotal` calls?
    * Solution: `CounterShould`. Possible answers:
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

// a:
counterA.getTotal(); // 0
counterB.getTotal(); // 0
counterC.getTotal(): // 0

// b:
counterA.getTotal(); // 6
counterB.getTotal(); // 6
counterC.getTotal(): // 6

// c:
counterA.getTotal(); // 3
counterB.getTotal(); // 5
counterC.getTotal(): // 6

// c:
counterA.getTotal(); // 6
counterB.getTotal(); // 3
counterC.getTotal(): // 1
```
   
### `final` keyword
* What does it do in attributes?
    * Does not allow to redefine them
* What does it do in methods?
    * Does not allow to override them
* What does it do in classes?
    * Does not allow to inherit from them
* When we should use it?
    * Same reasoning as with the visibility keywords: Guilt presumption.
    * Why: Make the next developer think twice before extending from it.
    * Key concept: [Composition over Inheritance](https://medium.com/humans-create-software/composition-over-inheritance-cb6f88070205).

### `abstract` classes vs `interface`s
* What's the difference?
    * Interfaces:
        * Doesn't allow to implement method bodies. It only allow us to declare method contracts/headers. <- True until Java8
        * They're great because as they have fewer capabilities, they are easier to read and understand without letting us mess up adding behaviour.
        * A class can implement different interfaces.
    * Abstract classes:
        * Allow to implement method bodies.
        * A class can only extend from one abstract class.    
* When we should use `abstract` classes?
    * Opinion: Almost never. Just exceptional cases. We should have a very big reason to do so 🙂
* When we should use `interfaces`?
    * Opinion: In order to decouple from infrastructure* stuff.
    * *Infrastructure: behaviour related to a third party library or component (Postgres DB, AWS SDK, Slack SDK, MailChimp API…)
    * Usage example:
```java

interface ProductRecommender
{
    Recommendations findFor(ProductId productId);
}

final class BlueknowProductRecommender implements ProductRecommender
{
    @Override
    public Recommendations findFor(ProductId productId) {
        // Call to the Blueknow service API
        // Parse the JSON response into a `Recommendations` class instance
        return recommendations;
    }
}
```

Example:
* Context:
    * We have a Builder system in order to build our applications
    * We want to notify the development team once the build is ready to be deployed
    * We're testing different messaging apps such as Slack and HipChat
    * In order to do not miss our notifications, we want to be notified through the `#dev-notifications` Slack channel, and through the `dev-notifications@codely.tv` mailing list
* Questions:
    * How would you model these different classes and their interactions?
