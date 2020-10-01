package com.upm.mastermind.model;

import java.util.Arrays;

public class PatternCodePeg {

    private final CodePeg[] pattern;

    public PatternCodePeg() {
        this.pattern = new CodePeg[Row.SIZE];
    }

    public PatternCodePeg(CodePeg[] pattern) {
        this.pattern = pattern;
    }

    public boolean containRepetitions() {
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
        } while (containRepetitions());
    }

    public boolean isEqualInPosition(PatternCodePeg patternCodePeg, int position) {
        return pattern[position] == patternCodePeg.pattern[position];
    }

    public CodePeg[] getPattern() {
        return this.pattern;
    }

    public boolean containByPosition(PatternCodePeg patternCodePeg, int position) {
        assert patternCodePeg != null;
        assert position >= 0 && position < Row.SIZE;
        for(CodePeg cp : pattern) {
            if (cp.equals(patternCodePeg.pattern[position])) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatternCodePeg that = (PatternCodePeg) o;
        return Arrays.equals(pattern, that.pattern);
    }

}
