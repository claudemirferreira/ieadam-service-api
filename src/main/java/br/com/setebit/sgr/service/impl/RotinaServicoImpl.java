package br.com.setebit.sgr.service.impl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.setebit.sgr.dto.RotinaDTO;
import br.com.setebit.sgr.dto.UsuarioDTO;
import br.com.setebit.sgr.repository.RotinaRepositorio;
import br.com.setebit.sgr.repository.RotinaRepositorioSql;
import br.com.setebit.sgr.security.entity.Rotina;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.service.RotinaServico;

@Service
public class RotinaServicoImpl implements RotinaServico, Serializable {

	private static final long serialVersionUID = -4128328556228022891L;

	@Autowired
	private RotinaRepositorio rotinaRepositorio;

	@Autowired
	private RotinaRepositorioSql rotinaRepositorioSql;

	@Override
	public List<Rotina> listarTodos() {
		
		return this.rotinaRepositorio.findAll();
	}

	@Override
	public Rotina salvar(Rotina rotina) {
		return this.rotinaRepositorio.save(rotina);
	}

	@Override
	public void remover(Rotina rotina) {
		this.rotinaRepositorio.delete(rotina);

	}

	@Override
	public List<Rotina> listaRotinasPorPerfil(int id) {
		return rotinaRepositorioSql.listaRotinasPorPerfil(id);
	}

	@Override
	public List<Rotina> findByNomeLike(String nome) {
		return this.rotinaRepositorio.findByNomeLike(nome+"%");
	}

	@Override
	public List<Rotina> listarRotinaPorPerfil(Integer idPerfil) {
		return this.rotinaRepositorio.listarRotinaPorPerfil(idPerfil);
	}

	@Override
	public Rotina findById(Integer id) {
		return this.rotinaRepositorio.findById(id).get();
	}

	@Override
	public void delete(Integer id) {
		this.rotinaRepositorio.deleteById(id);
	}
	
	public Page<Rotina> pesquisarRotina(RotinaDTO dto, int page, int size) {
		Pageable pageable = PageRequest.of(page, size, Sort.by("nome"));
		
		System.out.println("page="+page);
		System.out.println("size="+size);
		System.out.println("nome="+dto.getNome());
		if(dto.getNome() == null || dto.getNome().length() == 0)
			return rotinaRepositorio.findAll(pageable);
		else 
			return rotinaRepositorio.pesquisa(dto.getNome()+"%", pageable);
		
	}
}