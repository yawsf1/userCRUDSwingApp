package presentation;

import presentation.view.UserView;
import javax.swing.plaf.nimbus.NimbusLookAndFeel;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException {
        SwingUtilities.invokeLater(() -> {
            UserView view = new UserView();
            view.setVisible(true);
        });
        UIManager.setLookAndFeel(new NimbusLookAndFeel());

    }
}