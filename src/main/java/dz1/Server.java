package dz1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Server extends JFrame{
    private static final int WINDOW_HEIGHT = 400;
    private static final int WINDOW_WIDTH = 500;
    private static final int WINDOW_POSX = 500;
    private static final int WINDOW_POSY = 250;
    private static boolean isServerWorking;
    private final JButton btnStart = new JButton("Запустить сервер");
    private final JButton btnStop = new JButton("Остановить сервер");
    private final JTextArea log = new JTextArea("Сервер остановлен");

    public Server() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setAlwaysOnTop(true);
        setTitle("Чат");
        setResizable(false);

        add(log, BorderLayout.SOUTH);
        JPanel jPanel = new JPanel(new GridLayout(1,2));
        jPanel.add(btnStart);
        jPanel.add(btnStop);
        add(jPanel);

        log.setEditable(false);


        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isServerWorking) {
                    log.setText("Сервер работает");
                } else {
                    log.setText("Сервер запущен");;
                }
                isServerWorking = true;
            }
        });

        btnStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (!isServerWorking) {
                    log.setText("сервер не запущен");
                } else {
                    log.setText("Сервер остановлен");
                }
                isServerWorking = false;
            }
        });

        setVisible(true);

    }
}
