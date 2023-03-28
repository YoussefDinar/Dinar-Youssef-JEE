package dao;

import org.springframework.stereotype.Component;

@Component("dao")
public class DaoImpl implements IDao{

    @Override
    public double getData() {
        /* connexion a la B.D*/
        System.out.println("version base de donnees");
       double temp=Math.random()*40;
        return temp;
    }
}
