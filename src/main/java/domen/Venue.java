/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domen;

/**
 *
 * @author Mira
 */
public class Venue {

    private int id;
    private String name;
    private String address;
    private String city;
    private String country;

    public Venue() {
    }

    public Venue(int id, String name, String address, String city, String country) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "{" + "venueId = " + id + ", venueName = " + name + ", address = " + address + ", city = " + city + ", country = " + country + '}';
    }
}
