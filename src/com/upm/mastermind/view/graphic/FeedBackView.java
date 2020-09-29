package com.upm.mastermind.view.graphic;

import com.upm.mastermind.controller.FeedBackController;
import com.upm.mastermind.view.Message;

import javax.swing.*;

public class FeedBackView {

    public void interact(FeedBackController feedBackController) {
        feedBackController.calculateFeedBack();
        showDialog(new BoardView(feedBackController.getBoard()).getMessage());
        feedBackController.calculateState();
    }

    private void showDialog(String message) {
        JOptionPane.showMessageDialog(null, message, Message.TITTLE.toString(), JOptionPane.INFORMATION_MESSAGE);

    }
}
