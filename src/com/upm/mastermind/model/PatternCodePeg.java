package com.upm.mastermind.model;

import com.upm.utils.Console;

import java.util.Arrays;

public class PatternCodePeg {

    private final CodePeg[] pattern;

    public PatternCodePeg() {
        this.pattern = new CodePeg[Row.SIZE];
    }

    public void read() {
        boolean error;
        do {
            readValidCombination();
            error = isRepeated();
            if(error) {
                com.upm.mastermind.model.Error.REPEATED_CODE_PEG_PATTERN.writeln();
            }
        } while (error);
    }

    private void readValidCombination() {
        boolean error;
        do {
            error = false;
            String patternString = readWithCorrectLength();
            int i = 0;
            do {
                if (CodePeg.containInitial(patternString.charAt(i))) {
                    pattern[i] = CodePeg.valueOf(String.valueOf(patternString.charAt(i)));
                    i++;
                } else {
                    error = true;
                    com.upm.mastermind.model.Error.BAD_COMBINATION_CODE_PEG_PATTERN.writeln();
                }
            } while (!error && i < patternString.length());
        } while (error);
    }

    private String readWithCorrectLength() {
        Console console = Console.instance();
        String patternString;
        boolean error;
        do {
            patternString = console.readString(Message.ENTER_PATTERN.toString());
            error = patternString.length() != Row.SIZE;
            if(error) {
                com.upm.mastermind.model.Error.BAD_LONG_CODE_PEG_PATTERN.writeln();
            }
        } while (error);
        return patternString.toUpperCase();
    }

    private boolean isRepeated() {
        for (int i = 0; i < Row.SIZE; i++) {
            for (int j = 0; j < Row.SIZE; j++) {
                if (i != j && pattern[i].equals(pattern[j])) {
                    return true;
                }
            }
        }
        return false;
    }

    public void random() {
        do {
            for (int i = 0; i < Row.SIZE; i++) {
                this.pattern[i] = CodePeg.random();
            }
        } while (isRepeated());
    }

    public CodePeg[] getPattern() {
        return this.pattern;
    }

    public boolean contain(CodePeg codePeg) {
        assert codePeg != null;
        for(CodePeg cp : pattern) {
            if (cp.equals(codePeg)) {
                return true;
            }
        }
        return false;
    }

    public void write() {
        for (CodePeg codePeg: pattern) {
            Console.instance().write(codePeg.toString());
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatternCodePeg that = (PatternCodePeg) o;
        return Arrays.equals(pattern, that.pattern);
    }

}
