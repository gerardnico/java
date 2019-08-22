package Java.AbstractExtend;

import org.junit.Test;

public class ObjectHierarchyTest {


    @Test(expected = java.lang.ClassCastException.class)
    public void castParentToChildNoAllowedTest() {
        RelationParent relationParent = new RelationParent();
        // No, you can't construct a child from a parent
        RelationChild relationChild = (RelationChild) relationParent;
    }
}
