package metier;

import dao.IDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MetierImpl implements IMetier {
    //couplg faible
    @Autowired
   @Qualifier("dao2")
    private IDao dao;

    public MetierImpl(IDao dao){
        this.dao=dao;
    }
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
