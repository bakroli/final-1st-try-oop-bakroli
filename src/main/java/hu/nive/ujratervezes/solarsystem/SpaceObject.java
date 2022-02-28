package hu.nive.ujratervezes.solarsystem;

public class SpaceObject {
    private String name;
    private int mass;

    public SpaceObject(String name, int mass) {
        this.name = name;
        this.mass = mass;
    }

    public String getName() {
        return name;
    }

    public int getMass() {
        return mass;
    }
}
