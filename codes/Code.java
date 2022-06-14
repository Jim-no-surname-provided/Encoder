package codes;

import io.*;

public abstract class Code {
    public abstract void encode();

    public abstract void decode();

    protected void manageChar(char ch) {
    }

    protected void printLine() {
        Out.println();
    }

    /**
     * Loops through all the characters and jumps the line unless printLine() is
     * override
     */
    public void loopEveryChar() {
        String linea = In.readLine();

        while (In.done()) {

            for (char ch : linea.toCharArray()) {

                manageChar(ch);
            }

            linea = In.readLine();
            printLine();
        }
    }
}