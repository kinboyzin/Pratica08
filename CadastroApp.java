import javax.swing.*;

public class CadastroApp {
    public static void main(String[] args) {
        BancoDeClientes banco = new BancoDeClientes();
        int opcao;

        do {
            try {
                opcao = Integer.parseInt(JOptionPane.showInputDialog(
                    "Menu:\n" +
                    "1) Inserir cliente\n" +
                    "2) Remover cliente\n" +
                    "3) Alterar cliente\n" +
                    "4) Buscar cliente\n" +
                    "5) Listar todos os clientes\n" +
                    "6) Sair"
                ));

                switch (opcao) {
                    case 1 -> {
                        int id = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do cliente:"));
                        String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
                        String fone = JOptionPane.showInputDialog("Digite o telefone do cliente:");
                        banco.inserirCliente(new Cliente(id, nome, fone));
                        JOptionPane.showMessageDialog(null, "Cliente inserido com sucesso.");
                    }
                    case 2 -> {
                        int idRemover = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do cliente para remover:"));
                        if (banco.removerCliente(idRemover)) {
                            JOptionPane.showMessageDialog(null, "Cliente removido com sucesso.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                        }
                    }
                    case 3 -> {
                        int idAlterar = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do cliente para alterar:"));
                        String novoNome = JOptionPane.showInputDialog("Digite o novo nome do cliente:");
                        String novoFone = JOptionPane.showInputDialog("Digite o novo telefone do cliente:");
                        if (banco.alterarCliente(idAlterar, novoNome, novoFone)) {
                            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso.");
                        } else {
                            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                        }
                    }
                    case 4 -> {
                        int idBuscar = Integer.parseInt(JOptionPane.showInputDialog("Digite o ID do cliente para buscar:"));
                        Cliente cliente = banco.buscarCliente(idBuscar);
                        if (cliente != null) {
                            JOptionPane.showMessageDialog(null, cliente);
                        } else {
                            JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
                        }
                    }
                    case 5 -> {
                        StringBuilder listaClientes = new StringBuilder();
                        for (Cliente cliente : banco.getClientes()) {
                            listaClientes.append(cliente).append("\n");
                        }
                        JOptionPane.showMessageDialog(null,
                            listaClientes.length() > 0 ? listaClientes : "Nenhum cliente cadastrado.");
                    }
                    case 6 -> JOptionPane.showMessageDialog(null, "Saindo do sistema.");
                    default -> JOptionPane.showMessageDialog(null, "Opção inválida.");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, insira um número.");
                opcao = 0; // Redefine a opção para evitar saída prematura.
            }
        } while (opcao != 6);
    }
}
