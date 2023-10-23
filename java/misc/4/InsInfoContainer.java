import java.util.ArrayList;

public class InsInfoContainer {
    ArrayList<InsuranceInfo> datacontainer;

    public InsInfoContainer () {
        this.datacontainer = new ArrayList<InsuranceInfo>();
    }
    public InsInfoContainer (InsuranceInfo data) {
        this.datacontainer = new ArrayList<InsuranceInfo>();
        datacontainer.add(data);
    }
    public void add (InsuranceInfo data) {
        this.datacontainer.add(data);
    }

    public void printContents () {
        for (InsuranceInfo data : this.datacontainer) {
            System.out.println(data.getProperty().getType());
            System.out.println(data.getProperty().getLocation());
            System.out.println("Normaali arvo: " + data.getValue());
        }
    }
    public void printBigger (double value) {
        for (InsuranceInfo data : this.datacontainer) {
            if(data.getValue() > value) {
                System.out.println(data.getProperty().getType());
                System.out.println(data.getProperty().getLocation());
                System.out.println("Suurempi arvo: " + data.getValue());
            }
        }
    }
    public void printSmaller (double value) {
        for (InsuranceInfo data : this.datacontainer) {
            if(data.getValue() < value) {
                System.out.println(data.getProperty().getType());
                System.out.println(data.getProperty().getLocation());
                System.out.println("Pienempi arvo: " + data.getValue());
            }
        }
    }
}
