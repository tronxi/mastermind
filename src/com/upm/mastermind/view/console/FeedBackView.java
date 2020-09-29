package com.upm.mastermind.view.console;

import com.upm.mastermind.controller.FeedBackController;

public class FeedBackView extends com.upm.mastermind.view.FeedBackView {

    @Override
    public void interact(FeedBackController feedBackController) {
        feedBackController.calculateFeedBack();
        new BoardView(feedBackController.getBoard()).write();
        feedBackController.calculateState();
    }
}
