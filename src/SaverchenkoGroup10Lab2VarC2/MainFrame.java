package SaverchenkoGroup10Lab2VarC2;

import javax.swing.*;

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
}
