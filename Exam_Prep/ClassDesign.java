import java.util.List;
import java.util.ArrayList;

public class ClassDesign {
  public static void main(String[] args) {
    AnimalShelter shelter = AnimalShelter.getInstance();

    Dog marlie = new Dog(01);
    marlie.setName("Marlie");
    shelter.addDog(marlie);

    shelter.printAllDogs();

    Animal animal = marlie;
    animal.walk();

    if (animal instanceof Dog) {
      Dog dog = (Dog) animal;
      dog.bark();
    }

    System.out.println(marlie.equals(marlie));
  }
}

// ======================================================================================================================================
abstract class Animal {
  private String name;
  private int registryId;

  public void setName(String name) {this.name = name;};
  public String getName() {return this.name;};
  public int getRegistryId() {return this.registryId;};
  protected void setRegistryId(int registryId) {this.registryId = registryId;};

  public abstract void walk();
}

// ======================================================================================================================================
class Dog extends Animal {

  public Dog(int registryId) {
    setRegistryId(registryId);
  }

  public void walk() {
    System.out.println("Walking...");
  }

  public void bark() {
    System.out.println("Woof!");
  }

  @Override
  public String toString() {
    return this.getRegistryId() + " : " + this.getName();
  }

  @Override
  public int hashCode() {
    return this.getRegistryId();
  }

  @Override
  public boolean equals(Object otherObject) {
    boolean isNull = otherObject == null;
    boolean isDog = otherObject instanceof Dog;

    if (isNull || !isDog) {
      return false;
    }

    Dog otherDog = (Dog) otherObject;

    return this.getRegistryId() == otherDog.getRegistryId();
  }
}

// ======================================================================================================================================
class AnimalShelter {
  public static String name;
  public static List<Dog> shelteredDogs;

  static {
    name = "One Line";
    shelteredDogs = new ArrayList<>();
  }

  private static AnimalShelter animalShelter = null;

  private AnimalShelter() {}

  public static AnimalShelter getInstance() {
    if (animalShelter == null) {
      animalShelter = new AnimalShelter();
    }

    return animalShelter;
  }

  public void addDog(Dog dog) {
    this.shelteredDogs.add(dog);
  }

  public void printAllDogs() {
    shelteredDogs.forEach(System.out::println);
  }
}
