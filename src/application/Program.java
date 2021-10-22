package application;

import java.util.Scanner;

import entities.CalculoSalario;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.print("Digite o valor por hora: ");
		Double valorHora = sc.nextDouble();
		System.out.print("Digite a quantidade de hora(s) trabalhada(s): ");
		Double hora = sc.nextDouble();
		
		CalculoSalario cs = new CalculoSalario(valorHora, hora);
		
		int reajuste;
		Double valorPorHora = cs.calcValorPorHora();
		
		if (valorPorHora <= 900) {
			System.out.println("Salario liquido: R$ " + valorPorHora);
		}
		else if (valorPorHora > 900 && valorPorHora <= 1500) {
			reajuste = 5;
			cs.printSalary(reajuste);
		}
		else if (valorPorHora > 1500 && valorPorHora <= 2500){
			reajuste = 10;
			cs.printSalary(reajuste);
		}
		else {
			reajuste = 20;
			cs.printSalary(reajuste);
		}
		
		sc.close();
	}
}
