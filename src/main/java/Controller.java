import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    private View view;
    private FileSelectFrame fsl;
    private JTextPane jTextPane;
    private JTextArea jtaParse;
    private JButton btnStop, btnStart, button;
    private JMenuItem indicateItem, saveItem;
    private Settings settings;
    private String title;
    private ArrayList<String> arrayNews;

    public Controller() {
        initFields();
        initListeners();
        start();
    }

    public void start() {
        view.setVisible(true);
    }


    public void startParse() {
        Article article = new Article();
        List<Article> articleList = new ArrayList<>();
        new Thread(() -> {
            {
                try {
                    Document doc = Jsoup.connect("http://4pda.ru").get();

                    Elements ipElements = doc.getElementsByAttributeValue("class","list-post-title");

                    ipElements.forEach(ipElement -> {
                        Element aElement = ipElement.child(0);
                        String url = aElement.attr("href");
                        title = aElement.child(0).text();

                       // articleList.add(new Article(url, title));
                        articleList.add(new Article(url, title));

                        jtaParse.append(title + "\n");


                    });

                    //arrayNews.add(title);

                    articleList.forEach(System.out::println);

                    System.out.println(settings.getPath());


                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initFields() {
        view = new View();
        fsl = new FileSelectFrame();
        settings = new Settings();
        jtaParse = view.getJtaParse();
        btnStart = view.getBtnStart();
        btnStop = view.getBtnStop();
        indicateItem = view.getIndicateItem();
        saveItem = view.getSaveItem();
        button = fsl.getButton();
        jTextPane = fsl.getjTextPane();
    }

    private void initListeners() {
        btnStart.addActionListener(e -> {
            startParse();
            settings.setNull(true);
                });

        indicateItem.addActionListener(e -> {
            view.setVisible(false);
            fsl.setVisible(true);
        });
        button.addActionListener(e -> {
            String path = jTextPane.getText().toString();
            settings.setPath(path);
            view.setVisible(true);
            fsl.setVisible(false);
        });

        saveItem.addActionListener(e -> {
            if (settings.getPath() == null) {
                JOptionPane.showMessageDialog(null,"Укажите путь!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (settings.isNull() == false) {
                JOptionPane.showMessageDialog(null,"Вы ничего не спарсили!", "Ошибка", JOptionPane.ERROR_MESSAGE);
                return;
            }
            File file = new File(settings.getPath().toString(), "parse.txt");
            if (!file.exists()) {
                try {
                    file.createNewFile();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            FileWriter writer = null;
            try {
                writer = new FileWriter(file);
                writer.write(jtaParse.getText().toString());
                writer.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}
