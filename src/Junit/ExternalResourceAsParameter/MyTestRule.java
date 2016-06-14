package Junit.ExternalResourceAsParameter;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.List;

/**
 * Created by gerard on 14-06-2016.
 * http://stackoverflow.com/questions/3060631/junit-rule-to-pass-parameter-to-test
 */
public class MyTestRule implements TestRule  {

    private int parameterIndex = 0;
    private List<String> parameters;
    public MyTestRule(List<String> someParameters){
        System.out.printf(MyTestRule.class.getSimpleName()+", constructor");
        parameters = someParameters;
    }

    public String getParameter(){
        return parameters.get(parameterIndex);
    }


    @Override
    public Statement apply(Statement statement, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                for (int i = 0; i < parameters.size(); i++){
                    parameterIndex = i;
                    System.out.printf(MyTestRule.class.getSimpleName()+", evaluate, Parameter before : "+getParameter()+"\n");
                    statement.evaluate();

                }
            }
        };
    }
}
