package dk.dtu.compute.course02324.assignment3.lists.uses;

import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class Person implements Comparable<Person> {

    final public String name;

    private double weight;  // no longer final

    private Integer age;

    Person(@NotNull String name, @NotNull double weight, @NotNull Integer age) {
        if (name == null || weight <= 0) {
            throw new IllegalArgumentException("A persons must be initialized with a" +
                    "(non null) name and an age greater than 0");
        }
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    public void setAge(Integer age) {
        if (age < 0 ) {
            throw new IllegalArgumentException("Age cant be below zero");
        }
        
      this.age = age;
    }

    public Integer getAge() {
      return age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be greater than 0");
        }
        this.weight = weight;
    }

    @Override
    public int compareTo(@NotNull Person o) {
        // This code has been taken from the slides for assignment 3b
        if (o == null) {
            throw new IllegalArgumentException("Argument of compareTo() must not be null");
        }

        int result = this.name.compareTo(o.name);
        if (result != 0 ) {
            return result;
        }

        return (int) Math.signum(this.weight - o.weight);

    }

    /**
     * Computes a simple string representation of this object.
     *
     * @return a string representation of this object
     */
    @Override
    public String toString() {
        
        return name + ", " + weight + "kg";
    }

    /*
     * The following two methods must be implemented in order to respect the contract of objects
     * with respect to equals(), hashCode() and compareTo() methods. The details and reasons
     * as to why will be discussed much later.
     *
     * The implementations can be done fully automatically my IntelliJ (using the two attributes
     * of person).
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        // This code has been taken from the slides for assignment 3b
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Person person = (Person) o;
        return Double.compare(weight, person.weight) == 0 && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        // This code has been taken from the slides for assignment 3b
        return Objects.hash(name, weight);
    }


}