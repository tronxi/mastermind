package com.upm.mastermind;

import com.upm.utils.Console;

public class Board {

    private final static int MAX_ATTEMPTS = 10;

    private final PatternCodePeg secret;
    private final Row[] attempts;
    private int actualAttempt;

    public Board() {
        this.secret = new PatternCodePeg();
        this.attempts = new Row[MAX_ATTEMPTS];
        this.actualAttempt = 0;
    }

    public boolean ifFinished() {
        return actualAttempt == MAX_ATTEMPTS - 1;
    }

    public boolean playerWin() {
        return attempts[actualAttempt].isWinnerRow(secret);
    }

    public void advanceAttempts() {
        actualAttempt++;
    }

    public void generateSecret() {
        secret.random();
    }

    public void calculateFeedBack() {
        attempts[actualAttempt].calculateFeedBack(secret);
    }

    public void putPatternCodePeg(PatternCodePeg patternCodePeg) {
        assert patternCodePeg != null;
        attempts[actualAttempt] = new Row();
        attempts[actualAttempt].setPatternCodePeg(patternCodePeg);
    }

    public void write() {
        Console.instance().writeln(String.format(Message.ATTEMPTS.toString(), actualAttempt + 1));
        secret.write();
        Message.SECRET.writeln();
        for(int i = 0; i <= actualAttempt; i++) {
            attempts[i].write();
        }
        Message.SEPARATOR.writeln();
    }
}
