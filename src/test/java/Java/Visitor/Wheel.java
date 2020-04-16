package Java.Visitor;

/**
 * Created by gerard on 18-05-2016.
 */
class Wheel implements ICarElement {

    private String name;

    public Wheel(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void accept(ICarElementVisitor visitor) {
        /*
         * accept(ICarElementVisitor) in Wheel implements
         * accept(ICarElementVisitor) in ICarElement, so the call
         * to accept is bound at run time. This can be considered
         * the first dispatch. However, the decision to call
         * visit(Wheel) (as opposed to visit(Engine) etc.) can be
         * made during compile time since 'this' is known at compile
         * time to be a Wheel. Moreover, each implementation of
         * ICarElementVisitor implements the visit(Wheel), which is
         * another decision that is made at run time. This can be
         * considered the second dispatch.
         */
        visitor.visit(this);
    }

}