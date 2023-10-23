public class Subscription {
    private String tilattuLehti;
    private String tilaajanNimi;
    private String tilaajanOsoite;
    private double kuukausihinta;

    public Subscription(String tilattuLehti, String tilaajanNimi, String tilaajanOsoite, double kuukausihinta) { //konstruktori
        this.tilattuLehti = tilattuLehti;
        this.tilaajanNimi = tilaajanNimi;
        this.tilaajanOsoite = tilaajanOsoite;
        this.kuukausihinta = kuukausihinta;
    }


	public String getTilattuLehti() { //getterit ja setterit
        return this.tilattuLehti;
    }  
    public void setTilattuLehti(String tilattuLehti) { 
        this.tilattuLehti = tilattuLehti;
    }

    public String getTilaajanNimi() {
        return this.tilaajanNimi;
    }
    public void setTilaajanNimi(String tilaajanNimi) {
        this.tilaajanNimi = tilaajanNimi;
    }

    public String getTilaajanOsoite() {
        return this.tilaajanOsoite;
    }
    public void setTilaajanOsoite(String tilaajanOsoite) {
        this.tilaajanOsoite = tilaajanOsoite;
    }

    public double getKuukausiHinta() {
        return this.kuukausihinta;
    }
    public void setKuukausihinta(double kuukausihinta) {
        this.kuukausihinta = kuukausihinta;
    }
}
