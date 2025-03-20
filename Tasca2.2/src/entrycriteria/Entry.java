package entrycriteria;

import exceptions.EntryException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entry {

    public static Scanner sc = new Scanner(System.in);

    public static byte readByte(String message) throws InputMismatchException {
        System.out.println(message);
        if (sc.hasNextByte()) {
            return sc.nextByte();
        } else {
            throw new InputMismatchException();
        }
    }

    public static int readInt(String message) throws InputMismatchException {
        System.out.println(message);
        int input = sc.nextInt();
        if (input > 0) {
            sc.nextLine();
            return input;
        } else {
            throw new InputMismatchException();
        }
    }

    public static float readFloat(String message) throws InputMismatchException {
        System.out.println(message);
        if (sc.hasNextFloat()) {
            return sc.nextFloat();
        } else {
            sc.nextLine();
            throw new InputMismatchException();
        }
    }

    public static double readDouble(String message) throws InputMismatchException {
        System.out.println(message);
        if (sc.hasNextDouble()) {
            return sc.nextDouble();
        } else {
            throw new InputMismatchException();
        }
    }

    public static char readChar(String message) throws EntryException {
        System.out.println(message);
        String input = sc.next();
        if (input.length() == 1) {
            if (Character.isLetter(input.charAt(0))) {
                return input.charAt(0);
            } else {
                throw new EntryException(message);
            }
        } throw new EntryException(message);
    }

    public static String readString(String message) throws EntryException {
        System.out.println(message);
        sc.nextLine();
        String input = sc.nextLine();
        if (!input.isEmpty()) {
            return input;
        } else {
            throw new EntryException(message);
        }
    }
    public static boolean readBoolean(String message) throws EntryException {
        System.out.println(message);
        String input = sc.nextLine();
        if (input.equalsIgnoreCase("y")) {
            return true;
        } else if (input.equalsIgnoreCase("n")) {
            return false;
        } else {
            throw new EntryException(message);
        }
    }
}
