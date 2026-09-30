package com.potenciometro.application.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.potenciometro.application.entities.RegistroPotenciometro;
import com.potenciometro.application.repositories.RegistroPotenciometroRepository;

@Service
public class RegistroPotenciometroService {

	@Autowired
	private RegistroPotenciometroRepository repository;

	public List<RegistroPotenciometro> listarTodos() {
		return repository.findAll();
	}

	public Optional<RegistroPotenciometro> buscarPorId(Long id) {
		return repository.findById(id);
	}

	public RegistroPotenciometro salvar(RegistroPotenciometro potenciometro) {
		return repository.save(potenciometro);
	}

	public RegistroPotenciometro atualizar(Long id, RegistroPotenciometro leituraAtualizada) {
		Optional<RegistroPotenciometro> existente = repository.findById(id);

		if (existente.isPresent()) {
			RegistroPotenciometro potenciometroAtualizado = existente.get();
			potenciometroAtualizado.setValorPotenciometro(potenciometroAtualizado.getValorPotenciometro());
			potenciometroAtualizado.setLedsAcesos(potenciometroAtualizado.getLedsAcesos());
			potenciometroAtualizado.setDataHoraRegistro(leituraAtualizada.getDataHoraRegistro());
			return repository.save(potenciometroAtualizado);
		}

		throw new RuntimeException("Potenciometro não encontrado para atualização com o ID: " + id);
	}

	public void deletar(Long id) {
		if (!repository.existsById(id)) {
			throw new RuntimeException("Potenciometro não encontrado com o ID: " + id);
		}
		repository.deleteById(id);
	}

}