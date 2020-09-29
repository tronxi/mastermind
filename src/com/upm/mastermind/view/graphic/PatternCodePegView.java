package com.upm.mastermind.view.graphic;

import com.upm.mastermind.model.CodePeg;
import com.upm.mastermind.model.PatternCodePeg;

public class PatternCodePegView {

    private PatternCodePeg patternCodePeg;

    public PatternCodePegView(PatternCodePeg patternCodePeg) {
        this.patternCodePeg = patternCodePeg;
    }

    public String getMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        for (CodePeg codePeg : patternCodePeg.getPattern()) {
            stringBuilder.append(codePeg.toString());
        }
        return stringBuilder.toString();
    }
}
