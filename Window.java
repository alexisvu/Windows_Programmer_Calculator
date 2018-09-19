/*
    WINDOWS 10 PROGRAMMER CALCULATOR
    This program recreates a simplified version of the Programmer Calculator in Windows 10.
    The calculator allows users to easily perform different operations between different numerical bases.
    Team members: Alexis Vu, Bryce Murphy, Jacob Martin
    Summer 2018

    -- GUI Class --
 */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Window extends JFrame {

    // declare calculator GUI components - buttons and entry fields
    private JPanel mainPanel;
    private JTextField display;
    private JButton lsh;
    private JButton rsh;
    private JButton or;
    private JButton xor;
    private JButton not;
    private JButton and;
    private JButton up;
    private JButton mod;
    private JButton ce;
    private JButton c;
    private JButton backspace;
    private JButton divide;
    private JButton letter_a;
    private JButton letter_b;
    private JButton seven;
    private JButton eight;
    private JButton nine;
    private JButton multiply;
    private JButton letter_c;
    private JButton letter_d;
    private JButton four;
    private JButton five;
    private JButton six;
    private JButton subtract;
    private JButton letter_e;
    private JButton letter_f;
    private JButton one;
    private JButton two;
    private JButton three;
    private JButton add;
    private JButton left_parenthesis;
    private JButton right_parenthesis;
    private JButton change_sign;
    private JButton zero;
    private JButton decimal;
    private JButton equals;
    private JButton full_keypad;
    private JButton bit_toggle_keypad;
    private JButton qword;
    private JButton ms;
    private JButton bin;
    private JButton oct;
    private JButton dec;
    private JButton hex;
    private JLabel hexConverted;
    private JLabel decConverted;
    private JLabel octConverted;
    private JLabel binConverted;

    private final Color BACKGROUND_COLOR = Color.getHSBColor(0, 0, .9f);
    private final Color NUMBER_COLOR = Color.getHSBColor(0, 0, .98f);
    private final Color FUNCTION_COLOR = Color.getHSBColor(0, 0, .94f);

    // different base variable constants
    private final static int DEC = 10;
    private final static int BIN = 2;
    private final static int HEX = 16;
    private final static int OCT = 8;

    private boolean up_arrow = false;

    // change between modes; defaults to dec
    private int mode = 1;
    private ArrayList<Integer> numStore = new ArrayList<>();
    private ArrayList<String> operationStore = new ArrayList<>();

    private boolean starting_zero = true;

    // create main window encompassing entire calculator
    public Window() {
        setContentPane(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setColorLayouts();
        setVisible(true);
        dec();
        c.setEnabled(true);

        // add event listeners for each mode
        hex.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mode = 0;
                hex();
            }
        });
        hex.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hex.setBackground(FUNCTION_COLOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hex.setBackground(BACKGROUND_COLOR);
            }
        });
        dec.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mode = 1;
                dec();
            }
        });
        dec.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                dec.setBackground(FUNCTION_COLOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                dec.setBackground(BACKGROUND_COLOR);
            }
        });
        oct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mode = 2;
                oct();
            }
        });
        oct.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                oct.setBackground(FUNCTION_COLOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                oct.setBackground(BACKGROUND_COLOR);
            }
        });
        bin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mode = 3;
                bin();
            }
        });
        bin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                bin.setBackground(FUNCTION_COLOR);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                bin.setBackground(BACKGROUND_COLOR);
            }
        });

        // add event listeners for number buttons
        nine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (starting_zero) {
                    display.setText("9");
                    starting_zero = false;
                } else {
                    display.setText(display.getText() + "9");
                }
                writeMode();
            }
        });
        eight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (starting_zero) {
                    display.setText("8");
                    starting_zero = false;
                } else {
                    display.setText(display.getText() + "8");
                }
                writeMode();
            }
        });
        seven.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (starting_zero) {
                    display.setText("7");
                    starting_zero = false;
                } else {
                    display.setText(display.getText() + "7");
                }
                writeMode();
            }
        });
        six.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (starting_zero) {
                    display.setText("6");
                    starting_zero = false;
                } else {
                    display.setText(display.getText() + "6");
                }
                writeMode();
            }
        });
        five.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (starting_zero) {
                    display.setText("5");
                    starting_zero = false;
                } else {
                    display.setText(display.getText() + "5");
                }
                writeMode();
            }
        });
        four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (starting_zero) {
                    display.setText("4");
                    starting_zero = false;
                } else {
                    display.setText(display.getText() + "4");
                }
                writeMode();
            }
        });
        three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (starting_zero) {
                    display.setText("3");
                    starting_zero = false;
                } else {
                    display.setText(display.getText() + "3");
                }
                writeMode();
            }
        });
        two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (starting_zero) {
                    display.setText("2");
                    starting_zero = false;
                } else {
                    display.setText(display.getText() + "2");
                }
                writeMode();
            }
        });
        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (starting_zero) {
                    display.setText("1");
                    starting_zero = false;
                } else {
                    display.setText(display.getText() + "1");
                }
                writeMode();
            }
        });
        zero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (starting_zero) {
                    display.setText("0");
                    starting_zero = false;
                } else {
                    display.setText(display.getText() + "0");
                }
                writeMode();
            }
        });
        letter_a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (starting_zero) {
                    display.setText("A");
                    starting_zero = false;
                } else {
                    display.setText(display.getText() + "A");
                }
                writeMode();
            }
        });
        letter_b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (starting_zero) {
                    display.setText("B");
                    starting_zero = false;
                } else {
                    display.setText(display.getText() + "B");
                }
                writeMode();
            }
        });
        letter_c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (starting_zero) {
                    display.setText("C");
                    starting_zero = false;
                } else {
                    display.setText(display.getText() + "C");
                }
                writeMode();
            }
        });
        letter_d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (starting_zero) {
                    display.setText("D");
                    starting_zero = false;
                } else {
                    display.setText(display.getText() + "D");
                }
                writeMode();
            }
        });
        letter_e.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (starting_zero) {
                    display.setText("E");
                    starting_zero = false;
                } else {
                    display.setText(display.getText() + "E");
                }
                writeMode();
            }
        });
        letter_f.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (starting_zero) {
                    display.setText("F");
                    starting_zero = false;
                } else {
                    display.setText(display.getText() + "F");
                }
                writeMode();
            }
        });

        // add event listeners for operation buttons
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOperation("+");
                numStore.add(Integer.parseInt(display.getText()));
                starting_zero = true;
            }
        });
        subtract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOperation("-");
                numStore.add(Integer.parseInt(display.getText()));
                starting_zero = true;
            }
        });
        multiply.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOperation("*");
                numStore.add(Integer.parseInt(display.getText()));
                starting_zero = true;
            }
        });
        divide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOperation("/");
                numStore.add(Integer.parseInt(display.getText()));
                starting_zero = true;
            }
        });
        equals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText(Integer.toString(solve()));
            }
        });
        mod.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addOperation("%");
                numStore.add(Integer.parseInt(display.getText()));
                starting_zero = true;
            }
        });
        ce.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display.setText("0");
                decConverted.setText("0");
                hexConverted.setText("0");
                octConverted.setText("0");
                binConverted.setText("0");
                starting_zero = true;
            }
        });
        c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numStore.clear();
                operationStore.clear();
                display.setText("0");
                decConverted.setText("0");
                hexConverted.setText("0");
                octConverted.setText("0");
                binConverted.setText("0");
                starting_zero = true;
            }
        });
        backspace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // delete numbers at end of main text display when backspace button is hit
                StringBuilder newStr = new StringBuilder(display.getText());
                if (newStr.length() != 0) {
                    newStr.setLength(newStr.length() - 1);

                    // if string is empty, display setText to zero and set starting_zero to true
                    if (newStr.length() == 0) {
                        display.setText("0");
                        decConverted.setText("0");
                        hexConverted.setText("0");
                        binConverted.setText("0");
                        octConverted.setText("0");
                        starting_zero = true;
                    } else {
                        display.setText(newStr.toString()); // display new num in main text bar
                        writeMode(); // force all JLabels to follow in suit

                    }
                }

            }
        });
        change_sign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (mode == 0) {
                    int decimal = Integer.parseInt(display.getText(), HEX);
                    decimal *= 1;
                    display.setText(Integer.toHexString(decimal));
                }

                if (mode == 1) {
                    int val = Integer.parseInt(display.getText()); //change value on stack and displayed converted
                    display.setText(Integer.toString(-val));
                }

                if (mode == 2) {
                    int decimal = Integer.parseInt(display.getText(), OCT);
                    decimal *= 1;
                    display.setText(Integer.toOctalString(decimal));
                }

                if (mode == 3) {
                    int decimal = Integer.parseInt(display.getText(), BIN);
                    decimal *= 1;
                    display.setText(Integer.toBinaryString(decimal));
                }

                writeMode();
            }
        });
        up.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!up_arrow) {
                    lsh.setText("RoL");
                    rsh.setText("RoR");
                    up_arrow = true;
                } else {
                    lsh.setText("Lsh");
                    rsh.setText("Rsh");
                    up_arrow = false;
                }
            }
        });
    }

    public void setColorLayouts() {

        mainPanel.setBorder(null);
        mainPanel.setBackground(BACKGROUND_COLOR);

        hex.setBackground(BACKGROUND_COLOR);
        dec.setBackground(BACKGROUND_COLOR);
        oct.setBackground(BACKGROUND_COLOR);
        bin.setBackground(BACKGROUND_COLOR);

        zero.setBackground(NUMBER_COLOR);
        one.setBackground(NUMBER_COLOR);
        two.setBackground(NUMBER_COLOR);
        three.setBackground(NUMBER_COLOR);
        four.setBackground(NUMBER_COLOR);
        five.setBackground(NUMBER_COLOR);
        six.setBackground(NUMBER_COLOR);
        seven.setBackground(NUMBER_COLOR);
        eight.setBackground(NUMBER_COLOR);
        nine.setBackground(NUMBER_COLOR);


        lsh.setBackground(FUNCTION_COLOR);
        rsh.setBackground(FUNCTION_COLOR);
        or.setBackground(FUNCTION_COLOR);
        xor.setBackground(FUNCTION_COLOR);
        not.setBackground(FUNCTION_COLOR);
        and.setBackground(FUNCTION_COLOR);
        up.setBackground(FUNCTION_COLOR);
        mod.setBackground(FUNCTION_COLOR);
        c.setBackground(FUNCTION_COLOR);
        ce.setBackground(FUNCTION_COLOR);
        backspace.setBackground(FUNCTION_COLOR);
        divide.setBackground(FUNCTION_COLOR);
        left_parenthesis.setBackground(FUNCTION_COLOR);
        right_parenthesis.setBackground(FUNCTION_COLOR);
        change_sign.setBackground(FUNCTION_COLOR);

        multiply.setBackground(FUNCTION_COLOR);
        add.setBackground(FUNCTION_COLOR);
        subtract.setBackground(FUNCTION_COLOR);
        divide.setBackground(FUNCTION_COLOR);
        equals.setBackground(FUNCTION_COLOR);

        hex.setBorder(null);
        dec.setBorder(null);
        oct.setBorder(null);
        bin.setBorder(null);
        hex.setFocusPainted(false);
        dec.setFocusPainted(false);
        oct.setFocusPainted(false);
        bin.setFocusPainted(false);

        letter_a.setBackground(NUMBER_COLOR);
        letter_b.setBackground(NUMBER_COLOR);
        letter_c.setBackground(NUMBER_COLOR);
        letter_d.setBackground(NUMBER_COLOR);
        letter_e.setBackground(NUMBER_COLOR);
        letter_f.setBackground(NUMBER_COLOR);

        c.setFocusPainted(false);

    }

    private String stripFormats(String str) {
        String out = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals(",") || str.substring(i, i + 1) == " ") {
                continue;
            } else
                out = out + str.substring(i, i + 1);
        }
        return out;
    }

    // update each base text field to equivalent value - in real time
    private void writeMode() {
        if (mode == 0) { // if hex

            hexConverted.setText(formatHex(display.getText())); // no action - already in base
            decConverted.setText(convert(display.getText(), HEX, DEC)); // display decimal equiv of hex
            octConverted.setText(convert(display.getText(), HEX, OCT)); // display octal equiv of hex
            binConverted.setText(convert(display.getText(), HEX, BIN)); // display bin equiv of hex
        } else if (mode == 1) { // if dec

            decConverted.setText(formatDec(display.getText()));
            hexConverted.setText(convert(display.getText(), DEC, HEX));
            octConverted.setText(convert(display.getText(), DEC, OCT));
            binConverted.setText(convert(display.getText(), DEC, BIN));
        } else if (mode == 2) { // if oct

            octConverted.setText(formatOct(display.getText()));
            decConverted.setText(convert(display.getText(), OCT, DEC));
            hexConverted.setText(convert(display.getText(), OCT, HEX));
            binConverted.setText(convert(display.getText(), OCT, BIN));
        } else if (mode == 3) { // if bin

            binConverted.setText(formatBin(display.getText()));
            decConverted.setText(convert(display.getText(), BIN, DEC));
            octConverted.setText(convert(display.getText(), BIN, OCT));
            hexConverted.setText(convert(display.getText(), BIN, HEX));
        }
    }

    private void addOperation(String operation) {
        if (operation.equals("*") || operation.equals("/") || operation.equals("%")) {
            PriorityQueue<String> temp = new PriorityQueue<>();
            for (String o : operationStore) {
                if (!o.equals("*") || !o.equals("/")) {
                    temp.add(o);
                    operationStore.remove(o);
                }
            }
            operationStore.add(operation);
            for (String o : temp) {
                operationStore.add(o);
                temp.remove(o);
            }
        } else {
            operationStore.add(operation);
        }
    }

    private int solve() {
        numStore.add(Integer.parseInt(display.getText()));
        // solves without parenthesis
        int cNum = numStore.get(0);
        int n = 0;
        for (String op : operationStore) {
            if (op.equals("*")) {
                cNum *= numStore.get(n + 1);
            } else if (op.equals("/")) {
                cNum /= numStore.get(n + 1);
            } else if (op.equals("%")) {
                cNum %= numStore.get(n + 1);
            } else if (op.equals("+")) {
                cNum += numStore.get(n + 1);
            } else if (op.equals("-")) {
                cNum -= numStore.get(n + 1);
            }
        }
        return cNum;
    }

    // enable relevant hex buttons
    private void hex() {
        if (!starting_zero)
            display.setText(stripFormats(hexConverted.getText()));
        letter_a.setEnabled(true);
        letter_b.setEnabled(true);
        letter_c.setEnabled(true);
        letter_d.setEnabled(true);
        letter_e.setEnabled(true);
        letter_f.setEnabled(true);
        nine.setEnabled(true);
        eight.setEnabled(true);
        seven.setEnabled(true);
        six.setEnabled(true);
        five.setEnabled(true);
        four.setEnabled(true);
        three.setEnabled(true);
        two.setEnabled(true);
    }

    // enable relevant decimal buttons
    private void dec() {
        if (!starting_zero)
            display.setText(stripFormats(decConverted.getText()));
        // disables unnecessary buttons
        letter_a.setEnabled(false);
        letter_b.setEnabled(false);
        letter_c.setEnabled(false);
        letter_d.setEnabled(false);
        letter_e.setEnabled(false);
        letter_f.setEnabled(false);
        nine.setEnabled(true);
        eight.setEnabled(true);
        seven.setEnabled(true);
        six.setEnabled(true);
        five.setEnabled(true);
        four.setEnabled(true);
        three.setEnabled(true);
        two.setEnabled(true);
    }

    // enable relevant octal buttons
    private void oct() {
        if (!starting_zero)
            display.setText(stripFormats(octConverted.getText()));
        // disables unnecessary buttons
        letter_a.setEnabled(false);
        letter_b.setEnabled(false);
        letter_c.setEnabled(false);
        letter_d.setEnabled(false);
        letter_e.setEnabled(false);
        letter_f.setEnabled(false);
        nine.setEnabled(false);
        eight.setEnabled(false);
        seven.setEnabled(true);
        six.setEnabled(true);
        five.setEnabled(true);
        four.setEnabled(true);
        three.setEnabled(true);
        two.setEnabled(true);
    }

    // enable relevant binary buttons
    private void bin() {
        if (!starting_zero)
            display.setText(stripFormats(binConverted.getText()));
        // disables unnecessary buttons
        letter_a.setEnabled(false);
        letter_b.setEnabled(false);
        letter_c.setEnabled(false);
        letter_d.setEnabled(false);
        letter_e.setEnabled(false);
        letter_f.setEnabled(false);
        nine.setEnabled(false);
        eight.setEnabled(false);
        seven.setEnabled(false);
        six.setEnabled(false);
        five.setEnabled(false);
        four.setEnabled(false);
        three.setEnabled(false);
        two.setEnabled(false);
    }

    // converts input numbers to equivalent based on current flagged mode
    private String convert(String num, int firstBase, int secondBase) {

        String convert = Integer.toString(Integer.parseInt(num, firstBase), secondBase);

        if (mode == 1) {  // if user inputs as decimal numbers
            if (secondBase == HEX)
                convert = Integer.toHexString(Integer.valueOf(num));

            if (secondBase == BIN)
                convert = Integer.toBinaryString(Integer.valueOf(num));

            if (secondBase == OCT)
                convert = Integer.toOctalString(Integer.valueOf(num));
        }

        // formatting for different bases
        switch (secondBase) {
            case 2: // if converting to binary
                convert = formatBin(convert);
                break;
            case 8: // if converting to octal
                convert = formatOct(convert);
                break;
            case 10: // if converting to dec
                convert = formatDec(convert);
                break;
            case 16: // if converting to hex
                convert = formatHex(convert);
                break;
        }


        // make sure letter representations are displayed as upper case
        return convert.toUpperCase();
    }

    // format binary number string representation
    // will receive the binary string as a parameter
    private String formatBin(String str) {
        StringBuilder formatted = new StringBuilder(str); // convert to StringBuilder for inserts
        int spaceIndex = str.length() - 4;

        while (spaceIndex > 0) {
            formatted.insert(spaceIndex, ' ');
            spaceIndex -= 4;
        }

        // add leading zeroes so bits are in groups of 4
        int leadingZeroes = str.length() % 4;  // will yield amount of zeroes to add to beginning of string

        // only executes if bits not currently in groups of 4
        for (int count = 0; count < leadingZeroes; count++) {
            formatted.insert(0, '0');                // add zero to beginning of num. string
        }

        return formatted.toString();
    }

    // format decimal digits into groups of 3 separated by commas
    private String formatDec(String str) {
        StringBuilder formatted = new StringBuilder(str);
        int spaceIndex = str.length() - 3;

        while (spaceIndex > 0) {
            formatted.insert(spaceIndex, ',');
            spaceIndex -= 3;
        }

        return formatted.toString();
    }

    // format hex digits into groups of 4 separated by space
    private String formatHex(String str) {
        StringBuilder formatted = new StringBuilder(str); // convert to StringBuilder for inserts
        int spaceIndex = str.length() - 4;

        while (spaceIndex > 0) {
            formatted.insert(spaceIndex, ' ');
            spaceIndex -= 4;
        }

        return formatted.toString();
    }

    // format octal numbers into groups of 3 separated by space
    private String formatOct(String str) {
        StringBuilder formatted = new StringBuilder(str); // convert to StringBuilder for inserts
        int spaceIndex = str.length() - 3;

        while (spaceIndex > 0) {
            formatted.insert(spaceIndex, ' ');
            spaceIndex -= 3;
        }

        return formatted.toString();
    }

}
