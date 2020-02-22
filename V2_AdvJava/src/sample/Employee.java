package sample;

import java.util.UUID;

public class Employee implements Worker{
    public String fname;
    public String lname;
    public UUID empid;
    public boolean isActive;

    @Override
    public String toString(){
        return this.fname + " " + this.lname;
    }

    @Override
    public void hire() {
        isActive = true;
    }

    @Override
    public void fire() {
        isActive = false;
    }
}
