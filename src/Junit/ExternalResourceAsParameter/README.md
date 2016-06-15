# Junit - External Resources as Parameters for Parameterized Test

## Introduction

How to run the same test with several different set of External Resources as parameters (ie values).


## Implementation

The implementation is a mix of Junit technology:

  * [Parameterized tests](https://github.com/junit-team/junit4/wiki/Parameterized-tests)
  * and [ExternalResource Rules](https://github.com/junit-team/junit4/wiki/Rules#externalresource-rules)
  
The tricky thing here is that the method that set up the data is called before the `before` method of the `ExternalResource` object.
Therefore:
   * the "no mutable" external resources must be initialized in the constructor of the [ExternalResource](MyExternalResourceRule.java) object, not in the `before` method
   * the "mutable" resource (ie [reference variable](http://gerardnico.com/wiki/language/java/reference)) must be created in the constructor and the connection can be open in the `before` method of the [ExternalResource](MyExternalResourceRule.java)

## Start

You may start:

  * The test suite: [SuiteTest.java](MySuiteTest.java)
  * The test class: [MyParameterizedTest.java](MyParameterizedTest.java)
  * Or a test method of the test class: [MyParameterizedTest.java](MyParameterizedTest.java)

