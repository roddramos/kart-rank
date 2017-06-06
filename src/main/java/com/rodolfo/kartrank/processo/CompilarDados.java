package com.rodolfo.kartrank.processo;

import java.time.LocalTime;
import java.util.List;
import java.util.Map.Entry;

import com.rodolfo.kartrank.entities.Piloto;
import com.rodolfo.kartrank.entities.Stats;
import com.rodolfo.kartrank.entities.Volta;

public class CompilarDados {
	public void calcularStats(Entry<Piloto, List<Volta>> entry) {
		Piloto piloto = entry.getKey();
		List<Volta> voltas = (List<Volta>) entry.getValue();
		LocalTime totalTempo = LocalTime.of(0, 0);
		LocalTime horaFim = LocalTime.of(0, 0);
		int countVoltas = 0;
		for (Volta linha : voltas) {
			totalTempo = totalTempo.plusHours(linha.getTempoVolta().getHour())
					.plusMinutes(linha.getTempoVolta().getMinute()).plusSeconds(linha.getTempoVolta().getSecond())
					.plusNanos(linha.getTempoVolta().getNano());
			horaFim = linha.getHora();
			countVoltas++;

		}
		Stats stats = new Stats();
		stats.setTempoRace(totalTempo);
		stats.setQtdTotalVoltas(countVoltas);
		stats.setHoraFim(horaFim);
		piloto.setStats(stats);
	}
}
