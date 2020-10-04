package br.com.setebit.sgr.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.setebit.sgr.dto.AreaDTO;
import br.com.setebit.sgr.dto.UsuarioAreaDTO;
import br.com.setebit.sgr.repository.UsuarioAreaRepositorio;
import br.com.setebit.sgr.security.entity.Area;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.UsuarioArea;
import br.com.setebit.sgr.service.UsuarioAreaServico;

@Service
public class UsuarioAreaServicoImpl implements UsuarioAreaServico {

	@Autowired
	private UsuarioAreaRepositorio repositorio;

	@Override
	public List<UsuarioArea> listarTodos() {
		return repositorio.findAll();
	}

	@Override
	public UsuarioArea salvar(UsuarioArea usuarioNucleo) {
		return repositorio.saveAndFlush(usuarioNucleo);
	}

	@Override
	public void remover(UsuarioArea usuarioNucleo) {
		repositorio.delete(usuarioNucleo);
	}

	@Override
	public UsuarioArea findByUsuarioAndByArea(Usuario usuario, Area area) {
		return repositorio.findByUsuarioAndByArea(usuario, area);
	}

	@Override
	public void deleteByUsuarioAndByArea(Usuario usuario, Area area) {
		repositorio.deleteByUsuarioAndByArea(usuario, area);

	}

	@Override
	public UsuarioAreaDTO atualizar(UsuarioAreaDTO dto) {
		UsuarioArea usuarioArea = UsuarioAreaDTO.toEntity(dto);
		if (dto.isUsuarioArea())
			repositorio.save(usuarioArea);
		else {
			usuarioArea = repositorio.findByUsuarioAndByArea(new Usuario(dto.getIdUsuario()),
					new Area(dto.getIdArea()));
			repositorio.deleteById(usuarioArea.getIdUsuarioArea());
		}
		return dto;
	}

	@Override
	public List<UsuarioArea> findByUsuario(Usuario usuario) {
		return repositorio.findByUsuario(usuario);
	}

	@Override
	public List<AreaDTO> findAreaByUsuario(Integer idUsuario) {
		List<Area> list = this.repositorio.findAreaByUsuario(idUsuario).stream().map(p-> p.getArea()).collect(Collectors.toList());
		return AreaDTO.toDTO(list);
	}

}