/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package meetup_api;


import domen.Event;
import constants.Constants;
import domen.City;
import domen.Group;
import domen.Venue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Mira
 */
public class APICommunication {

    ArrayList<City> citiesList = new ArrayList<>();
    ArrayList<Event> eventsList = new ArrayList<>();
    String apiMethod;
    String param1;
    String url;
    HttpURLConnection con;
    URL obj;
    int responseCode;
    StringBuffer response;
    JSONObject myResponse;
    String inputLine;


    public ArrayList<City> getAllCities() throws Exception {

        apiMethod = "/2/cities";
        param1 = "country=rs";
        url = Constants.url + apiMethod + "?" + param1;

        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        responseCode = con.getResponseCode();
        
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }

        myResponse = new JSONObject(response.toString());

        JSONArray cities = myResponse.getJSONArray("results");
        Iterator<Object> iterator = cities.iterator();

        while (iterator.hasNext()) {

            JSONObject city = (JSONObject) iterator.next();

            City cityForList = new City();
            cityForList.setOrdinal(city.getInt("ranking"));
            cityForList.setName(city.getString("city"));
            cityForList.setLatitude(city.getDouble("lat"));
            cityForList.setLongitude(city.getDouble("lon"));

            citiesList.add(cityForList);
        }
        return citiesList;
    }

    public City findCityByOrdinal(int ordinalForFind) {
        for (City city : citiesList) {
            if (city.getOrdinal() == ordinalForFind) {
                return city;
            }
        }
        return null;
    }

    public ArrayList<Event> getEventsByCity(int ordinal, String cityName, double latitude, double longitude) throws Exception {

        DecimalFormat df2 = new DecimalFormat(".##");

        apiMethod = "/find/upcoming_events";
        param1 = "radius=30.0";
        url = Constants.url + apiMethod + "?" + param1 + "&lon=" + df2.format(longitude) + "&lat=" + df2.format(latitude) + "&key=647154f4a695f20693840334b132b61";

        obj = new URL(url);
        con = (HttpURLConnection) obj.openConnection();

        con.setRequestMethod("GET");

        responseCode = con.getResponseCode();
        
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
        }

        myResponse = new JSONObject(response.toString());

        JSONArray events = myResponse.getJSONArray("events");
        Iterator<Object> iterator = events.iterator();

        while (iterator.hasNext()) {
            JSONObject event = (JSONObject) iterator.next();

            try {

                JSONObject venue = event.getJSONObject("venue");
                String city = venue.getString("city");

                if (cityName.equals(city)) {

                    int idVenue = venue.getInt("id");
                    String nameVenue = venue.getString("name");
                    String address = venue.getString("address_1");
                    String country = venue.getString("country");

                    Venue venueEvent = new Venue(idVenue, nameVenue, address, city, country);

                    JSONObject group = event.getJSONObject("group");

                    int idGroup = group.getInt("id");
                    String nameGroup = group.getString("name");
                    String location = group.getString("localized_location");
                    String region = group.getString("region");

                    Group groupEvent = new Group(idGroup, nameGroup, location, region);

                    String idEvent = event.getString("id");
                    String nameEvent = event.getString("name");
                    String link = event.getString("link");
                    String description = event.getString("description");
                    String visibility = event.getString("visibility");

                    Event eventForList = new Event(idEvent, nameEvent, venueEvent, groupEvent, link, description, visibility);

                    eventsList.add(eventForList);

                } 

            } catch (JSONException e) {
                //Događaj ne sadrži 'Venue' objekat u sebi, nema atribut 'city' gde se odrzava pa ga preskacemo!);
               
            }

        }

        return eventsList;
    }

}
