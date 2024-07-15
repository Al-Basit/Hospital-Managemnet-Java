/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package common;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class commonMethods {
    
    public void resizer(String imagePath, JLabel targetLabel) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            // Determine the new size (width and height) of the image
            int newWidth = targetLabel.getWidth();
            int newHeight = targetLabel.getHeight();

            // Create a new scaled image with higher quality
            Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            // Convert the scaled image back to a BufferedImage
            BufferedImage bufferedScaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bufferedScaledImage.createGraphics();
            g2d.drawImage(scaledImage, 0, 0, null);
            g2d.dispose();

            // Set the scaled image as the icon for the label
            ImageIcon icon = new ImageIcon(bufferedScaledImage);
            targetLabel.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(commonMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
