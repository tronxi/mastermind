package com.upm.mastermind.model;

public class Row {

    public static final int SIZE = 4;
    private final PatternKeyPeg patternKeyPeg;
    private PatternCodePeg patternCodePeg;

    public Row() {
        this.patternCodePeg = new PatternCodePeg();
        this.patternKeyPeg = new PatternKeyPeg();
    }

    public boolean isWinnerRow(PatternCodePeg secret) {
        assert secret != null;
        return patternCodePeg.equals(secret);
    }

    public void setPatternCodePeg(PatternCodePeg patternCodePeg) {
        assert patternCodePeg != null;
        this.patternCodePeg = patternCodePeg;
    }

    public void calculateFeedBack(PatternCodePeg secret) {
        assert secret != null;
        patternKeyPeg.calculateFeedBack(secret, this.patternCodePeg);
    }

    public PatternCodePeg getPatternCodePeg() {
        return patternCodePeg;
    }

    public PatternKeyPeg getPatternKeyPeg() {
        return patternKeyPeg;
    }
}
