import calculator.AbstractValueParser;
import calculator.Calculator;
import calculator.datatypes.complex.complexValueParser;
import calculator.datatypes.integer.IntegerValueParser;
import calculator.datatypes.real.RealValueParser;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class calculatorUI {

  // Объявление всех компонентов калькулятора.
  JPanel windowContent;
  GridLayout gl;
  JLabel label1;
  JTextField field1;
  JLabel label2;
  JTextField field2;
  JLabel label3;
  JTextField result;
  JButton go;
  JButton saveBtn;
  JLabel labelEmpty1;
  JLabel labelEmpty2;
  JComboBox<String> operationBox;
  JComboBox<String> typeBox;
  String[] itemsOperation = { "+", "-", "*", "/" };
  TypeArray typeArray = new TypeArray();

  calculatorUI() {
    // Init UI
    this.windowContent = new JPanel();
    this.gl = new GridLayout(6, 2);
    this.windowContent.setLayout(gl);
    this.label1 = new JLabel("Переменная 1:");
    this.field1 = new JTextField(10);
    this.label2 = new JLabel("Переменная 2:");
    this.field2 = new JTextField(10);
    this.label3 = new JLabel("Итог:");
    this.result = new JTextField(10);
    this.go = new JButton("Результат");
    this.saveBtn = new JButton("Сохранить");
    this.labelEmpty1 = new JLabel("");
    this.labelEmpty2 = new JLabel("");
    this.typeBox = new JComboBox<String>(typeArray.getNameItems());
    this.operationBox = new JComboBox<String>(itemsOperation);

    go.addActionListener(new calcResult());
    saveBtn.addActionListener(new saveResult());
    // Добавляем компоненты в панель
    windowContent.add(typeBox);
    windowContent.add(labelEmpty1);
    windowContent.add(label1);
    windowContent.add(field1);
    windowContent.add(labelEmpty2);
    windowContent.add(operationBox);
    windowContent.add(label2);
    windowContent.add(field2);
    windowContent.add(label3);
    windowContent.add(result);
    windowContent.add(go);
    windowContent.add(saveBtn);

    // Создаём фрейм и задаём панель для него
    JFrame frame = new JFrame(
      "Мой первый калькулятор                                                                "
    );
    frame.setContentPane(windowContent);
    // задаём размер и отображаем окно
    frame.setSize(400, 200);
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    calculatorUI calc = new calculatorUI();
  }

  class calcResult implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      Calculator calculatorCheked;
      try {
        calculatorCheked =
          new Calculator(
            typeArray.getParser((String) typeBox.getSelectedItem())
          );
        String res = calculatorCheked.calculate(
          field1.getText(),
          (String) operationBox.getSelectedItem(),
          field2.getText()
        );
        result.setText(res);
      } catch (Exception e1) {
        e1.printStackTrace();
      }
    }
  }

  class saveResult implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
      File file = new File("res.txt");
      try {
        file.createNewFile();
      } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }

      try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
        String line =
          field1.getText() +
          ((String) operationBox.getSelectedItem()) +
          field2.getText() +
          "=" +
          result.getText();
        writer.write(line);
        writer.close();
      } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    }
  }

  class TypeArray {

    TypeBox[] typeItems = {
      new TypeBox("Целые числа", new IntegerValueParser()),
      new TypeBox("Рациональные числа", new RealValueParser()),
      new TypeBox("Комплексные числа", new complexValueParser()),
    };

    public String[] getNameItems() {
      String[] arr = new String[typeItems.length];
      for (int i = 0; i < typeItems.length; i++) {
        arr[i] = typeItems[i].name;
      }
      return arr;
    }

    public AbstractValueParser getParser(String name) throws Exception {
      for (int i = 0; i < typeItems.length; i++) {
        if (typeItems[i].name == name) {
          return typeItems[i].parser;
        }
      }
      throw new Exception("Invalid datatype class");
    }
  }

  class TypeBox {

    String name;
    AbstractValueParser parser;

    public TypeBox(String name, AbstractValueParser parser) {
      this.parser = parser;
      this.name = name;
    }
  }
}
