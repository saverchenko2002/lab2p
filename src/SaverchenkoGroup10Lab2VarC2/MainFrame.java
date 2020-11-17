package SaverchenkoGroup10Lab2VarC2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private static final int WIDTH = 1000;
    private static final int HEIGHT = 500;

    private JTextField textFieldX;
    private JTextField textFieldY;
    private JTextField textFieldZ;
    private JTextField textFieldResult;

    private Double mem1 = 0.0;
    private Double mem2 = 0.0;
    private Double mem3 = 0.0;

    private ButtonGroup buttonsFormula = new ButtonGroup();
    private Box hboxFormulaType = Box.createHorizontalBox();
    private ButtonGroup buttonsVariable = new ButtonGroup();
    private Box hboxVariableType = Box.createHorizontalBox();

    private int formulaId = 1;
    private int memId = 1;

    private JLabel labelFormula;
    private JLabel labelForMem1;
    private JLabel labelForMem2;
    private JLabel labelForMem3;

    private Icon icon;

    public Double calculate1(Double x, Double y, Double z) {
        return Math.pow((Math.log(Math.pow((1+x),2))+Math.cos(Math.PI*Math.pow(z,3))),Math.sin(y))+Math.pow(Math.pow(Math.E,Math.pow(x,2))+Math.cos(Math.pow(Math.E,z))+Math.pow(1/y,0.5),1/x);
    }

    public Double calculate2(Double x, Double y, Double z) {
        return Math.pow(Math.cos(Math.PI*Math.pow(x,3))+Math.log(Math.pow((1+y),2)),0.25)*(Math.pow(Math.E,Math.pow(z,2))+Math.pow(1/x,0.5)+Math.cos(Math.pow(Math.E,y)));
    }

    private void addFormulaRadioButton(String buttonName, final int formulaId) {
        JRadioButton button = new JRadioButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.formulaId = formulaId;
                setFormulaImage();
            }
        });
        button.setText(buttonName);
        buttonsFormula.add(button);
        hboxFormulaType.add(button);
    }

    private void addVariableRadioButton(String buttonName, final int memId) {
        JRadioButton button = new JRadioButton();
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                MainFrame.this.memId = memId;
            }
        });
        button.setText(buttonName);
        buttonsVariable.add(button);
        hboxVariableType.add(button);
    }

    private void setFormulaImage() {
        icon = new ImageIcon("src/SaverchenkoGroup10Lab2VarC2/func" + formulaId + ".png");
        labelFormula.setIcon(icon);
    }

    private void reloadMemoryPanel(){
        labelForMem1.setText(mem1.toString());
        labelForMem2.setText(mem2.toString());
        labelForMem3.setText(mem3.toString());
    }

    public MainFrame(){
        super("Вычисление формулы");
        setSize(WIDTH,HEIGHT);
        setResizable(false);
        Toolkit kit = Toolkit.getDefaultToolkit();
        setLocation((kit.getScreenSize().width-WIDTH)/2,(kit.getScreenSize().height-HEIGHT)/2);
        Image img = kit.getImage("src/SaverchenkoGroup10Lab2VarC2/icon.png");
        setIconImage(img);

        hboxFormulaType.add(Box.createHorizontalGlue());
        addFormulaRadioButton("Формула 1", 1);
        addFormulaRadioButton("Формула 2", 2);
        buttonsFormula.setSelected(buttonsFormula.getElements().nextElement().getModel(),true); // Установить выделенной 1-ую кнопку из группы
        hboxFormulaType.add(Box.createHorizontalGlue());

        Box hboxFormulaImg=Box.createHorizontalBox();
        labelFormula = new JLabel();
        icon = new ImageIcon("src/SaverchenkoGroup10Lab2VarC2/func1.png");
        labelFormula.setIcon(icon);
        hboxFormulaImg.add(labelFormula);

        JLabel labelForX = new JLabel("X:");
        textFieldX = new JTextField("0", 10);
        textFieldX.setMaximumSize(textFieldX.getPreferredSize());
        JLabel labelForY = new JLabel("Y:");
        textFieldY = new JTextField("0", 10);
        textFieldY.setMaximumSize(textFieldY.getPreferredSize());
        JLabel labelForZ = new JLabel("Z:");
        textFieldZ = new JTextField("0", 10);
        textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());

        Box hboxArguments = Box.createHorizontalBox();
        hboxArguments.add(Box.createHorizontalGlue());
        hboxArguments.add(labelForX);
        hboxArguments.add(Box.createHorizontalStrut(10));
        hboxArguments.add(textFieldX);
        hboxArguments.add(Box.createHorizontalStrut(10));
        hboxArguments.add(labelForY);
        hboxArguments.add(Box.createHorizontalStrut(10));
        hboxArguments.add(textFieldY);
        hboxArguments.add(Box.createHorizontalStrut(10));
        hboxArguments.add(labelForZ);
        hboxArguments.add(Box.createHorizontalStrut(10));
        hboxArguments.add(textFieldZ);
        hboxArguments.add(Box.createHorizontalGlue());

        JLabel labelForResult = new JLabel("Результат:");
        textFieldResult = new JTextField("0", 20);
        textFieldResult.setMaximumSize(textFieldResult.getPreferredSize());
        textFieldResult.setEditable(false);
        Box hboxResult = Box.createHorizontalBox();
        hboxResult.add(Box.createHorizontalGlue());
        hboxResult.add(labelForResult);
        hboxResult.add(Box.createHorizontalStrut(10));
        hboxResult.add(textFieldResult);
        hboxResult.add(Box.createHorizontalGlue());

        JButton buttonCalc = new JButton("Вычислить");
        buttonCalc.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                try {
                    Double x = Double.parseDouble(textFieldX.getText());
                    Double y = Double.parseDouble(textFieldY.getText());
                    Double z = Double.parseDouble(textFieldZ.getText());
                    Double result;
                    if (formulaId == 1) {
                        if (y == 0 || y < 0)
                            throw new ArithmeticException("Y не должен быть равен 0 или быть меньше 0");
                        if (x == 0 || x == -1)
                            throw new ArithmeticException("X не должен быть равен 0 или -1");
                        result = calculate1(x,y,z);
                    } else {
                        if (x == 0 || x < 0)
                            throw new ArithmeticException("X не должен быть равен 0 или быть меньше 0");
                        if (y == -1)
                            throw new ArithmeticException("Y не должен быть равен -1");
                        result = calculate2(x,y,z);
                    }
                    textFieldResult.setText(result.toString());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, "Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа", JOptionPane.WARNING_MESSAGE);

                } catch (ArithmeticException ex) {
                    JOptionPane.showMessageDialog(MainFrame.this, ex.toString(), "Выход из ОДЗ", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton buttonReset = new JButton("Очистить");
        buttonReset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textFieldX.setText("0");
                textFieldY.setText("0");
                textFieldZ.setText("0");
                textFieldResult.setText("0");
            }
        });

        Box hboxButtons = Box.createHorizontalBox();
        hboxButtons.add(Box.createHorizontalGlue());
        hboxButtons.add(buttonCalc);
        hboxButtons.add(Box.createHorizontalStrut(200));
        hboxButtons.add(buttonReset);
        hboxButtons.add(Box.createHorizontalGlue());

        Box contentBox=Box.createVerticalBox();
        contentBox.add(hboxFormulaType);
        contentBox.add(hboxFormulaImg);
        contentBox.add(hboxArguments);
        contentBox.add(hboxResult);
        contentBox.add(hboxButtons);
        getContentPane().add(contentBox, BorderLayout.CENTER);
    }

    public static void main(String[] args){
        MainFrame frame=new MainFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
