/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import domen.City;
import domen.Event;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import meetup_api.APICommunication;

/**
 *
 * @author Mira
 */
public class Main {

    public static void main(String[] args) {

         boolean kraj = false;
        
        try {
            while (!kraj) {
            APICommunication apiCommunication = new APICommunication();
            ArrayList<City> citiesForShow = apiCommunication.getAllCities();
           

            System.out.println("Prikaz gradova Srbije: ");

            for (City city : citiesForShow) {
                System.out.println(city.toString());
            }

            

                System.out.println("Unesite redni broj grada: [0-55] ");

                int ordinal = -1;

                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                try {
                    ordinal = Integer.parseInt(br.readLine());
                } catch (NumberFormatException ex) {
                    System.out.println("Morate uneti broj u rasponu [0-55]! Pokušajte ponovo!");
                    continue;
                }

                City city = apiCommunication.findCityByOrdinal(ordinal);

                if (city != null) {
                    ArrayList<Event> eventsForShow = apiCommunication.getEventsByCity(city.getOrdinal(), city.getName(), city.getLatitude(), city.getLongitude());

                    System.out.println("Prikaz predstojećih događaja za izabrani grad: '" + city.getName() + "':");
                    for (Event event : eventsForShow) {
                        System.out.println(event.toString());
                    }
                } else {
                    System.out.println("Grad sa tim rednim brojem ne postoji! ");
                }

                System.out.println("Da li želite da nastavite pretragu po gradovima? [da/ne]");
                String answer = br.readLine();

                if (answer.equalsIgnoreCase("ne")) {
                    kraj = true;
                }

            }

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
