abstract public class Vardesaker implements Comparable<Vardesaker> {

    private String namn;

   public Vardesaker(String namn){
       this.namn=namn;
   }

   public String getNamn(){
       return namn;
   }

   public int compareTo(Vardesaker v) {
       return namn.compareTo(v.namn);
   }

   abstract public Double getVarde();

   public Double getRealVarde(){
       return getVarde()*1.25;
   }
}
