package com.upm.mastermind.view;

import com.upm.mastermind.controller.Controller;
import com.upm.mastermind.controller.ControllerVisitor;

public interface View extends ControllerVisitor {
    void interact(Controller controller);
}
