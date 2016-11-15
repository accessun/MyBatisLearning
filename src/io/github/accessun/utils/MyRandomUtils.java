package io.github.accessun.utils;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class MyRandomUtils {

    private static List<String> EMAIL_SERVICES;

    static {
        EMAIL_SERVICES = Arrays.asList("@gmail.com", "@hotmail.com", "@outlook.com", "@yahoo.com", "@mail.com");
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

    public static List<String> randomFirstNames() {
        return randomNames("first");
    }

    public static List<String> randomLastNames() {
        return randomNames("last");
    }

    public static List<String> randomFullNames() {
        return randomNames("full");
    }

    private static List<String> randomNames(String type) {
        return null;
    }

    public static String randomEmail(String fullName) {
        return null;
    }

}
