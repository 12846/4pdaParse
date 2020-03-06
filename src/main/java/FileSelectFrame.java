import javax.swing.*;

public class FileSelectFrame extends JFrame {
    private JLabel jLabel;
    private JTextPane jTextPane;
    private JButton button;

    FileSelectFrame() {
        super("Выбирите путь");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(300,100,300,100);

        Box box = Box.createVerticalBox();
        jLabel = new JLabel("Укажите путь");
        jTextPane = new JTextPane();
        button = new JButton("Готово");
        box.add(jLabel);
        box.add(jTextPane);
        box.add(button);

        setContentPane(box);
    }

    public JLabel getjLabel() {
        return jLabel;
    }

    public JTextPane getjTextPane() {
        return jTextPane;
    }

    public JButton getButton() {
        return button;
    }
    //    public static void main(String[] args) {
//        FileSelectFrame fileSelectFrame = new FileSelectFrame();
//        fileSelectFrame.setVisible(true);
//    }
}
