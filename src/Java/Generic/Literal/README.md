# Literal Class


## About

The package that shows how to use generic literal class to return safely an object from a any other serialization method
(such as configuration file or query statement).

Technique of using class literals as run time type tokens is a very useful trick to know. It's an idiom that's used extensively in the new APIs for manipulating annotations, for example.

Call Example are in [Main](Main.java)

```java
public static <T> Collection<T> selectWithGeneric(Class<T> c, String sqlStatement) {
        Collection<T> result = new ArrayList<T>();
        /* Run sql query using jdbc. */
        for (/* Iterate over jdbc results. */ ) {
            T item = null;
            try {
                item = c.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            /* Use reflection and set all of item's
             * fields from sql results.
             */
            result.add(item);
        }
        return result;
    }
```
