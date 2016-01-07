# Java Type Configuration Values

## Introduction
Configuration values have the following property.

They have:
 
  * an unique key
  * only one value (not a list of value)
  * a simple data type (string, number, may be a path ?)
  * a value domain that may be:
     * delimited (Size Small to Large ie enum) 
     * or not Length (between 0 and 2 m)

## Implementations


### Property
They are normally implemented through [property Map in Java](http://gerardnico.com/wiki/language/java/property) with a string as key and as value.
There is no demonstration there.

 
### DemoConfigSet
A configuration values system implementation through a [configSet](ConfigSet.java).

A config set that lets you use:

  * an [enum class](http://gerardnico.com/wiki/language/java/enum)
  * or any class blueprint

as configuration parameters.

As the unique key is the class name, you can't have two Integers with the class Integer.class, 
you need to encapsulate them in a separate class (See [Length](Length.java)).

Demo: [DemoConfigSet](DemoConfigSet.java)
