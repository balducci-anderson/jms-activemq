package com.devbalducci.jms.dominio;

import java.io.Serializable;

public class Cliente implements Serializable {

	private static final long serialVersionUID = -8943342825586637552L;

	private String nome;
	private String cpf;
	private double salario;
	
	public Cliente(String nome, String cpf, double salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
}
