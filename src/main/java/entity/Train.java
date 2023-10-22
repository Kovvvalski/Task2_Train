package entity;

import exception.CreateTrainException;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Train {
  private Destination destination;
  private int number;
  private int allPlaces;
  private int economy;
  private int compartment;
  private int lux;
  private Calendar departureTime;

  public Train(Destination destination, int number, int economy, int compartment, int lux, Calendar calendar) throws CreateTrainException {
    setDestination(destination);
    setNumber(number);
    setEconomy(economy);
    setCompartment(compartment);
    setLux(lux);
    setCalendar(calendar);
  }

  public Train() {
  }

  public Destination getDestination() {
    return destination;
  }

  public void setDestination(Destination destination) {
    this.destination = destination;
  }

  public int getNumber() {
    return number;
  }

  public void setNumber(int number) throws CreateTrainException {
    if (number < 1 || number > 999) {
      throw new CreateTrainException("Not correct number");
    }
    this.number = number;
  }

  public int getAllPlaces() {
    return allPlaces;
  }

  public int getEconomy() {
    return economy;
  }

  public void setEconomy(int economy) throws CreateTrainException {
    if (economy < 0 || economy > 800) {
      throw new CreateTrainException("Not correct number of economy places");
    }
    allPlaces -= this.economy;
    allPlaces += economy;
    this.economy = economy;
  }

  public int getCompartment() {
    return compartment;
  }

  public void setCompartment(int compartment) throws CreateTrainException {
    if (compartment < 0 || compartment > 400) {
      throw new CreateTrainException("Not correct number of compartment places");
    }
    allPlaces -= this.compartment;
    allPlaces += compartment;
    this.compartment = compartment;
  }

  public int getLux() {
    return lux;
  }

  public void setLux(int lux) throws CreateTrainException {
    if (lux < 0 || lux > 100) {
      throw new CreateTrainException("Not correct number of lux places");
    }
    allPlaces -= this.lux;
    allPlaces += lux;
    this.lux = lux;
  }

  public Calendar getCalendar() {
    int year = this.departureTime.get(1);
    int month = this.departureTime.get(2);
    int day = this.departureTime.get(5);
    int hour = this.departureTime.get(11);
    int minute = this.departureTime.get(12);
    Calendar calendar = new GregorianCalendar(year, month, day, hour, minute);
    return calendar;
  }

  public void setCalendar(Calendar departureTime) {
    int year = departureTime.get(1);
    int month = departureTime.get(2);
    int day = departureTime.get(5);
    int hour = departureTime.get(11);
    int minute = departureTime.get(12);
    Calendar toSet = new GregorianCalendar(year, month, day, hour, minute);
    this.departureTime = toSet;
  }

  @Override
  public String toString() {
    return "Train{" +
            "destination=" + destination +
            ", number=" + number +
            ", allPlaces=" + allPlaces +
            ", economy=" + economy +
            ", compartment=" + compartment +
            ", lux=" + lux +
            ", calendar=" + departureTime.getTime() +
            '}';
  }
}
