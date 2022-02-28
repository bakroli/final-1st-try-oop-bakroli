# Csillagrendszer
Ebben a feladatban egy csillagrendszert kell modelezned.

Minden osztályodat a s `hu.nive.ujratervezes.solarsystem` packagben kell létrehozni.

A `Main` osztály `main` metódusában próbálhatod ki a kódodat, illetve használd
az előre megírt teszteseteket az algoritmusod kipróbálására!

## Feladatleírás
Implementáld az alábbi leírás szerinti programot:

### hu.nive.ujratervezes.solarsystem.SpaceObject
tulajdonságai:
- `String name` ami az űrbeli objektum neve. Konstruktor segítségével beállítható kell legyen. Tartozik hozzá egy `String getName()` getter.
- `int mass`  ami az űrbeli objektum tömege. Konstruktor segítségével beállítható kell legyen. Tartozik hozzá egy `int getMass()` getter.

### hu.nive.ujratervezes.solarsystem.PlanetType
Egy enum ami a `GAS_GIANT` és a `NORMAL` értékeket veheti fel.

### hu.nive.ujratervezes.solarsystem.Moon
Az összes `Moon` egyben `SpaceObject` is.
Ezen felül tulajdonsága:
- `int periapsis` a bolygó és a hold közötti legkisebb távolság. Konstruktor segítségével beállítható kell legyen. Tartozik hozzá egy `int getPeriapsis()` getter.

### hu.nive.ujratervezes.solarsystem.Planet
Az összes `Planet` egyben `SpaceObject` is.
Ezen felül tulajdonsága:
- `PlanetType planetType` a bolygó tipusa. Konstruktor segítségével beállítható kell legyen. Tartozik hozzá egy `PlanetType getPlanetType()` getter.
- `List<Moon> moons` a bolygó holdjainak listája. Konstruktor segítségével beállítható kell legyen. Tartozik hozzá egy `PlanetType getPlanetType()` getter.

Metodusai:
- `int calculateMassWithMoons()` visszadja a bolygó és a holdjai eggyütes tömegét.
- `int calculateClosestDistanceWithMoon()` a legissebb távolság a bolygó és holdjai között.
- `int numberOfMoons()` a bolygó holdjainak számát adja vissza.

### hu.nive.ujratervezes.solarsystem.SolarSystem
Tulajdonsága:
- `List<Planet> planets` a bolygók listája. Konstruktor segítségével beállítható kell legyen. Tartozik hozzá egy `List<Planet> getPlanets()` getter.

Metodusai:
- `int countPlanetByType(PlanetType planetType)` vissza adja, hogy a paraméterben kapott bolygó tipusból hány van a naprendszerben.
- `void addPlanet(Planet planet)` a paraméterben kapott bolygót hozzá adja a naprendszer bolygóihoz.
- `void removePlanetByName(String name)` a paraméterben egy bolygó nevét kapja. Az ilyen nevű bolygót eltávolítja a bolygók listájáról.
- `Planet findPlanetWithMostMoons()` vissza adja azt a bolygót ami a legtöbb holdal rendelkezik.