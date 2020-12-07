package br.com.setebit.sgr.repository;

import java.util.List;

import javax.persistence.NoResultException;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.setebit.sgr.security.entity.Usuario;


public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {

	@Query("select u from Usuario u where u.login = :login")
	public Usuario findByLogin(@Param("login") String login);

	@Query("select u from Usuario u where u.nome like :nome")
	public List<Usuario> findByNomeLike(@Param("nome") String nome);

	@Query("select u from Usuario u where u.login = :login and u.senha = :senha")
	public Usuario findByLoginAndSenha(@Param("login") String login, @Param("senha") String senha)
			throws NoResultException;

	@Query("select u from Usuario u where u.email = :email")
	public Usuario findByEmail(@Param("email") String email);

	@Query("SELECT u FROM Usuario u WHERE NOME like ?1 OR LOGIN like ?2 OR idMembro = ?3")
    Page<Usuario> pesquisa(String nome, String login, Integer idMembro, Pageable pageable);
	
	@Query("select u from Usuario u where u.login = :login")
	public Page<Usuario> findByLogin(@Param("login") String login, Pageable pages);

	@Query("select u from Usuario u where u.idMembro = :idMembro")
	public Page<Usuario> findByIdMembro(@Param("idMembro") Integer idMembro, Pageable pages);

	public Usuario findByIdMembro(Integer idMembro);
	
	@Modifying	
	@Transactional
    @Query(value = "UPDATE saa_usuario u set zona =?1, nucleo=?2, area=?3  where u.id_usuario = ?4",
            nativeQuery = true)
	Integer updateUser(boolean zona, boolean nucleo, boolean area, Integer idUsuario);
	
	
}
