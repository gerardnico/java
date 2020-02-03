package Java.AbstractExtend;

public class RelationParent extends RelationAbs {


    public RelationParent() {
        super();
    }

    @Override
    public RelationParent add(Integer i) {
        super.add(i);
        return this;
    }
}
