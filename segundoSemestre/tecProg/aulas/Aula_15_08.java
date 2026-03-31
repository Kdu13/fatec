package aulas;
import java.util.Random;

public class Aula_15_08 {
    
public static void main(String[] args){

    Random rand = new Random();
    
    int inteiro = rand.nextInt(0, 100);
    float flutuante = rand.nextFloat(0, 100);
    double doubli = rand.nextDouble(0, 100);
    boolean booleano = rand.nextBoolean();

    System.out.println(inteiro);
    System.out.println(flutuante);
    System.out.println(doubli);
    System.out.println(booleano);
}


}