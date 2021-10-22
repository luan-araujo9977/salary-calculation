package entities;

public class CalculoSalario {
	
	private Double valorHora;
	private Double hora;
	
	public CalculoSalario(Double valorHora, Double hora) {
		this.valorHora = valorHora;
		this.hora = hora;
	}

	public Double getValorHora() {
		return valorHora;
	}

	public void setValorHora(Double valorHora) {
		this.valorHora = valorHora;
	}

	public Double getHora() {
		return hora;
	}

	public void setHora(Double hora) {
		this.hora = hora;
	}
	
	public Double calcIR(int n){
		if (n == 1) {
			return 0.0;
		}
		if (n == 2) {
			return (calcValorPorHora()*5)/100;
		}
		if (n == 3) {
			return (calcValorPorHora()*10)/100;
		}
		else {
			return (calcValorPorHora()*20)/100;
		}
	}
	
	public Double calcDescontoTotal(int n) {
		if (n == 1) {
			return 0.0;
		}
		if (n == 2) {
			return ((calcValorPorHora()*5)/100) + ((calcValorPorHora()*10)/100);
		}
		if (n == 3) {
			return ((calcValorPorHora()*10)/100) + ((calcValorPorHora()*10)/100);
		}
		else {
			return ((calcValorPorHora()*20)/100) + ((calcValorPorHora()*10)/100);
		}
	}
	
	public Double calcSalarioLiquido(int n) {
		if (n == 1) {
			return 0.0;
		}
		if (n == 2) {
			return (valorHora*hora - ((calcValorPorHora()*5)/100 + (calcValorPorHora()*10)/100));
		}
		if (n == 3) {
			return (valorHora*hora - ((calcValorPorHora()*10)/100 + (calcValorPorHora()*10)/100));
		}
		else {
			return (valorHora*hora - ((calcValorPorHora()*20)/100 + (calcValorPorHora()*10)/100));
		}
	}
	
	public Double calcValorPorHora() {
		return valorHora * hora;
	}
	
	public void printSalary(int n, int x) {	
		System.out.println("Salario bruto: (" + valorHora + "*" + hora + ")" + ": R$ " + calcValorPorHora());
		System.out.println("(-) IR (" + x + "%): R$ " + calcIR(n));
		System.out.println("(-) INSS (10%): R$ " + (calcValorPorHora()*10)/100);
		System.out.println("FGTS (11%): R$ " + (calcValorPorHora()*11)/100);
		System.out.println("Total de desconto: R$ " + calcDescontoTotal(n));
		System.out.println("Salario liquido: R$ " + calcSalarioLiquido(n));
	}
}
