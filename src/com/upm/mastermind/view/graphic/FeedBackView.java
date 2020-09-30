package com.upm.mastermind.view.graphic;

import com.upm.mastermind.controller.FeedBackController;
import com.upm.mastermind.view.Message;
import com.upm.utils.GraphicDialog;

public class FeedBackView {

    public void interact(FeedBackController feedBackController) {
        feedBackController.calculateFeedBack();
        showDialog(new BoardView(feedBackController.getBoard()).getMessage());
        feedBackController.calculateState();
    }

    private void showDialog(String message) {
        GraphicDialog.getInstance().info(Message.TITTLE.toString(), message);
    }
}
