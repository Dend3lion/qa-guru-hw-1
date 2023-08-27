package com.demoqa.fixtures;

import static com.demoqa.utils.RandomUtils.*;

public class RegistrationUser {
        public static String[] birthday = getRandomBirthday();
        public static String
                firstName = getRandomFirstName(),
                lastName = getRandomLastName(),
                email = getRandomEmail(),
                gender = getRandomGender(),
                phoneNumber = getRandomPhone(),
                birthdayDay = birthday[0],
                birthdayMonth = birthday[1],
                birthdayYear = birthday[2],
                subject = getRandomSubject(),
                hobby = getRandomHobby(),
                picture = "photo.jpg",
                address = getRandomAddress(),
                state = getRandomState(),
                city = getRandomCity(state);
}
