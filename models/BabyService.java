package models;

import java.text.ParseException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class BabyService {

    static List<Baby> babies = new ArrayList<>();
    static List<Gift> gifts = new ArrayList<>();
    static List<Integer> ages = new ArrayList<>();
    static List<String> names = new ArrayList<>();

    public BabyService() {

    }

    public static void addBaby(Baby baby) {
        babies.add(baby);
    }

    public static List<Integer> listBabyByAge() throws ParseException {
        for (Baby baby : babies) {
            ages.add(baby.howOld() - 1900);
        }

        Collections.sort(ages);

        return ages;
    }

    public static List<String> listBabyByName() {
        for (Baby baby : babies) {
            names.add(baby.getName());
        }
        Collections.sort(names);

        return names;
    }

    public static void addGifts(Gift gift) {
        gifts.add(gift);
    }

    public static List<Gift> listGifts() {
        return gifts;
    }

}
