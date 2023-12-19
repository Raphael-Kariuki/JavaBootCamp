/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.gui;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

/**
 *
 * @author mo
 */
public class swingComponents  extends JFrame{
    
    //declare gui components
    private JPanel mainPanel;
    private JRadioButton unoRbtn;
    private JRadioButton deuxRbtn;
    private JRadioButton troisRbtn;
    private ButtonGroup rBtnGroup;
    
    public swingComponents(){
        initComponents();
    }
    
    private void initComponents(){
        
        //initialize gui components
        mainPanel = new JPanel();
        unoRbtn = new JRadioButton("uno");
        deuxRbtn = new JRadioButton("deux");
        troisRbtn = new JRadioButton("trois");
        rBtnGroup = new ButtonGroup();
        
        //set default action on close window button click
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set title - could also be set with super("title") - though with super it has to be the first call in the constructor
        setTitle("Swing components");
        
        
        final int WIDTH = 200;
        final int HEIGHT = 200;
        
        //without setting size, window isn't rendered in a visible/usable manner
        setSize(WIDTH, HEIGHT);
        
        //set location to somewhere in the middle of the screen
        setLocation(500,200);
        
        //add individual rbuttons to a button group to create a relation
        rBtnGroup.add(unoRbtn);
        rBtnGroup.add(deuxRbtn);
        rBtnGroup.add(troisRbtn);
        
        //add rbuttons to panel
        mainPanel.add(unoRbtn);
        mainPanel.add(deuxRbtn);
        mainPanel.add(troisRbtn);
        
        //add panel to frame
        add(mainPanel);
        
        //inner class that implements the ItemListener has to be referenced in the main class so that it can access top-level class variables and methods
        EventHandler eventHandler = new EventHandler();
        
        //associate event event handler to all rbuttons
        unoRbtn.addItemListener(eventHandler);
        deuxRbtn.addItemListener(eventHandler);
        troisRbtn.addItemListener(eventHandler);
        
    }
    
    private class EventHandler implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent ie) {
            
            //check source of event and event should be  specific to a component select, this is coz on selecting a diff radio button in 
            //a button group, 2 events are fired, deselect on the previous rbutton and a select on the new rbutton
            if (ie.getSource() == unoRbtn && ie.getStateChange() == ItemEvent.SELECTED) {
                JOptionPane.showMessageDialog(null, unoRbtn.getActionCommand(), "Radio button selected", JOptionPane.PLAIN_MESSAGE);
            } else if (ie.getSource() == deuxRbtn && ie.getStateChange() == ItemEvent.SELECTED) {
                JOptionPane.showMessageDialog(null, deuxRbtn.getActionCommand(), "Radio button selected", JOptionPane.PLAIN_MESSAGE);
            } else if (ie.getSource() == troisRbtn && ie.getStateChange() == ItemEvent.SELECTED) {
                JOptionPane.showMessageDialog(null, troisRbtn.getActionCommand(), "Radio button selected", JOptionPane.PLAIN_MESSAGE);
            } 
            
        }
        
    }
    public static void main(String[] args) {
        //frame has to be set as visible otherwise it won't be displayed.
        new swingComponents().setVisible(true);
    }
    
    
}
