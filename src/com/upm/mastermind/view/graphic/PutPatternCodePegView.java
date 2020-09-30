package com.upm.mastermind.view.graphic;

import com.upm.mastermind.controller.PutPatternCodePegController;
import com.upm.mastermind.model.CodePeg;
import com.upm.mastermind.model.PatternCodePeg;
import com.upm.mastermind.model.Row;
import com.upm.mastermind.view.Error;
import com.upm.mastermind.view.Message;
import com.upm.utils.GraphicDialog;

public class PutPatternCodePegView {

    public void interact(PutPatternCodePegController putPatternCodePegController) {
        putPatternCodePegController.put(read());
    }

    private PatternCodePeg read() {
        boolean error;
        PatternCodePeg patternCodePeg;
        do {
            CodePeg[] codePegs = readValidCombination();
            patternCodePeg = new PatternCodePeg(codePegs);
            error = patternCodePeg.isRepeated();
            if(error) {
                GraphicDialog.getInstance().error(Error.REPEATED_CODE_PEG_PATTERN.getMessage());
            }
        } while (error);
        return patternCodePeg;
    }

    private CodePeg[] readValidCombination() {
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
                    GraphicDialog.getInstance().error(Error.BAD_COMBINATION_CODE_PEG_PATTERN.getMessage());
                }
            } while (!error && i < patternString.length());
        } while (error);
        return pattern;
    }

    private String readWithCorrectLength() {
        String patternString;
        boolean error;
        do {
            patternString = GraphicDialog.getInstance().input(Message.TITTLE.toString(), Message.ENTER_PATTERN.toString());
            error = patternString.length() != Row.SIZE;
            if(error) {
                GraphicDialog.getInstance().error(Error.BAD_LONG_CODE_PEG_PATTERN.getMessage());
            }
        } while (error);
        return patternString;
    }
}
