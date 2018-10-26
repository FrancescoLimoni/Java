package midTermProject02;

import java.util.ArrayList;

public abstract class Hardware {

     ArrayList<String> ram;
     ArrayList<Double> ramPrice;
     ArrayList<String> cpu;
     ArrayList<Double> cpuPrice;
     ArrayList<String> graphic;
     ArrayList<Double> graphicPrice;

    public Hardware(){

        ram = new ArrayList<>();
        ram.add("256MB DDR");
        ram.add("2GB DDR2 ");
        ram.add("2GB DDR3 ");
        ram.add("8GB DDR4 ");

        ramPrice = new ArrayList<>();
        ramPrice.add(89.99);
        ramPrice.add(77.99);
        ramPrice.add(85.99);
        ramPrice.add(99.99);

        cpu = new ArrayList<>();
        cpu.add("AMD Ryzen 5  ");
        cpu.add("Intel Core i5");
        cpu.add("Intel Core i7");
        cpu.add("Intel Pentium");

        cpuPrice = new ArrayList<>();
        cpuPrice.add(189.99);
        cpuPrice.add(199.99);
        cpuPrice.add(341.99);
        cpuPrice.add(103.99);

        graphic = new ArrayList<>();
        graphic.add("AMD Radeon RX 580 ");
        graphic.add("AMD Radeon RX Vega");
        graphic.add("Nvidia GeForce RTX");
        graphic.add("Nvidia GeForce GTX");

        graphicPrice = new ArrayList<>();
        graphicPrice.add(239.99);
        graphicPrice.add(399.99);
        graphicPrice.add(499.99);
        graphicPrice.add(699.99);
    }
}
