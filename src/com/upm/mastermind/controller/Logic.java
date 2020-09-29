package com.upm.mastermind.controller;

import com.upm.mastermind.model.Game;

public class Logic {

    private final Game game;
    private final Controller feedBackController;
    private final Controller makePatternController;
    private final Controller putPatternController;
    private final Controller resumeController;

    public Logic() {
        this.game = new Game();
        this.feedBackController = new FeedBackController(game);
        this.makePatternController = new MakePatternCodePegController(game);
        this.putPatternController = new PutPatternCodePegController(game);
        this.resumeController = new ResumeController(game);
    }

    public Controller getAction() {
        switch (game.getState()) {
            case INITIAL:
                return makePatternController;
            case IN_GAME:
                return putPatternController;
            case PENDING_FEEDBACK:
                return feedBackController;
            case WON:
            case LOST:
                return resumeController;
            case EXIT:
            default:
                return null;
        }
    }
}
