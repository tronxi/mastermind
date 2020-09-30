package com.upm.mastermind.view;

import com.upm.mastermind.controller.PutPatternCodePegController;
import com.upm.mastermind.model.CodePeg;
import com.upm.mastermind.model.PatternCodePeg;
import com.upm.mastermind.model.Row;

public abstract class PutPatternCodePegView {

    public void interact(PutPatternCodePegController putPatternCodePegController) {
        putPatternCodePegController.put(read());
    }

    protected PatternCodePeg read() {
        boolean error;
        PatternCodePeg patternCodePeg;
        do {
            CodePeg[] codePegs = readValidCombination();
            patternCodePeg = new PatternCodePeg(codePegs);
            error = patternCodePeg.isRepeated();
            if(error) {
                showError(Error.REPEATED_CODE_PEG_PATTERN);
            }
        } while (error);
        return patternCodePeg;
    }

    protected CodePeg[] readValidCombination() {
        boolean error;
        CodePeg[] pattern = new CodePeg[Row.SIZE];
        do {
            error = false;
            String patternString = readWithCorrectLength();
            int i = 0;
            do {
                if (CodePeg.containInitial(patternString.charAt(i))) {
                    pattern[i] = CodePeg.getByInitial(String.valueOf(patternString.charAt(i)));
                    i++;
                } else {
                    error = true;
                    showError(Error.BAD_COMBINATION_CODE_PEG_PATTERN);
                }
            } while (!error && i < patternString.length());
        } while (error);
        return pattern;
    }

    protected String readWithCorrectLength() {
        String patternString;
        boolean error;
        do {
            patternString = readInput(Message.TITTLE, Message.ENTER_PATTERN);
            error = patternString.length() != Row.SIZE;
            if(error) {
                showError(Error.BAD_LONG_CODE_PEG_PATTERN);
            }
        } while (error);
        return patternString;
    }

    protected abstract void showError(Error error);

    protected abstract String readInput(Message title, Message message);
}
