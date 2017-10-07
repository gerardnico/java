package Java.Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Arrays {


    @Test
    public void sort() throws Exception {

        ArrayList<Person> personArray = new ArrayList();
        personArray.add(new Person("Gerard","Nico", 44.4));
        personArray.add(new Person("Van Der Veen","MonAmour", 40.0));
        personArray.add(new Person("Ger","Madelief", 11.0));
        personArray.add(new Person("Gerard","Mélissa", 8.0));

        System.out.println("Sort by LastName Ascendant (Default)");
        Collections.sort(personArray);
        printCollection(personArray);
        System.out.println();

        System.out.println("Sort by LastName Descendant with an inline comparator");
        Collections.sort(personArray, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {

                return o2.LastName.compareTo(o1.LastName);
            }
        });
        printCollection(personArray);
        System.out.println();


        System.out.println("Sort by Age Ascendant with Lambda Expression (Java 8)");
        Collections.sort(personArray, (o1, o2) -> o1.Age.compareTo(o2.Age));
        printCollection(personArray);
        System.out.println();

        System.out.println("Sort by LastName Ascendant from the Array with Lambda Expression (Java 8)");
        personArray.sort((o1, o2) -> o1.LastName.compareTo(o2.LastName));
        printCollection(personArray);
        System.out.println();


    }

    private void printCollection(ArrayList<Person> personArray) {
        String format = "%16s%16s%10s%n";
        System.out.format(format, "LastName", "FirstName", "Age");
        // %n translate to the end of line of the OS (ie \n for Linux or \r\n for Windows)
        for (Person person: personArray){
            System.out.format(format, person.LastName, person.FirstName, person.Age);
        }
    }
}
