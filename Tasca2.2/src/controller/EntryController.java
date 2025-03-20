package controller;

import entrycriteria.Entry;
import exceptions.EntryException;

import java.util.InputMismatchException;

import static entrycriteria.Entry.sc;

public class EntryController {

    public static void entryLauncher() {

        while (true) {
            try {
                byte result = Entry.readByte("Hi there! How old are you, eh?");
                System.out.println("Oh, so you are " + result + " years old, nice.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("I think your age must be a reasonable number, you funny potato.");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                int result = Entry.readInt("I dare you, I double dare you. Give me the approximate number of neurons that an octopus has, without going over!");
                System.out.println("Well " + result + " is definitely not MORE than the total neurons of an octopus.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("That is either too much or not a number at all.");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                float result = Entry.readFloat("Do you know what is the mean number of legs of human beings?");
                System.out.println(result + " is a guess, I guess.");
                break;
            } catch (InputMismatchException e) {
                System.out.println("Hint, it is more than 1 but less than 2! LOOL");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                double result = Entry.readDouble("I have a challenge, give me the digits of PI to the 20th decimal");
                System.out.println("You said " + result + " which is probably off, but at least you gave me THE PROPER FORMAT NUMBER!");
                break;
            } catch (InputMismatchException e) {
                System.out.println("You know PI is three point something, right? Cmon...");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                char result = Entry.readChar("Think fast! What letter is between Q and S in the abecedary");
                System.out.println("You said " + result + " which might be right, I don't even know the abecedary.");
                break;
            } catch (EntryException e) {
                System.out.println("I am quite dumm dumm, but even I know that the answer must be a letter.");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                String result = Entry.readString("Say something!");
                System.out.println("You said " + result + ", which is crazy.");
                break;
            } catch (EntryException e) {
                System.out.println("I can't even imagine what you can say that is not something");
                sc.nextLine();
            }
        }

        while (true) {
            try {
                boolean result = Entry.readBoolean("Ok, last thing, you clever ape. Write in the console either N or Y and see what happens");
                System.out.println("Wow, you are great at following instructions, what you wrote means " + result);
                break;
            } catch (EntryException e) {
                System.out.println("That is not a valid boolean");
                sc.nextLine();
            }
        }
    }
}
