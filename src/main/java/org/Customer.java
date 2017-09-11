package org;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    private String lastName;
    private String firstName;

    private Customer() {}

    public Customer(String firstName, String lastName) {
        this();
        this.lastName = lastName;
        this.firstName = firstName;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }
}
