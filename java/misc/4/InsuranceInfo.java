public class InsuranceInfo {
    private Property property;
    private double value;

    public InsuranceInfo (Property property, double value) {
        this.setProperty(property);
        this.setValue(value);
    }

    public Property getProperty () { //getters and setters
        return this.property;
    }
    public void setProperty (Property property) {
        this.property = property;
    }

    public double getValue () {
        return this.value;
    }
    public void setValue (double value) {
        this.value = value;
    }

}
