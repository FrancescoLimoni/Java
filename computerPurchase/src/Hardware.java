import java.util.ArrayList;

public class Hardware extends Computer {

    ArrayList<String> cpu;
    ArrayList<String> graphic;
    ArrayList<String> ram;

    public Hardware(){
        cpu = new ArrayList<>();
        cpu.add("Intel Core i5");
        cpu.add("Intel Core i7");
        cpu.add("Intel Core i5");

        graphic = new ArrayList<>();
        graphic.add("Intel HD Graphics 6000");
        graphic.add("Intel HD Graphics 5000");
        graphic.add("Intel HD Graphics 7000");

        ram = new ArrayList<>();
        ram.add("256MB DDR module");
        ram.add("2GB DDR2");
        ram.add("2GB DDR3");
    }


}
