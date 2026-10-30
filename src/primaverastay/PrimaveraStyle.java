
package primaverastay;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class PrimaveraStyle {

public static final Color CREAM = new Color(244, 248, 252);
public static final Color BLUE = new Color(59, 130, 246);
public static final Color DARK = new Color(30, 58, 95);
public static final Color MUTED = new Color(107, 128, 150);
public static final Color BORDER = new Color(220, 230, 240);

    public static void styleCard(JPanel panel) {
        panel.setBackground(Color.WHITE);
        panel.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER, 1),
                BorderFactory.createEmptyBorder(12, 12, 12, 12)
            )
        );
    }

    public static void styleField(JTextField field) {
        field.setBackground(Color.WHITE);
        field.setForeground(DARK);
        field.setFont(
            new Font("Segoe UI", Font.PLAIN, 14)
        );
        field.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER, 1),
                BorderFactory.createEmptyBorder(5, 10, 5, 10)
            )
        );
    }

    public static void styleTextArea(JTextArea area) {
        area.setBackground(Color.WHITE);
        area.setForeground(DARK);
        area.setFont(
            new Font("Segoe UI", Font.PLAIN, 14)
        );
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        area.setMargin(new Insets(8, 10, 8, 10));
    }

    public static void styleLabel(JLabel label) {
        label.setForeground(DARK);
        label.setFont(
            new Font("Segoe UI", Font.BOLD, 13)
        );
    }

    public static void stylePrimaryButton(JButton button) {
        button.setBackground(BLUE);
        button.setForeground(Color.WHITE);
        button.setFont(
            new Font("Segoe UI", Font.BOLD, 13)
        );
        button.setFocusPainted(false);
        button.setCursor(
            Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );
        button.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLineBorder(BLUE),
                BorderFactory.createEmptyBorder(8, 18, 8, 18)
            )
        );
    }

    public static void styleSecondaryButton(JButton button) {
        button.setBackground(new Color(245, 247, 244));
        button.setForeground(DARK);
        button.setFont(
            new Font("Segoe UI", Font.BOLD, 13)
        );
        button.setFocusPainted(false);
        button.setCursor(
            Cursor.getPredefinedCursor(Cursor.HAND_CURSOR)
        );
        button.setBorder(
            BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(BORDER),
                BorderFactory.createEmptyBorder(8, 18, 8, 18)
            )
        );
    }
}

