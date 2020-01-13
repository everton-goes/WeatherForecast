package com.teste.web.hbsis.weatherforecast.service;

import com.teste.web.hbsis.weatherforecast.model.Cidade;
import com.teste.web.hbsis.weatherforecast.repository.CidadeRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepositorio cidadeRepositorio;

    public Cidade buscaCidade(Long idCidade){
        return cidadeRepositorio.findByidCidade(idCidade);
    }

    public void salvarCidade(Long idCidade, String nomeCidade, String siglaPais){
        Cidade cidade = new Cidade();
        cidade.setIdCidade(idCidade);
        cidade.setNomeCidade(nomeCidade);
        cidade.setSiglaPais(siglaPais);

        cidadeRepositorio.save(cidade);
    }

    public List<Cidade> listarCidades(){
        return cidadeRepositorio.findAll();
    }

    public void excluirCidade(Long id) {
        Cidade cidade = cidadeRepositorio.findByidCidade(id);
        cidadeRepositorio.delete(cidade);
    }
}
