package com.teste.web.hbsis.weatherforecast.service;

import com.teste.web.hbsis.weatherforecast.model.Cidade;
import com.teste.web.hbsis.weatherforecast.repository.CidadeRepositorio;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CidadeServiceTest {

    @Autowired
    private CidadeRepositorio cidadeRepositorio;

    @Test
    public void salvarCidade(){
        Cidade cidade = new Cidade(3469968L, "Blumenau", "BR");
        cidadeRepositorio.save(cidade);
        assertThat(cidade.getId()).isNotNull();
        assertThat(cidade.getIdCidade()).isEqualTo(3469968L);
        assertThat(cidade.getNomeCidade()).isEqualTo("Blumenau");
        assertThat(cidade.getSiglaPais()).isEqualTo("BR");
    }

    @Test
    public void excluirCidade(){
        Cidade cidade = new Cidade(3469968L, "Blumenau", "BR");
        cidadeRepositorio.save(cidade);
        cidadeRepositorio.delete(cidade);
        assertThat(cidadeRepositorio.findById(cidade.getId())).isEmpty();
    }

}
