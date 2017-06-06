package com.rodolfo.kartrank.entities;

import java.time.LocalTime;

public class Volta {
	private LocalTime hora;
	private String piloto;
	private Integer NVolta;
	private LocalTime tempoVolta;
	private Double velocidadeMediaVolta;

	public Volta(String linha) {
		this.hora = LocalTime.parse(linha.substring(0, 12).trim());
		this.piloto = linha.substring(18, 38).trim();
		this.NVolta = Integer.parseInt(linha.substring(39, 46).trim());
		this.tempoVolta = LocalTime.parse("00:0" + linha.substring(49, 60).trim());
		this.velocidadeMediaVolta = Double.parseDouble(linha.substring(66).trim().replace(",", "."));
	}

	/**
	 * @return the hora
	 */
	public LocalTime getHora() {
		return hora;
	}

	/**
	 * @return the piloto
	 */
	public String getPiloto() {
		return piloto;
	}

	/**
	 * @return the nVolta
	 */
	public Integer getNVolta() {
		return NVolta;
	}

	/**
	 * @return the tempoVolta
	 */
	public LocalTime getTempoVolta() {
		return tempoVolta;
	}

	/**
	 * @return the velocidadeMediaVolta
	 */
	public Double getVelocidadeMediaVolta() {
		return velocidadeMediaVolta;
	}

	/**
	 * @param hora
	 *            the hora to set
	 */
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}

	/**
	 * @param piloto
	 *            the piloto to set
	 */
	public void setPiloto(String piloto) {
		this.piloto = piloto;
	}

	/**
	 * @param nVolta
	 *            the nVolta to set
	 */
	public void setNVolta(Integer nVolta) {
		NVolta = nVolta;
	}

	/**
	 * @param tempoVolta
	 *            the tempoVolta to set
	 */
	public void setTempoVolta(LocalTime tempoVolta) {
		this.tempoVolta = tempoVolta;
	}

	/**
	 * @param velocidadeMediaVolta
	 *            the velocidadeMediaVolta to set
	 */
	public void setVelocidadeMediaVolta(Double velocidadeMediaVolta) {
		this.velocidadeMediaVolta = velocidadeMediaVolta;
	}

	@Override
	public String toString() {
		return "Volta [hora=" + hora + ", piloto=" + piloto + ", NVolta=" + NVolta + ", tempoVolta=" + tempoVolta
				+ ", velocidadeMediaVolta=" + velocidadeMediaVolta + "]";
	}

}
