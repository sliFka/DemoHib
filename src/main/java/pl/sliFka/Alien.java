package pl.sliFka;

import javax.persistence.*;

@Entity
@Table(name="moja_nazwa_tabeli")
public class Alien { //POJO ??
    @Id
    private int aid;
    @Column(name="alien_name")
    private AlienNamee aname;
   // @Transient
    private String color;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public AlienNamee getAname() {
        return aname;
    }

    public void setAname(AlienNamee aname) {
        this.aname = aname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}
