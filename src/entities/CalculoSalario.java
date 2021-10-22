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
			return (calcValorPorHora()*5)/100;
	}
	
	public Double calcDescontoTotal(int n) {
			return ((calcValorPorHora()*n)/100) + ((calcValorPorHora()*10)/100);
	}
	
	public Double calcSalarioLiquido(int n) {
			return (valorHora*hora - ((calcValorPorHora()*n)/100 + (calcValorPorHora()*10)/100));
	}
	
	public Double calcValorPorHora() {
		return valorHora * hora;
	}
	
	public void printSalary(int n) {	
		System.out.println("Salario bruto: (" + valorHora + "*" + hora + ")" + ": R$ " + String.format("%.2f", calcValorPorHora()));
		System.out.println("(-) IR (" + n + "%): R$ " + String.format("%.2f", calcIR(n)));
		System.out.println("(-) INSS (10%): R$ " + String.format("%.2f",(calcValorPorHora()*10)/100));
		System.out.println("FGTS (11%): R$ " + String.format("%.2f", (calcValorPorHora()*11)/100));
		System.out.println("Total de desconto: R$ " + String.format("%.2f", calcDescontoTotal(n)));
		System.out.println("Salario liquido: R$ " + String.format("%.2f", calcSalarioLiquido(n)));
	}
}