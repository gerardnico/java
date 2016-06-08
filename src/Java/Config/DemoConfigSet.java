package Java.Config;



/**
 * Created by gerard on 06-01-2016.
 */
public class DemoConfigSet {

    public static void main(String[] args) {


        System.out.println("A configSet that kept only one instance of one enum class");
        ConfigSet<ConfigParameter> configParameters = new ConfigSet<ConfigParameter>();
        System.out.println("We add two sizes enum, the last one MEDIUM must stay");
        configParameters.add(Size.SMALL);
        configParameters.add(Size.MEDIUM);
        configParameters.add(Color.BLUE);
        configParameters.add(Length.of(180));
        configParameters.add(Length.of(182));

        System.out.println();
        System.out.println("Only one size and one color !");
        for (ConfigParameter butterfly:configParameters){
            System.out.println(butterfly);
        }

        System.out.println();
        System.out.println("And we can get the size without a cast!");
        Size size = configParameters.get(Size.class);
        if (size == Size.MEDIUM ) {
            System.out.println("size is "+ size );
        }


    }
}
