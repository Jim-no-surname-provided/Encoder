package codes;

import io.*;

public class HelmutCode extends Code {

    // ! The first must be vowels
    public static final String[] LETTER_LISTS_L = {
            "aeiou",
            "bcdfghjklmnpqrstvwxyz"
    };
    public static String[] LETTER_LISTS_U;

    public static final String[] SPECIAL_VOWELS_L = { "áéíóú", "äëïöü" };
    public static String[] SPECIAL_VOWELS_U;

    public HelmutCode() {

        // Generate the uppercase versions
        LETTER_LISTS_U = new String[LETTER_LISTS_L.length];

        for (int i = 0; i < LETTER_LISTS_U.length; i++) {
            LETTER_LISTS_U[i] = LETTER_LISTS_L[i].toUpperCase();
        }

        SPECIAL_VOWELS_U = new String[SPECIAL_VOWELS_L.length];

        for (int i = 0; i < SPECIAL_VOWELS_U.length; i++) {
            SPECIAL_VOWELS_U[i] = SPECIAL_VOWELS_L[i].toUpperCase();
        }

    }

    @Override
    public void encode() {
        encode(1);
    }

    @Override
    public void decode() {
        decode(1);
    }

    public void encode(int fase) {
        changeChars(fase);
    }

    public void decode(int fase) {
        changeChars(-fase);
    }

    public void changeChars(int fase) {

        String linea = In.readLine();

        while (In.done()) {

            for (char ch : linea.toCharArray()) {

                if (Character.isLowerCase(ch)) {
                    Out.print(nextChar(ch, fase, LETTER_LISTS_L, SPECIAL_VOWELS_L));
                } else {
                    Out.print(nextChar(ch, fase, LETTER_LISTS_U, SPECIAL_VOWELS_U));
                }
            }

            linea = In.readLine();
            Out.println();
        }
    }

    private static char nextChar(char ch, int fase, String[] lists, String[] specialVowels) {

        for (int i = 0; i < specialVowels.length; i++) {
            int indexOfSpecialVowel = specialVowels[i].indexOf(ch);

            if (indexOfSpecialVowel != -1) {
                // The next vowel going back if it exceeds, and forwards it is negative
                ch = lists[0].charAt(indexOfSpecialVowel);
            }
        }

        for (String letters : lists) {
            int indexOfLetter = letters.indexOf(ch);

            if (indexOfLetter != -1) {
                // The next vowel going back if it exceeds, and forwards it is negative
                int position = ((indexOfLetter + fase) % letters.length() + letters.length()) % letters.length();

                return letters.charAt(position);
            }
        }

        return ch;
    }
}