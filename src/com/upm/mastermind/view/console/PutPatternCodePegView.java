package com.upm.mastermind.view.console;

import com.upm.mastermind.controller.PutPatternCodePegController;
import com.upm.mastermind.model.CodePeg;
import com.upm.mastermind.model.PatternCodePeg;
import com.upm.mastermind.model.Row;
import com.upm.mastermind.view.Error;
import com.upm.mastermind.view.Message;
import com.upm.utils.Console;

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
                Error.REPEATED_CODE_PEG_PATTERN.writeln();
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
                    Error.BAD_COMBINATION_CODE_PEG_PATTERN.writeln();
                }
            } while (!error && i < patternString.length());
        } while (error);
        return pattern;
    }

    private String readWithCorrectLength() {
        Console console = Console.instance();
        String patternString;
        boolean error;
        do {
            patternString = console.readString(Message.ENTER_PATTERN.toString());
            error = patternString.length() != Row.SIZE;
            if(error) {
                Error.BAD_LONG_CODE_PEG_PATTERN.writeln();
            }
        } while (error);
        return patternString;
    }
}
