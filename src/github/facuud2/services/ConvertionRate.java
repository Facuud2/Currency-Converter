package github.facuud2.services;

public class ConvertionRate {
    private String base_code;
    private String target_code;
    private float conversion_rate;

    public ConvertionRate(ConvertionRateRec convertionRateRec) {
        this.base_code = convertionRateRec.base_code();
        this.target_code = convertionRateRec.target_code();
        this.conversion_rate = convertionRateRec.conversion_rate();
    }

    public String getBase_code() {
        return base_code;
    }

    public String getTarget_code() {
        return target_code;
    }

    public float getConversion_rate() {
        return conversion_rate;
    }

    @Override
    public String toString() {
        return "ConvertionRate{" +
                "Moneda base='" + base_code + '\'' +
                ", Moneda objetivo='" + target_code + '\'' +
                ", Ratio de conversion=" + conversion_rate +
                '}';
    }
}
