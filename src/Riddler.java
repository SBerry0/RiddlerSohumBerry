import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: YOUR NAME HERE
 */
public class Riddler {
    public String decryptOne(String encrypted) {
        String decrypted = "";
        for (int i = 0; i < encrypted.length(); i++) {
//            if (((int) encrypted.charAt(i) < 97 || (int) encrypted.charAt(i) > 122) &&
//                    ((int) encrypted.charAt(i) < 65 || (int) encrypted.charAt(i) > 90)) {
            if (!Character.isAlphabetic(encrypted.charAt(i))) {
                decrypted += encrypted.charAt(i);
                continue;
            }
            int newLetter = ((int) encrypted.charAt(i)) + 9;
            boolean isLower = ((int) encrypted.charAt(i) < 'A' || (int) encrypted.charAt(i) > 'Z');
            if (newLetter > (isLower ? 'z' : 'Z')) {
                newLetter = newLetter % (isLower ? 'z' : 'Z') + (isLower ? 'a'-1 : 'A'-1);
            }
            decrypted += (char) newLetter;
        }
        return decrypted;
    }

    public String decryptTwo(String encrypted) {
        String decrypted = "";
        String[] encryptWords = encrypted.split(" ");
        for (String s : encryptWords) {
            decrypted += (char) (Integer.parseInt(s));
        }
        // TODO: Complete the decryptTwo() function.
        System.out.println(decrypted);
        return decrypted;
    }

    public String decryptThree(String encrypted) {
        String decrypted = "";
        int[] unicodes = new int[encrypted.length()/8];
        // TODO: Complete the decryptThree() function.
        for (int i = 0; i < encrypted.length() - 8; i+=8) {
            unicodes[i/8] = Integer.parseInt(encrypted.substring(i, i+8), 2);
        }
        for (int i : unicodes) {
            decrypted += (char) i;
        }
        System.out.println(decrypted);
        return decrypted;
    }
    private boolean checkArray(char c, ArrayList<Character> array) {
        for (char i : array) {
            if (i == c) {
                return true;
            }
        }
        return false;
    }
    public String decryptFour(String encrypted) {
        String decrypted = "";
//        char[] seenCharacters = new char[encrypted.length()];
//        ArrayList<Character> seenCharacters = new ArrayList<>();
//        int i = 0;
//        for (char c : encrypted.toCharArray()) {
//            if (!checkArray(c, seenCharacters)) {
//                seenCharacters.add(c);
//            }
//        }
//        for (char c : seenCharacters) {
//            System.out.println(c);
//        }
//        System.out.println(seenCharacters.size());
//        for (int i = 0; i < encrypted.length(); i++) {
//            System.out.println(Arrays.toString(encrypted.substring(i, i + 1).getBytes()));
//        }
        System.out.println(encrypted.charAt(encrypted.length()-1));
        byte[] emojiBytes = encrypted.getBytes();
        int diff = 9984 - 'A';
        System.out.println(diff);
        for (int i = 0; i < encrypted.length()-1; i++) {
            char c = encrypted.toCharArray()[i];
            String hexVal = Integer.toHexString(c);
//            System.out.println(hexVal);
            decrypted += (char) (Integer.parseInt(hexVal, 16) - diff);

//            if (String.valueOf((int) c).charAt(0) == '1') {
                // Alphabetic Character
//                decrypted += (char) ((Integer.parseInt(hexVal, 16) - diff - 'a') % 26 + 'a');
//            } else if (String.valueOf((int) c).charAt(0) == '9') {
                // Miscellaneous Character
//                decrypted += c;
//            }
//            System.out.println("HexVal: " + hexVal + " - HexString: " + Integer.toHexString(c));
//            System.out.println("c: " + c);
//            System.out.println("ParseInt: " + Integer.parseInt(Integer.toHexString(c), 16));
//            System.out.println("Result ASCII Num: " + (Integer.parseInt(hexVal, 16) - diff));
//            System.out.println("");
        }
//        for (int i = 1; i < emojiBytes.length-4; i+=3) {
//            System.out.println("Emoji: " + encrypted.charAt((i-1)/3));
//            System.out.println(emojiBytes[i]);
//            System.out.println(emojiBytes[i+1]);
//            if (emojiBytes[i] == -101) {
//                decrypted += (char) (-1*emojiBytes[i+1]);
//            }
//            else if (emojiBytes[i] == -100) {
//                decrypted += (char) (-1*emojiBytes[i+1]);
//            }
//        }
        System.out.println(decrypted);
//        System.out.println(Arrays.toString(encrypted.getBytes(StandardCharsets.UTF_8)));
//        for (char c : encrypted.toCharArray()) {
//            if (c == '⛫') {
//                decrypted += 'n';
//            } else if (c == '⛟') {
//                decrypted += 'm';
//            } else if (c == '✶') {
//                decrypted += 's';
//            } else if (c == '✤') {
//                decrypted += 'd';
//            } else if (c == '✫') {
//                decrypted += 'r';
//            }  else {
//                decrypted += c;
//            }
//        }
//        System.out.println(decrypted);
        // TODO: Complete the decryptFour() function.

        return decrypted;
    }
}
