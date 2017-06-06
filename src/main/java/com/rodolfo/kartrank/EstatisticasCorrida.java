package com.rodolfo.kartrank;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

import com.rodolfo.kartrank.entities.Volta;

public class EstatisticasCorrida {
	private Path arquivoCorrida;

	public EstatisticasCorrida(Path arquivoCorrida) {
		this.arquivoCorrida = arquivoCorrida;
	}

	public List<Volta> ler() throws IOException {

		List<Volta> linhas = Files.lines(arquivoCorrida).filter(linha -> !linha.startsWith("Hora")).map(linha -> {
			return new Volta(linha);
		}).collect(Collectors.toList());

		return linhas;
	}

}
