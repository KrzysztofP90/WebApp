package model;


import javax.persistence.*;

@Entity
public class Background {

    @Id
    private String allias;

    private String name;
    private boolean active;



    public Background() {
    }

    public Background(String name, boolean active, String allias) {
        this.name = name;
        this.active = active;
        this.allias = allias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getAllias() { return allias; }

    public void setAllias(String allias) { this.allias = allias; }
}
