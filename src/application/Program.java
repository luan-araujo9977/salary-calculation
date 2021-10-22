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
			reajuste = 1;
		}
		else if (valorPorHora > 900 && valorPorHora <= 1500) {
			reajuste = 2;
		}
		else if (valorPorHora > 1500 && valorPorHora <= 2500){
			reajuste = 3;
		}
		else {
			reajuste = 4;
		}
		
		switch (reajuste) {
		case 1:
			System.out.println("Salario liquido: R$ " + valorPorHora);
			break;
		case 2:
			cs.printSalary(reajuste, 5);
			break;
		case 3:
			cs.printSalary(reajuste, 10);
			break;
		case 4:
			cs.printSalary(reajuste, 20);
			break;
		default: 
			System.out.println("Valor invalido");
		}
		
		sc.close();
	}

}