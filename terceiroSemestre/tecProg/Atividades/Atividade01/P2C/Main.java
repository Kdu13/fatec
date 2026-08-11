package P2C;

public class Main {

    public static void main(String[] args) {

        Aluno aluno1 = new Aluno("Carlos", 8.5);
        Aluno aluno2 = new Aluno("João", 7.0);

        TreinamentoPresencial presencial =
                new TreinamentoPresencial(
                        1,
                        "Alessandro",
                        "Java",
                        "Fatec Praia Grande"
                );

        TreinamentoOnline online =
                new TreinamentoOnline(
                        2,
                        "Alessandro",
                        "Python",
                        "www.treinamento.com"
                );

        presencial.adicionarAluno(aluno1);
        presencial.adicionarAluno(aluno2);

        presencial.definirCargaHoraria(40);

        online.definirCargaHoraria(30);

        System.out.println("Média dos alunos: "
                + presencial.calcularMediaAlunos());

        presencial.informarLocal();

        Treinamento treinamento1 = presencial;
        Treinamento treinamento2 = online;

        treinamento1.exibirInformacoes();

        System.out.println("--------------------");

        treinamento2.exibirInformacoes();
    }
}