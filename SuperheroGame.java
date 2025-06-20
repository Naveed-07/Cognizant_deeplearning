package Design_pattern;

//Superhero Game using Strategy Pattern
interface Superpower {
 void usePower();
}

class Fly implements Superpower {
 public void usePower() {
     System.out.println("Flying high in the sky!");
 }
}

class Strength implements Superpower {
 public void usePower() {
     System.out.println("Lifting a car with bare hands!");
 }
}

class Invisibility implements Superpower {
 public void usePower() {
     System.out.println("Disappearing into thin air!");
 }
}

class Superhero {
 private Superpower power;

 public void setPower(Superpower power) {
     this.power = power;
 }

 public void useSuperpower() {
     power.usePower();
 }
}

public class SuperheroGame {
 public static void main(String[] args) {
     Superhero hero = new Superhero();

     hero.setPower(new Fly());
     hero.useSuperpower();

     hero.setPower(new Strength());
     hero.useSuperpower();

     hero.setPower(new Invisibility());
     hero.useSuperpower();
 }
}