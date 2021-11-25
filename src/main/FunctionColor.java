package main;

import java.awt.*;

public class FunctionColor {

    GUI gui;

    public FunctionColor(GUI gui) {
        this.gui = gui;
    }

    public void changeColor(String color) {

        switch (color) {
            case "White" -> {
                gui.window.getContentPane().setBackground(Color.white);
                gui.textArea.setBackground(Color.white);
                gui.textArea.setForeground(Color.black);
            }
            case "Black" -> {
                gui.window.getContentPane().setBackground(Color.black);
                gui.textArea.setBackground(Color.black);
                gui.textArea.setForeground(Color.white);
            }
            case "Blue" -> {
                gui.window.getContentPane().setBackground(Color.blue);
                gui.textArea.setBackground(Color.blue);
                gui.textArea.setForeground(Color.white);
            }
        }
    }
}
