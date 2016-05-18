package Visitor;

/**
 * Created by gerard on 18-05-2016.
 */
public class Main {


    public static void main(String[] args) {

        ICarElement car = new Car();
        System.out.println("Print Visitor:");
        car.accept(new CarElementPrintVisitor());

        System.out.println("");
        System.out.println("Do Visitor:");
        car.accept(new CarElementDoVisitor());

    }


}
