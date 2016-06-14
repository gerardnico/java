# Junit - Parametrized Test

## Introduction

How to run the same test with several different set of parameters (ie values).

## Methods

The two first methods are the standard method of Junit (See [Parametrized tests](https://github.com/junit-team/junit4/wiki/Parameterized-tests))

  * With a constructor: [ParametersWithConstructorTest.java](ParametersWithConstructorTest.java)
  * With a annotation injection: [ParametersWithParameterAnnotationTest.java](ParametersWithParameterAnnotationTest.java)
  * With a [rule](https://github.com/junit-team/junit4/wiki/Rules) that loops over its passed parameters and calls the test method several times: [MyRuleParametersTest.java](MyRuleParametersTest.java)
  
  

