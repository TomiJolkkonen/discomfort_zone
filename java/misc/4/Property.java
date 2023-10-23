public class Property {
    private String type;
    private String location;

    public Property (String type, String location) {
        this.setType(type);
        this.setLocation(location);
    }

    public String getType () { //getters and setters
        return this.type;
    }
    public void setType (String type) {
        this.type = type;
    }

    public String getLocation () {
        return this.location;
    }
    public void setLocation (String location) {
        this.location = location;
    }
}
