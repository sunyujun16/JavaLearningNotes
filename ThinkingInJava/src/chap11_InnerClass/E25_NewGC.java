package chap11_InnerClass;

public class E25_NewGC {
    public static void main(String[] args) {
        NewGreenControls ngc = new NewGreenControls();

        // Instead of using code, you could parse
        // configuration information from a text file:
        ngc.addA12_Event(ngc.new Bell(700));

        A12_Event[] eventList = {
                ngc.new ThermostatNight(0),
                ngc.new LightOn(200),
                ngc.new LightOff(400),
                ngc.new WaterOn(600),
                ngc.new WaterOff(800),
                ngc.new ThermostatDay(1400),
                ngc.new WaterJetOn(1600),
                ngc.new WaterJetOff(1800),
        };

        ngc.addA12_Event(ngc.new Restart(2000, eventList));
        ngc.addA12_Event(new A14_GreenhouseControls.Terminate(5000));
        ngc.run();
    }
}