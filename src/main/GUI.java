package main;

import javax.swing.*;
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
    // FORMAT MENU
    JMenuItem itemWrap, itemFontArial, itemFontCSMS, itemFontTNR,
            itemFontSize8, itemFontSize12, itemFontSize16, itemFontSize20, itemFontSize24, itemFontSize28 ;
    JMenu menuFont, menuFontSize;

    FunctionFile functionFile = new FunctionFile(this);
    FunctionFormat functionFormat = new FunctionFormat(this);

    public static void main(String args[]) {
        new GUI();
    }

    public GUI() {
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createFormatMenu();
        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("Notepad");
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createTextArea() {
        textArea = new JTextArea();
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
        itemFontSize24.setActionCommand("size24n");
        menuFontSize.add(itemFontSize24);

        itemFontSize28 = new JMenuItem("28");
        itemFontSize28.addActionListener(this);
        itemFontSize28.setActionCommand("size28");
        menuFontSize.add(itemFontSize28);
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
//            case "Word Wrap" ->
        }
    }
}
