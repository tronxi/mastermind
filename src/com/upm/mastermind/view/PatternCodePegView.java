package com.upm.mastermind.view;

import com.upm.mastermind.model.CodePeg;
import com.upm.mastermind.model.PatternCodePeg;
import com.upm.utils.Console;

public class PatternCodePegView {

    private final PatternCodePeg patternCodePeg;

    public PatternCodePegView(PatternCodePeg patternCodePeg) {
        this.patternCodePeg = patternCodePeg;
    }

    public void write() {
        for (CodePeg codePeg : patternCodePeg.getPattern()) {
            Console.instance().write(codePeg.toString());
        }
    }
}
