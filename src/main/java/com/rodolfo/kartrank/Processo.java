package com.rodolfo.kartrank;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.rodolfo.kartrank.entities.Piloto;
import com.rodolfo.kartrank.entities.Volta;
import com.rodolfo.kartrank.processo.CompilarDados;

public class Processo {
	private String caminhoArquivo;

	public Processo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}

	public String processarArquivo() throws Exception {
		Path arquivoCorrida = validacaoCriacaoPath();

		EstatisticasCorrida estatisticasCorrida = new EstatisticasCorrida(arquivoCorrida);
		List<Volta> ler = estatisticasCorrida.ler();

		ler.sort((l1, l2) -> l1.getHora().compareTo(l2.getHora()));

		Map<Piloto, List<Volta>> groupPiloto = ler.stream()
				.collect(Collectors.groupingBy(linha -> new Piloto(linha.getPiloto()), Collectors.toList()));

		CompilarDados cpDados = new CompilarDados();
		for (Entry<Piloto, List<Volta>> entry : groupPiloto.entrySet()) {
			cpDados.calcularStats(entry);
		}

		LinkedHashMap<Piloto, List<Volta>> listaCorrida = groupPiloto.entrySet().stream().sorted(
				(p1, p2) -> p1.getKey().getStats().getTempoRace().compareTo(p2.getKey().getStats().getTempoRace()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

		Integer posicao = 0;

		String log = header();

		LocalTime tempoPrimeiro = null;

		for (Entry<Piloto, List<Volta>> entry : listaCorrida.entrySet()) {
			Piloto piloto = entry.getKey();
			List<Volta> voltas = (List<Volta>) entry.getValue();

			Double somaMedia = voltas.stream().collect(Collectors.summingDouble(Volta::getVelocidadeMediaVolta));

			Double velocidadeMedia = somaMedia / piloto.getStats().getQtdTotalVoltas();
			voltas.sort((l1, l2) -> l1.getTempoVolta().compareTo(l2.getTempoVolta()));

			posicao++;
			LocalTime tempoAtrasPrimeiro = piloto.getStats().getTempoRace();
			if (posicao == 1) {
				tempoPrimeiro = piloto.getStats().getTempoRace();
			}

			long between = ChronoUnit.NANOS.between(tempoPrimeiro, tempoAtrasPrimeiro);

			LocalTime diferenca = LocalTime.ofNanoOfDay(between);

			log = montarOutPut(posicao, log, piloto, voltas, velocidadeMedia, diferenca);

		}

		log += "\r\n";
		log += "\r\n";
		ler.sort((l1, l2) -> l1.getTempoVolta().compareTo(l2.getTempoVolta()));
		Volta volta = ler.get(0);
		log += "Melhor Volta -> " + volta.getPiloto() + " - Tempo: " + volta.getTempoVolta() + " - Volta: "
				+ volta.getNVolta();

		System.out.println(log);

		return log;
	}

	private Path validacaoCriacaoPath() throws Exception {
		if (caminhoArquivo == null) {
			throw new Exception("Caminho não informado");
		}
		Path arquivoCorrida = Paths.get(caminhoArquivo);
		if (!arquivoCorrida.toFile().exists()) {
			throw new Exception("Arquivo não existe");
		}
		return arquivoCorrida;
	}

	private String montarOutPut(Integer posicao, String log, Piloto piloto, List<Volta> voltas, Double velocidadeMedia,
			LocalTime diferenca) {
		log += "\r\n" + padRight(posicao.toString(), 16, " ") + padRight(piloto.getCodigo(), 14, " ")
				+ padRight(piloto.getNome(), 16, " ")
				+ padRight(piloto.getStats().getQtdTotalVoltas().toString(), 17, " ")
				+ padRight(piloto.getStats().getTempoRace().toString(), 14, " ")
				+ padRight(voltas.get(0).getTempoVolta().toString(), 14, " ")
				+ padRight(String.format("%.3f", velocidadeMedia), 17, " ") + padRight(diferenca.toString(), 24, " ");
		return log;
	}

	private String header() {
		String log = padRight("Posição no Grid", 16, " ") + padRight("Codigo Piloto", 14, " ")
				+ padRight("Nome Piloto", 16, " ") + padRight("Numero de Voltas", 17, " ")
				+ padRight("Tempo Total", 14, " ") + padRight("Melhor Volta", 14, " ")
				+ padRight("Velocidade Média", 17, " ") + padRight("Tempo atras do primeiro", 24, " ");
		return log;
	}

	public static String padRight(String str, Integer length, String car) {
		return String.format("%" + (length - str.length()) + "s", "").replace(" ", String.valueOf(car)) + str;
	}

}
