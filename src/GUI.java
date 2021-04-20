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
    private int drawRange, drawNumbers;
    private JButton buttonDraw;
    private JLabel labelDrawNumbers, labelDrawRange, labelYourNumbers, labelDrawn;
    private JTextField textDrawRange, textDrawNumbers;

    public GUI() {
        setTitle("Lotto Machine");
        setLayout(null);
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        try {
            setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("background.jpg")))));
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        ImageIcon img = new ImageIcon("icon.png");
        setIconImage(img.getImage());

        labelDrawRange = new JLabel("Wprowadü zakres:");
        labelDrawRange.setBounds(50, 50, 200, 25);
        add(labelDrawRange);

        labelDrawNumbers = new JLabel("Wprowadü liczbÍ losowanych liczb:");
        labelDrawNumbers.setBounds(50, 100, 200, 25);
        add(labelDrawNumbers);

        textDrawRange = new JTextField("");
        textDrawRange.setBounds(300, 50, 90, 25);
        add(textDrawRange);

        textDrawNumbers = new JTextField("");
        textDrawNumbers.setBounds(300, 100, 90, 25);
        add(textDrawNumbers);

        labelYourNumbers = new JLabel("Twoje liczby to:");
        labelYourNumbers.setBounds(50, 220, 200, 25);
        add(labelYourNumbers);

        labelDrawn = new JLabel();
        labelDrawn.setBounds(150, 220, 250, 25);
        labelDrawn.setFont(new Font("Veranda", Font.BOLD, 13));
        add(labelDrawn);

        buttonDraw = new JButton("Losuj");
        buttonDraw.setBounds(150, 150, 180, 50);
        buttonDraw.addActionListener(this);
        add(buttonDraw);

        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == buttonDraw) {
            try {
                drawRange = Integer.parseInt(textDrawNumbers.getText());
                drawNumbers = Integer.parseInt(textDrawRange.getText());
                if (drawRange > drawNumbers) {
                    labelDrawn.setForeground(Color.RED);
                    labelDrawn.setText("Liczba losowanych przewyøsza zakres!");
                } else {
                    Lotto lotto = new Lotto(drawNumbers, drawRange);
                    lotto.drawNumbers();
                    labelDrawn.setText(lotto.display());
                    labelDrawn.setForeground(Color.BLUE);
                }
            } catch (Exception ex) {
                labelDrawn.setForeground(Color.RED);
                labelDrawn.setText("Wprowadü poprawnie liczby!");
            }
        }
    }
}
