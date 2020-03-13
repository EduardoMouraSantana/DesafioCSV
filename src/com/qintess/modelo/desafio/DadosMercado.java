package com.qintess.modelo.desafio;

public class DadosMercado {
		private int id_preco;
		private int nu_prazoDiasCorridos;
		private double vl_preco;
		
		@Override
		public String toString() {
			return  id_preco + "; \n";
		}

		public DadosMercado(int id_preco, int nu_prazoDiasCorridos, double vl_preco) {
			this.id_preco = id_preco;
			this.nu_prazoDiasCorridos = nu_prazoDiasCorridos;
			this.vl_preco = vl_preco;
			
		}
		
		public double getVl_preco() {
			return vl_preco;
		}
		public void setVl_preco(double vl_preco) {
			this.vl_preco = vl_preco;
		}
		public int getId_preco() {
			return id_preco;
		}
		public void setId_preco(int id_preco) {
			this.id_preco = id_preco;
		}
		public int getNu_prazoDiasCorridos() {
			return nu_prazoDiasCorridos;
		}
		public void setNu_prazoDiasCorridos(int nu_prazoDiasCorridos) {
			this.nu_prazoDiasCorridos = nu_prazoDiasCorridos;
		}
		
		
}
