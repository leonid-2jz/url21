package pr3;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class pr3 {
	// Список товаров и адресов
    private String[] products = {"Сигареты - 100 руб.", "Наушники - 200 руб.", "Молоко - 300 руб."};
    private String[] addresses = {"Ул. Мечникова", "ул. Варфаламеево", "пр. Гагагрина"};

    public static void main(String[] args) {
        new pr3().createAndShowGUI();
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Доставка товаров");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        // Поле для ввода имени
        JLabel nameLabel = new JLabel("Имя:");
        nameLabel.setBounds(20, 20, 100, 25);
        frame.add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(150, 20, 200, 25);
        frame.add(nameField);

        // Список товаров
        JLabel productLabel = new JLabel("Выберите товар:");
        productLabel.setBounds(20, 60, 150, 25);
        frame.add(productLabel);

        JComboBox<String> productCombo = new JComboBox<>(products);
        productCombo.setBounds(150, 60, 200, 25);
        frame.add(productCombo);

        // Список адресов
        JLabel addressLabel = new JLabel("Выберите адрес:");
        addressLabel.setBounds(20, 100, 150, 25);
        frame.add(addressLabel);

        JComboBox<String> addressCombo = new JComboBox<>(addresses);
        addressCombo.setBounds(150, 100, 200, 25);
        frame.add(addressCombo);

        // Вид доставки
        JLabel deliveryLabel = new JLabel("Выберите вид доставки:");
        deliveryLabel.setBounds(20, 140, 150, 25);
        frame.add(deliveryLabel);

        JRadioButton pointDelivery = new JRadioButton("Пункт выдачи");
        JRadioButton courierDelivery = new JRadioButton("Курьер");
        ButtonGroup deliveryGroup = new ButtonGroup();
        deliveryGroup.add(pointDelivery);
        deliveryGroup.add(courierDelivery);
        pointDelivery.setBounds(150, 140, 150, 25);
        courierDelivery.setBounds(150, 160, 150, 25);
        frame.add(pointDelivery);
        frame.add(courierDelivery);

        // Кнопка для вывода результата
        JButton resultButton = new JButton("Показать результат");
        resultButton.setBounds(150, 200, 200, 25);
        frame.add(resultButton);

        // Обработка нажатия кнопки
        resultButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String product = (String) productCombo.getSelectedItem();
                String address = (String) addressCombo.getSelectedItem();
                String deliveryType = pointDelivery.isSelected() ? "Пункт выдачи" : "Курьер";

                if (name.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Пожалуйста, введите имя.", "Ошибка", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int productPrice = Integer.parseInt(product.split("-")[1].trim().replace(" руб.", ""));
                int deliveryCost = deliveryType.equals("Курьер") ? 50 : 0; //  50 руб. за курьера
                int totalCost = productPrice + deliveryCost;

                String message = String.format("Здравствуйте, %s!\nТовар: %s\nАдрес: %s\nВид доставки: %s\nОбщая стоимость: %d руб.",
                        name, product, address, deliveryType, totalCost);
                JOptionPane.showMessageDialog(frame, message, "Результат", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.setVisible(true);
    }
    public int calculateTotalCost(String product, boolean isCourier) {
        int productPrice = extractProductPrice(product);
        int deliveryCost = isCourier ? 50 : 0; // 50 руб. за курьера
        return productPrice + deliveryCost;
    }

    public int extractProductPrice(String product) {
        return Integer.parseInt(product.split("-")[1].trim().replace(" руб.", ""));
    }
}

