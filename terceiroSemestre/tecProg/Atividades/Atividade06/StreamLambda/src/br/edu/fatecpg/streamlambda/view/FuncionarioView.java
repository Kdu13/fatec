package br.edu.fatecpg.streamlambda.view;

import br.edu.fatecpg.streamlambda.model.Funcionario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FuncionarioView {

    public static void executar() {

        List<Funcionario> funcionarios = new ArrayList<>();
        funcionarios.add(new Funcionario("Ana Silva", "TI", 4500.00, 12));
        funcionarios.add(new Funcionario("Bruno Costa", "TI", 3200.00, 4));
        funcionarios.add(new Funcionario("Carla Souza", "Financeiro", 5200.00, 15));
        funcionarios.add(new Funcionario("Daniel Lima", "Financeiro", 2800.00, 2));
        funcionarios.add(new Funcionario("Eduarda Alves", "RH", 3900.00, 8));
        funcionarios.add(new Funcionario("Felipe Rocha", "RH", 2500.00, 1));
        funcionarios.add(new Funcionario("Gabriela Dias", "TI", 6100.00, 11));
        funcionarios.add(new Funcionario("Hugo Martins", "Financeiro", 3400.00, 10));

        System.out.println("=== Lista completa de funcionarios ===");
        funcionarios.forEach(System.out::println);

        double valorMinimo = 3000.0;
        List<Funcionario> salarioAcimaDe3000 = funcionarios.stream()
                .filter(f -> f.getSalario() > valorMinimo)
                .collect(Collectors.toList());

        System.out.println("\n=== Funcionarios com salario acima de R$ " + valorMinimo + " ===");
        salarioAcimaDe3000.forEach(System.out::println);

        List<Funcionario> funcionariosComReajuste = funcionarios.stream()
                .map(f -> f.getAnosDeServico() >= 10
                        ? new Funcionario(f.getNome(), f.getDepartamento(), f.getSalario() * 1.05, f.getAnosDeServico())
                        : f)
                .collect(Collectors.toList());

        System.out.println("\n=== Funcionarios apos reajuste de 5% (10+ anos de servico) ===");
        funcionariosComReajuste.forEach(System.out::println);

        List<Funcionario> funcionariosOrdenados = funcionarios.stream()
                .sorted(Comparator.comparing(Funcionario::getNome))
                .collect(Collectors.toList());

        System.out.println("\n=== Funcionarios ordenados por nome ===");
        funcionariosOrdenados.forEach(System.out::println);

        double totalSalarios = funcionarios.stream()
                .map(Funcionario::getSalario)
                .reduce(0.0, Double::sum);

        System.out.printf("%n=== Total gasto com salarios: R$ %.2f ===%n", totalSalarios);

        Map<String, Double> mediaPorDepartamento = funcionarios.stream()
                .collect(Collectors.groupingBy(
                        Funcionario::getDepartamento,
                        Collectors.averagingDouble(Funcionario::getSalario)
                ));

        System.out.println("\n=== Media salarial por departamento ===");
        mediaPorDepartamento.forEach((departamento, media) ->
                System.out.printf("%s: R$ %.2f%n", departamento, media));
    }
}
