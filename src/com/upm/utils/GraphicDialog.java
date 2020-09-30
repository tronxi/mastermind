package com.upm.utils;

import javax.swing.*;

public class GraphicDialog {

    private final static String ERROR = "Error";

    private static GraphicDialog graphicDialog;

    public static GraphicDialog getInstance() {
        if(GraphicDialog.graphicDialog == null)
            GraphicDialog.graphicDialog = new GraphicDialog();
        return graphicDialog;
    }

    private GraphicDialog() {

    }

    public void error(String message) {
        JOptionPane.showMessageDialog(null, message, ERROR, JOptionPane.ERROR_MESSAGE);
    }

    public void info(String title, String message) {
        JOptionPane.showMessageDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public String input (String title, String message) {
        return JOptionPane.showInputDialog(null, message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean confirm(String title, String message) {
        return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION) == 0;
    }
}
