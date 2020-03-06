import javax.swing.*;
import java.awt.*;

public class View extends JFrame {
    private JButton btnStop, btnStart;
    private JTextArea jtaParse;
    private JMenuBar menuBar;
    private JMenuItem indicateItem, saveItem;

    public View() {
        super("4pda parser version 1.0");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(750, 750, 750, 750);

        jtaParse = new JTextArea();
        jtaParse.setEditable(false);
        jtaParse.setLineWrap(true);
        JScrollPane jScrollPane = new JScrollPane(jtaParse);
        add(jScrollPane, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(new BorderLayout());
        add(bottomPanel, BorderLayout.SOUTH);
        btnStart = new JButton("Начать");
       // btnStop = new JButton("Закончить");
        bottomPanel.add(btnStart, BorderLayout.EAST);
        //bottomPanel.add(btnStop, BorderLayout.WEST);

        menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("файл");
        menuBar.add(fileMenu);
        saveItem = new JMenuItem("Сохранить");
        fileMenu.add(saveItem);
        indicateItem = new JMenuItem("Выбрать путь");
        fileMenu.add(indicateItem);
        add(menuBar, BorderLayout.NORTH);
    }

    public JButton getBtnStop() {
        return btnStop;
    }

    public void setBtnStop(JButton btnStop) {
        this.btnStop = btnStop;
    }

    public JButton getBtnStart() {
        return btnStart;
    }

    public void setBtnStart(JButton btnStart) {
        this.btnStart = btnStart;
    }

    public JTextArea getJtaParse() {
        return jtaParse;
    }

    public void setJtaParse(JTextArea jtaParse) {
        this.jtaParse = jtaParse;
    }

    public void setMenuBar(JMenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public JMenuItem getIndicateItem() {
        return indicateItem;
    }

    public void setIndicateItem(JMenuItem indicateItem) {
        this.indicateItem = indicateItem;
    }

    public JMenuItem getSaveItem() {
        return saveItem;
    }

    public void setSaveItem(JMenuItem saveItem) {
        this.saveItem = saveItem;
    }


//        public static void main(String[] args) { // Запуск только интерфейса программы(без логики)
//        View view = new View();
//        view.setVisible(true);
//    }

}
