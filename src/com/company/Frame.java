package com.company;

import java.awt.Container;
import javax.swing.JFrame;

public class Frame extends JFrame {
    public Frame(){
        Container contentPane = getContentPane();
        Panel panel = new Panel();
        contentPane.add(panel);
        setBounds(0,0,800,900);
    }

}
