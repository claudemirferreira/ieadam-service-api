package br.com.setebit.sgr.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.setebit.sgr.security.entity.Area;
import br.com.setebit.sgr.security.entity.Nucleo;

public class ComboDTO {

	private AreaDTO area;

	private NucleoDTO nucleo;

	private ZonaDTO zona;
	
	private List<AreaDTO> areas;

	public AreaDTO getArea() {
		return area;
	}

	public void setArea(AreaDTO area) {
		this.area = area;
	}

	public NucleoDTO getNucleo() {
		return nucleo;
	}

	public void setNucleo(NucleoDTO nucleo) {
		this.nucleo = nucleo;
	}

	public ZonaDTO getZona() {
		return zona;
	}

	public void setZona(ZonaDTO zona) {
		this.zona = zona;
	}

	public List<AreaDTO> getAreas() {
		return areas;
	}

	public void setAreas(List<AreaDTO> areas) {
		this.areas = areas;
	}

	public ComboDTO() {
		this.area = new AreaDTO();
		this.zona = new ZonaDTO();
		this.nucleo = new NucleoDTO();
		this.areas = new ArrayList<>();
	}
	
	public static ComboDTO toDTO(Area entity) {
		ComboDTO dto = new ComboDTO();
		dto.area = new AreaDTO(entity.getIdArea(), entity.getNome());
		dto.nucleo = new NucleoDTO(entity.getNucleo().getId(), entity.getNucleo().getNome());
		dto.zona = new ZonaDTO(entity.getNucleo().getZona().getIdZona(), entity.getNucleo().getZona().getNome());
		return dto;
	}

	public static ComboDTO toDTO(Nucleo nucleo) {
		ComboDTO dto = new ComboDTO();
		dto.nucleo = new NucleoDTO(nucleo.getId(), nucleo.getNome());
		dto.zona = new ZonaDTO(nucleo.getZona().getIdZona(), nucleo.getZona().getNome());
		return dto;
	}
	
	

}
