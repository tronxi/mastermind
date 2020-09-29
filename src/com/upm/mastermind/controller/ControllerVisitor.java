package com.upm.mastermind.controller;

public interface ControllerVisitor {
    void visit (FeedBackController feedBackController);
    void visit (MakePatternCodePegController makePatternCodePegController);
    void visit (PutPatternCodePegController putPatternCodePegController);
    void visit (ResumeController resumeController);
}
