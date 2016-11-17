package io.github.accessun.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.io.IOUtils;

public class MyRandomUtils {

    private static List<String> EMAIL_SERVICES;
    private static List<Map<String, String>> firstNamesWithGender;
    private static List<String> lastNames;

    static {
        EMAIL_SERVICES = Arrays.asList("@gmail.com", "@hotmail.com", "@outlook.com", "@yahoo.com", "@mail.com");
        try {
            firstNamesWithGender = new ArrayList<>();
            lastNames = IOUtils.readLines(MyRandomUtils.class.getResourceAsStream("lastNames.txt"));
            
            List<String> listReadIn = IOUtils.readLines(MyRandomUtils.class.getResourceAsStream("names_with_gender.txt"));
            
            listReadIn.stream().forEach(line -> {
                String[] nameAndGender = line.split("\\s+");
                Map<String, String> personNameWithGender = new HashMap<>();
                personNameWithGender.put(nameAndGender[0], nameAndGender[1]);
                firstNamesWithGender.add(personNameWithGender);
            });
            
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Generate a random integer <code>n</code>.<br>
     * <code>min &le; n &lt; max</code>
     * 
     * @param min
     *            lower bound (inclusive)
     * @param max
     *            higher bound (exclusive)
     * @return a random value of type <code>int</code>
     */
    public static int randomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max);
    }

    /**
     * Generate a random gender.
     * 
     * @return <code>"female"</code> or <code>"male"</code>
     */
    public static String randomGender() {
        return new Random().nextBoolean() ? "female" : "male";
    }

    /**
     * Between 20 and 60 years old
     * 
     * @return
     */
    public static int randomAge() {
        return randomAge(20, 60);
    }

    public static int randomAge(int lower, int higher) {
        return randomInt(lower, higher + 1);
    }

    public static int randomSalary() {
        return randomInt(5_000, 50_000 + 1);
    }

    public static Date randomDate() {
        GregorianCalendar gc = new GregorianCalendar();

        int year = randomInt(1950, 1996 + 1);
        gc.set(Calendar.YEAR, year);

        int dayOfYear = randomInt(1, gc.getActualMaximum(Calendar.DAY_OF_YEAR));
        gc.set(Calendar.DAY_OF_YEAR, dayOfYear);

        return new Date(gc.getTimeInMillis());
    }

    public static List<Map<String, String>> randomFirstNamesWithGender(int number) {
        synchronized (MyRandomUtils.class) {
            Collections.shuffle(firstNamesWithGender);
        }
        if (number <= 0 || number > lastNames.size()) {
            return new ArrayList<>();
        }
        return firstNamesWithGender.subList(0, number);
    }

    public static List<String> randomLastNames(int number) {
        synchronized (MyRandomUtils.class) {
            Collections.shuffle(lastNames);
        }
        if (number <= 0 || number > lastNames.size())
            return new ArrayList<>();
        return lastNames.subList(0, number);
    }
    
    public static String randomLastName() {
        int index = randomInt(0, lastNames.size());
        return lastNames.get(index);
    }

    public static List<String> randomFullNamesWithGender() {
        return null;
    }

    public static String randomEmail(String name) {
        return null;
    }

}
