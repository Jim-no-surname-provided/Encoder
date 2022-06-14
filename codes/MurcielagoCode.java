package codes;

import io.*;

public class MurcielagoCode extends Code {

    public static final String MURCIELAGO = "murcielago";

    @Override
    public void encode() {
        changeChars(false);
    }
    
    @Override
    public void decode() {
        changeChars(true);
    }

    public void changeChars(boolean decoding) {

        String linea = In.readLine();

        while (In.done()) {

            for (char ch : linea.toCharArray()) {

                if(decoding){
                    Out.print(changedCharDecoding(ch));
                } else {
                    Out.print(changedChar(ch));
                }

            }

            linea = In.readLine();
            Out.println();
        }
    }

    private char changedChar(char ch) {
        int indexOfMurcielago = MURCIELAGO.indexOf(Character.toLowerCase(ch));
        if (indexOfMurcielago != -1) {
            return (char) (indexOfMurcielago + '0');
        } else {
            return ch;
        }
    }

    private char changedCharDecoding(char ch) {
        if (Character.isDigit(ch)) {
            return MURCIELAGO.charAt(ch - '0');
        } else {
            return ch;
        }
    }

}