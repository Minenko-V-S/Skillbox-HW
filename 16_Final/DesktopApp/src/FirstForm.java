import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstForm {
    private JPanel startPanel;
    private JButton buttonCollapse;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;

    public FirstForm(String Family, String Name, String Patronymic) {
        this();
        textField1.setText(Family);
        textField2.setText(Name);
        textField3.setText(Patronymic);
    }

    public FirstForm() {
        buttonCollapse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (textField1.getText().trim().length() > 0
                        && textField2.getText().trim().length() > 0) {
                    String Family = textField1.getText().trim();
                    String Name = textField2.getText().trim();
                    String Patronymic = textField3.getText().trim();

                    String FIO = Family + " " + Name + " " + Patronymic;

                    Main.setFrameContent(new SecondForm(FIO).getRootPanel());
                } else {
                    JOptionPane.showMessageDialog(
                            startPanel,
                            "Поля имя и фамилия должны быть заполнены.",
                            "Сообщение",
                            JOptionPane.PLAIN_MESSAGE
                    );
                }
            }
        });
    }

    public JPanel getStartPanel() {
        return startPanel;
    }


}