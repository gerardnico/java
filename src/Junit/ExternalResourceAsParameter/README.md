# Junit - External Resources as Parameters for Parameterized Test

## Introduction

How to run the same test with several different set of External Resources as parameters (ie values).

The output will give you the lifecycle of each Junit steps in a run.


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
  
  
## Console of output when running ...

The log has the following format:

```
TheClassSimpleName, (static method|object), function name, a text explicating
```

### A test method

When running [the test method TestA of MyParameterizedTest.java](MyParameterizedTest.java), you got the following output:

```
MyExternalResourceRule, (object: 6aa8ceb6) constructor, immutable resource created
MyParameterizedTest, (static method) data
MyDatabase, (object: MyDatabase{databaseName='Database', status='Open'}) Open, Database
MyExternalResourceRule, (object: 6aa8ceb6) before, mutable resource open MyDatabase{databaseName='Database', status='Open'}
MyParameterizedTest, (static method) beforeClass
MyParameterizedTest, (object: 182decdb) Constructor
MyParameterizedTest, (object: 182decdb) before with Resource (Immutable Resource (String))
MyParameterizedTest, (object: 182decdb) TestA with Resource (Immutable Resource (String))
MyParameterizedTest, (object: 182decdb) after with Resource (Immutable Resource (String))
MyParameterizedTest, (object: 39ed3c8d) Constructor
MyParameterizedTest, (object: 39ed3c8d) before with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (object: 39ed3c8d) TestA with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (object: 39ed3c8d) after with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (static method) afterClass
MyExternalResourceRule, (object: 6aa8ceb6) after, shutdown
MyDatabase, (object: MyDatabase{databaseName='Database', status='Close'}) Close, Database
```


### The test class


When running [MyParameterizedTest.java](MyParameterizedTest.java) with the test methods TestA and TestB, you got the following output:

```
MyExternalResourceRule, (object: 17d10166) constructor, immutable resource created
MyParameterizedTest, (static method) data
MyDatabase, (object: MyDatabase{databaseName='Database', status='Open'}) Open, Database
MyExternalResourceRule, (object: 17d10166) before, mutable resource open MyDatabase{databaseName='Database', status='Open'}
MyParameterizedTest, (static method) beforeClass
MyParameterizedTest, (object: 3830f1c0) Constructor
MyParameterizedTest, (object: 3830f1c0) before with Resource (Immutable Resource (String))
MyParameterizedTest, (object: 3830f1c0) TestA with Resource (Immutable Resource (String))
MyParameterizedTest, (object: 3830f1c0) after with Resource (Immutable Resource (String))
MyParameterizedTest, (object: 782830e) Constructor
MyParameterizedTest, (object: 782830e) before with Resource (Immutable Resource (String))
MyParameterizedTest, (object: 782830e) TestB with Resource (Immutable Resource (String))
MyParameterizedTest, (object: 782830e) after with Resource (Immutable Resource (String))
MyParameterizedTest, (object: 3fb4f649) Constructor
MyParameterizedTest, (object: 3fb4f649) before with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (object: 3fb4f649) TestA with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (object: 3fb4f649) after with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (object: 200a570f) Constructor
MyParameterizedTest, (object: 200a570f) before with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (object: 200a570f) TestB with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (object: 200a570f) after with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (static method) afterClass
MyExternalResourceRule, (object: 17d10166) after, shutdown
MyDatabase, (object: MyDatabase{databaseName='Database', status='Close'}) Close, Database
```

### The test suite



When running [MySuiteTest.java](MySuiteTest.java) that include the external resource and the test class, you got the following output
where you can see that the external resource is handled gently even if it's present two times:

   * in the test suite class
   * and in each test class.


```
MyExternalResourceRule, (object: 3b764bce) constructor, immutable resource created
MyParameterizedTest, (static method) data
MyExternalResourceRule, (object: 5d22bbb7) constructor, immutable resource already initialized
MyDatabase, (object: MyDatabase{databaseName='Database', status='Open'}) Open, Database
MyExternalResourceRule, (object: 5d22bbb7) before, mutable resource open MyDatabase{databaseName='Database', status='Open'}
MySuiteTest, (static method) beforeClass
MyDatabase, (object: MyDatabase{databaseName='Database', status='Open'}) Open, Database
MyExternalResourceRule, (object: 3b764bce) before, mutable resource open MyDatabase{databaseName='Database', status='Open'}
MyParameterizedTest, (static method) beforeClass
MyParameterizedTest, (object: 73a28541) Constructor
MyParameterizedTest, (object: 73a28541) before with Resource (Immutable Resource (String))
MyParameterizedTest, (object: 73a28541) TestA with Resource (Immutable Resource (String))
MyParameterizedTest, (object: 73a28541) after with Resource (Immutable Resource (String))
MyParameterizedTest, (object: 244038d0) Constructor
MyParameterizedTest, (object: 244038d0) before with Resource (Immutable Resource (String))
MyParameterizedTest, (object: 244038d0) TestB with Resource (Immutable Resource (String))
MyParameterizedTest, (object: 244038d0) after with Resource (Immutable Resource (String))
MyParameterizedTest, (object: 3b22cdd0) Constructor
MyParameterizedTest, (object: 3b22cdd0) before with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (object: 3b22cdd0) TestA with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (object: 3b22cdd0) after with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (object: 4d591d15) Constructor
MyParameterizedTest, (object: 4d591d15) before with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (object: 4d591d15) TestB with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (object: 4d591d15) after with Resource (MyDatabase{databaseName='Database', status='Open'})
MyParameterizedTest, (static method) afterClass
MyExternalResourceRule, (object: 3b764bce) after, still (1) extra alive
MySuiteTest, (static method) afterClass
MyExternalResourceRule, (object: 5d22bbb7) after, shutdown
MyDatabase, (object: MyDatabase{databaseName='Database', status='Close'}) Close, Database
```
