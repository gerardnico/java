package Visitor;

/**
 * Created by gerard on 18-05-2016.
 */
interface ICarElementVisitor {

    void visit(Wheel wheel);
    void visit(Engine engine);
    void visit(Body body);
    void visit(Car car);

}