package com.myApp.view;

import com.myApp.controller.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Component
public class View implements ActionListener {
    private Controller control;
    private JTextField nameTF;
    private JTextField addressTF;
    private JTextField numberTF;

    @Autowired
    public View(Controller control){
        this.control = control;
        JFrame frame = new JFrame("Save com.myApp.model.BuddyInfo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton button = new JButton("Save");
        button.addActionListener(this);

        JPanel namePanel = new JPanel(new FlowLayout());
        JLabel nameLabel = new JLabel("Name");
        nameTF = new JTextField(10);
        JPanel addressPanel = new JPanel(new FlowLayout());
        JLabel addressLabel = new JLabel("Address");
        addressTF = new JTextField(10);
        JPanel numberPanel = new JPanel(new FlowLayout());
        JLabel numberLabel = new JLabel("Phone Number");
        numberTF = new JTextField(10);

        namePanel.add(nameLabel);
        namePanel.add(nameTF);
        addressPanel.add(addressLabel);
        addressPanel.add(addressTF);
        numberPanel.add(numberLabel);
        numberPanel.add(numberTF);
        buttonPanel.add(button);

        JPanel panelPanel = new JPanel(new FlowLayout());
        panelPanel.add(namePanel);
        panelPanel.add(addressPanel);
        panelPanel.add(numberPanel);
        panelPanel.add(buttonPanel);
        panelPanel.add(button);
        frame.getContentPane().add(panelPanel);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        control.addBuddy(nameTF.getText(), addressTF.getText(), Integer.parseInt(numberTF.getText()));
    }
}
