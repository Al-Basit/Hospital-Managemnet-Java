package config;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class DesignConstants {
    // Colors
    
//    primary-colors
    public static final Color PRIMARY_COLOR = new Color(111, 66, 193); // Light Sea Green (Primary - used for header bg, active link bg, buttons bg)
    public static final Color SECONDARY_COLOR = new Color(0, 123, 255); // Rosy Brown (Supporting color)
    
//    supporting-colors
    public static final Color SUPPORTING_COLOR_1 = new Color(13, 202, 240); // White Smoke (White - used for panel bg, layout bg)
    public static final Color SUPPORTING_COLOR_2 = new Color(0, 204, 204); // Taupe (Supporting color)
    public static final Color SUPPORTING_COLOR_3 = new Color(23, 162, 187); // Sky Blue (Touching - used for hover, boxes, etc)
    public static final Color TEXT_COLOR = Color.BLACK; // Black (Text color)
    
//   other colors
     public static final Color WHITE_COLOR = Color.WHITE; // White

//    background-color (for frame only)
    public static final Color BACKGROUND_COLOR = new Color(255, 255, 240);
    
    // Fonts
    public static final Font GLOBAL_FONT = new Font("Arial", Font.PLAIN, 14);
    public static final Font HEADING_FONT1 = new Font("Arial", Font.BOLD, 24);
    public static final Font HEADING_FONT2 = new Font("Arial", Font.BOLD, 18);
    public static final Font HEADING_FONT3 = new Font("Arial", Font.BOLD, 16);
    public static final Font ITALIC_FONT = new Font("Arial", Font.ITALIC, 14);
    public static final Font BOLD_FONT = new Font("Arial", Font.BOLD, 14);
    
    // Borders
    public static final Border DEFAULT_BORDER = BorderFactory.createLineBorder(PRIMARY_COLOR, 1);
    public static final Border TOP_BORDER = BorderFactory.createMatteBorder(1, 0, 0, 0, PRIMARY_COLOR);
    public static final Border BOTTOM_BORDER = BorderFactory.createMatteBorder(0, 0, 1, 0, PRIMARY_COLOR);
    public static final Border WHOLE_BORDER = BorderFactory.createMatteBorder(1, 1, 1, 1, PRIMARY_COLOR);

    //sizes
   public static final Dimension FRAME_SIZE = new Dimension(1300, 600);
   public static final Dimension GRID_BOX_SIZE = new Dimension(100, 70);
   public static final Dimension GRID_BOX_IMAGE_SIZE = new Dimension(70, 70);
   public static final Dimension FORM_FRAME_SIZE = new Dimension(700, 600);
   
    public static final Dimension HALF_FRAME_SIZE = new Dimension(650, 600);
    public static final Dimension FIELD_SIZE = new Dimension(60, 20);


    // Margin and padding sizes
    public static final int MARGIN_SMALL = 10;
    public static final int MARGIN_MEDIUM = 20;
    public static final int MARGIN_LARGE = 30;
    public static final int PADDING_SMALL = 5;
    public static final int PADDING_MEDIUM = 10;
    public static final int PADDING_LARGE = 15;
}
