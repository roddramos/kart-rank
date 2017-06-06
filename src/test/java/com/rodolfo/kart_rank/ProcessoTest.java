package com.rodolfo.kart_rank;

import org.junit.Test;

import com.rodolfo.kartrank.Processo;

public class ProcessoTest {
	@Test
	public void testeProcesso() {
		Processo processo = new Processo("D:\\Projetos\\Java\\eclipse\\kart_rank\\logrank.txt");
		try {
			processo.processarArquivo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
