package SaverchenkoGroup10Lab2VarC2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    private static final int WIDTH = 700;
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

    }

    public static void main(String[] args){
        MainFrame frame=new MainFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
