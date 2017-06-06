package com.rodolfo.kart_rank;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

import com.rodolfo.kartrank.EstatisticasCorrida;
import com.rodolfo.kartrank.entities.Volta;

public class EstatisticasCorridaTest {

	@Test
	public void testEstatisticasCorrida() {
		Path arquivoCorrida = Paths.get("D:\\Projetos\\Java\\eclipse\\kart_rank\\logrank.txt");

		EstatisticasCorrida estatisticasCorrida = new EstatisticasCorrida(arquivoCorrida);
		try {
			List<Volta> ler = estatisticasCorrida.ler();
			for (Volta volta : ler) {
				System.out.println("Linha Volta " + volta.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
