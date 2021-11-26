package main;

import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {

    JFrame window;

    //TEXT AREA
    JTextArea textArea;
    JScrollPane scrollPane;
    boolean wordWrapOn = false;
    // TOP MENU BAR
    JMenuBar menuBar;
    JMenu menuFile, menuEdit, menuFormat, menuColor;
    // FILE MENU
    JMenuItem itemNew, itemOpen, itemSave, itemSaveAs, itemExit;
    // EDIT MENU
    JMenuItem itemUndo, itemRedo;
    // FORMAT MENU
    JMenuItem itemWrap, itemFontArial, itemFontCSMS, itemFontTNR,
            itemFontSize8, itemFontSize12, itemFontSize16, itemFontSize20, itemFontSize24, itemFontSize28 ;
    JMenu menuFont, menuFontSize;
    // COLOR MENU
    JMenuItem  itemColor1, itemColor2, itemColor3;

    FunctionFile functionFile = new FunctionFile(this);
    FunctionFormat functionFormat = new FunctionFormat(this);
    FunctionColor functionColor = new FunctionColor(this);
    FunctionEdit functionEdit = new FunctionEdit(this);

    KeyHandler keyHandler = new KeyHandler(this);

    UndoManager undoManager = new UndoManager();

    public static void main(String args[]) {
        new GUI();
    }

    public GUI() {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createEditMenu();
        createFormatMenu();
        createColorMenu();

        functionFormat.selectedFont = "Arial";
        functionFormat.createFont(16);
        functionFormat.wordWrap();
        functionColor.changeColor("White");
        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea() {
        textArea = new JTextArea();

        textArea.addKeyListener(keyHandler);

        textArea.getDocument().addUndoableEditListener(
                new UndoableEditListener() {
                    @Override
                    public void undoableEditHappened(UndoableEditEvent e) {
                        undoManager.addEdit(e.getEdit());
                    }
                }
        );

        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    public void createMenuBar() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);
    }

    public void createFileMenu() {

        itemNew = new JMenuItem("New");
        itemNew.addActionListener(this);
        itemNew.setActionCommand("New");
        menuFile.add(itemNew);

        itemOpen = new JMenuItem("Open");
        itemOpen.addActionListener(this);
        itemOpen.setActionCommand("Open");
        menuFile.add(itemOpen);

        itemSave = new JMenuItem("Save");
        itemSave.addActionListener(this);
        itemSave.setActionCommand("Save");
        menuFile.add(itemSave);

        itemSaveAs = new JMenuItem("Save as");
        itemSaveAs.addActionListener(this);
        itemSaveAs.setActionCommand("Save as");
        menuFile.add(itemSaveAs);

        itemExit = new JMenuItem("Exit");
        itemExit.addActionListener(this);
        itemExit.setActionCommand("Exit");
        menuFile.add(itemExit);
    }

    public void createEditMenu() {
        itemUndo = new JMenuItem("Undo");
        itemUndo.addActionListener(this);
        itemUndo.setActionCommand("Undo");
        menuEdit.add(itemUndo);

        itemRedo = new JMenuItem("Redo");
        itemRedo.addActionListener(this);
        itemRedo.setActionCommand("Redo");
        menuEdit.add(itemRedo);
    }

    public void createFormatMenu() {

        itemWrap = new JMenuItem("Word Wrap: Off");
        itemWrap.addActionListener(this);
        itemWrap.setActionCommand("Word Wrap");
        menuFormat.add(itemWrap);

        menuFont = new JMenu("Font");
        menuFormat.add(menuFont);

        itemFontArial = new JMenuItem(("Arial"));
        itemFontArial.addActionListener(this);
        itemFontArial.setActionCommand("Arial");
        menuFont.add(itemFontArial);

        itemFontCSMS = new JMenuItem(("Comic Sans MS"));
        itemFontCSMS.addActionListener(this);
        itemFontCSMS.setActionCommand("Comic Sans MS");
        menuFont.add(itemFontCSMS);

        itemFontTNR = new JMenuItem(("Times New Roman"));
        itemFontTNR.addActionListener(this);
        itemFontTNR.setActionCommand("Times New Roman");
        menuFont.add(itemFontTNR);

        menuFontSize = new JMenu("Font Size");
        menuFormat.add(menuFontSize);

        itemFontSize8 = new JMenuItem("8");
        itemFontSize8.addActionListener(this);
        itemFontSize8.setActionCommand("size8");
        menuFontSize.add(itemFontSize8);

        itemFontSize12 = new JMenuItem("12");
        itemFontSize12.addActionListener(this);
        itemFontSize12.setActionCommand("size12");
        menuFontSize.add(itemFontSize12);

        itemFontSize16 = new JMenuItem("16");
        itemFontSize16.addActionListener(this);
        itemFontSize16.setActionCommand("size16");
        menuFontSize.add(itemFontSize16);

        itemFontSize20 = new JMenuItem("20");
        itemFontSize20.addActionListener(this);
        itemFontSize20.setActionCommand("size20");
        menuFontSize.add(itemFontSize20);

        itemFontSize24 = new JMenuItem("24");
        itemFontSize24.addActionListener(this);
        itemFontSize24.setActionCommand("size24");
        menuFontSize.add(itemFontSize24);

        itemFontSize28 = new JMenuItem("28");
        itemFontSize28.addActionListener(this);
        itemFontSize28.setActionCommand("size28");
        menuFontSize.add(itemFontSize28);
    }

    public void createColorMenu() {
        itemColor1 = new JMenuItem("White");
        itemColor1.addActionListener(this);
        itemColor1.setActionCommand("White");
        menuColor.add(itemColor1);

        itemColor2 = new JMenuItem("Black");
        itemColor2.addActionListener(this);
        itemColor2.setActionCommand("Black");
        menuColor.add(itemColor2);

        itemColor3 = new JMenuItem("Blue");
        itemColor3.addActionListener(this);
        itemColor3.setActionCommand("Blue");
        menuColor.add(itemColor3);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        switch (command) {
            case "New" -> functionFile.newFile();
            case "Open" -> functionFile.open();
            case "Save as" -> functionFile.saveAs();
            case "Save" -> functionFile.save();
            case "Exit" -> functionFile.exit();
            case "Undo" -> functionEdit.undo();
            case "Redo" -> functionEdit.redo();
            case "Word Wrap" -> functionFormat.wordWrap();
            case "Arial" -> functionFormat.setFont(command);
            case "Comic Sans MS" -> functionFormat.setFont(command);
            case "Times New Roman" -> functionFormat.setFont(command);
            case "size8" -> functionFormat.createFont(8);
            case "size12" -> functionFormat.createFont(12);
            case "size16" -> functionFormat.createFont(16);
            case "size20" -> functionFormat.createFont(20);
            case "size24" -> functionFormat.createFont(24);
            case "size28" -> functionFormat.createFont(28);
            case "White" -> functionColor.changeColor(command);
            case "Black" -> functionColor.changeColor(command);
            case "Blue" -> functionColor.changeColor(command);
        }
    }
}
