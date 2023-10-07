package pl.sliFka;

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
      //  AlienNamee an = new AlienNamee();
      //  an.setfName("Romek");
      //  an.setmName("Tomek");
      //  an.setlName("Atomek");

      //  Alien telusko = new Alien();
      // telusko.setAid(101);
      // telusko.setAname(an);
      // telusko.setColor("blue");


        Laptop laptop = new Laptop();
        laptop.setLid(101);
        laptop.setLname("Dell");


        Student stud = new Student();
        stud.setName("Bartek");
        stud.setRollno(1);
        stud.setMarks(50);
        stud.getLaptop().add(laptop);

        laptop.getStudent().add(stud);


        //Configuration con = new Configuration().configure().addAnnotatedClass(Alien.class);
        Configuration con = new Configuration().configure().addAnnotatedClass(Student.class).addAnnotatedClass(Laptop.class);
        ServiceRegistry reg = new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry()    ;
        SessionFactory sf = con.buildSessionFactory(reg);
        Session session = sf.openSession();
      //  Transaction tx= session.beginTransaction();
       // session.save(telusko);
      //  telusko = (Alien)  session.get(Alien.class,102);
        //  tx.commit();
        session.beginTransaction();
        session.save(laptop);
        session.save(stud);

        session.getTransaction().commit();



     //   System.out.println(telusko);
    }
}
