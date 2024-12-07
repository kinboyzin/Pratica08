import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculadora extends JFrame implements ActionListener {
    private JTextField display;
    private JPanel painelBotoes;
    private String operacao = "";
    private int primeiroNumero = 0;

    public Calculadora() {
        super("Calculadora");

        // Configurando display
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.BOLD, 20));
        add(display, BorderLayout.NORTH);

        // Configurando botões
        painelBotoes = new JPanel(new GridLayout(4, 4));
        String[] botoes = {
            "7", "8", "9", "+",
            "4", "5", "6", "-",
            "1", "2", "3", "*",
            "0", "C", "=", "/"
        };

        for (String texto : botoes) {
            JButton botao = new JButton(texto);
            botao.setFont(new Font("Arial", Font.BOLD, 20));
            botao.addActionListener(this);
            painelBotoes.add(botao);
        }

        add(painelBotoes, BorderLayout.CENTER);

        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String comando = e.getActionCommand();

        if (comando.matches("\\d")) {
            display.setText(display.getText() + comando);
        } else if (comando.equals("C")) {
            display.setText("");
            operacao = "";
            primeiroNumero = 0;
        } else if (comando.equals("=")) {
            int segundoNumero = Integer.parseInt(display.getText());
            int resultado = 0;

            switch (operacao) {
                case "+": resultado = primeiroNumero + segundoNumero; break;
                case "-": resultado = primeiroNumero - segundoNumero; break;
                case "*": resultado = primeiroNumero * segundoNumero; break;
                case "/": resultado = primeiroNumero / segundoNumero; break;
            }

            display.setText(String.valueOf(resultado));
        } else {
            primeiroNumero = Integer.parseInt(display.getText());
            operacao = comando;
            display.setText("");
        }
    }

    public static void main(String[] args) {
        new Calculadora();
    }
}
