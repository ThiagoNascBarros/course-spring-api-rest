package br.com.senaisp.Produto.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.senaisp.Produto.model.Produto;
import br.com.senaisp.Produto.service.ProdutoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProdutoController {
	
//	A anotação abaixo é feita para fazer injeção de dependência!
	@Autowired
	private ProdutoService produtoService;
	
	@PostMapping
	public ResponseEntity addProduto(@Valid @RequestBody Produto produto, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return ResponseEntity.status(400).body(bindingResult.getAllErrors());
		}
		
		try {
			produtoService.addProdutoText(produto);
			
			return new ResponseEntity<Produto>(produto, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
