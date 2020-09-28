package com.upm.mastermind.view;

import com.upm.mastermind.model.KeyPeg;
import com.upm.mastermind.model.Message;
import com.upm.mastermind.model.PatternKeyPeg;
import com.upm.utils.Console;

public class PatternKeyPegView {

    private PatternKeyPeg patternKeyPeg;

    public PatternKeyPegView(PatternKeyPeg patternKeyPeg) {
        this.patternKeyPeg = patternKeyPeg;
    }

    public void write() {
        Console.instance().write(String.format(Message.KEY_PEG_OCCURRENCES.toString(),
                patternKeyPeg.countOccurrences(KeyPeg.BLACK), patternKeyPeg.countOccurrences(KeyPeg.WHITE)));
    }
}
