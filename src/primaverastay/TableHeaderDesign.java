
package primaverastay;

public class TableHeaderDesign {

    public static void apply(javax.swing.JTable table) {

        javax.swing.table.JTableHeader header =
                table.getTableHeader();

        header.setDefaultRenderer(
            new javax.swing.table.DefaultTableCellRenderer() {

                @Override
                public java.awt.Component getTableCellRendererComponent(
                        javax.swing.JTable table,
                        Object value,
                        boolean isSelected,
                        boolean hasFocus,
                        int row,
                        int column) {

                    javax.swing.JLabel label =
                        (javax.swing.JLabel)
                        super.getTableCellRendererComponent(
                            table, value, isSelected,
                            hasFocus, row, column
                        );

                    label.setBackground(
                        new java.awt.Color(30, 58, 95)
                    );
                    label.setForeground(java.awt.Color.WHITE);
                    label.setOpaque(true);
                    label.setFont(
                        new java.awt.Font("Segoe UI", 1, 14)
                    );
                    label.setBorder(
                        javax.swing.BorderFactory.createEmptyBorder(
                            0, 10, 0, 10
                        )
                    );

                    return label;
                }
            }
        );

        header.setPreferredSize(
            new java.awt.Dimension(0, 48)
        );

        header.repaint();
    }
}

