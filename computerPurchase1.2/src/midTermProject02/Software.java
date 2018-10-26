package midTermProject02;

import java.util.ArrayList;

public abstract class Software extends Hardware {

    ArrayList<String> operatingSystem;

    public Software(){

        operatingSystem = new ArrayList<>();
        operatingSystem.add("Google Chrome");
        operatingSystem.add("Window 10");
        operatingSystem.add("macOS");
        operatingSystem.add("Linux");
    }
}
