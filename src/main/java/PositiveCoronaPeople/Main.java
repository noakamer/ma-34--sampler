package PositiveCoronaPeople;

import health_care_provider.errors.InvalidIdException;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        PositiveCoronaPeopleManager p = new PositiveCoronaPeopleManager();
        try {
            p.manager();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidIdException e) {
            e.printStackTrace();
        }
    }
}
