package hu.nive.ujratervezes.solarsystem;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SolarSystemTest {

        private Planet createPlanetOne(){
            List<Moon> moonsOfFirstPlanet = new ArrayList<Moon>(){{
                add(new Moon("moon1",12,1200));
                add(new Moon("moon2",8,1700));
            }};
            return new Planet("planet1", 500,PlanetType.NORMAL,moonsOfFirstPlanet );
        }

        private Planet createPlanetTwo(){
            List<Moon> moonsOfSecondPlanet = new ArrayList<Moon>(){{
                add(new Moon("moon1",16,500));
                add(new Moon("moon2",5,1700));
                add(new Moon("moon3",9,2700));
            }};
            return new Planet("planet2", 600,PlanetType.GAS_GIANT,moonsOfSecondPlanet );
        }

        private Planet createPlanetThree(){
            List<Moon> moonsOfThirdPlanet = new ArrayList<Moon>(){{
                add(new Moon("moon1",20,600));
            }};
            return new Planet("planet3", 400,PlanetType.NORMAL,moonsOfThirdPlanet );
        }

        private Planet createPlanetFour(){
            List<Moon> moonsOfFourthPlanet = new ArrayList<Moon>(){{
                add(new Moon("moon1",22,1600));
            }};
            return new Planet("planet4", 30000,PlanetType.GAS_GIANT,moonsOfFourthPlanet);
        }

        private Planet createPlanetFive(){
            List<Moon> moonsOfFifthPlanet = new ArrayList<Moon>(){{
                add(new Moon("moon1",20,600));
            }};
            return new Planet("planet5", 45000,PlanetType.NORMAL,moonsOfFifthPlanet );
        }

        private List<Planet> createPlanets(){
            return new ArrayList<Planet>(){{
                add(createPlanetOne());
                add(createPlanetTwo());
                add(createPlanetThree());
                add(createPlanetFour());
                add(createPlanetFive());
            }};
        }

        @Test
        void test_getPlanets(){
            List<Planet> planets = createPlanets();
            SolarSystem solarSystem = new SolarSystem(planets);
            assertEquals(planets,solarSystem.getPlanets());
        }

        @Test
        void test_countPlanetType_gasGiant(){
            List<Planet> planets = createPlanets();
            SolarSystem solarSystem = new SolarSystem(planets);
            assertEquals(2,solarSystem.countPlanetByType(PlanetType.GAS_GIANT));
        }

        @Test
        void test_countPlanetType_normal(){
            List<Planet> planets = createPlanets();
            SolarSystem solarSystem = new SolarSystem(planets);
            assertEquals(3,solarSystem.countPlanetByType(PlanetType.NORMAL));
        }

        @Test
        void test_addPlanet(){
            List<Planet> planets = new ArrayList<>();
            SolarSystem solarSystem = new SolarSystem(planets);
            Planet planet = createPlanetOne();
            solarSystem.addPlanet(planet);
            assertTrue(solarSystem.getPlanets().contains(planet));
        }

        @Test
        void test_removePlanetByName(){
            Planet planetOne = createPlanetOne();
            Planet planetTwo = createPlanetTwo();
            Planet planetThree = createPlanetThree();
            List<Planet> planets = new ArrayList<Planet>(){{
                add(planetOne);
                add(planetTwo);
                add(planetThree);
            }};
            List<Planet> expectedPlanets = new ArrayList<Planet>(){{
                add(planetOne);
                add(planetThree);
            }};
            SolarSystem solarSystem = new SolarSystem(planets);
            solarSystem.removePlanetByName("planet2");
            assertEquals(expectedPlanets, solarSystem.getPlanets());
        }

        @Test
        void test_findPlanetWithMostMoons(){
            Planet planetOne = createPlanetOne();
            Planet planetTwo = createPlanetTwo();
            Planet planetThree = createPlanetThree();
            List<Planet> planets = new ArrayList<Planet>(){{
                add(planetOne);
                add(planetTwo);
                add(planetThree);
            }};
            SolarSystem solarSystem = new SolarSystem(planets);
            assertEquals(planetTwo,solarSystem.findPlanetWithMostMoons());
        }

        @Test
        void test_getPeriapsis(){
            Moon moon = new Moon("testMoon",10,150);
            assertEquals(150,moon.getPeriapsis());
        }

        @Test
        void test_moonIsSpaceObject(){
            Moon moon = new Moon("testMoon",10,150);
            assertTrue(moon instanceof SpaceObject);
        }

        @Test
        void test_getPlanetTypeWorksForNormalPlanet(){
            Planet planet = createPlanetOne();
            assertEquals(PlanetType.NORMAL, planet.getPlanetType());
        }

        @Test
        void test_getPlanetTypeWorksForGasGiant(){
            Planet planet = createPlanetTwo();
            assertEquals(PlanetType.GAS_GIANT, planet.getPlanetType());
        }

        @Test
        void test_getMoons(){
            List<Moon> moonsOfPlanet = new ArrayList<Moon>(){{
                add(new Moon("moon1",16,500));
                add(new Moon("moon2",5,1700));
                add(new Moon("moon3",9,2700));
                add(new Moon("moon4",9,2700));
            }};
            Planet planet = new Planet("planet", 10, PlanetType.NORMAL,moonsOfPlanet);
            assertEquals(moonsOfPlanet,planet.getMoons());
        }

        @Test
        void test_calculateMassWithMoons(){
            Planet planet = createPlanetTwo();
            assertEquals(630,planet.calculateMassWithMoons());
        }

        @Test
        void test_calculateClosestDistanceWithMoon(){
            Planet planet = createPlanetTwo();
            assertEquals(500,planet.calculateClosestDistanceWithMoon());
        }

        @Test
        void test_numberOfMoons(){
            Planet planet = createPlanetTwo();
            assertEquals(3,planet.numberOfMoons());
        }

        @Test
        void test_planetIsSpaceObject(){
            Planet planet = createPlanetOne();
            assertTrue(planet instanceof SpaceObject);
        }

        @Test
        void test_getMass(){
            Planet planet = createPlanetOne();
            assertEquals(500,planet.getMass());
        }

        @Test
        void test_getName(){
            Planet planet = createPlanetOne();
            assertEquals("planet1",planet.getName());
        }
}