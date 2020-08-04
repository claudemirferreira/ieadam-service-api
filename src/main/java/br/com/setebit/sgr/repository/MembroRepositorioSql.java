package br.com.setebit.sgr.repository;

import java.util.List;

import br.com.setebit.sgr.dto.FiltroDTO;
import br.com.setebit.sgr.security.entity.ViewMembro;

public interface MembroRepositorioSql {

	public List<ViewMembro> listarMembrosByFiltros(FiltroDTO filtroDTO);
	
	public ViewMembro findById(int idMembro);

}