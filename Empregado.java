abstract class Empregado {
    private String nome;

    public Empregado(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract double calcularSalario();
}

class Mensalista extends Empregado {
    private double salarioMensal;

    public Mensalista(String nome, double salarioMensal) {
        super(nome);
        this.salarioMensal = salarioMensal;
    }

    @Override
    public double calcularSalario() {
        return salarioMensal;
    }
}

class Comissionado extends Empregado {
    private double vendas, taxaComissao;

    public Comissionado(String nome, double vendas, double taxaComissao) {
        super(nome);
        this.vendas = vendas;
        this.taxaComissao = taxaComissao;
    }

    @Override
    public double calcularSalario() {
        return vendas * taxaComissao;
    }
}

class Horista extends Empregado {
    private double horasTrabalhadas, valorHora;

    public Horista(String nome, double horasTrabalhadas, double valorHora) {
        super(nome);
        this.horasTrabalhadas = horasTrabalhadas;
        this.valorHora = valorHora;
    }

    @Override
    public double calcularSalario() {
        return horasTrabalhadas * valorHora;
    }
}
