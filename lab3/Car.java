package lab3;

/**
 * Represents a car with basic properties such as brand, model, year, color, and price.
 * <p>
 * This class provides methods to access car attributes, compare cars, and
 * obtain a string representation of the car. Equality is defined by comparing all fields.
 * </p>
 *
 * @author Dmytro Tarasenko
 * @version 1.0
 * @since 15-10-2025
 */
public class Car {
    private String brand;
    private String model;
    private int year;
    private String color;
    private int price;

    /**
     * Constructs a new Car object with the specified attributes.
     *
     * @param brand the brand of the car ("Mitsubishi", "Audi")
     * @param model the model name of the car
     * @param year  the manufacturing year
     * @param color the color of the car
     * @param price the price of the car in abstract units
     */
    public Car(String brand, String model, int year, String color, int price) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.color = color;
        this.price = price;
    }

    /**
     * Returns the brand of this car.
     *
     * @return the car's brand
     */
    public String getBrand() { return brand; }

    /**
     * Returns the model of this car.
     *
     * @return the car's model
     */
    public String getModel() { return model; }

    /**
     * Returns the manufacturing year of this car.
     *
     * @return the car's year
     */
    public int getYear() { return year; }

    /**
     * Returns the color of this car.
     *
     * @return the car's color
     */
    public String getColor() { return color; }

    /**
     * Returns the price of this car.
     *
     * @return the car's price
     */
    public int getPrice() { return price; }

    /**
     * Compares this car to another object for equality.
     * Two cars are considered equal if all fields match.
     *
     * @param obj the object to compare with
     * @return true if the specified object represents the same car,
     *         false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Car car = (Car) obj;
        return brand.equals(car.brand) &&
               model.equals(car.model) &&
               year == car.year &&
               color.equals(car.color) &&
               price == car.price;
    }

    /**
     * Returns a string representation of this car in the format:
     * brand model year color price.
     *
     * @return a string describing the car
     */
    @Override
    public String toString() {
        return brand + " " + model + " " + year + " " + color + " " + price;
    }
}
