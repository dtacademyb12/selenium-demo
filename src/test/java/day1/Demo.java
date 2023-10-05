package day1;

import com.github.javafaker.Faker;

public class Demo {


    public static void main(String[] args) {


//        System.out.println("Hello");

        Faker faker = new Faker();

        String username = faker.name().username();

        System.out.println(username);

        System.out.println(faker.business().creditCardNumber());

    }
}
