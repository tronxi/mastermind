package com.upm.mastermind.view.graphic;

import com.upm.mastermind.controller.*;
import com.upm.mastermind.view.View;

public class GraphicView implements View {

    private FeedBackView feedBackView;
    private ResumeView resumeView;
    private MakePatternCodePegView makePatternCodePegView;
    private PutPatternCodePegView putPatternCodePegView;

    public GraphicView() {
        feedBackView = new FeedBackView();
        resumeView = new ResumeView();
        makePatternCodePegView = new MakePatternCodePegView();
        putPatternCodePegView = new PutPatternCodePegView();
    }

    @Override
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
