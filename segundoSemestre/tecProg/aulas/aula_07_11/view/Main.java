package aulas.aula_07_11.view;

import java.util.ArrayList;
import java.util.List;
import aulas.aula_07_11.model.*;

public class Main {
    public static void main(String[] args) {
        System.out.println();
        // Associação por Composição
        Endereco end = new Endereco("Rua 1", "255555", 59);
        Pessoa carlos = new Pessoa("Carlos", 25, "123.456.789-00", end);
        System.out.println(end);
        System.out.println(carlos);
        System.out.println();

        // Associação por Agregação
        Aluno al = new Aluno("Caio", "2021001", 20);
        Disciplina tp = new Disciplina("TP1", "DSM", "2025/2", al);
        System.out.println(tp);
        System.out.println();

        // Associação por Dependência
        Cupom cupom = new Cupom("FATEC777", 59.99);
        Compra compra = new Compra("Notebook", 2000);
        String resultado = compra.finalizarCompra(cupom);
        System.out.println(resultado);
        System.out.println(compra);
        System.out.println();

        // Listas
        List<Object> qualquerCoisa = new ArrayList<>();
        qualquerCoisa.add(1);
        qualquerCoisa.add("Carlos");
        qualquerCoisa.add('b');
        System.out.println(qualquerCoisa);

        List<String> nomes = new ArrayList<>();
        nomes.add("Carlos");
        nomes.add("Caio");
        nomes.add("Joao");
        nomes.add(1, "Geovanny");
        System.out.println(nomes);

        for (String nome : nomes) {
            if (nome.length() <= 3) {
                System.out.println(nome);
            }
        }

        Aluno a1 = new Aluno("Carlos", "123557", 24);
        Aluno a2 = new Aluno("Caio", "151555", 24);
        Aluno a3 = new Aluno("Joao", "12155151", 25);
        Aluno a4 = new Aluno("Geovanny", "555554", 18);

        List<Aluno> alunos = new ArrayList<>();
        alunos.add(a1);
        alunos.add(a2);
        alunos.add(a3);
        alunos.add(a4);

        for (Aluno a : alunos) {
            if (a.getIdade() >= 25) {
                System.out.println(a);
            }

        }
    }
}