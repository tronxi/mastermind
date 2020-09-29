package com.upm.mastermind.model;

import java.util.Arrays;
import java.util.Random;

public enum CodePeg {
    BLUE("b"),
    RED("r"),
    PINK("p"),
    YELLOW("y"),
    GREEN("g"),
    ORANGE("o");

    private String initial;

    CodePeg(String initial) {
        this.initial = initial;
    }

    public String getInitial() {
        return this.initial;
    }

    public static boolean containInitial(char codePeg) {
        return Arrays.stream(CodePeg.values())
                .map(CodePeg::getInitial)
                .anyMatch(cp -> cp.equals(String.valueOf(codePeg).toLowerCase()));
    }

    public static CodePeg getByInitial(String initial) {
        for (CodePeg codePeg: CodePeg.values()) {
            if(codePeg.getInitial().equals(initial.toLowerCase()))
                return codePeg;
        }
        return null;
    }

    public static CodePeg random() {
        return CodePeg.values()[new Random().nextInt(CodePeg.values().length)];
    }

}
