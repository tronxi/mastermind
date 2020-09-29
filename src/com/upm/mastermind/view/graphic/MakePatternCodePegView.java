package com.upm.mastermind.view.graphic;

import com.upm.mastermind.controller.MakePatternCodePegController;

public class MakePatternCodePegView extends com.upm.mastermind.view.MakePatternCodePegView {

    @Override
    public void interact(MakePatternCodePegController makePatternCodePegController) {
        makePatternCodePegController.execute();
    }
}
