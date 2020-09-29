package com.upm.mastermind.model;

public class PatternKeyPeg {

    private final KeyPeg[] pattern;

    public PatternKeyPeg() {
        this.pattern = new KeyPeg[Row.SIZE];
    }

    public void calculateFeedBack(PatternCodePeg secret, PatternCodePeg actual) {
        assert secret != null;
        assert actual != null;
        for (int i = 0; i < Row.SIZE; i++) {
            if(secret.getPattern()[i].equals(actual.getPattern()[i])) {
                pattern[i] = KeyPeg.BLACK;
            } else {
                if(secret.contain(actual.getPattern()[i])) {
                    pattern[i] = KeyPeg.WHITE;
                }
            }
        }
    }

    public int countOccurrences(KeyPeg keyPeg) {
        int occurrences = 0;
        for(KeyPeg kp : pattern) {
            if(kp != null && kp.equals(keyPeg)) {
                occurrences++;
            }
        }
        return occurrences;
    }

}
