package chap29_references;

class OceanReading implements Cloneable {
    private DepthReading depth;
    private TemperatureReading temperature;

    public OceanReading(double tdata, double ddata) {
        temperature = new TemperatureReading(tdata);
        depth = new DepthReading(ddata);
    }

    @Override
    public OceanReading clone() {
        OceanReading or = null;
        try {
            or = (OceanReading) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        // Must clone references:
        or.depth = (DepthReading) or.depth.clone();
        or.temperature =
                (TemperatureReading) or.temperature.clone();
        return or;
    }

    public TemperatureReading getTemperatureReading() {
        return temperature;
    }

    public void
    setTemperatureReading(TemperatureReading tr) {
        temperature = tr;
    }

    public DepthReading getDepthReading() {
        return depth;
    }

    public void setDepthReading(DepthReading dr) {
        this.depth = dr;
    }

    @Override
    public String toString() {
        return "temperature: " + temperature +
                ", depth: " + depth;
    }
}

public class A02_OceanReading {
}
