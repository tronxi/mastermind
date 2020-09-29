package com.upm.mastermind.view;

import com.upm.mastermind.controller.FeedBackController;

public class FeedBackView {

    public void interact(FeedBackController feedBackController) {
        feedBackController.calculateFeedBack();
        new BoardView(feedBackController.getBoard()).write();
        feedBackController.calculateState();
    }
}
