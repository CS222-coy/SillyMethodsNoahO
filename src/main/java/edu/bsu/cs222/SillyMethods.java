package edu.bsu.cs222;

public class SillyMethods {

    public boolean didGuess42(int i) {
        if(i == 42) {
            return true;
        }
        return false;
    }

    public String countTo(int i) {
        String numberCount = "0";
        for(int x = 1; x <= i; x++) {
            numberCount += (" " + x);
        }
        return numberCount;
    }

    public boolean checkIfEven(int numberToCheck) {
        if(numberToCheck % 2 == 0) {
            return true;
        }
        return false;
    }
}
