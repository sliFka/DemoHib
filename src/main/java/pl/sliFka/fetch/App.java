package pl.sliFka.fetch;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;


public class App
{
    public static void main( String[] args )
    {

        Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setBrand("Acer");
        laptop.setPrice(300);

       Laptop laptop2 = new Laptop();
       laptop2.setLid(102);
       laptop2.setBrand("Acer");
       laptop2.setPrice(560);
       Laptop laptop3 = new Laptop();
       laptop3.setLid(103);
       laptop3.setBrand("DELL");
       laptop3.setPrice(30020);
       Laptop laptop4 = new Laptop();
       laptop4.setLid(104);
       laptop4.setBrand("HP");
       laptop4.setPrice(9000);
       Laptop laptop5 = new Laptop();
       laptop5.setLid(105);
       laptop5.setBrand("Mac");
       laptop5.setPrice(1234);

       Laptop laptop6 = new Laptop();
       laptop6.setLid(106);
       laptop6.setBrand("Samsung");
       laptop6.setPrice(4332);

        Laptop laptop7 = new Laptop();
        laptop7.setLid(107);
        laptop7.setBrand("Asus");
        laptop7.setPrice(4332);



       List<Laptop> laptopList = new ArrayList<>(List.of(laptop,laptop2, laptop3, laptop4, laptop5, laptop6, laptop7));

       // var laptopList2 = new ArrayList<>(List.of(laptop,laptop2, laptop3, laptop4, laptop5, laptop6));

        Alien alienObject = new Alien();


       alienObject.setAid(1);
       alienObject.setAname("Romano");
       /*alienObject.getLaps().add(laptop);
        alienObject.getLaps().add(laptop2);
        alienObject.getLaps().add(laptop3);
        alienObject.getLaps().add(laptop4);
        alienObject.getLaps().add(laptop5);
        alienObject.getLaps().add(laptop6);*/
        alienObject.setLaps(laptopList);

        ///alienObject.getLaps().forEach( l -> l.setAlien(alienObject));

       //alienObject.getLaps(4).set(laptop);
        //jestem zajebisty




        Configuration config = new Configuration().configure().addAnnotatedClass(pl.sliFka.fetch.Laptop.class).addAnnotatedClass(Alien.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry()    ;
        SessionFactory sf = config.buildSessionFactory(reg);
        Session session = sf.openSession();

        session.beginTransaction();

        session.save(laptop);
        session.save(laptop2);
        session.save(laptop3);
        session.save(laptop4);
        session.save(laptop5);
        session.save(laptop6);
        session.save(laptop7);



        session.save(alienObject);


        session.getTransaction().commit();




    }
}
