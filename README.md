# TDD Kata Word Wrap

In this repository we'll solve the word wrap problem using
the [TDD](https://www.digite.com/agile/test-driven-development-tdd/) methodology.

**Word wrap**

You write a class called Wrapper, that has a single static function named wrap that takes two arguments, a string, and a
column number. The function returns the string, but with line breaks inserted at just the right places to make sure that
no line is longer than the column number. You try to break lines at word boundaries.

> In this case, we'll care more on the steps you used to solve it rather than the algorithm efficiency.

This is a KATA extracted from the coding dojo [website](https://codingdojo.org/kata/)

# Setup

This is a Maven repository, and you can find its definition in the `pom.xml` file.

**Dependencies**

- JDK 11
- Maven (Installed on your machine or IDE)

**Maven dependencies**

- JUnit
- Surefire (Run tests)

### Build

```shell
mvn clean install
```

### Run tests

Run the WrapperTest class and that will run all the tests inside. You can also run

```shell
mvn test
```

# How to TDD

![TDD flow](https://d112uwirao0vo9.cloudfront.net/wp-content/uploads/2020/12/tdd_flow1.gif)

Now that you understand the coding problem, in order to work with TDD you'll need to

1. Understand the requirements (Tests must explain the requirements)

> The test is the question and the code is the answer

My problem is that I need a program that divides two integers. I need to be aware of the `divide by zero` problem and 
validate the input (all integers are accepted).

2. Create precise tests

```java
public class Tests {
    @Test
    public void get_2_when_10_divided_by_5() {
        int result = myClass.divide(10, 5);
        Assertions.assertEquals(result, 2);
    }

    @Test
    public void get_0_when_0_divided_by_5() {
        int result = myClass.divide(0, 5);
        Assertions.assertEquals(result, 0);
    }
    
    @Test
    public void get_error_when_5_divided_by_0() {
        Assertions.assertThrows(DivideByZeroException.class, myClass.divide(5, 0));
    }    
}
```

Then we start to write tests, we're writing exactly the requirements and business validation of our program.
And we don't even need the code yet, we just need the tests to pass.

3. Write the code that makes them pass
4. Refactor the code: Check for redundancy or any possible code optimization. You must ensure refactoring does not break your tests.

# Authors

- Felipe Ramis