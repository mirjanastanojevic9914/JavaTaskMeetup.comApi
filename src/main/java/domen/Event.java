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
public class Event {

    private String id;
    private String name;
    private Venue venue;
    private Group group;
    private String link;
    private String description;
    private String visibility;

    public Event() {
    }

    public Event(String id, String name, Venue venue, Group group, String link, String description, String visibility) {
        this.id = id;
        this.name = name;
        this.venue = venue;
        this.group = group;
        this.link = link;
        this.description = description;
        this.visibility = visibility;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return "Event {" + "eventId = " + id + ", eventName = " + name + ", venue = " + venue + ", group = " + group + ", link = " + link + ", description = " + description + ", visibility = " + visibility + '}';
    }

}
