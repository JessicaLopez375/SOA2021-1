package ar.edu.iua.business;

import java.util.List;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.model.HistoricoRegistro;
import ar.edu.iua.model.Registro;


public interface IHistoricoRegistroBusiness {
	public HistoricoRegistro add(Registro registro) throws BusinessException;

	public List<HistoricoRegistro> list() throws BusinessException;
}
