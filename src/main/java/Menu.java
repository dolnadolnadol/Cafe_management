import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Menu extends JFrame{ 
    private JButton Btn1 = new JButton("Beverages");
    private JButton Btn2 = new JButton("Ingredients");
    private JButton Btn3 = new JButton("Order");
    private JButton Btn4 = new JButton("Employees");
    private JButton Btn7 = new JButton("Position");
    private JButton Btn5 = new JButton("Customers");
    private JButton Btn6 = new JButton("Receipt");


    private JFrame frame;

    Menu(){
        panels();
    }        

    private void panels(){       
        frame = new JFrame("หมีภู คาเฟ่");
        frame.setSize(new Dimension(1000 ,700));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel label = new JLabel("หมีภู คาเฟ่");
        Dimension size = label.getPreferredSize();
        label.setBounds(450, 50, size.width+10, size.height+10);
        panel.add(label);

        JLabel label1 = new JLabel("-------------------------------------------------------Manage-------------------------------------------------------");
        size = label1.getPreferredSize();
        label1.setBounds(70, 130, size.width, size.height);
        panel.add(label1);

        Btn1.setBounds(70, 180, 180, 50);
        panel.add(Btn1);
        Btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                beverage beverage = new beverage();
                // frame.dispose();
                // beverage.setVisible(true);
            }
        });

        Btn2.setBounds(270, 180, 180, 50);
        panel.add(Btn2);
        Btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
//                JFrame beverage = new JFrame();
                Ingredient ingredient = new Ingredient();
                // frame.dispose();
//                beverage.setVisible(true);
            }
        });

        Btn3.setBounds(470, 180, 180, 50);
        panel.add(Btn3);
        Btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Order order = new Order();
//                ingredient.setVisible(true);
            }
        });

        Btn4.setBounds(70, 250, 180, 50);
        panel.add(Btn4);
        Btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                employee employee = new employee();
                // frame.dispose();
//                beverage.setVisible(true);
            }
        });

        Btn7.setBounds(270, 250, 180, 50);
        panel.add(Btn7);
        Btn7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Position position = new Position();
                // frame.dispose();
//                beverage.setVisible(true);
            }
        });

        JLabel label2 = new JLabel("------------------------------------------------------Customer------------------------------------------------------");
        size = label2.getPreferredSize();
        label2.setBounds(70, 400, size.width, size.height);
        panel.add(label2);

        Btn5.setBounds(70, 450, 180, 50);
        panel.add(Btn5);
        Btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                customer customer = new customer();
            }
        });

        Btn6.setBounds(270, 450, 180, 50);
        panel.add(Btn6);
        Btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                receipt receipt = new receipt();

            }
        });
    }
}