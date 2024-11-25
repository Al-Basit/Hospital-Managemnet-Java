/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Components;

import config.DesignConstants;
import common.commonMethods;
import java.awt.event.*;
import javax.swing.SwingUtilities;

import Modules.*;
/**
 *
 * @author HP
 */
public class GridBox extends javax.swing.JPanel {

    /**
     * Creates new form GridBox
     * @param imageSrc
     * @param boxLabelText
     */
    public GridBox(String imageSrc, String boxLabelText) {
        initComponents();

        setBackground(DesignConstants.SUPPORTING_COLOR_2);
        commonMethods cm = new commonMethods();

        imageBox.setPreferredSize(DesignConstants.GRID_BOX_IMAGE_SIZE);
imageBox.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent e) {
        switch (boxLabelText) {
            case "Doctors":
                DoctorsPage doctorPage = new DoctorsPage();
                doctorPage.setVisible(true);
                break;
            case "Pateints":
                PatientsPage patientPage = new PatientsPage();
                patientPage.setVisible(true);
                break;
            case "Appointment":
                AppointmentsPage appointmentPage = new AppointmentsPage();
                appointmentPage.setVisible(true);
                break;
            case "Medicines":
                MedicinesPage medicinePage = new MedicinesPage();
                medicinePage.setVisible(true);
                break;
        }
    }
});

boxLabel.setText(boxLabelText);

        SwingUtilities.invokeLater(() -> {
            cm.resizer(imageSrc, imageBox);
            imageBox.addComponentListener(new ComponentAdapter() {
                @Override
                public void componentResized(ComponentEvent e) {
                    cm.resizer(imageSrc, imageBox);
                }
            });
        });
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        imageBox = new javax.swing.JLabel();
        boxLabel = new javax.swing.JLabel();

        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(DesignConstants.GRID_BOX_SIZE);
        setPreferredSize(DesignConstants.GRID_BOX_SIZE);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        imageBox.setPreferredSize(DesignConstants.GRID_BOX_IMAGE_SIZE);

        boxLabel.setFont(DesignConstants.HEADING_FONT3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imageBox, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(boxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(imageBox, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(boxLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel boxLabel;
    private javax.swing.JLabel imageBox;
    // End of variables declaration//GEN-END:variables
}
