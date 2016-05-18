package Visitor;

/**
 * Created by gerard on 18-05-2016.
 */
class Car implements ICarElement {
    ICarElement[] elements;

    public Car() {

        this.elements = new ICarElement[] {
                new Wheel("front left"),
                new Wheel("front right"),
                new Wheel("back left") ,
                new Wheel("back right"),
                new Body(),
                new Engine() };

    }

    public void accept(ICarElementVisitor visitor) {

        for(ICarElement elem : elements) {
            elem.accept(visitor);
        }
        visitor.visit(this);

    }
}
