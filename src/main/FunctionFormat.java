package main;

public class FunctionFormat {

    GUI gui;

    public FunctionFormat(GUI gui) {
        this.gui = gui;
    }

    public void wordWrap() {
        if(gui.wordWrapOn == false) {
            gui.wordWrapOn = true;
            gui.textArea.setLineWrap(true);
            gui.textArea.setWrapStyleWord(true);
            gui.itemWrap.setText("Word Wrap: On");
        }
        else if(gui.wordWrapOn == true) {
            gui.wordWrapOn = false;
            gui.textArea.setLineWrap(false);
            gui.textArea.setWrapStyleWord(false);
            gui.itemWrap.setText("Word Wrap: Off");
        }
    }
}
