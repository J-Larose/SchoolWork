/**
 * @author Jacob Larose
 * @since 2016-02-28
 * @custom.citations https://docs.oracle.com/javase/tutorial/java/data/numberformat.html
 */


import java.text.DecimalFormat;

/** 
 * Weather class
 * 
 * COMP1406 - Winter 2016 - Assignment 6
 */


public class Weather{
  private float temp;
  private int day;
  private int month;
  private int year;
  private char degree;
  /**
   * Creates a weather object for a given day having 
   * a given temperature (in degrees celsius).
   * 
   * @param temp is the temperature in degrees Celsius
   * @param day is the day [1,31]
   * @param month is the month [1,12]
   * @param year is the year (2016, for example)
   */ 
  public Weather(float temp, int day, int month, int year){
    this.temp = temp;
    this.day = day;
    this.month = month;
    this.year = year;
    this.degree = 'c';
  }
  
  /**
   * Getter method for the temperature.
   * 
   * @return the temperature of the current object in whichever
   * unit (Celsius or Fahrenheit) the object currently set to.
   */
  public float getTemp(){
    return this.temp;
  }
  
  
  /**
   * Sets the objects unit of temperature to Celsius. 
   * 
   * @return Nothing. Has the side effect of setting the object's unit of temerature to Celsius.  
   */
  public void setCelsius(){
      if(this.degree == 'f'){
          this.temp = (this.temp-32)*5/9;
          this.degree = 'c';
      }
  }
  
  /**
   * Sets the objects unit of temperature to Fahrenheit.
   * 
   * @return Nothing. Has the side effect of setting the obkect's unit of temperature to Fahrenheit.
   */ 
  public void setFahrenheit(){
      if(this.degree == 'c'){
          this.temp = this.temp*9/5+32;
          this.degree = 'f';
      }
  }
  
  /** 
   * Checks which unit of temperature the object currently has.
   * 
   * @return true if the object's unit of temperature is currently Celsius and false if
   * the object's unit of temperature is currently Fahrenheit.
   */
  public boolean isCelsius(){
      return this.degree == 'c';
  }
  
  /**
   * A string representation of this object.
   * 
   * The string representation must be exactly as specified in the assignment.
   * 
   * 
   * @return a string representation of this object.
   */
  @Override
  public String toString(){
      StringBuilder str = new StringBuilder();
      DecimalFormat tempFormat = new DecimalFormat("###.##");
      String[] months = {"January", "February", "March", "April", "May", "June",
          "July", "August", "September", "October", "November", "December"};
      str.append(months[this.month-1]).append(" ").append(this.day).append(", ")
              .append(this.year).append(". Tempurature is ").append(tempFormat.format(this.temp))
              .append(" ").append(Character.toUpperCase(this.degree));
      
    return str.toString();
  }
}