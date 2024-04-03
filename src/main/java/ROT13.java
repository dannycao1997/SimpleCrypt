import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13 {
    private final char shiftStart; //character to start shift
    private final char shiftEnd; //character to end shift

    ROT13(Character cs, Character cf) {
        this.shiftStart = cs;           //cs is the char to start the shift
        this.shiftEnd = cf;             //cf is the char to end the shift
    }

    ROT13() {
        this('a', 'n'); // constructor
    }

    public String crypt(String text) {

        StringBuilder sb = new StringBuilder(); // added String Builder to convert

        for (char c : text.toCharArray()) { // converting String text to letter/char
            if (c >= 'a' && c <= 'z') {
                sb.append((char) ((c - 'a' + getShiftDistance()) % 26 + 'a')); // lower case
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ((c - 'A' + getShiftDistance()) % 26 + 'A')); // upper case
            } else {
                sb.append(c);
            }
        }
        return sb.toString(); // return char back to string
    }

    private int getShiftDistance() {

        int shiftDistance;

        if(Character.isLowerCase(shiftStart) && Character.isLowerCase(shiftEnd)) { // lowercase method
            shiftDistance = shiftEnd - shiftStart;
        } else if
        (Character.isUpperCase(shiftStart) && Character.isUpperCase(shiftEnd)) { // uppercase method
            shiftDistance = shiftEnd - shiftStart;
        } else {
            throw new UnsupportedOperationException(); // given
        }
        return shiftDistance;
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        int index = s.indexOf(c);  // changed code to simplified code
        return s.substring(index) + s.substring(0, index);
    }
}
