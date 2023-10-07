package pl.sliFka.fetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;




public class App
{
    public static void main( String[] args )
    {

        Laptop laptop = new Laptop();
        laptop.setLid(102);
        laptop.setBrand("Acer");
        laptop.setPrice(300);

       // Laptop laptop2 = new Laptop();
       // laptop2.setLid(102);
       // laptop2.setBrand("Acer");
       // laptop2.setPrice(560);
//
       // Laptop laptop3 = new Laptop();
       // laptop2.setLid(103);
       // laptop2.setBrand("DELL");
       // laptop2.setPrice(30020);
//
       // Laptop laptop4 = new Laptop();
       // laptop2.setLid(104);
       // laptop2.setBrand("HP");
       // laptop2.setPrice(9000);
//
       // Laptop laptop5 = new Laptop();
       // laptop2.setLid(105);
       // laptop2.setBrand("Mac");
       // laptop2.setPrice(1234);
//
       // Laptop laptop6 = new Laptop();
       // laptop2.setLid(106);
       // laptop2.setBrand("Samsung");
       // laptop2.setPrice(4332);



        Alien alien = new Alien();
       alien.setAid(1);
       alien.setAname("Romano");
       alien.getLaps().add(laptop);


       //alien.getLaps(4).set(laptop);




        Configuration config = new Configuration().configure().addAnnotatedClass(pl.sliFka.fetch.Laptop.class).addAnnotatedClass(Alien.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry()    ;
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();

        session.beginTransaction();

        session.save(laptop);

        session.save(alien);


        session.getTransaction().commit();




    }
}
