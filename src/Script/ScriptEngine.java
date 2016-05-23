package Script;

import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;

/**
 * Created by gerard on 22-05-2016.
 */
public class ScriptEngine {

    public static void main(String[] args) {
        printEngine();
    }

    private static void printEngine() {
        final ScriptEngineManager manager = new ScriptEngineManager();
        for (final ScriptEngineFactory scriptEngine : manager.getEngineFactories())
        {
            System.out.println(
                    scriptEngine.getEngineName() + " ("
                            + scriptEngine.getEngineVersion() + ")" );
            System.out.println(
                    "\tLanguage: " + scriptEngine.getLanguageName() + "("
                            + scriptEngine.getLanguageVersion() + ")" );
            System.out.println("\tCommon Names/Aliases: "+String.join(", ", scriptEngine.getNames()));

        }
    }
}
