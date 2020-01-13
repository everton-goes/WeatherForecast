package com.teste.web.hbsis.weatherforecast.model;

import javax.persistence.*;

@Entity
@Table(name = "cidades")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "id_cidade")
    private Long idCidade;

    @Column(name = "nome_cidade")
    private String nomeCidade;

    @Column(name = "sigla_pais")
    private String siglaPais;

    public Cidade(){

    }

    public Cidade(Long idCidade, String nomeCidade, String siglaPais) {
        this.idCidade = idCidade;
        this.nomeCidade = nomeCidade;
        this.siglaPais = siglaPais;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCidade() {
        return idCidade;
    }

    public void setIdCidade(Long idCidade) {
        this.idCidade = idCidade;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    public String getSiglaPais() {
        return siglaPais;
    }

    public void setSiglaPais(String siglaPais) {
        this.siglaPais = siglaPais;
    }
}
