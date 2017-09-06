import java.util.List;
import java.util.ArrayList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.io.Serializable;

import java.io.IOException;
import java.io.EOFException;
import java.lang.ClassNotFoundException;

/**
 * ObjectStreamSample example on page 429
 */
public class ObjectStreamer {
  public static List<Animal> getAnimals(File dataFile) throws IOException, ClassNotFoundException {
    List<Animal> animals = new ArrayList<Animal>();

    try (ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(dataFile)))) {
      while(true) {
        Object object = in.readObject();
        if(object instanceof Animal)
          animals.add((Animal)object);
      }
    } catch (EOFException e) {
      // File end reached
    }

    return animals;
  }

  public static void createAnimalsFile(List<Animal> animals, File dataFile) throws IOException {
    try (ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(dataFile)))) {
      for(Animal animal: animals)
        out.writeObject(animal);
    }
  }

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    List<Animal> animals = new ArrayList<Animal>();
    animals.add(new Animal("Tommy Tiger",5,'T'));
    animals.add(new Animal("Peter Penguin",8,'P'));

    File dataFile = new File("data/animal.data");
    createAnimalsFile(animals,dataFile);

    System.out.println(getAnimals(dataFile));
  }
}

/**
 * Serializable Animal example on page 431
 */
class Animal implements Serializable {
  private static final long serialVersionUID = 2L;
  private transient String name;
  private transient int age = 10;
  private static char type = 'C';

  {this.age = 14;}

  public Animal() {
    this.name = "Unknown";
    this.age = 12;
    this.type = 'Q';
  }

  public Animal(String name, int age, char type) {
    this.name = name;
    this.age = age;
    this.type = type;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public char getType() {
    return type;
  }

  public String toString() {
    return "Animal [name=" + name + ", age=" + age + ", type=" + type + "]";
  }
}
