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
            if(secret.isEqualInPosition(actual, i)) {
                pattern[i] = KeyPeg.BLACK;
            } else {
                if(secret.containByPosition(actual, i)) {
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
