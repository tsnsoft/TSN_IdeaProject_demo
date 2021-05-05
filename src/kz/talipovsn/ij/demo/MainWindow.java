package kz.talipovsn.ij.demo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainWindow extends JFrame {
    private JButton button_Calc;
    private JPanel mainPanel;
    private JTextField textField_x;
    private JTextField textField_b;
    private JTextField textField_d;
    private JButton Button_Exit;
    private JButton Button_Clear;
    private JLabel jLabel_y;

    public MainWindow() {
        // Инициализация компонент
        getContentPane().add(mainPanel);
        setIconImage(Toolkit.getDefaultToolkit().createImage(getClass().getResource("icon.png")));
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        setResizable(false);
        setTitle("Решатель задачи");
        pack();
        setLocationRelativeTo(null);

        // Решение примера
        button_Calc.addActionListener(actionEvent -> {
            float x, b, d, y; // Вещественные переменные
            try {
                x = Float.parseFloat(textField_x.getText()); // Получение данных
                b = Float.parseFloat(textField_b.getText()); // Получение данных
                d = Float.parseFloat(textField_d.getText()); // Получение данных
            } catch (Exception ex) {
                // Выводим окошко с сообщением об ошибке
                JOptionPane.showMessageDialog(rootPane, "Ошибка введенных данных!",
                    "Ошибка ввода", JOptionPane.ERROR_MESSAGE);
                textField_x.requestFocus(); // Устанавливаем фокус на компонент
                jLabel_y.setText("В введенных значениях допущены ошибки");
                textField_x.setText(""); // Очистка данных
                textField_b.setText(""); // Очистка данных
                textField_d.setText(""); // Очистка данных
                return; // Выход из метода (процедуры)
            }
            if (x >= 8) { // Вычисление выражения
                y = (x - 2) / (x * x);
            } else {
                y = b * b * d + 4 * x * x * x;
            }
            jLabel_y.setText("ОТВЕТ: " + String.format("%.2f", y)); // Выдача ответа с двумя знаками после запятой
        });

        // Очистка данных
        Button_Clear.addActionListener(actionEvent -> {
            jLabel_y.setText("");
            textField_x.setText(""); // Очистка данных
            textField_b.setText(""); // Очистка данных
            textField_d.setText(""); // Очистка данных
        });

        // Выход из программы
        Button_Exit.addActionListener(actionEvent -> dispose());

        // Переопределение методов окна
        addWindowListener(new WindowAdapter() {
            // Закрытие окна "по крестику"
            @Override
            public void windowClosing(WindowEvent evt) {
                windowClose();
            }

            // Закрытие окна после команды окна "dispose()"
            @Override
            public void windowClosed(WindowEvent evt) {
                windowClose();
            }

            // Наш метод закрытия окна
            private void windowClose() {
                JOptionPane.showMessageDialog(rootPane, "До свидания!",
                    "Выход", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }

        });

    }

    // Запуск программы на выполнение
    public static void main(String[] args) {
        // Создание и открытие окна
        SwingUtilities.invokeLater(() -> new MainWindow().setVisible(true));
    }

}
