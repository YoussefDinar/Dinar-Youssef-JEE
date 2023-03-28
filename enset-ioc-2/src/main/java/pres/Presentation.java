package pres;
import dao.DaoImpl;
import ext.DaoImpl2;
import metier.MetierImpl;

public class Presentation {
    public static void main (String [] args){
        /*Injection des depd par instanc statique
        * => new */
        DaoImpl2 dao = new DaoImpl2();
        MetierImpl metier=new MetierImpl(dao);
        //metier.setDao(dao);
        System.out.println("Resultats="+metier.calcul());
    }
}
