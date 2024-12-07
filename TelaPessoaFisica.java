import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPessoaFisica extends JFrame implements ActionListener {
    private JTextField txtNome, txtCpf, txtValor1, txtValor2;
    private JComboBox<String> cbTipo;
    private JButton btnMostrar;

    public TelaPessoaFisica() {
        super("Pessoa Física");

        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField(15);

        JLabel lblCpf = new JLabel("CPF:");
        txtCpf = new JTextField(15);

        JLabel lblTipo = new JLabel("Tipo:");
        cbTipo = new JComboBox<>(new String[]{"Desempregado", "Mensalista", "Comissionado"});

        JLabel lblValor1 = new JLabel("Salário/Vendas:");
        txtValor1 = new JTextField(10);

        JLabel lblValor2 = new JLabel("Taxa Comissão:");
        txtValor2 = new JTextField(10);

        btnMostrar = new JButton("Mostrar Detalhes");
        btnMostrar.addActionListener(this);

        JPanel painel = new JPanel();
        painel.add(lblNome);
        painel.add(txtNome);
        painel.add(lblCpf);
        painel.add(txtCpf);
        painel.add(lblTipo);
        painel.add(cbTipo);
        painel.add(lblValor1);
        painel.add(txtValor1);
        painel.add(lblValor2);
        painel.add(txtValor2);
        painel.add(btnMostrar);

        add(painel);
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nome = txtNome.getText();
        String cpf = txtCpf.getText();
        String tipo = (String) cbTipo.getSelectedItem();
        PessoaFisica pessoa;

        if (tipo.equals("Desempregado")) {
            pessoa = new Desempregado(nome, cpf);
        } else if (tipo.equals("Mensalista")) {
            double salario = Double.parseDouble(txtValor1.getText());
            pessoa = new Mensalista(nome, cpf, salario);
        } else {
            double vendas = Double.parseDouble(txtValor1.getText());
            double taxa = Double.parseDouble(txtValor2.getText());
            pessoa = new Comissionado(nome, cpf, vendas, taxa);
        }

        JOptionPane.showMessageDialog(this, pessoa.getDetalhes());
    }

    public static void main(String[] args) {
        new TelaPessoaFisica();
    }
}
