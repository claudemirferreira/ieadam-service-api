package br.com.setebit.sgr;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.setebit.sgr.dto.UsuarioDTO;
import br.com.setebit.sgr.repository.UsuarioRepositorio;
import br.com.setebit.sgr.security.entity.Usuario;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IeadamServiceApiApplicationTests {
	
	@Autowired
	UsuarioRepositorio rep;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void lista() {
		System.out.println("##############################");
		// idMembro: "" login: "" nome: "admin"
		Pageable pageable = PageRequest.of(0, 100, Sort.by("nome"));
		UsuarioDTO dto = new UsuarioDTO();
		dto.setNome("admin");
		dto.setLogin("admin");
		dto.setIdMembro(3830);
		System.out.println("nome="+dto.getNomeFiltro());
		System.out.println("login="+dto.getLoginFiltro());
		System.out.println("idMembro="+dto.getIdMembroFiltro());
		Page<Usuario> resultPage = rep.pesquisa(dto.getNomeFiltro(), dto.getLoginFiltro(), dto.getIdMembroFiltro(), pageable);
		System.out.println(resultPage.getContent().size());
		
	}
	

}
