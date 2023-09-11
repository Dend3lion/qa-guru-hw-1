package com.demoqa.utils;

import com.github.javafaker.Faker;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class RandomUtils {
    private static final Faker faker = new Faker(Locale.ENGLISH);

    public static String getRandomFirstName() {
        return faker.name().firstName();
    }

    public static String getRandomLastName() {
        return faker.name().lastName();
    }

    public static String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public static String getRandomGender() {
        String[] subject = {"Male", "Female", "Other"};
        return faker.options().option(subject);
    }


    public static String getRandomPhone() {
        return faker.phoneNumber().subscriberNumber(10);
    }

    public static String[] getRandomBirthday() {
        Date date = faker.date().birthday();
        return new SimpleDateFormat("dd-MMMM-yyyy", Locale.ENGLISH).format(date).split("-");
    }

    public static String getRandomSubject() {
        String[] subject = {"English", "Chemistry", "Computer Science", "Commerce", "Economics", "Social Studies"};
        return faker.options().option(subject);
    }

    public static String getRandomHobby() {
        String[] hobby = {"Sports", "Reading", "Music"};
        return faker.options().option(hobby);
    }

    public static String getRandomAddress() {
        return faker.address().fullAddress();
    }

    public static String getRandomState() {
        String[] state = {"NCR", "Uttar Pradesh", "Haryana", "Rajasthan"};
        return faker.options().option(state);
    }

    public static String getRandomCity(String state) {
        switch (state) {
            case "NCR": {
                String[] cities = {"Delhi", "Gurgaon", "Noida"};
                return faker.options().option(cities);
            }
            case "Uttar Pradesh": {
                String[] cities = {"Agra", "Lucknow", "Merrut"};
                return faker.options().option(cities);
            }
            case "Haryana": {
                String[] cities = {"Karnal", "Panipat"};
                return faker.options().option(cities);
            }
            case "Rajasthan": {
                String[] cities = {"Jaipur", "Jaiselmer"};
                return faker.options().option(cities);
            }
            default: {
                return null;
            }
        }
    }
}
