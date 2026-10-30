package primaverastay;

public class PrimaveraStay {

    public static void main(String[] args) {

        javax.swing.SwingUtilities.invokeLater(() -> {

            LoginForm form = new LoginForm();
            form.setVisible(true);

        });
    }
}
