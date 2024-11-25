package Components;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import DbConfig.CrudManager;
import config.DesignConstants;

public class DynamicForm extends JFrame {

    private JPanel contentPane;
    private JButton submitButton;
    private Object[][] formData;
    private String entity;
    private boolean isUpdateMode;
    private boolean success;
    private int updateRowId;
    private ButtonGroup[] buttonGroups;

    public DynamicForm(Object[][] formStructure, String entity) {
        this.formData = formStructure;
        this.entity = entity;
        this.isUpdateMode = false;
        this.buttonGroups = new ButtonGroup[formStructure.length];
        setupForm();
    }

    public DynamicForm(Object[][] formStructure, String entity, Object[] rowData) {
        this.formData = formStructure;
        this.entity = entity;
        this.isUpdateMode = true;
        this.updateRowId = (int) rowData[0];
        this.buttonGroups = new ButtonGroup[formStructure.length];
        setupForm(rowData);
    }

    private void setupForm() {
        setupForm(null);
    }

private void setupForm(Object[] rowData) {
    setTitle(isUpdateMode ? "Update " + entity : "Create New " + entity);
    setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    setBounds(100, 100, 450, 300);
    contentPane = new JPanel();
    contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
    setContentPane(contentPane);
    contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    for (int i = 0; i < formData.length; i++) {
        Object[] field = formData[i];
        String label = (String) field[0];
        String fieldType = (String) field[1];

        JLabel labelComponent = new JLabel(label + ":");
        labelComponent.setFont(DesignConstants.GLOBAL_FONT);
        contentPane.add(labelComponent);

        switch (fieldType) {
            case "TextField":
                JTextField textField = new JTextField();
                if (isUpdateMode) {
                    textField.setText(rowData[i] != null ? rowData[i].toString() : "");
                }
                textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                textField.setPreferredSize(new Dimension(200, 20));
                contentPane.add(textField);
                field[3] = textField;
                break;
            case "IntegerField":
                JSpinner intSpinner = new JSpinner(new SpinnerNumberModel(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1));
                if (isUpdateMode) {
                    try {
                        int value = Integer.parseInt(rowData[i].toString());
                        intSpinner.setValue(value);
                    } catch (NumberFormatException e) {
                        System.err.println("Error parsing integer for field " + label + ": " + e.getMessage());
                    }
                }
                intSpinner.setFont(DesignConstants.GLOBAL_FONT);
                intSpinner.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                contentPane.add(intSpinner);
                field[3] = intSpinner;
                break;
            case "ComboBox":
                String[] options = (String[]) field[2];
                JComboBox<String> comboBox = new JComboBox<>(options);
                if (isUpdateMode) {
                    comboBox.setSelectedItem(rowData[i]);
                }
                comboBox.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                contentPane.add(comboBox);
                field[3] = comboBox;
                break;
            case "RadioButton":
                JPanel radioPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
                ButtonGroup group = new ButtonGroup();
                buttonGroups[i] = group;
                for (String option : (String[]) field[2]) {
                    JRadioButton radioButton = new JRadioButton(option);
                    if (isUpdateMode && option.equals(rowData[i])) {
                        radioButton.setSelected(true);
                    }
                    radioButton.setFont(DesignConstants.GLOBAL_FONT);
                    radioButton.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
                    group.add(radioButton);
                    radioPanel.add(radioButton);
                }
                contentPane.add(radioPanel);
                break;
            case "DateField":
                JSpinner dateSpinner = new JSpinner(new SpinnerDateModel());
                dateSpinner.setEditor(new JSpinner.DateEditor(dateSpinner, "yyyy-MM-dd"));
                if (isUpdateMode) {
                    try {
                        String dateStr = rowData[i] != null ? rowData[i].toString() : "";
                        LocalDate parsedDate = LocalDate.parse(dateStr, dateFormatter);
                        dateSpinner.setValue(java.sql.Date.valueOf(parsedDate));
                    } catch (DateTimeParseException e) {
                        System.err.println("Error parsing date for field " + label + ": " + e.getMessage());
                    }
                }
                dateSpinner.setFont(DesignConstants.GLOBAL_FONT);
                dateSpinner.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                contentPane.add(dateSpinner);
                field[3] = dateSpinner;
                break;
            case "TimeField":
                JSpinner timeSpinner = new JSpinner(new SpinnerDateModel());
                timeSpinner.setEditor(new JSpinner.DateEditor(timeSpinner, "HH:mm:ss"));
                if (isUpdateMode) {
                    try {
                        String timeStr = rowData[i] != null ? rowData[i].toString() : "";
                        LocalTime parsedTime = LocalTime.parse(timeStr, timeFormatter);
                        timeSpinner.setValue(java.sql.Time.valueOf(parsedTime));
                    } catch (DateTimeParseException e) {
                        System.err.println("Error parsing time for field " + label + ": " + e.getMessage());
                    }
                }
                timeSpinner.setFont(DesignConstants.GLOBAL_FONT);
                timeSpinner.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                contentPane.add(timeSpinner);
                field[3] = timeSpinner;
                break;
            case "CheckBox":
                JCheckBox checkBox = new JCheckBox(label);
                if (isUpdateMode) {
                    checkBox.setSelected(rowData[i] != null && (Boolean) rowData[i]);
                }
                checkBox.setFont(DesignConstants.GLOBAL_FONT);
                checkBox.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 5));
                contentPane.add(checkBox);
                field[3] = checkBox;
                break;
            default:
                throw new IllegalArgumentException("Unsupported field type: " + fieldType);
        }
    }

    submitButton = new JButton("Submit");
    submitButton.setFont(DesignConstants.GLOBAL_FONT);
    submitButton.setBackground(DesignConstants.PRIMARY_COLOR);
    submitButton.setForeground(DesignConstants.WHITE_COLOR);
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            handleSubmit();
        }
    });
    contentPane.add(submitButton);

    pack();
    setLocationRelativeTo(null);
}

private void handleSubmit() {
    String[] columns = new String[formData.length];
    Object[] values = new Object[formData.length];

    for (int i = 0; i < formData.length; i++) {
        Object[] field = formData[i];
        String label = (String) field[0];
        String fieldType = (String) field[1];
        JComponent component = (JComponent) field[3];

        columns[i] = label.toLowerCase();

        switch (fieldType) {
            case "TextField":
                values[i] = ((JTextField) component).getText();
                break;
            case "ComboBox":
                values[i] = ((JComboBox<?>) component).getSelectedItem();
                break;
            case "IntegerField":
                values[i] = ((JSpinner) component).getValue();
                break;
            case "RadioButton":
                ButtonGroup group = buttonGroups[i];
                for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
                    AbstractButton button = buttons.nextElement();
                    if (button.isSelected()) {
                        values[i] = button.getText();
                        break;
                    }
                }
                break;
            case "DateField":
                values[i] = ((JSpinner) component).getValue();
                break;
            case "TimeField":
                values[i] = ((JSpinner) component).getValue();
                break;
            case "CheckBox":
                values[i] = ((JCheckBox) component).isSelected();
                break;
            default:
                throw new IllegalArgumentException("Unsupported field type: " + fieldType);
        }
    }

    StringBuilder setClauseBuilder = new StringBuilder();
    for (int i = 0; i < columns.length; i++) {
        setClauseBuilder.append("`").append(columns[i]).append("` = ?");
        if (i < columns.length - 1) {
            setClauseBuilder.append(", ");
        }
    }
    String setClause = setClauseBuilder.toString();

    boolean success;
    if (isUpdateMode) {
        Object[] updateParams = new Object[values.length + 1];
        System.arraycopy(values, 0, updateParams, 0, values.length);
        updateParams[values.length] = updateRowId;
        
        int result = CrudManager.update(entity, setClause, "id = ?", updateParams);
        success = result > 0;
    } else {
        success = CrudManager.create(entity + "s", String.join(",", columns), values);
    }

    if (success) {
        if (isUpdateMode) {
            JOptionPane.showMessageDialog(this, "Successfully updated the " + entity);
        } else {
            JOptionPane.showMessageDialog(this, "Successfully created the " + entity);
        }
        this.dispose();
    } else {
        JOptionPane.showMessageDialog(this, "Operation failed!");
    }
}

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(DesignConstants.FORM_FRAME_SIZE);

        jLabel1.setFont(DesignConstants.HEADING_FONT1);
        jLabel1.setForeground(DesignConstants.SECONDARY_COLOR);
        jLabel1.setText("Doctor Form");

        submit.setBackground(DesignConstants.PRIMARY_COLOR);
        submit.setForeground(DesignConstants.WHITE_COLOR);
        submit.setText("Submit");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(submit)
                    .addComponent(jLabel1))
                .addContainerGap(169, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 235, Short.MAX_VALUE)
                .addComponent(submit)
                .addGap(20, 20, 20))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DynamicForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DynamicForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DynamicForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DynamicForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

//        DynamicForm form = new DynamicForm();
//                new DynamicForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton submit;
    // End of variables declaration//GEN-END:variables
}
