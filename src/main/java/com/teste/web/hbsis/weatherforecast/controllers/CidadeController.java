package com.teste.web.hbsis.weatherforecast.controllers;

import com.teste.web.hbsis.weatherforecast.model.Cidade;
import com.teste.web.hbsis.weatherforecast.service.CidadeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cidades")
public class CidadeController {

	private static final Logger LOG = LoggerFactory.getLogger(CidadeController.class);

	@Autowired
	private CidadeService cidadeService;

	@PostMapping("/cadastrar")
	public ResponseEntity cadastrarCidade(@RequestParam("idCidade") Long idCidade,
										  @RequestParam("nomeCidade") String nomeCidade,
										  @RequestParam("siglaPais") String siglaPais) {
		try{
			Cidade cidade = cidadeService.buscaCidade(idCidade);

			if(cidade != null){
				return new ResponseEntity("Cidade já cadastrada!", HttpStatus.BAD_REQUEST);
			}else{
				cidadeService.salvarCidade(idCidade, nomeCidade, siglaPais);
			}
		}catch (Exception e){
			LOG.error("Erro ao cadastrar a cidade. " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.BAD_GATEWAY);
		}

		return new ResponseEntity(HttpStatus.OK);
	}

	@PostMapping("/listarCidades")
	@ResponseBody
	public List<Cidade> listaCidades(){
		return cidadeService.listarCidades();
	}

	@PostMapping("/buscaCidadePorId")
	@ResponseBody
	public Cidade buscaCidadePorId(@RequestParam("idCidade") Long idCidade){
		return cidadeService.buscaCidade(idCidade);
	}

	@GetMapping("/excluirCidade")
	public ResponseEntity excluirCidade(@RequestParam("id") Long id) {
		try{
			cidadeService.excluirCidade(id);
		}catch (Exception e){
			LOG.error("Erro ao excluir a cidade. " + e.getMessage());
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.BAD_GATEWAY);
		}

		return new ResponseEntity(HttpStatus.OK);
	}

}
