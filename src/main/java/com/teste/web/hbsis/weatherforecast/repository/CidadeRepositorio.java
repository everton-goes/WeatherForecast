package com.teste.web.hbsis.weatherforecast.repository;

import com.teste.web.hbsis.weatherforecast.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepositorio extends JpaRepository<Cidade, Long> {

    Cidade findByidCidade(Long idCidade);
}
