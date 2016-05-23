package top.itmp.uidemo3;

/**
 * Created by hz on 16/5/23.
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

/**
 * Created by hz on 2016/4/7.
 */
public class dummy {

    private static final int FOUR = 4;
    private static final int LENGTH = 5;
    private static Random random = new Random();


    private static char rndCase(boolean isUpper) {
        int i = random.nextInt(26);
        return isUpper ? (char) (i + 'A') : (char) (i + 'a');
    }


    private static char rndChar() {
        return random.nextBoolean() ? rndCase(true) : rndCase(false);
    }

    public static String dummy(int from, int to, boolean initCap, boolean isMixed) {
        int base;
        int length;
        if (from == to) {
            length = from;
        } else {
            base = Math.min(from, to);
            length = random.nextInt(Math.abs(from - to)) + base;
        }
        if (length == 0) return null;

        char[] chars = new char[length];
        for (int i = 0; i < length; i++) {
            if (initCap && i == 0) {
                chars[i] = rndCase(true);
            } else if (isMixed) {
                chars[i] = rndChar();
            } else {
                chars[i] = rndCase(false);
            }
        }
        return new String(chars);
    }

    public static String dummy(int length, boolean initCap, boolean isMixed) {
        return dummy(length, length, initCap, isMixed);
    }

    public static String dummy(boolean initCap, boolean isMixed) {
        return dummy(random.nextInt(dummy.FOUR) + dummy.LENGTH, initCap, isMixed);
    }

    public static String dummy(boolean isMixed) {
        return dummy(true, isMixed);
    }

    public static String dummy() {
        return dummy(false);
    }

    public static String upper(int from, int to) {
        int base;
        int length;
        if (from == to) {
            length = from;
        } else {
            base = Math.min(from, to);
            length = random.nextInt(Math.abs(from - to)) + base;
        }
        if (length == 0) return null;

        char[] chars = new char[length];

        for (int i = 0; i < length; i++) {
            chars[i] = rndCase(true);
        }
        return new String(chars);
    }

    public static String lower(int from, int to) {
        int base;
        int length;
        if (from == to) {
            length = from;
        } else {
            base = Math.min(from, to);
            length = random.nextInt(Math.abs(from - to)) + base;
        }
        if (length == 0) return null;

        char[] chars = new char[length];

        for (int i = 0; i < length; i++) {
            chars[i] = rndCase(false);
        }
        return new String(chars);
    }

    public static String upper(int length) {
        return upper(length, length);
    }

    public static String lower(int length) {
        return lower(length, length);
    }

    public static String upper() {
        return upper(random.nextInt(dummy.FOUR) + dummy.LENGTH);
    }

    public static String lower() {
        return lower(random.nextInt(dummy.FOUR) + dummy.LENGTH);
    }

    /**
     * Return a array of counts random Chars.
     *
     * @param count the amount of chars to return.
     */
    public static ArrayList<String> dummys(int count, int from, int to, boolean isUpper, boolean isMixed) {
        HashSet<String> hashSet = new HashSet<String>();

        while (hashSet.size() < count) {
            hashSet.add(dummy(from, to, isUpper, isMixed));
        }
        return new ArrayList<>(hashSet);
    }

    public static ArrayList<String> dummys(int count, int length, boolean isUpper, boolean isMixed) {
        return dummys(count, length, length, isUpper, isMixed);
    }

    public static ArrayList<String> dummys(int count, boolean isUpper, boolean isMixed) {
        return dummys(count, random.nextInt(dummy.FOUR) + dummy.LENGTH, isUpper, isMixed);
    }

    public static ArrayList<String> dummys(int count, boolean isMixed) {
        return dummys(count, true, isMixed);
    }

    public static ArrayList<String> dummys(int count) {
        return dummys(count, false);
    }

    public static ArrayList<String> uppers(int count, int from, int to) {
        HashSet<String> hashSet = new HashSet<String>();

        while (hashSet.size() < count) {
            hashSet.add(upper(from, to));
        }
        return new ArrayList<>(hashSet);
    }

    public static ArrayList<String> uppers(int count, int length) {
        return uppers(count, length, length);
    }

    public static ArrayList<String> uppers(int count) {
        return uppers(count, random.nextInt(dummy.FOUR) + dummy.LENGTH);
    }

    public static ArrayList<String> lowers(int count, int from, int to) {
        HashSet<String> hashSet = new HashSet<String>();

        while (hashSet.size() < count) {
            hashSet.add(lower(from, to));
        }
        return new ArrayList<>(hashSet);
    }

    public static ArrayList<String> lowers(int count, int length) {
        return lowers(count, length, length);
    }

    public static ArrayList<String> lowers(int count) {
        return lowers(count, random.nextInt(dummy.FOUR) + dummy.LENGTH);
    }

}