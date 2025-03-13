package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Entry {

    private static Scanner sc = new Scanner(System.in);

    public static byte readByte(String message) throws InputMismatchException {
        try {
            return sc.nextByte();
        } catch (InputMismatchException e) {
            throw new InputMismatchException(message);
        }
    }

    public static int readInt(String message) throws InputMismatchException {
        try {
            return sc.nextInt();
        } catch (InputMismatchException e) {
            throw new InputMismatchException(message);
        }
    }

    public static float readFloat(String message) throws InputMismatchException {
        try {
            return sc.nextFloat();
        } catch (InputMismatchException e) {
            throw new InputMismatchException(message);
        }
    }

    public static double readDouble(String message) throws InputMismatchException {
        try {
            return sc.nextDouble();
        } catch (InputMismatchException e) {
            throw new InputMismatchException(message);
        }
    }

    public static char readChar(String message) throws Exception {
        try {
            return sc.next().charAt(0);
        } catch (Exception e) {
            throw new Exception(message);
        }
    }

    public static String readString(String message) throws Exception {
        try {
            return sc.next();
        } catch (Exception e) {
            throw new Exception(message);
        }
    }
    public static boolean readBoolean(String message) throws Exception {
        try {
            return sc.nextBoolean();
        } catch (Exception e) {
            throw new Exception(message);
        }
    }
}
