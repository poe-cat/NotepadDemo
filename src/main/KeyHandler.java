package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    GUI gui;

    public KeyHandler(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
            gui.functionFile.save();
        }

        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N) {
            gui.functionFile.newFile();
        }

        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
            gui.functionEdit.undo();
        }

        if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_X) {
            gui.functionEdit.redo();
        }

        if(e.isAltDown() && e.getKeyCode() == KeyEvent.VK_F) {
            gui.menuFile.doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
