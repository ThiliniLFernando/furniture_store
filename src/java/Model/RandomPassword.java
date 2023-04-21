package Model;

/**
 *
 * @author Thilini
 */

// Java program generate a random AlphaNumeric String 
// using Math.random() method 
public final class RandomPassword {

    // function to generate a random string of length n 
    public static String getRandomPassword() {

        // chose a Character random from this String 
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString 
        StringBuilder sb = new StringBuilder(8);

        for (int i = 0; i < 8; i++) {
            // generate a random number between 
            // 0 to AlphaNumericString variable length 
            int index
                    = (int) (AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb 
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }
}
