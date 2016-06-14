# Junit - External Resources as Parameters for Parametrized Test

## Introduction

How to run the same test with several different set of External Resources as parameters (ie values).


## Implementation

The implementation is a mix of Junit technology:

  * [Parametrized tests](https://github.com/junit-team/junit4/wiki/Parameterized-tests)
  * and [ExternalResource Rules](https://github.com/junit-team/junit4/wiki/Rules#externalresource-rules)
  
The tricky thing here is that the method that set up the data is called before the `before` method of the `ExternalResource` object.
Therefore it's needed to initialize the external resource not in the `before` method but in the constructor of the `ExternalResource` object.


