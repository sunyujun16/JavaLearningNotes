package chap11_InnerClass;

// Configure and execute the greenhouse system

public class A15_GreenhouseController {
    public static void main(String[] args) {
        A14_GreenhouseControls gc = new A14_GreenhouseControls();

        // Instead of using code, you could parse
        // configuration information from a text file:
        gc.addA12_Event(gc.new Bell(900));

        A12_Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400)
        };

        gc.addA12_Event(gc.new Restart(2000, eventList));
        gc.addA12_Event(new A14_GreenhouseControls.Terminate(5000));
        gc.run();
    }
}

