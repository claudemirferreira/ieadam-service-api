package br.com.setebit.sgr;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.setebit.sgr.repository.AreaRepositorio;
import br.com.setebit.sgr.repository.NucleoRepositorio;
import br.com.setebit.sgr.repository.ZonaRepositorio;
import br.com.setebit.sgr.security.entity.Nucleo;
import br.com.setebit.sgr.security.entity.Zona;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IeadamServiceApiApplicationTests {

	@Autowired
	AreaRepositorio rep;

	@Autowired
	NucleoRepositorio nucleoRepositorio;

	@Autowired
	ZonaRepositorio zonaRepositorio;

	@Test
	public void contextLoads() {
	}

	@Test
	public void lista() {
		List<Zona> lista = zonaRepositorio.findAllById(Arrays.asList(1, 2));
		List<Integer> ids = lista.stream().map(x -> x.getIdZona()).collect(Collectors.toList());
		List<Nucleo> nucleos = nucleoRepositorio.findByZonaIds(ids);
		System.out.println(nucleos.size());
	}

}
