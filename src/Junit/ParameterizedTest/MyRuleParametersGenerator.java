package Junit.ParameterizedTest;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

import java.util.List;

/**
 * Created by gerard on 14-06-2016.
 * http://stackoverflow.com/questions/3060631/junit-rule-to-pass-parameter-to-test
 */
public class MyRuleParametersGenerator implements org.junit.rules.TestRule {

    private int parameterIndex = 0;
    private List<String> parameters;
    public MyRuleParametersGenerator(List<String> someParameters){
        parameters = someParameters;
    }

    public String getParameter(){
        return parameters.get(parameterIndex);
    }


    @Override
    public Statement apply(final Statement statement, Description description) {
        return new Statement() {
            @Override
            public void evaluate() throws Throwable {
                for (int i = 0; i < parameters.size(); i++){
                    parameterIndex = i;
                    statement.evaluate();
                }
            }
        };
    }
}
