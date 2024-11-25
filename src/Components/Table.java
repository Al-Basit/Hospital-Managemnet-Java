package Components;

import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;

import DbConfig.CrudManager;
import common.commonMethods;


public class Table extends JPanel {

    private DefaultTableModel tableModel;
    private JTable dataTable;
    private JScrollPane scrollPane;

    private String entity;
    private Object[][] formStructure;

    commonMethods cm = new commonMethods();

    public Table(String[] columns, String entity, Object[][] formStructure) {
        this.entity = entity;
        this.formStructure = formStructure;
        initComponents();

        String query = "SELECT * FROM " + entity;
        Object[][] dataRows = CrudManager.read(query);

        setupTable(dataRows, columns);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // </editor-fold>
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 631, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 433, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

     private void setupTable(Object[][] rows, String[] columns) {
        tableModel = new DefaultTableModel(rows, columns) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == columns.length - 1;
            }
        };

        dataTable = new JTable(tableModel);
        dataTable.setRowHeight(30);
        dataTable.getColumnModel().getColumn(columns.length - 1).setCellRenderer(new ActionCellRenderer());
        dataTable.getColumnModel().getColumn(columns.length - 1).setCellEditor(new ActionCellEditor());

        scrollPane = new JScrollPane(dataTable);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
    }

    private class ActionCellRenderer extends JPanel implements TableCellRenderer {
        private JLabel updateLabel;
        private JLabel deleteLabel;

        public ActionCellRenderer() {
            setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

            updateLabel = new JLabel();
            updateLabel.setPreferredSize(new Dimension(20, 20));
            updateLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            deleteLabel = new JLabel();
            deleteLabel.setPreferredSize(new Dimension(20, 20));
            deleteLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            add(updateLabel);
            add(deleteLabel);

            updateLabel.setSize(20, 20);
            deleteLabel.setSize(20, 20);

            cm.resizer("src/Images/pen.png", updateLabel);
            cm.resizer("src/Images/bin.png", deleteLabel);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    private class ActionCellEditor extends AbstractCellEditor implements TableCellEditor {
        private JPanel panel;
        private JLabel updateLabel;
        private JLabel deleteLabel;

        public ActionCellEditor() {
            panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

            updateLabel = new JLabel();
            updateLabel.setPreferredSize(new Dimension(20, 20));
            updateLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

            deleteLabel = new JLabel();
            deleteLabel.setPreferredSize(new Dimension(20, 20));
            deleteLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            
            updateLabel.setSize(new Dimension(30,30));
            deleteLabel.setSize(new Dimension(30,30));

            cm.resizer("src/Images/pen.png", updateLabel);
            cm.resizer("src/Images/bin.png", deleteLabel);

            updateLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = dataTable.getSelectedRow();
                    
                    System.out.println("Update clicked for row: " + row);
                    fireEditingStopped();
                    Object[] rowData = new Object[dataTable.getColumnCount() - 1];
                    for (int i = 0; i < dataTable.getColumnCount() - 1; i++) {
                        rowData[i] = dataTable.getValueAt(row, i);
                    }
                    openUpdateForm(rowData);
                }
            });

            deleteLabel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int row = dataTable.getSelectedRow();
                   
                    System.out.println("Delete clicked for row: " + row);
                    fireEditingStopped();
                    removeRow(row);
                }
            });

            panel.add(updateLabel);
            panel.add(deleteLabel);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return null;
        }
    }

    private void openUpdateForm(Object[] rowData) {
        DynamicForm updateForm = new DynamicForm(formStructure, entity, rowData);
        updateForm.setVisible(true);
    }

    public void addRow(Object[] rowData) {
        tableModel.addRow(rowData);
    }

public void removeRow(int rowIndex) {
    if (rowIndex >= 0 && rowIndex < tableModel.getRowCount()) {
         int id = (int) tableModel.getValueAt(rowIndex, 0);
        int result = CrudManager.delete(entity, "id=?", id);
        if (result > 0) {
            tableModel.removeRow(rowIndex);
            commonMethods.showDialogPane("success", "Successfully deleted the " + entity);
        }
    }
}

//    public void updateCell(int rowIndex, int columnIndex, Object newValue) {
//        if (rowIndex >= 0 && rowIndex < tableModel.getRowCount()
//                && columnIndex >= 0 && columnIndex < tableModel.getColumnCount()) {
//            tableModel.setValueAt(newValue, rowIndex, columnIndex);
//        }
//    }
//
//    public Object getCellData(int rowIndex, int columnIndex) {
//        if (rowIndex >= 0 && rowIndex < tableModel.getRowCount()
//                && columnIndex >= 0 && columnIndex < tableModel.getColumnCount()) {
//            return tableModel.getValueAt(rowIndex, columnIndex);
//        }
//        return null;
//    }



    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
