package entrycriteria;

import exceptions.EntryException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entry {

    public static Scanner sc = new Scanner(System.in);

    public static byte readByte(String message) throws InputMismatchException {
        System.out.println(message);

        if (!sc.hasNextByte()) {
            throw new InputMismatchException();
        } else {
            return sc.nextByte();
        }
    }

    public static int readInt(String message) throws InputMismatchException {
        System.out.println(message);
        String input = sc.nextLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }

    public static float readFloat(String message) throws InputMismatchException {
        System.out.println(message);
        String input = sc.nextLine();

        try {
            return Float.parseFloat(input);
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }

    public static double readDouble(String message) throws InputMismatchException {
        System.out.println(message);
        String input = sc.nextLine();

        try {
            return Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new InputMismatchException();
        }
    }

    public static char readChar(String message) throws EntryException {
        System.out.println(message);
        String input = sc.next();

        if (input.length() != 1 || !Character.isLetter(input.charAt(0))) {
            throw new EntryException(message);
        } else {
            return input.charAt(0);
        }
    }

    public static String readString(String message) throws EntryException {
        System.out.println(message);
        String input = sc.nextLine();

        if (input.isEmpty()) {
            throw new EntryException(message);
        } else {
            return input;
        }
    }

    public static boolean readBoolean(String message) throws EntryException {
        System.out.println(message);
        String input = sc.nextLine();

        if (!(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n"))) {
            throw new EntryException(message);
        } else {
            return input.equalsIgnoreCase("y");
        }
    }
}
