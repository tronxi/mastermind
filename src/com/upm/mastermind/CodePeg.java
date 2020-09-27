package com.upm.mastermind;

import java.util.Arrays;
import java.util.Random;

public enum CodePeg {
    B,
    R,
    P,
    Y,
    G,
    O;

    public static boolean containInitial(char codePeg) {
        return Arrays.stream(CodePeg.values())
                .map(Enum::toString)
                .anyMatch(cp -> cp.equals(String.valueOf(codePeg)));
    }

    public static CodePeg random() {
        return CodePeg.values()[new Random().nextInt(CodePeg.values().length)];
    }

}
