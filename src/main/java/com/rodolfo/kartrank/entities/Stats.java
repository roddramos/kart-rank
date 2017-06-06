package com.rodolfo.kartrank.entities;

import java.time.LocalTime;

public class Stats {
	private LocalTime tempoRace;
	private LocalTime horaFim;
	private Integer qtdTotalVoltas;

	/**
	 * @return the tempoRace
	 */
	public LocalTime getTempoRace() {
		return tempoRace;
	}

	/**
	 * @return the horaFim
	 */
	public LocalTime getHoraFim() {
		return horaFim;
	}

	/**
	 * @return the qtdTotalVoltas
	 */
	public Integer getQtdTotalVoltas() {
		return qtdTotalVoltas;
	}

	/**
	 * @param tempoRace
	 *            the tempoRace to set
	 */
	public void setTempoRace(LocalTime tempoRace) {
		this.tempoRace = tempoRace;
	}

	/**
	 * @param horaFim
	 *            the horaFim to set
	 */
	public void setHoraFim(LocalTime horaFim) {
		this.horaFim = horaFim;
	}

	/**
	 * @param qtdTotalVoltas
	 *            the qtdTotalVoltas to set
	 */
	public void setQtdTotalVoltas(Integer qtdTotalVoltas) {
		this.qtdTotalVoltas = qtdTotalVoltas;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Stats [tempoRace=" + tempoRace + ", horaFim=" + horaFim + ", qtdTotalVoltas=" + qtdTotalVoltas + "]";
	}

}
