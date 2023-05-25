import javax.swing.*;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static JFrame frame;

    public static void setUIFont(javax.swing.plaf.FontUIResource f)
    {   
        java.util.Enumeration keys = UIManager.getDefaults().keys();
        while(keys.hasMoreElements())
        {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if(value instanceof javax.swing.plaf.FontUIResource) UIManager.put(key, f);
        }
    }
    public static void main(String[] args) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));


        // jframe set title
        frame.setTitle("หมีภู คาเฟ่");

        try
        {
            setUIFont(new javax.swing.plaf.FontUIResource("Tahoma",Font.PLAIN,20));
        }
        catch(Exception e){}

        JLabel label = new JLabel("หมีภู คาเฟ่");
        Dimension size = label.getPreferredSize();
        label.setBounds(200, 100, size.width, size.height);
        panel.add(label);

        label = new JLabel("ยินดีต้อนรับ !!");
        size = label.getPreferredSize();
        label.setBounds(190, 125, size.width, size.height);
        panel.add(label);

        JButton button = new JButton("Start");
        button.setBounds(190, 180, 100, 50);
        
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                Menu menu = new Menu();
                frame.dispose();
            }
        });   
        panel.add(button);

        frame.setSize(new Dimension(500 ,400));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
