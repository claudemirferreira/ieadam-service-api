package br.com.setebit.sgr.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.setebit.sgr.security.entity.Usuario;

public interface UsuarioPagination extends PagingAndSortingRepository<Usuario, Integer> {

	@Query("SELECT u FROM Usuario u WHERE LOGIN = ?1 OR NOME like ?2 ")
    Page<Usuario> pesquisa(String login, String nome, Pageable pageable);

}
