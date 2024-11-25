package common;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Utility methods for common operations used throughout the project.
 */
public class commonMethods {

    /**
     * Resizes the image to fit within the given JLabel.
     * 
     * @param imagePath the path to the image file
     * @param targetLabel the JLabel to display the resized image
     */
    public void resizer(String imagePath, JLabel targetLabel) {
        try {
            BufferedImage originalImage = ImageIO.read(new File(imagePath));
            int newWidth = targetLabel.getWidth();
            int newHeight = targetLabel.getHeight();

            Image scaledImage = originalImage.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);

            BufferedImage bufferedScaledImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = bufferedScaledImage.createGraphics();
            g2d.drawImage(scaledImage, 0, 0, null);
            g2d.dispose();

            ImageIcon icon = new ImageIcon(bufferedScaledImage);
            targetLabel.setIcon(icon);
        } catch (IOException ex) {
            Logger.getLogger(commonMethods.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Displays an error dialog with the given message.
     * 
     * @param type
     * @param message the error message to display
     */
   public static void showDialogPane(String type, String message) {
        int messageType;
        messageType = switch (type.toLowerCase()) {
            case "error" -> JOptionPane.ERROR_MESSAGE;
            case "warning" -> JOptionPane.WARNING_MESSAGE;
            case "information" -> JOptionPane.INFORMATION_MESSAGE;
            default -> JOptionPane.PLAIN_MESSAGE;
        };
        
        JOptionPane.showMessageDialog(null, message, type, messageType);
    }

    /**
     * Validates if a given string is a valid email address.
     * 
     * @param email the email address to validate
     * @return true if the email is valid, false otherwise
     */
    public static boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    /**
     * Validates if a given string is a valid phone number.
     * 
     * @param phone the phone number to validate
     * @return true if the phone number is valid, false otherwise
     */
    public static boolean isValidPhoneNumber(String phone) {
        String phoneRegex = "^\\+?[0-9. ()-]{7,25}$";
        return phone.matches(phoneRegex);
    }

    /**
     * Converts a BufferedImage to a byte array.
     * 
     * @param image the BufferedImage to convert
     * @param format the format to use (e.g., "png", "jpg")
     * @return the byte array representing the image
     * @throws IOException if an error occurs during writing
     */
    public static byte[] imageToByteArray(BufferedImage image, String format) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, format, baos);
        return baos.toByteArray();
    }

    /**
     * Reads a BufferedImage from a byte array.
     * 
     * @param imageBytes the byte array representing the image
     * @return the BufferedImage
     * @throws IOException if an error occurs during reading
     */
    public static BufferedImage byteArrayToImage(byte[] imageBytes) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
        return ImageIO.read(bais);
    }

    /**
     * Logs a message at the INFO level.
     * 
     * @param message the message to log
     */
    public static void logInfo(String message) {
        Logger.getLogger(commonMethods.class.getName()).log(Level.INFO, message);
    }

    /**
     * Logs a message at the SEVERE level.
     * 
     * @param message the message to log
     */
    public static void logSevere(String message) {
        Logger.getLogger(commonMethods.class.getName()).log(Level.SEVERE, message);
    }
}
