package hu.nive.ujratervezes.solarsystem;

import java.util.List;

public class Planet extends SpaceObject {

    private PlanetType planetType;
    private List<Moon> moons;

    public Planet(String name, int mass, PlanetType planetType, List<Moon> moons) {
        super(name, mass);
        this.planetType = planetType;
        this.moons = moons;
    }

    public PlanetType getPlanetType() {
        return planetType;
    }

    public List<Moon> getMoons() {
        return moons;
    }

    public int calculateMassWithMoons() {
        int sumMass = 0;
        sumMass += this.getMass();
        for (Moon moon : moons) {
            sumMass += moon.getMass();
        }
        return sumMass;
    }

    public int calculateClosestDistanceWithMoon() {
        int minDistance = moons.get(0).getPeriapsis();
        for (Moon moon : moons) {
            if (moon.getPeriapsis() < minDistance) {
                minDistance = moon.getPeriapsis();
            }
        }
        return minDistance;
    }

    public int numberOfMoons() {
        return moons.size();
    }

}
