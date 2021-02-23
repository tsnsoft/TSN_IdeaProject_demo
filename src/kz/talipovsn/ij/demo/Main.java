package kz.talipovsn.ij.demo;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Создание и открытие окна
        SwingUtilities.invokeLater(() -> new MainWindow().setVisible(true));
    }
}
