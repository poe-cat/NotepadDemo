package main;

public class FunctionEdit {

    GUI gui;

    public FunctionEdit(GUI gui) {
        this.gui = gui;
    }

    public void undo() {
        gui.undoManager.undo();
    }

    public void redo() {
        gui.undoManager.redo();
    }
}
