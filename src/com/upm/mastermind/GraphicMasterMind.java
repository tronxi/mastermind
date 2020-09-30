package com.upm.mastermind;

import com.upm.mastermind.view.View;
import com.upm.mastermind.view.graphic.GraphicView;

public class GraphicMasterMind extends Mastermind {

    @Override
    public View createView() {
        return new GraphicView();
    }

    public static void main(String[] args) {
        new GraphicMasterMind().play();
    }
}
