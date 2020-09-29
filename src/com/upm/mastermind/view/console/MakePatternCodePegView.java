package com.upm.mastermind.view.console;

import com.upm.mastermind.controller.MakePatternCodePegController;

public class MakePatternCodePegView extends com.upm.mastermind.view.MakePatternCodePegView {

    @Override
    public void interact(MakePatternCodePegController makePatternCodePegController) {
        makePatternCodePegController.execute();
    }
}
