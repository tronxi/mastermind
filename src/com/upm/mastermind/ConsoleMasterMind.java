package com.upm.mastermind;

import com.upm.mastermind.view.View;
import com.upm.mastermind.view.console.ConsoleView;

public class ConsoleMasterMind extends Mastermind{

    @Override
    public View createView() {
        return new ConsoleView();
    }

    public static void main(String[] args) {
        new ConsoleMasterMind().play();
    }

}
