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
public class Group {

    private int id;
    private String name;
    private String location;
    private String region;

    public Group() {
    }

    public Group(int id, String name, String location, String region) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.region = region;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "{" + "groupId = " + id + ", groupName = " + name + ", location = " + location + ", region = " + region + '}';
    }

}
