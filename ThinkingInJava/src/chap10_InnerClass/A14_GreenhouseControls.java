package chap10_InnerClass;
// This produces a specific application of the
// control system, all in a single class. Inner
// classes allow you to encapsulate different
// functionality for each type of event.
public class A14_GreenhouseControls extends A13_Controller {
    private boolean light = false;

    public class LightOn extends A12_Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control code here to
            // physically turn on the light.
            light = true;
        }

        @Override
        public String toString() {
            return "Light is on";
        }
    }

    public class LightOff extends A12_Event {
        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control code here to
            // physically turn off the light.
            light = false;
        }

        @Override
        public String toString() {
            return "Light is off";
        }
    }

    private boolean water = false;

    public class WaterOn extends A12_Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control code here.
            water = true;
        }

        @Override
        public String toString() {
            return "Greenhouse water is on";
        }
    }

    public class WaterOff extends A12_Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control code here.
            water = false;
        }

        @Override
        public String toString() {
            return "Greenhouse water is off";
        }
    }

    private String thermostat = "Day";

    public class ThermostatNight extends A12_Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control code here.
            thermostat = "Night";
        }

        @Override
        public String toString() {
            return "Thermostat on night setting";
        }
    }

    public class ThermostatDay extends A12_Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // Put hardware control code here.
            thermostat = "Day";
        }

        @Override
        public String toString() {
            return "Thermostat on day setting";
        }
    }

    // An example of an action() that inserts a
    // new one of itself into the event list:
    public class Bell extends A12_Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            //delayTime来自父类, 且已由上面的构造方法初始化.
            addA12_Event(new Bell(delayTime.toMillis()));
        }

        @Override
        public String toString() {
            return "Bing!";
        }
    }

    public class Restart extends A12_Event {
        private A12_Event[] eventList;

        public Restart(long delayTime, A12_Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            for (A12_Event e : eventList)
                addA12_Event(e);
        }

        @Override
        public void action() {
            for (A12_Event e : eventList) {
                e.start(); // Rerun each event
                addA12_Event(e);
            }
            start(); // Rerun this Event
            addA12_Event(this);
        }

        @Override
        public String toString() {
            return "Restarting system";
        }
    }

    public static class Terminate extends A12_Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }

        @Override
        public String toString() {
            return "Terminating";
        }
    }
}

class NewGreenControls extends A14_GreenhouseControls{
    private boolean jet = false;

    public class WaterJetOn extends A12_Event{
        public WaterJetOn(long millisecondDelay) {
            super(millisecondDelay);
        }

        @Override
        public void action() {
            jet = true;
        }

        @Override
        public String toString() {
            return "Water jet is on";
        }
    }

    public class WaterJetOff extends A12_Event{
        public WaterJetOff(long millisecondDelay) {
            super(millisecondDelay);
        }

        @Override
        public void action() {
            jet = true;
        }

        @Override
        public String toString() {
            return "Water jet is off";
        }
    }


}
