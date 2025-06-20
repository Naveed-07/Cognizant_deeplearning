package Design_pattern;

abstract class Pizza {
 abstract void prepare();
 abstract void bake();
 abstract void cut();
 abstract void box();
}

class MargheritaPizza extends Pizza {
 void prepare() { System.out.println("Preparing Margherita: Tomato + Cheese"); }
 void bake() { System.out.println("Baking for 10 mins"); }
 void cut() { System.out.println("Cutting into 6 slices"); }
 void box() { System.out.println("Boxing in green box"); }
}

class PepperoniPizza extends Pizza {
 void prepare() { System.out.println("Preparing Pepperoni: Tomato + Cheese + Pepperoni"); }
 void bake() { System.out.println("Baking for 12 mins"); }
 void cut() { System.out.println("Cutting into 8 slices"); }
 void box() { System.out.println("Boxing in red box"); }
}

class PizzaFactory {
 Pizza createPizza(String type) {
     if (type.equals("Margherita")) return new MargheritaPizza();
     else if (type.equals("Pepperoni")) return new PepperoniPizza();
     else throw new IllegalArgumentException("Unknown pizza type");
 }
}

public class PizzaShop {
 public static void main(String[] args) {
     PizzaFactory factory = new PizzaFactory();
     Pizza myPizza = factory.createPizza("Pepperoni");
     myPizza.prepare();
     myPizza.bake();
     myPizza.cut();
     myPizza.box();
 }
}