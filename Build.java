import javax.swing.*;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.web.WebView;
import javafx.scene.Scene;
import java.awt.*;
import java.awt.event.*;

public class Build extends JFrame implements Runnable {
    
    private JFXPanel panel;
    private String homePage;
    private JTextField addressBar;

    public void run() {
        setTitle("Prospect Browser");
        setBounds(0, 0, 1000, 500);
        setVisible(true);
        
        Search();
        panel = new JFXPanel();
        add(panel);

        Platform.runLater(() -> {
            WebView view = new WebView();
            homePage = "http://www.google.com";
            view.getEngine().load(homePage);
            panel.setScene(new Scene(view));
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void Search() {
        addressBar = new JTextField("");
        addressBar.addActionListener (
            new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    load(event.getActionCommand());
                }
            }
        );
        add(addressBar, BorderLayout.NORTH);
    }

    private void load(String userText) {
        
        try {
            addressBar.setText(userText);
        } catch(Exception e) {
            addressBar.setText("https://www.google.com/search?q=" + userText);
        }
    }
}