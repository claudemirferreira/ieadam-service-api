package br.com.setebit.sgr.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import br.com.setebit.sgr.security.entity.Area;
import br.com.setebit.sgr.security.entity.Zona;

@Repository
public class AreaRepositorioSqlImpl implements AreaRepositorioSql {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Area> listaAreaToUsuarioAndNucleo(int idUsuario, int idNucleo) {

		String SQL = "select b.* from ieadam_area b, ieadam_usuario_area c " + " where b.id_area = c.id_area "
				+ " and b.id_nucleo = " + idNucleo + " and c.id_usuario = " + idUsuario;
		return entityManager.createNativeQuery(SQL, Area.class).getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Area> listaAreaToZona(Zona zona) {

		String SQL = "select a.* from ieadam_area a, ieadam_nucleo b, ieadam_zona c "
				+ "where a.id_nucleo = b.id_nucleo and b.id_zona = c.id_zona " + "and c.id_zona =" + zona.getIdZona();

		return entityManager.createNativeQuery(SQL, Area.class).getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Area> listaAreaToUsuario(Integer idUsuario) {

		String SQL = " select distinct b.* from ieadam_usuario_area a, ieadam_area b\r\n" + 
				" where a.id_area = b.id_area \r\n" + 
				" and a.id_usuario =" + idUsuario;
		System.out.println(SQL);

		return entityManager.createNativeQuery(SQL, Area.class).getResultList();
	}
}