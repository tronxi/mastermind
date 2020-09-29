package com.upm.mastermind.view.graphic;

import com.upm.mastermind.model.KeyPeg;
import com.upm.mastermind.model.PatternKeyPeg;
import com.upm.mastermind.view.Message;

public class PatternKeyPegView {

    private PatternKeyPeg patternKeyPeg;

    public PatternKeyPegView(PatternKeyPeg patternKeyPeg) {
        this.patternKeyPeg = patternKeyPeg;
    }

    public String getMessage() {
        return String.format(Message.KEY_PEG_OCCURRENCES.toString(),
                patternKeyPeg.countOccurrences(KeyPeg.BLACK), patternKeyPeg.countOccurrences(KeyPeg.WHITE));
    }
}
