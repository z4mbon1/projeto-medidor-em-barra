package com.potenciometro.application.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_potenciometro")
public class RegistroPotenciometro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_potenciometro")
	private Long id;

	@Column(name = "valor_potenciometro", nullable = false, unique = true)
	private int valorPotenciometro;

	@Column(name = "leds_Acesos", nullable = false, unique = true)
	private int ledsAcesos;

	@Column(name = "data_hora_registro", nullable = false, unique = true)
	private LocalDateTime dataHoraRegistro;

	public RegistroPotenciometro() {
	}

	public RegistroPotenciometro(int valorPotenciometro, int ledsAcesos, LocalDateTime dataHoraRegistro) {
		this.valorPotenciometro = valorPotenciometro;
		this.ledsAcesos = ledsAcesos;
		this.dataHoraRegistro = dataHoraRegistro;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getValorPotenciometro() {
		return valorPotenciometro;
	}

	public void setValorPotenciometro(int valorPotenciometro) {
		this.valorPotenciometro = valorPotenciometro;
	}

	public int getLedsAcesos() {
		return ledsAcesos;
	}

	public void setLedsAcesos(int ledsAcesos) {
		this.ledsAcesos = ledsAcesos;
	}

	public LocalDateTime getDataHoraRegistro() {
		return dataHoraRegistro;
	}

	public void setDataHoraRegistro(LocalDateTime dataHoraRegistro) {
		this.dataHoraRegistro = dataHoraRegistro;
	}

}