import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaSimples extends JFrame implements ActionListener {
    private JTextField txtTexto;
    private JButton btnMostrar, btnLimpar, btnSair;

    public TelaSimples() {
        super("Exemplo Simples");

        // Configurando os componentes
        txtTexto = new JTextField(20);
        btnMostrar = new JButton("Mostrar");
        btnLimpar = new JButton("Limpar");
        btnSair = new JButton("Sair");

        btnMostrar.addActionListener(this);
        btnLimpar.addActionListener(this);
        btnSair.addActionListener(this);

        // Layout
        setLayout(new FlowLayout());
        add(new JLabel("Texto:"));
        add(txtTexto);
        add(btnMostrar);
        add(btnLimpar);
        add(btnSair);

        setSize(300, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMostrar) {
            JOptionPane.showMessageDialog(this, "Conteúdo: " + txtTexto.getText());
        } else if (e.getSource() == btnLimpar) {
            txtTexto.setText("");
        } else if (e.getSource() == btnSair) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new TelaSimples();
    }
}
