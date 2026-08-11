package P2C;

import java.util.ArrayList;

public class Treinamento {

    private int id;
    private String nomeInstrutor;
    private String linguagemEnsinada;
    private ArrayList<Aluno> alunos;
    private int cargaHoraria;

    public Treinamento(int id, String nomeInstrutor,
                       String linguagemEnsinada) {

        this.id = id;
        this.nomeInstrutor = nomeInstrutor;
        this.linguagemEnsinada = linguagemEnsinada;
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public boolean verificarDisponibilidade() {
        return true;
    }

    public void definirCargaHoraria(int horas) {
        cargaHoraria = horas;
    }

    public boolean verificarUltimoTreinamento(Aluno aluno) {
        return true;
    }

    public double calcularMediaAlunos() {

        if (alunos.size() == 0) {
            return 0;
        }

        double soma = 0;

        for (Aluno aluno : alunos) {
            soma += aluno.getNotaFinal();
        }

        return soma / alunos.size();
    }

    public void exibirInformacoes() {

        System.out.println("ID: " + id);
        System.out.println("Instrutor: " + nomeInstrutor);
        System.out.println("Linguagem: " + linguagemEnsinada);
        System.out.println("Carga horária: " + cargaHoraria + " horas");
    }
}
