package br.edu.senaisp.colegio.controller;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.senaisp.colegio.model.Disciplina;
import br.edu.senaisp.colegio.model.dto.DisciplinaClassDTO;
import br.edu.senaisp.colegio.model.mapper.DisciplinaMapper;
import br.edu.senaisp.colegio.model.mapper.DisciplinaStructMapper;
import br.edu.senaisp.colegio.service.DisciplinaService;

@RestController
@RequestMapping("/api/disciplina")
public class DisciplinaController {
	@Autowired
	private DisciplinaService disciplinaService;

	@Autowired
	private DisciplinaMapper mapper;

	@PostMapping
	public ResponseEntity<?> gravarDisciplina(@RequestBody Disciplina d) {
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.gravar(d));

		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro: " + e.getMessage());
		}
	}

	@PostMapping("/simples")
	public ResponseEntity<?> gravarDisciplinaSimples(@RequestBody DisciplinaClassDTO dto) {

		ModelMapper mapper = new ModelMapper();
//		System.err.println(dto.getTitulo());
		Type type = new TypeToken<Disciplina>() {
		}.getType();
		Disciplina disc = mapper.map(dto, type);
//		System.err.println(disc.getTitulo());

		type = new TypeToken<DisciplinaClassDTO>() {
		}.getType();
		DisciplinaClassDTO dto2 = mapper.map(disc, type);

		System.err.println(disc.getTitulo());

		// Disciplina disc = new Disciplina();
		// BeanUtils.copyProperties(dto, disc);

//		Disciplina d = dto.toDisciplina();
//		DisciplinaDTO dDto = d.toDisciplinaDTO();
//		System.err.println(dDto.titulo());
//
//		Disciplina dd = mapper.toDisciplina(dto);
//		System.err.println(dd.getTitulo());
//		
//		DisciplinaDTO ddDTO = mapper.toDisciplinaDTO(dd);
//		System.err.println(ddDTO.titulo());

		return ResponseEntity.status(HttpStatus.CREATED).body(disciplinaService.gravar(disc));
	}

	@PostMapping("/struct")
	public Disciplina gravarDisciplinaStruct(@RequestBody DisciplinaClassDTO dto) {
		DisciplinaStructMapper mapper = DisciplinaStructMapper.INSTANCE;

		Disciplina disciplina = mapper.toDisciplina(dto);

		return disciplina;
	}

	@GetMapping
	public ResponseEntity<?> buscarTodos() {
		List<Disciplina> lista = disciplinaService.buscarTodos();
		if (lista.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok().body(lista);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> buscarPorId(@PathVariable Long id) {

		Optional<Disciplina> opt = disciplinaService.buscarPorId(id);
		if (opt.isEmpty())
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok().body(opt.get());
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> alterar(@PathVariable Long id, @RequestBody Disciplina disc) {

		disc.setId(id);
		disc = disciplinaService.alterar(id, disc);
		try {
			if (disc != null)
				return ResponseEntity.ok().body(disc);
			else
				return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi encontrado " + "para alteração!");

		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro " + e.getMessage());
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluirPorId(@PathVariable Long id) {

		try {
			if (disciplinaService.excluirPorId(id))
				return ResponseEntity.status(HttpStatus.OK).body("Excluido com sucesso!");
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi Excluido!");

		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Erro " + e.getMessage());
		}

	}

}
