public class Smycke extends Vardesaker {
    private int mangdstenar;
    private boolean material;
    private Double urvarde;

    public Smycke(String namn, int mangdstenar, boolean material) {
        super(namn);
        this.mangdstenar = mangdstenar;
        this.material = material;
    }


    public int getMangdStenar() {
        return mangdstenar;
    }

    public boolean getMaterial() {
        return material;
    }

    public String getMaterialTyp() {
        if (material)
            return "Guld";
        else {
            return "Silver";
        }

    }

    public Double getVarde() {
        if (material) {

            urvarde = 2000.00;
        } else {
            urvarde = 700.00;
        }

        return (urvarde + (500 * mangdstenar));
    }

    public String toString() {
        return "Namn: " + this.getNamn() + " | Material: " + this.getMaterialTyp()
                + " | Värde: " + this.getRealVarde();
    }
}