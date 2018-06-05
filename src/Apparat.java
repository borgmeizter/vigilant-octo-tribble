public class Apparat extends Vardesaker {

    private int slitning;
    private Double inkopspris;

    public Apparat(String namn, int slitning, double inkopspris){
        super(namn);
        this.slitning=slitning;
        this.inkopspris=inkopspris;

    }


    public double getInkopspris(){
        return inkopspris;
    }

    public Double getVarde(){
        return (inkopspris * (slitning/(10.0)));
    }

    public int getSlitning(){
        return slitning;
    }


    public String toString() {
        return "Namn: " + this.getNamn() + " | Inköpspris: " + this.inkopspris
                + " | Slitage: " + this.getSlitning() + " | Värde: " + this.getRealVarde();
    }

}

