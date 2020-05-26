package br.com.setebit.sgr.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.setebit.sgr.security.entity.Perfil;
import br.com.setebit.sgr.security.entity.Usuario;
import br.com.setebit.sgr.security.entity.UsuarioPerfil;

@Repository
public interface UsuarioPerfilRepositorio extends JpaRepository<UsuarioPerfil, Long> {

	@Query("select up from UsuarioPerfil up " + " where up.usuarioPerfilPk.usuario = :usuario "
			+ " and up.usuarioPerfilPk.perfil = :perfil ")
	public UsuarioPerfil findByUsuarioAndPerfil(@Param("usuario") Usuario usuario, @Param("perfil") Perfil perfil);

	@Query("select up from UsuarioPerfil up " + " where up.usuarioPerfilPk.usuario = :usuario ")
	public List<UsuarioPerfil> findByUsuario(@Param("usuario") Usuario usuario);

	 
	@Query("SELECT u FROM Usuario u WHERE LOGIN = ?1 OR NOME like ?2 OR idMembro = ?3")
    Page<Usuario> pesquisa(String login, String nome, Integer idMembro, Pageable pageable);

}