package com.upm.mastermind;

import com.upm.utils.Console;

public class Board {

    private final static int MAX_ATTEMPTS = 10;

    private final PatternCodePeg secret;
    private final Row[] attempts;
    private int actualAttempt;

    public Board() {
        secret = new PatternCodePeg();
        attempts = new Row[MAX_ATTEMPTS];
        actualAttempt = 0;
    }

    public boolean ifFinished() {
        return actualAttempt == MAX_ATTEMPTS - 1;
    }

    public boolean playerWin() {
        return attempts[actualAttempt].isWinnerRow(secret);
    }

    public void advanceAttempts() {
        this.actualAttempt++;
    }

    public void generateSecret() {
        this.secret.random();
    }

    public void calculateFeedBack() {
        this.attempts[actualAttempt].calculateFeedBack(this.secret);
    }

    public void putPatternCodePeg(PatternCodePeg patternCodePeg) {
        assert patternCodePeg != null;
        attempts[actualAttempt] = new Row();
        attempts[actualAttempt].setPatternCodePeg(patternCodePeg);
    }

    public void write() {
        Console.instance().writeln(String.format(Message.ATTEMPTS.toString(), actualAttempt + 1));
        this.secret.write();
        Message.SECRET.writeln();
        for(int i = 0; i <= actualAttempt; i++) {
            attempts[i].write();
        }
        Message.SEPARATOR.writeln();
    }
}
