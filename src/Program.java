import java.util.ArrayList;

public class Program {
    public static void main(String args[]) {

    ArrayList<Vardesaker> saker = new ArrayList<>();


        Smycke s1 = new Smycke("Halsband", 1, true);
        saker.add(s1);
        Smycke s2 = new Smycke("Armband", 3, true);
        saker.add(s2);
        Aktie ak1 = new Aktie("Ericsson", 4, 0.25);
        saker.add(ak1);
        Apparat ap1 = new Apparat("Teve", 3000, 5);
        saker.add(ap1);
        Apparat ap2 = new Apparat("Ipad", 6000, 1);
        saker.add(ap2);
        Apparat ap3 = new Apparat("Android", 2000, 7);
        saker.add(ap3);

        System.out.println(saker);

       
    }
    public void nyttSmycke() {
        SmyckeNy smyckesForm = new SmyckeNy();
    }
   
}
