package com.upm.mastermind.view;

import com.upm.mastermind.controller.*;

public class View implements ControllerVisitor {

    private FeedBackView feedBackView;
    private ResumeView resumeView;
    private MakePatternCodePegView makePatternCodePegView;
    private PutPatternCodePegView putPatternCodePegView;

    public View() {
        feedBackView = new FeedBackView();
        resumeView = new ResumeView();
        makePatternCodePegView = new MakePatternCodePegView();
        putPatternCodePegView = new PutPatternCodePegView();
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
