package com.upm.mastermind.view;

import com.upm.mastermind.controller.*;

public class View implements ControllerVisitor {

    private FeedBackView feedBackView;
    private ResumeView resumeView;
    private MakePatternCodePegView makePatternCodePegView;
    private PutPatternCodePegView putPatternCodePegView;

    public View() {
        graphic();
    }

    private void console() {
        feedBackView = new com.upm.mastermind.view.console.FeedBackView();
        resumeView = new com.upm.mastermind.view.console.ResumeView();
        makePatternCodePegView = new com.upm.mastermind.view.console.MakePatternCodePegView();
        putPatternCodePegView = new com.upm.mastermind.view.console.PutPatternCodePegView();
    }

    private void graphic() {
        feedBackView = new com.upm.mastermind.view.graphic.FeedBackView();
        resumeView = new com.upm.mastermind.view.graphic.ResumeView();
        makePatternCodePegView = new com.upm.mastermind.view.graphic.MakePatternCodePegView();
        putPatternCodePegView = new com.upm.mastermind.view.graphic.PutPatternCodePegView();
    }

    public void interact(Controller controller) {
        controller.accept(this);
    }

    @Override
    public void visit(MakePatternCodePegController makePatternCodePegController) {
        makePatternCodePegView.interact(makePatternCodePegController);
    }

    @Override
    public void visit(PutPatternCodePegController putPatternCodePegController) {
        putPatternCodePegView.interact(putPatternCodePegController);
    }

    @Override
    public void visit(FeedBackController feedBackController) {
        feedBackView.interact(feedBackController);
    }

    @Override
    public void visit(ResumeController resumeController) {
        resumeView.interact(resumeController);
    }

}
