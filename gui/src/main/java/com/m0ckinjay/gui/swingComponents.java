/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m0ckinjay.gui;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

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
    
    private JPanel checksPanel;
    private JTextField displaTextField;
    private JCheckBox unoCheckBox;
    private JCheckBox deuxCheckBox;
    private JCheckBox troisCheckBox;
    
    private JPanel comboPanel;
    private JComboBox jComboBox;
    
    private JPanel jlistPanel;
    private JList<String> jList;
    
    
    public swingComponents(){
        initComponents();
    }
    
    private void initComponents(){
        //set default action on close window button click
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set title - could also be set with super("title") - though with super it has to be the first call in the constructor
        setTitle("Swing components");
        setLayout(new GridLayout(4, 1));

        final int WIDTH = 500;
        final int HEIGHT = 600;

        //without setting size, window isn't rendered in a visible/usable manner
        setSize(WIDTH, HEIGHT);

        //set location to somewhere in the middle of the screen
        setLocation(500, 100);
        
        
        
        //initialize gui components
        mainPanel = new JPanel();
        unoRbtn = new JRadioButton("uno");
        deuxRbtn = new JRadioButton("deux");
        troisRbtn = new JRadioButton("trois");
        rBtnGroup = new ButtonGroup();
        
        
        checksPanel = new JPanel();
        checksPanel.setLayout(new GridLayout(5,1));
        displaTextField = new JTextField("Text to manipulate");
        unoCheckBox = new JCheckBox("Bold");
        deuxCheckBox = new JCheckBox("Italic");
        troisCheckBox = new JCheckBox("Bold Italic");
        
        displaTextField.setEditable(false);
        
        comboPanel = new JPanel();
        comboPanel.setSize(40, 40);
        
        jComboBox = new JComboBox(getUserNamesForComboBox());
        jComboBox.setMaximumRowCount(5);
        
        jlistPanel = new JPanel();
        jList = new JList<>(getUserNamesForComboBox());
        jList.setVisibleRowCount(5);
        jList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        
   
        
        //add individual rbuttons to a button group to create a relation
        rBtnGroup.add(unoRbtn);
        rBtnGroup.add(deuxRbtn);
        rBtnGroup.add(troisRbtn);
        
        //add rbuttons to panel
        mainPanel.add(unoRbtn);
        mainPanel.add(deuxRbtn);
        mainPanel.add(troisRbtn);
        
        checksPanel.add(displaTextField);
        checksPanel.add(unoCheckBox);
        checksPanel.add(deuxCheckBox);
        checksPanel.add(troisCheckBox);
        
        comboPanel.add(jComboBox);
        
        jlistPanel.add(jList);
        
        
        
        //add panel to frame
        add(mainPanel);
        add(checksPanel);
        add(comboPanel);
        add(jlistPanel);
        
        //inner class that implements the ItemListener has to be referenced in the main class so that it can access top-level class variables and methods
        EventHandler eventHandler = new EventHandler();
        
        //associate event event handler to all rbuttons
        unoRbtn.addItemListener(eventHandler);
        deuxRbtn.addItemListener(eventHandler);
        troisRbtn.addItemListener(eventHandler);
        
        CheckBoxEventHandler checkBoxEventHandler = new CheckBoxEventHandler();
        unoCheckBox.addItemListener(checkBoxEventHandler);
        deuxCheckBox.addItemListener(checkBoxEventHandler);
        troisCheckBox.addItemListener(checkBoxEventHandler);
        
        
        ComboEventListener comboEventListener = new ComboEventListener();
        jComboBox.addItemListener(comboEventListener);
        
        JlistListSelectionListener jlistListSelectionListener = new JlistListSelectionListener();
        jList.addListSelectionListener(jlistListSelectionListener);
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
    private class CheckBoxEventHandler implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent ie) {
             if (unoCheckBox.isSelected()) {
                displaTextField.setFont(new Font(Font.SERIF,Font.BOLD, 14));
            }else if (deuxCheckBox.isSelected()) {
                displaTextField.setFont(new Font(Font.SERIF,Font.ITALIC, 14));
            }else if (troisCheckBox.isSelected()) {
                displaTextField.setFont(new Font(Font.SERIF,Font.BOLD + Font.ITALIC, 14));
            }
        }
    }
    
    private class ComboEventListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent ie) {
            if (ie.getStateChange() == ItemEvent.SELECTED) {
                if (jComboBox.getSelectedItem()== "Blue") {
                    comboPanel.setBackground(Color.BLUE);
                }else if (jComboBox.getSelectedItem() == "Black") {
                    comboPanel.setBackground(Color.BLACK);
                }else if (jComboBox.getSelectedItem() == "Green") {
                    comboPanel.setBackground(Color.GREEN);
                }
            }
        }
    }
    
    private class JlistListSelectionListener implements ListSelectionListener{

        @Override
        public void valueChanged(ListSelectionEvent lse) {
            JOptionPane.showMessageDialog(null, jList.getSelectedValue(), "Selected value", JOptionPane.PLAIN_MESSAGE);
        }
    
    }
    public static void main(String[] args) {
        //frame has to be set as visible otherwise it won't be displayed.
        new swingComponents().setVisible(true);
    }
    private String[] getUserNamesForComboBox(){
    
        String[] usernames = new String[]{};
    
        Client client = ClientBuilder.newClient();
        String apiURI = "http://localhost:8081/server/webapi/person/all";
        WebTarget apiResource = client.target(apiURI);
        
        usernames = apiResource.request(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .get(String[].class);
        return usernames;
    }
    
    
}
