package Java.Visitor;

/**
 * Created by gerard on 18-05-2016.
 */
interface ICarElement {

    void accept(ICarElementVisitor visitor);

}