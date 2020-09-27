package com.upm.mastermind;

import com.upm.utils.Console;

import java.util.Arrays;

public class PatternCodePeg {

    private final CodePeg [] pattern;

    public PatternCodePeg() {
        this.pattern = new CodePeg[Row.SIZE];
    }

    public void read() {
        boolean error;
        do {
            readValidCombination();
            error = isRepeated();
            if(error) {
                Error.REPEATED_CODE_PEG_PATTERN.writeln();
            }
        } while (error);
    }

    private void readValidCombination() {
        boolean error;
        do {
            error = false;
            char[] patternString = readWithCorrectLength();
            int i = 0;
            do {
                if (CodePeg.containInitial(patternString[i])) {
                    pattern[i] = CodePeg.valueOf(String.valueOf(patternString[i]));
                    i++;
                } else {
                    error = true;
                    Error.BAD_COMBINATION_CODE_PEG_PATTERN.writeln();
                }
            } while (!error && i < patternString.length);
        } while (error);
    }

    private char[] readWithCorrectLength() {
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
        return patternString.toUpperCase().toCharArray();
    }

    private boolean isRepeated() {
        for (int i = 0; i < Row.SIZE; i++) {
            for (int j = 0; j < Row.SIZE; j++) {
                if (i != j) {
                    if (pattern[i].equals(pattern[j])) {
                        return true;
                    }
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
