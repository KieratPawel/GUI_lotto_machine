import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Created by Znakomity on 2017-10-01.
 */
public class GUI extends JFrame implements ActionListener {
    private int liczbaLosowanych, zakres;
    private JButton bLosuj;
    private JLabel lLiczbalosowanych, lZakres, lTwojeLiczbyTo, lWylosowane;
    private JTextField tZakres, tLiczbaLosowanych;

    public GUI() {
        setTitle("Lotto Machine");
        setLayout(null);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("test.jpg")))));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        ImageIcon img = new ImageIcon("icon.png");
        setIconImage(img.getImage());

        lZakres = new JLabel("Wprowadź zakres:");
        lZakres.setBounds(50, 50, 200, 25);
        add(lZakres);

        lLiczbalosowanych = new JLabel("Wprowadź liczbę losowanych liczb:");
        lLiczbalosowanych.setBounds(50, 100, 200, 25);
        add(lLiczbalosowanych);

        tZakres = new JTextField("");
        tZakres.setBounds(300, 50, 90, 25);
        add(tZakres);

        tLiczbaLosowanych = new JTextField("");
        tLiczbaLosowanych.setBounds(300, 100, 90, 25);
        add(tLiczbaLosowanych);

        lTwojeLiczbyTo = new JLabel("Twoje liczby to:");
        lTwojeLiczbyTo.setBounds(50, 220, 200, 25);
        add(lTwojeLiczbyTo);

        lWylosowane = new JLabel();
        lWylosowane.setBounds(150, 220, 250, 25);
        lWylosowane.setFont(new Font("Veranda", Font.BOLD, 13));
        add(lWylosowane);

        bLosuj = new JButton("Losuj");
        bLosuj.setBounds(150, 150, 180, 50);
        bLosuj.addActionListener(this);
        add(bLosuj);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == bLosuj) {
            try {
                liczbaLosowanych = Integer.parseInt(tLiczbaLosowanych.getText());
                zakres = Integer.parseInt(tZakres.getText());
                if (liczbaLosowanych > zakres) {
                    lWylosowane.setForeground(Color.RED);
                    lWylosowane.setText("Liczba losowanych przewyższa zakres!");
                } else {
                    Lotto lotto = new Lotto(zakres, liczbaLosowanych);
                    lotto.mechanizm2();
                    lWylosowane.setText(lotto.wyświetl());
                    lWylosowane.setForeground(Color.BLUE);
                }
            } catch (Exception ex) {
                lWylosowane.setForeground(Color.RED);
                lWylosowane.setText("Wprowadź poprawnie liczby!");
            }
        }
    }
}
