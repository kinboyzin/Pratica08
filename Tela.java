package atv8;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class Tela extends JFrame {
	private JTextField campoTexto;
	private JButton botaoMostrar, botaoLimpar, botaoSair;

	public Tela() {

		JLabel nome = new JLabel("Texto:");
		campoTexto = new JTextField(13);
		botaoMostrar = new JButton("Mostrar");
		botaoLimpar = new JButton("Limpar");
		botaoSair = new JButton("Sair");

		add(nome);
		add(campoTexto);
		add(botaoMostrar);
		add(botaoLimpar);
		add(botaoSair);

		setTitle("Tela");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		botaoMostrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String texto = campoTexto.getText();
				JOptionPane.showMessageDialog(null, texto);
			}
		});

		botaoLimpar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				campoTexto.setText("");
			}
		});

		botaoSair.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}

}