package config;

import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class DesignConstants {
    // Colors
    public static final Color PRIMARY_COLOR = new Color(141, 184, 181); // Light Sea Green (Primary - used for header bg, active link bg, buttons bg)
    public static final Color SECONDARY_COLOR = new Color(168, 151, 156); // Rosy Brown (Supporting color)
    public static final Color ACCENT_COLOR = new Color(136, 114, 112); // Taupe (Supporting color)
    public static final Color BACKGROUND_COLOR = new Color(244, 239, 242); // White Smoke (White - used for panel bg, layout bg)
    public static final Color TEXT_COLOR = Color.BLACK; // Black (Text color)
    public static final Color HOVER_COLOR = new Color(129, 208, 226); // Sky Blue (Touching - used for hover, boxes, etc)

    // Fonts
    public static final Font GLOBAL_FONT = new Font("Arial", Font.PLAIN, 14);
    public static final Font HEADING_FONT1 = new Font("Arial", Font.BOLD, 24);
    public static final Font HEADING_FONT2 = new Font("Arial", Font.BOLD, 18);
    public static final Font HEADING_FONT3 = new Font("Arial", Font.BOLD, 16);
    public static final Font BOLD_FONT = new Font("Arial", Font.BOLD, 14);
    public static final Font ITALIC_FONT = new Font("Arial", Font.ITALIC, 14);
    
    // Borders
    public static final Border DEFAULT_BORDER = BorderFactory.createLineBorder(PRIMARY_COLOR, 1);
    public static final Border TOP_BORDER = BorderFactory.createMatteBorder(1, 0, 0, 0, PRIMARY_COLOR);
    public static final Border BOTTOM_BORDER = BorderFactory.createMatteBorder(0, 0, 1, 0, PRIMARY_COLOR);
    public static final Border WHOLE_BORDER = BorderFactory.createMatteBorder(1, 1, 1, 1, PRIMARY_COLOR);

    //sizes
   public static final Dimension FRAME_SIZE = new Dimension(1100, 600);
   
    public static final Dimension HALF_FRAME_SIZE = new Dimension(550, 600);
    public static final Dimension FIELD_SIZE = new Dimension(400, 30);


    // Margin and padding sizes
    public static final int MARGIN_SMALL = 10;
    public static final int MARGIN_MEDIUM = 20;
    public static final int MARGIN_LARGE = 30;
    public static final int PADDING_SMALL = 5;
    public static final int PADDING_MEDIUM = 10;
    public static final int PADDING_LARGE = 15;
}
