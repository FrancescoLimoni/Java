package midTermProject02;

import java.util.ArrayList;

public class Desktop extends Software {

    ArrayList<String> tower;
    ArrayList<Double> towerPrice;
    ArrayList<String> monitor;
    ArrayList<Double> monitorPrice;

    public Desktop(){

        tower = new ArrayList<>();
        tower.add("Thermaltake Core P5");
        tower.add("Rosewill Dual Fans");
        tower.add("Thermaltake Tower");
        tower.add("Phantom Black ATX");

        towerPrice = new ArrayList<>();
        towerPrice.add(219.99);
        towerPrice.add(249.99);
        towerPrice.add(155.99);
        towerPrice.add(138.28);

        monitor = new ArrayList<>();
        monitor.add("Asus ROG Swift");
        monitor.add("Acer Predator");
        monitor.add("BenQ PD3200U");
        monitor.add("AOC Agon");

        monitorPrice = new ArrayList<>();
        monitorPrice.add(698.99);
        monitorPrice.add(799.99);
        monitorPrice.add(849.99);
        monitorPrice.add(999.99);
    }

}
