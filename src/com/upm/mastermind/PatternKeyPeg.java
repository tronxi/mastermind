package com.upm.mastermind;

import com.upm.utils.Console;

public class PatternKeyPeg {
    private final KeyPeg [] pattern;
    private int actualFeedBack;

    public PatternKeyPeg() {
        this.pattern = new KeyPeg[Row.SIZE];
        actualFeedBack = 0;
    }

    public void calculateFeedBack(PatternCodePeg secret, PatternCodePeg actual) {
        assert secret != null;
        assert actual != null;
        for (int i = 0; i < Row.SIZE; i++) {
            if(secret.getPattern()[i].equals(actual.getPattern()[i])) {
                pattern[actualFeedBack] = KeyPeg.BLACK;
                actualFeedBack++;
            } else {
                if(secret.contain(actual.getPattern()[i])) {
                    pattern[actualFeedBack] = KeyPeg.WHITE;
                    actualFeedBack++;
                }
            }
        }
    }

    public void write() {
        Console.instance().write(String.format(Message.KEY_PEG_OCCURRENCES.toString(),
                countOccurrences(KeyPeg.BLACK), countOccurrences(KeyPeg.WHITE)));
    }

    private int countOccurrences(KeyPeg keyPeg) {
        int occurrences = 0;
        for(KeyPeg kp : pattern) {
            if(kp != null && kp.equals(keyPeg)) {
                occurrences++;
            }
        }
        return occurrences;
    }

}
