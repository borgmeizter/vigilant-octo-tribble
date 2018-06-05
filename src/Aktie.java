

public class Aktie extends Vardesaker {

    private int aktiemangd;
    private Double aktiekurs;

    public Aktie(String namn, int aktiemangd, Double aktiekurs) {
        super(namn);
        this.aktiemangd = aktiemangd;
        this.aktiekurs = aktiekurs;

    }

    public int getAktiemangd() {
        return aktiemangd;
    }

    public Double getAktiekurs() {
        return aktiekurs;
    }

    public Double getVarde() {
        return (aktiemangd * aktiekurs);
    }

    public String toString() {
        return "Namn: " + this.getNamn() + " | Antal: " + this.getAktiemangd() + " | Kurs: " + this.getAktiekurs() + " | Värde: "
                + this.getRealVarde();


    }
}
