package metier;

import dao.IDao;

public class MetierImpl implements IMetier {
    //couplg faible
    private IDao dao;
    @Override
    public double calcul() {
        double tmp=dao.getData();
        double res=tmp*540/Math.cos(tmp*Math.PI);
        return res;
    }
/*Injecter dans var dao un obj d une
class qui impl l interf IDao*/
    public void setDao(IDao dao) {
        this.dao = dao;
    }
}
