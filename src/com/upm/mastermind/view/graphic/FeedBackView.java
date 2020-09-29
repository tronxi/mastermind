package com.upm.mastermind.view.graphic;

import com.upm.mastermind.controller.FeedBackController;

import javax.swing.*;

public class FeedBackView extends com.upm.mastermind.view.FeedBackView {

    @Override
    public void interact(FeedBackController feedBackController) {
        feedBackController.calculateFeedBack();
        showDialog(new BoardView(feedBackController.getBoard()).getMessage());
        feedBackController.calculateState();
    }

    private void showDialog(String message) {
        JOptionPane.showMessageDialog(null, message);

    }
}
