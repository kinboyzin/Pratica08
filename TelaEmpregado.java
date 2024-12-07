import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaEmpregado extends JFrame implements ActionListener {
    private JTextField txtNome, txtValor1, txtValor2;
    private JComboBox<String> cbTipo;
    private JButton btnCalcular;

    public TelaEmpregado() {
        super("Empregado");

        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField(15);

        JLabel lblTipo = new JLabel("Tipo:");
        cbTipo = new JComboBox<>(new String[]{"Mensalista", "Comissionado", "Horista"});

        JLabel lblValor1 = new JLabel("Salário/Vendas/Horas:");
        txtValor1 = new JTextField(10);

        JLabel lblValor2 = new JLabel("Taxa/Horas Valor:");
        txtValor2 = new JTextField(10);

        btnCalcular = new JButton("Calcular");
        btnCalcular.addActionListener(this);

        JPanel painel = new JPanel();
        painel.add(lblNome);
        painel.add(txtNome);
        painel.add(lblTipo);
        painel.add(cbTipo);
        painel.add(lblValor1);
        painel.add(txtValor1);
        painel.add(lblValor2);
        painel.add(txtValor2);
        painel.add(btnCalcular);

        add(painel);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = txtNome.getText();
        String tipo = (String) cbTipo.getSelectedItem();
        double valor1 = Double.parseDouble(txtValor1.getText());
        double valor2 = Double.parseDouble(txtValor2.getText());

        Empregado empregado;
        if (tipo.equals("Mensalista")) {
            empregado = new Mensalista(nome, valor1);
        } else if (tipo.equals("Comissionado")) {
            empregado = new Comissionado(nome, valor1, valor2);
        } else {
            empregado = new Horista(nome, valor1, valor2);
        }

        JOptionPane.showMessageDialog(this, "Salário: " + empregado.calcularSalario());
    }

    public static void main(String[] args) {
        new TelaEmpregado();
    }
}
