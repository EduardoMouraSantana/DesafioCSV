package com.qintess.modelo.desafio;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Operacoes {
		private Date dt1 = new Date();
		private Date dt2 = new Date();
		private int id_preco;
		private String qt;
		private String nmSubproduto;
		private long diasCorridos;
		
		
		public Operacoes(Date dt1, Date dt2, int id_preco, String qt, String nm_subProduto) {
			long diffMills = Math.abs(dt2.getTime() - dt1.getTime());
			long diff = TimeUnit.DAYS.convert(diffMills, TimeUnit.MILLISECONDS);
			this.id_preco = id_preco;
			this.qt = qt;
			this.diasCorridos = diff;
			this.nmSubproduto = nm_subProduto;
		}
		@Override
		public String toString() {
			return nmSubproduto ;
		}
		
		public String getNmSubproduto() {
			return nmSubproduto;
		}
		public void setNmSubproduto(String nmSubproduto) {
			this.nmSubproduto = nmSubproduto;
		}
		public long getDiasCorridos() {
			return diasCorridos;
		}
		public void setDiasCorridos(long diasCorridos) {
			this.diasCorridos = diasCorridos;
		}
		public String getQt() {
			return qt;
		}
		public void setQt(String qt) {
			this.qt = qt;
		}
		public Date getDt1() {
			return dt1;
		}
		public void setDt1(Date dt1) {
			this.dt1 = dt1;
		}
		public Date getDt2() {
			return dt2;
		}
		public void setDt2(Date dt2) {
			this.dt2 = dt2;
		}
		public int getId_preco() {
			return id_preco;
		}
		public void setId_preco(int id_preco) {
			this.id_preco = id_preco;
		}
		
		



}
