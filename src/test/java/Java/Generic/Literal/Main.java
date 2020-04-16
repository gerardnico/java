package Java.Generic.Literal;

import java.util.Collection;

public class Main {


    /**
     * Direct Instantiation of a class with the help of generic and reflection
     */
    public void withAndWithoutGeneric() {

        // Without, we get a generic collection
        Collection emps = SqlUtility.selectWithoutGeneric(EmpInfo.class, "select * from emps");

        // We get  collection of the precise type (in a type safe way)
        Collection<EmpInfo> empsWithGeneric = SqlUtility.selectWithGeneric(EmpInfo.class, "select * from emps");

    }

    /**
     * Instantiation via a Generic Factory
     *
     * A verbose call to build a collection of EmpInfo
     * {@link #getEmpInfoViaEmpInfoFactory(String)} use a factory class and is less verbose
     * @param query
     * @return
     */
    public Collection<EmpInfo> getEmpInfoViaGenericFactory(String query) {

        return SqlUtility.get(
                new GenericFactory<EmpInfo>() {
                    public EmpInfo make() {
                        return new EmpInfo();
                    }
                }, query);

    }

    /**
     * Same as {@link #getEmpInfoViaGenericFactory(String)} but with a specialized factory
     * @param query
     * @return
     */
    public Collection<EmpInfo> getEmpInfoViaEmpInfoFactory(String query) {

        return SqlUtility.get( new EmpInfoFactory(), query);

    }




}
