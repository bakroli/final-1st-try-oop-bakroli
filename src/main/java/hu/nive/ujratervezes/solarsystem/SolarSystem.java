package hu.nive.ujratervezes.solarsystem;

import java.util.List;

public class SolarSystem {
    private List<Planet> planets;

    public SolarSystem(List<Planet> planets) {
        this.planets = planets;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public int countPlanetByType(PlanetType planetType) {
        int countPlanet = 0;
        for (Planet planet : planets) {
            if (planet.getPlanetType() == planetType) {
                countPlanet += 1;
            }
        }
        return countPlanet;
    }

    public void addPlanet(Planet planet) {
        planets.add(planet);
    }

    public void removePlanetByName(String name) {
        Planet removePlanet = null;
        for (Planet planet : planets) {
            if (planet.getName().equals(name)) {
                removePlanet = planet;
            }
        }
        if (removePlanet != null) {
            planets.remove(removePlanet);
        }
    }

    public Planet findPlanetWithMostMoons() {
        Planet planetFullMoon = null;
        int moonNumber = 0;
        for (Planet planet : planets) {
            if (planet.getMoons().size() > moonNumber) {
                moonNumber = planet.getMoons().size();
                planetFullMoon = planet;
            }
        }
        return planetFullMoon;
    }

}
