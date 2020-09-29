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

    public boolean isRepeated() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatternCodePeg that = (PatternCodePeg) o;
        return Arrays.equals(pattern, that.pattern);
    }

}
