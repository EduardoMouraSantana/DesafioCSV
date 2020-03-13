package com.qintess.modelo.desafio;

import java.lang.Comparable;
public class Resultado implements Comparable<Resultado>{
	private String nmSubProduto;
	private double resultado;
	@Override
	public String toString() {
		return  nmSubProduto +";"+ resultado ;
	}
	public String getNmSubProduto() {
		return nmSubProduto;
	}
	public void setNmSubProduto(String nmSubProduto) {
		this.nmSubProduto = nmSubProduto;
	}
	public double getResultado() {
		return resultado;
	}
	public void setResultado(double resultado) {
		this.resultado = resultado;
	}
	public Resultado(String nmSubProduto, double resultado) {
		this.nmSubProduto = nmSubProduto;
		this.resultado = resultado;
	}
	public Object stream() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public int compareTo(Resultado outroResultado) {
		return this.getNmSubProduto().compareTo(outroResultado.getNmSubProduto());
	}
	
	
}
