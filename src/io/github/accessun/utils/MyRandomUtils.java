package io.github.accessun.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.io.IOUtils;

import io.github.accessun.entity.PersonName;

public class MyRandomUtils {

    private static List<String> EMAIL_SERVICES;
    private static List<PersonName> NAMES;
    private static List<String> LAST_NAMES;
    private static final int RANDOM_NAME_POOL_SIZE = 500;

    static {
        EMAIL_SERVICES = Arrays.asList("@gmail.com", "@hotmail.com", "@outlook.com", "@yahoo.com", "@mail.com");
        try {
            NAMES = new ArrayList<>();
            LAST_NAMES = IOUtils.readLines(MyRandomUtils.class.getResourceAsStream("lastNames.txt"));

            List<String> listReadIn = IOUtils
                    .readLines(MyRandomUtils.class.getResourceAsStream("names_with_gender.txt"));
            int poolSize = RANDOM_NAME_POOL_SIZE < listReadIn.size() ? RANDOM_NAME_POOL_SIZE : listReadIn.size();

            for (int i = 0; i < poolSize; i++) {
                String[] nameAndGender = listReadIn.get(i).split("\\s+");
                PersonName personName = new PersonName(nameAndGender[0],
                        LAST_NAMES.get(randomInt(0, LAST_NAMES.size())), nameAndGender[1]);
                NAMES.add(personName);
            }

            Collections.shuffle(NAMES);

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

    /**
     * Random age between <code>lower</code> and <code>higher</code> years old.<br>
     * 
     * <code>lower</code> and <code>higher</code> are both inclusive:<br>
     * 
     * <code>lower &le; randomAge &le; higher</code>
     * 
     * @return
     */
    public static int randomAge(int lower, int higher) {
        return randomInt(lower, higher + 1);
    }

    /**
     * Random salary.<br>
     * 
     * <code>5,000 &le; salary &le; 50,000</code>
     * 
     * @return
     */
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

    public static List<PersonName> randomNames(int size) {
        int num = size < NAMES.size() ? size : NAMES.size();
        Collections.shuffle(NAMES);
        return NAMES.subList(0, num);
    }

    public static String randomEmail(String name) {
        return shortUuid() + EMAIL_SERVICES.get(randomInt(0, EMAIL_SERVICES.size()));
    }

    public static String shortUuid() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

}
