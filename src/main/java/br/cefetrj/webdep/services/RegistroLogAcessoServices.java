package br.cefetrj.webdep.services;

import java.util.List;

import javax.persistence.Query;

import br.cefetrj.webdep.model.dao.GenericDAO;
import br.cefetrj.webdep.model.dao.PersistenceManager;
import br.cefetrj.webdep.model.entity.RegistroLogAcesso;
import br.cefetrj.webdep.model.entity.Sistema;
import br.cefetrj.webdep.model.entity.Usuario;

public class RegistroLogAcessoServices {
	
	public static List<RegistroLogAcesso> searchRegistroLogAcessoByUsuario(Usuario u) {
		PersistenceManager pm = PersistenceManager.getInstance();
		try {
			Query q = pm.createQuery("FROM RegistroLogAcesso WHERE usuario LIKE :param ");
			
			q.setParameter("param", "%"+u+"%");

			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<RegistroLogAcesso> searchRegistroLogAcessoBySistema(Sistema s) {
		PersistenceManager pm = PersistenceManager.getInstance();
		try {
			Query q = pm.createQuery("FROM RegistroLogAcesso r WHERE r.sistema.id = :param");
			
			q.setParameter("param", s.getId());

			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void deleteRegistroLogAcesso (RegistroLogAcesso r) {
		PersistenceManager pm = PersistenceManager.getInstance();

		pm.beginTransaction();

		GenericDAO<RegistroLogAcesso> dao = pm.createGenericDAO(RegistroLogAcesso.class);
		dao.delete(r);

		pm.commitTransaction();
	}

	public static List<RegistroLogAcesso> listAllRegisters() {
		List<RegistroLogAcesso> reg = null;
		PersistenceManager pManager = PersistenceManager.getInstance();
		try {
			pManager.beginTransaction();

			GenericDAO<RegistroLogAcesso> permissaoDAO = pManager.createGenericDAO(RegistroLogAcesso.class);
			reg = permissaoDAO.listAll();

			pManager.commitTransaction();
		} catch (Exception e) {
			pManager.rollbackTransaction();
		}

		return reg;
	}
	
}