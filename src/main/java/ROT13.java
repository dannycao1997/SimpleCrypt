import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13 {
    private final char shiftStart; //char to start shift
    private final char shiftEnd; //char to end shift

    ROT13(Character cs, Character cf) {
        this.shiftStart = cs;           //cs is the char to start the shift
        this.shiftEnd = cf;             //cf is the char to end the shift
    }

    ROT13() {
        this('a', 'n'); // constructor
    }


    public String crypt(String text) {

        StringBuilder sb = new StringBuilder(); //added

        for (char c : text.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                sb.append((char) ((c - 'a' + getShiftDistance()) % 26 + 'a'));
            } else if (c >= 'A' && c <= 'Z') {
                sb.append((char) ((c - 'A' + getShiftDistance()) % 26 + 'A'));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    private int getShiftDistance() {
        int shiftDistance;

        if(Character.isLowerCase(shiftStart) && Character.isLowerCase(shiftEnd)) {
            shiftDistance = shiftEnd - shiftStart;
        } else if
        (Character.isUpperCase(shiftStart) && Character.isUpperCase(shiftEnd)) {
            shiftDistance = shiftEnd - shiftStart;
        } else {
            throw new UnsupportedOperationException();
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
        int index = s.indexOf(c); //added
        if (index != -1) {
            return s.substring(index) + s.substring(0, index);
        }
        return s;
    }
}
