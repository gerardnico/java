package Visitor;

/**
 * Created by gerard on 18-05-2016.
 */
class Engine implements ICarElement {
    public void accept(ICarElementVisitor visitor) {
        visitor.visit(this);
    }
}
