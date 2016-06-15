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
  
  
## Example of output for the test class:


The log has the following format:

```
TheClassSimpleName, (static method|object), function name, a text explicating
```

When running [MyParameterizedTest.java](MyParameterizedTest.java), you got the following output:

```
MyExternalResourceRule, (object: Junit.ExternalResourceAsParameter.MyExternalResourceRule@17d10166) constructor, immutable resource created
MyParameterizedTest, (static method) data
MyDatabase, (object: MyDatabase{databaseName='Database', status='Open'}) Open, Database
MyExternalResourceRule, (object: Junit.ExternalResourceAsParameter.MyExternalResourceRule@17d10166) before, mutable resource open MyDatabase{databaseName='Database', status='Open'}
MyParameterizedTest, (static method) beforeClass
MyParameterizedTest, (object: Junit.ExternalResourceAsParameter.MyParameterizedTest@3830f1c0) Constructor
MyParameterizedTest, (object: Junit.ExternalResourceAsParameter.MyParameterizedTest@3830f1c0) before with Resource (Immutable Resource (String))
MyParameterizedTest, (object: Junit.ExternalResourceAsParameter.MyParameterizedTest@3830f1c0) TestB with Resource (Immutable Resource (String))
MyParameterizedTest, (object: Junit.ExternalResourceAsParameter.MyParameterizedTest@3830f1c0) after with Resource (Immutable Resource (String))
MyParameterizedTest, (object: Junit.ExternalResourceAsParameter.MyParameterizedTest@782830e) Constructor
MyParameterizedTest, (object: Junit.ExternalResourceAsParameter.MyParameterizedTest@782830e) before with Resource (Immutable Resource (String))
MyParameterizedTest, (object: Junit.ExternalResourceAsParameter.MyParameterizedTest@782830e) TestA with Resource (Immutable Resource (String))
MyParameterizedTest, (object: Junit.ExternalResourceAsParameter.MyParameterizedTest@782830e) after with Resource (Immutable Resource (String))
MyParameterizedTest, (object: Junit.ExternalResourceAsParameter.MyParameterizedTest@3fb4f649) Constructor
MyParameterizedTest, (object: Junit.ExternalResourceAsParameter.MyParameterizedTest@3fb4f649) before with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (object: Junit.ExternalResourceAsParameter.MyParameterizedTest@3fb4f649) TestB with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (object: Junit.ExternalResourceAsParameter.MyParameterizedTest@3fb4f649) after with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (object: Junit.ExternalResourceAsParameter.MyParameterizedTest@200a570f) Constructor
MyParameterizedTest, (object: Junit.ExternalResourceAsParameter.MyParameterizedTest@200a570f) before with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (object: Junit.ExternalResourceAsParameter.MyParameterizedTest@200a570f) TestA with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (object: Junit.ExternalResourceAsParameter.MyParameterizedTest@200a570f) after with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (static method) afterClass
MyExternalResourceRule, (object: Junit.ExternalResourceAsParameter.MyExternalResourceRule@17d10166) after, shutdown
MyDatabase, (object: MyDatabase{databaseName='Database', status='Close'}) Close, Database
```
