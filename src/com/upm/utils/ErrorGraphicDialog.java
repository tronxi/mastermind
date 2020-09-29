package com.upm.utils;

import javax.swing.*;

public class ErrorGraphicDialog {

    private final static String ERROR = "Error";

    public void show(String message) {
        JOptionPane.showMessageDialog(null, message, ERROR, JOptionPane.ERROR_MESSAGE);

    }
}
