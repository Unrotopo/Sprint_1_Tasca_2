package manager;

import entrycriteria.Entry;
import exceptions.EntryException;

import java.util.InputMismatchException;

import static entrycriteria.Entry.sc;

public class EntryManager {

    public void entryLauncher() {

        demandByte();
        demandInt();
        demandFloat();
        demandDouble();
        demandChar();
        demandString();
        demandBoolean();
    }

    public void demandByte() {
        boolean validInput = false;
        do {
            try {
                byte result = Entry.readByte("\nHi there! How old are you, eh?");
                System.out.println("Oh, so you are " + result + " years old, nice.");
                validInput = true;
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("I think your age must be a reasonable number, you funny potato.");
                sc.nextLine();
            }
        } while (!validInput);
    }

    public void demandInt() {
        boolean validInput = false;
        do {
            try {
                int result = Entry.readInt("\nI dare you, I double dare you. Give me the approximate number of neurons that an octopus has, without going over!");
                System.out.println("Well " + result + " is definitely not MORE than the total neurons of an octopus.");
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("That is either too much or not a number at all.");
            }
        } while (!validInput);
    }

    public void demandFloat() {
        boolean validInput = false;
        do {
            try {
                float result = Entry.readFloat("\nDo you know what is the mean number of legs of human beings?");
                System.out.println(result + " is a guess, I guess.");
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("Hint, it is more than 1 but less than 2! LOOL");
            }
        } while (!validInput);
    }

    public void demandDouble() {
        boolean validInput = false;
        do {
            try {
                double result = Entry.readDouble("\nI have a challenge, give me the digits of PI to the 20th decimal");
                System.out.println("You said " + result + " which is probably off, but at least you gave me THE PROPER FORMAT NUMBER!");
                validInput = true;
            } catch (InputMismatchException e) {
                System.out.println("You know PI is three point something, right? Cmon...");
            }
        } while (!validInput);
    }

    public void demandChar() {
        boolean validInput = false;
        do {
            try {
                char result = Entry.readChar("\nThink fast! What letter is between Q and S in the abecedary");
                System.out.println("You said " + result + " which might be right, I don't even know the abecedary.");
                validInput = true;
                sc.nextLine();
            } catch (EntryException e) {
                System.out.println("I am quite dumm dumm, but even I know that the answer must be a letter.");
            }
        } while (!validInput);
    }

    public void demandString() {
        boolean validInput = false;
        do {
            try {
                String result = Entry.readString("\nSay something!");
                System.out.println("You said " + result + ", which is crazy.");
                validInput = true;
            } catch (EntryException e) {
                System.out.println("I can't even imagine what you can say that is not something");
            }
        } while (!validInput);
    }

    public void demandBoolean() {
        boolean validInput = false;
        do {
            try {
                boolean result = Entry.readBoolean("\nOk, last thing, you clever ape. Write in the console either N or Y and see what happens");
                System.out.println("Wow, you are great at following instructions, what you wrote means " + result);
                validInput = true;
            } catch (EntryException e) {
                System.out.println("That is not a valid boolean");
            }
        } while (!validInput);
    }
}
