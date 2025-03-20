package main;

import utils.Entry;
import utils.EntryException;

import java.util.InputMismatchException;

public class Main {
    public static void main(String[] args) {

        while (true) {
            try {
                byte result = Entry.readByte("Introduce a valid byte value: ");
                System.out.println("The valid byte type value is " + result + "\n");
                Entry.sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid byte type value");
                Entry.sc.nextLine();
            }
        }

        while (true) {
            try {
                int result = Entry.readInt("Introduce a valid integer: ");
                System.out.println("The valid integer is " + result + "\n");
                Entry.sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid integer");
                Entry.sc.nextLine();
            }
        }

        while (true) {
            try {
                float result = Entry.readFloat("Introduce a valid float: ");
                System.out.println("The valid float is " + result + "\n");
                Entry.sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid float");
                Entry.sc.nextLine();
            }
        }

        while (true) {
            try {
                double result = Entry.readDouble("Introduce a valid double: ");
                System.out.println("The valid double is " + result + "\n");
                Entry.sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("That is not a valid double");
                Entry.sc.nextLine();
            }
        }

        while (true) {
            try {
                char result = Entry.readChar("Introduce a valid character: ");
                System.out.println("The valid character is " + result + "\n");
                Entry.sc.nextLine();
                break;
            } catch (EntryException e) {
                System.out.println("That is not a valid character");
                Entry.sc.nextLine();
            }
        }

        while (true) {
            try {
                String result = Entry.readString("Introduce a valid string: ");
                System.out.println("The valid string is " + result + "\n");
                Entry.sc.nextLine();
                break;
            } catch (EntryException e) {
                System.out.println("That is not a valid string");
                Entry.sc.nextLine();
            }
        }

        while (true) {
            try {
                boolean result = Entry.readBoolean("Introduce a valid boolean (y/n): ");
                System.out.println("The valid boolean is " + result + "\n");
                Entry.sc.nextLine();
                break;
            } catch (EntryException e) {
                System.out.println("That is not a valid boolean");
                Entry.sc.nextLine();
            } // No aparece la pregunta en pantalla del boolean.
            // Hacer preguntas con un poco de sentido humano, para todas.
            // Especificar la razón de la excepción (qué estamos buscando), eso es una excepción personificada
        } // El programa no termina.
        // Revisar limpieza buffer (sobre todo después de los números)
    }
}
