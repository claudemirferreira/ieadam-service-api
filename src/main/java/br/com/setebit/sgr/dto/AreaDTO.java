package br.com.setebit.sgr.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.setebit.sgr.security.entity.Area;

public class AreaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;

	private String nome;

	private boolean usuarioArea;

	private NucleoDTO nucleo;

	public AreaDTO() {
	}

	public AreaDTO(int id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isUsuarioArea() {
		return usuarioArea;
	}

	public void setUsuarioArea(boolean usuarioArea) {
		this.usuarioArea = usuarioArea;
	}

	public NucleoDTO getNucleo() {
		return nucleo;
	}

	public void setNucleo(NucleoDTO nucleo) {
		this.nucleo = nucleo;
	}

	public static AreaDTO toDTO(Area entity) {
		AreaDTO area = new AreaDTO(entity.getIdArea(), entity.getNome());
		area.nucleo = NucleoDTO.toDTO(entity.getNucleo());
		return area;
	}

	public static List<AreaDTO> toDTO(List<Area> list) {
		List<AreaDTO> dtos = new ArrayList<AreaDTO>();
		list.forEach(item -> dtos.add(toDTO(item)));
		return dtos;
	}

}