package hu.nive.ujratervezes.solarsystem;

public class Moon extends SpaceObject{

    private int periapsis;

    public Moon(String name, int mass, int periapsis) {
        super(name, mass);
        this.periapsis = periapsis;
    }

    public int getPeriapsis() {
        return periapsis;
    }



}
