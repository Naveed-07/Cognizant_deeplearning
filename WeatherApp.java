package Design_pattern;

import java.util.ArrayList;
import java.util.List;

interface Observer {
 void update(String weather);
}

interface Subject {
 void registerObserver(Observer o);
 void notifyObservers();
}

class WeatherStation implements Subject {
 private List<Observer> observers = new ArrayList<>();
 private String weather;

 public void setWeather(String weather) {
     this.weather = weather;
     notifyObservers();
 }

 public void registerObserver(Observer o) {
     observers.add(o);
 }

 public void notifyObservers() {
     for (Observer o : observers) {
         o.update(weather);
     }
 }
}

class PhoneDisplay implements Observer {
 public void update(String weather) {
     System.out.println("Phone Display: Weather updated - " + weather);
 }
}

class TVDisplay implements Observer {
 public void update(String weather) {
     System.out.println("TV Display: Weather updated - " + weather);
 }
}

public class WeatherApp {
 public static void main(String[] args) {
     WeatherStation station = new WeatherStation();
     PhoneDisplay phone = new PhoneDisplay();
     TVDisplay tv = new TVDisplay();

     station.registerObserver(phone);
     station.registerObserver(tv);

     station.setWeather("Sunny");
     station.setWeather("Rainy");
 }
}