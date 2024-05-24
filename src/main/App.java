package com.areport;

import java.util.Map;

public class App {
    public static void main(String[] args) {
        // Accessing static variables and methods from Config class
        String monetaryItem = Config.monetaryItem;
        Map<String, String> lang = Config.lang;
        Map<String, String> confSet = Config.confSet;
        Map<String, String> moduleSet = Config.moduleSet;
        Map<String, String> createInstance = Config.createInstance;
        String owner = Config.owner;

        // Output some of the values
        System.out.println("Monetary Item: " + monetaryItem);
        System.out.println("Lang: " + lang);
        System.out.println("Conf Set: " + confSet);
        System.out.println("Module Set: " + moduleSet);
        System.out.println("Create Instance: " + createInstance);
        System.out.println("Owner: " + owner);

        // Accessing owners map
        Map<String, Map<String, String>> owners = Config.owners();
        for (Map.Entry<String, Map<String, String>> entry : owners.entrySet()) {
            String ownerName = entry.getKey();
            Map<String, String> ownerDetails = entry.getValue();
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Owner Details: " + ownerDetails);
        }
    }
}