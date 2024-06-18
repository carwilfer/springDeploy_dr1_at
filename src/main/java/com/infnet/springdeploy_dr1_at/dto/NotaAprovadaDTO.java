package com.infnet.springdeploy_dr1_at.dto;

public class NotaAprovadaDTO {
    private Long id;
    private Double valor;
    private String nomeDisciplina;
    private String nomeAluno;

    // Construtores, getters e setters
    public NotaAprovadaDTO(Long id, Double valor, String nomeDisciplina, String nomeAluno) {
        this.id = id;
        this.valor = valor;
        this.nomeDisciplina = nomeDisciplina;
        this.nomeAluno = nomeAluno;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getNomeAluno() {
        return nomeAluno;
    }

    public void setNomeAluno(String nomeAluno) {
        this.nomeAluno = nomeAluno;
    }
}
