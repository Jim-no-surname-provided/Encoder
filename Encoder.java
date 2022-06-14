import codes.*;
import io.*;

public class Encoder {

    public static enum code {
        HELMUT,
        JULIANO,
        MURCIELAGO,
    }

    public static void main(String[] args) {
        try {
            In.open("Input.txt");
            Out.open("Output.txt");

            Code code = new HelmutCode();

            code.encode();

        } catch (Exception e) {
        } finally {
            In.close();
            Out.close();
        }
    }

}