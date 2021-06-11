package ar.edu.iua.business;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.iua.business.exception.BusinessException;
import ar.edu.iua.business.exception.NotFoundException;
import ar.edu.iua.model.Categoria;
import ar.edu.iua.model.SubCategoria;
import ar.edu.iua.model.persistence.CategoriaRepository;
import ar.edu.iua.model.persistence.SubCategoriaRepository;

@Service
public class SubCategoriaBusiness implements ISubCategoriaBusiness{
	@Autowired
	private SubCategoriaRepository subCategoriaDAO;

	@Override
	public SubCategoria add(SubCategoria registro) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public SubCategoria load(Integer id) throws NotFoundException, BusinessException {
		Optional<SubCategoria> categoria = null;
		try {
			categoria = subCategoriaDAO.findById(id);

		} catch (Exception e) {
			throw new BusinessException(e);
		}
		return categoria.get();
	}

	@Override
	public SubCategoria asegurarSubCategoria(SubCategoria categoria) throws BusinessException {
		
		SubCategoria c = null;
		try {
			if (subCategoriaDAO.findById(categoria.getId()) != null) {
				
				return subCategoriaDAO.save(categoria);

			} else {
				c = new SubCategoria();
				c.setId(categoria.getId());
				c.setDescripcion(categoria.getDescripcion());
				return subCategoriaDAO.save(c);

			}

		} catch (Exception e) {
			throw new BusinessException(e);
		}
	}

}
