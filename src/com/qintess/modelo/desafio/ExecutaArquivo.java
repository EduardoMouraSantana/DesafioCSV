package com.qintess.modelo.desafio;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.lang.Comparable;

public class ExecutaArquivo {
	
	public static void main(String[] args) throws NumberFormatException, ParseException, FileNotFoundException {
		long tempoInicial = System.currentTimeMillis(); // ms do inicio
		List <Operacoes> ListaOperacao = new ArrayList<Operacoes>();
		List <DadosMercado> ListaDadosMercado = new ArrayList<DadosMercado>();
		List <Resultado> ListaResultado = new ArrayList<Resultado>();
		List <Resultado> ListaResultadoFinal = new ArrayList<Resultado>();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		boolean encontrado;
		String[] colunaOperacoes = null;
		String[] colunaDados = null;
		try {
			FileReader enderecoDados = new FileReader("C:\\Users\\qintess\\Documents\\Docs\\DesafioCSV\\DadosMercado.csv");
			FileReader enderecoOperacoes = new FileReader("C:\\Users\\qintess\\Documents\\Docs\\DesafioCSV\\Operacoes.csv");
			
			Scanner leitorOperacoes = new Scanner(enderecoOperacoes);
			Scanner leitorDados = new Scanner(enderecoDados);
			
			
			leitorOperacoes.nextLine(); //retira cabeçalho
			leitorDados.nextLine(); // retira cabeçalho
			
			while (leitorDados.hasNextLine()) {
				colunaDados = leitorDados.nextLine().split(";");
				DadosMercado dados = new DadosMercado(Integer.parseInt(colunaDados[0]), Integer.parseInt(colunaDados[1]), Double.parseDouble(colunaDados[2].replace(",", ".")));
				ListaDadosMercado.add(dados);
			}
			while (leitorOperacoes.hasNextLine()) {
				colunaOperacoes = leitorOperacoes.nextLine().split(";");
				Operacoes operacao = new Operacoes(sdf.parse(colunaOperacoes[1]), sdf.parse(colunaOperacoes[2]), Integer.parseInt(colunaOperacoes[13]), (colunaOperacoes[12].replace(",", "")), colunaOperacoes[9]);
				ListaOperacao.add(operacao);
			}
			
			 for(Operacoes operacao: ListaOperacao) {
				 encontrado = false;
				 for(DadosMercado dadosMercado: ListaDadosMercado) {
					if(operacao.getId_preco() == dadosMercado.getId_preco() 
							&& operacao.getDiasCorridos() == dadosMercado.getNu_prazoDiasCorridos()) {
								ListaResultado.add(new Resultado(operacao.getNmSubproduto(),
										dadosMercado.getVl_preco() * Double.parseDouble(operacao.getQt())));
								break;
					}
				}
			} 
			 
			
			Collections.sort(ListaResultado);
			String nomeAtual = null;
			String nomeAnterior = ListaResultado.get(0).getNmSubProduto();
			double soma = 0;
			
			for(Resultado resultado: ListaResultado) {
				nomeAtual = resultado.getNmSubProduto();
				if(nomeAtual.equals(nomeAnterior)) {
					soma+= resultado.getResultado();
				}
				else {
					ListaResultadoFinal.add(new Resultado(nomeAnterior,soma));
					soma = resultado.getResultado();
					nomeAnterior = resultado.getNmSubProduto();
				}
				
			}
			
			
			
			FileWriter csvArquivo = new FileWriter ("C:\\Users\\qintess\\Documents\\Docs\\DesafioCSV\\arquivos.csv");
			csvArquivo.append("NM_SUBPRODUTO");
			csvArquivo.append(";");
			csvArquivo.append("RESULTADO");
			csvArquivo.append("\n");
			
			for (Resultado res: ListaResultadoFinal) {
				csvArquivo.append(String.join(";", res.toString()));
				csvArquivo.append("\n");
			}
			
			
			//csvArquivo.append(String.join(";", ListaOperacao.stream().filter(e -> e.getId_preco() == preco 
			//				&& e.getDiasCorridos() == diasCorridos).distinct().map(String::valueOf).collect(Collectors.joining(";")))).toString();
					
				
				
				
				
				
			csvArquivo.flush();
			csvArquivo.close();
				
			leitorOperacoes.close();
			leitorDados.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
		
		long tempoFinal = System.currentTimeMillis();
		System.out.println("Tempo: " + (tempoFinal-tempoInicial) + "ms");
						
	
		}
}
