package utils;

/**
 * This class contains helper method related with phone numbers.
 */
public class PhoneNumberUtils {

    /**
     * This method generates random phone number starting from 555.
     *
     * @return Random phone number.
     */
    public static String getRandomPhoneNumber() {
        long fraction = 5_550_000_000L + (long) Math.floor(Math.random() * 10_000_000L);
        return Long.toString(fraction);
    }
}
