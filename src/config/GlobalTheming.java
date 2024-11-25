package config;

import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.FontUIResource;
import java.awt.Color;


public class GlobalTheming {
    public static void applyGlobalTheming() {
        // Apply global colors
        UIManager.put("control", new ColorUIResource(DesignConstants.BACKGROUND_COLOR));
        UIManager.put("info", new ColorUIResource(DesignConstants.SECONDARY_COLOR));
        UIManager.put("nimbusBase", new ColorUIResource(DesignConstants.PRIMARY_COLOR));
        UIManager.put("nimbusBlueGrey", new ColorUIResource(DesignConstants.SECONDARY_COLOR));
        UIManager.put("nimbusFocus", new ColorUIResource(DesignConstants.SUPPORTING_COLOR_1));
        UIManager.put("nimbusLightBackground", new ColorUIResource(DesignConstants.BACKGROUND_COLOR));
        UIManager.put("nimbusOrange", new ColorUIResource(DesignConstants.SUPPORTING_COLOR_2));
        UIManager.put("nimbusSelectedText", new ColorUIResource(Color.WHITE));
        UIManager.put("nimbusSelectionBackground", new ColorUIResource(DesignConstants.PRIMARY_COLOR));
        UIManager.put("text", new ColorUIResource(DesignConstants.TEXT_COLOR));

        // Apply global fonts
        UIManager.put("Label.font", new FontUIResource(DesignConstants.GLOBAL_FONT));
        UIManager.put("Button.font", new FontUIResource(DesignConstants.GLOBAL_FONT));
        UIManager.put("Menu.font", new FontUIResource(DesignConstants.GLOBAL_FONT));
        UIManager.put("TextField.font", new FontUIResource(DesignConstants.GLOBAL_FONT));
        UIManager.put("TextArea.font", new FontUIResource(DesignConstants.GLOBAL_FONT));
        UIManager.put("ComboBox.font", new FontUIResource(DesignConstants.GLOBAL_FONT));
        UIManager.put("List.font", new FontUIResource(DesignConstants.GLOBAL_FONT));
        UIManager.put("RadioButton.font", new FontUIResource(DesignConstants.GLOBAL_FONT));
        UIManager.put("CheckBox.font", new FontUIResource(DesignConstants.GLOBAL_FONT));
        UIManager.put("TabbedPane.font", new FontUIResource(DesignConstants.GLOBAL_FONT));
        UIManager.put("Table.font", new FontUIResource(DesignConstants.GLOBAL_FONT));
        UIManager.put("ProgressBar.font", new FontUIResource(DesignConstants.GLOBAL_FONT));
        UIManager.put("ToolBar.font", new FontUIResource(DesignConstants.GLOBAL_FONT));
        UIManager.put("ToolTip.font", new FontUIResource(DesignConstants.GLOBAL_FONT));

        // Apply heading fonts
        UIManager.put("Label.font.heading1", new FontUIResource(DesignConstants.HEADING_FONT1));
        UIManager.put("Label.font.heading2", new FontUIResource(DesignConstants.HEADING_FONT2));
        UIManager.put("Label.font.heading3", new FontUIResource(DesignConstants.HEADING_FONT3));

        // Apply borders
        UIManager.put("Panel.border", DesignConstants.DEFAULT_BORDER);
        UIManager.put("Panel.topBorder", DesignConstants.TOP_BORDER);
        UIManager.put("Panel.bottomBorder", DesignConstants.BOTTOM_BORDER);
        UIManager.put("Panel.wholeBorder", DesignConstants.WHOLE_BORDER);

        // Button styling
        UIManager.put("Button.background", new ColorUIResource(DesignConstants.PRIMARY_COLOR));
        UIManager.put("Button.foreground", new ColorUIResource(DesignConstants.TEXT_COLOR));
        UIManager.put("Button.border", DesignConstants.DEFAULT_BORDER);
        UIManager.put("Button.hover", new ColorUIResource(DesignConstants.SUPPORTING_COLOR_3));

        // Apply global styling for JPanel
        UIManager.put("Panel.background", new ColorUIResource(DesignConstants.BACKGROUND_COLOR));
        UIManager.put("Panel.foreground", new ColorUIResource(DesignConstants.TEXT_COLOR));
    }
}
