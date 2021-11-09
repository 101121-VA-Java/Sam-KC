package com.revature.controllers;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageViewer 
{	
    public static void viewImage(String imgUrl)
    {
    	Image image = null;
        try {
            URL url = new URL(imgUrl);
            image = ImageIO.read(url);
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        JFrame frame = new JFrame();        
        frame.setSize(1000, 1000);
        JLabel label = new JLabel(new ImageIcon(image));
        frame.add(label);
        frame.setVisible(true);
    }
}
