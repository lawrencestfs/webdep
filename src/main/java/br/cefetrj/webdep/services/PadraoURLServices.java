package br.cefetrj.webdep.services;

import java.util.List;

import javax.persistence.Query;

import br.cefetrj.webdep.model.dao.GenericDAO;
import br.cefetrj.webdep.model.dao.PersistenceManager;
import br.cefetrj.webdep.model.entity.PadraoURL;

public class PadraoURLServices {
	public static void insertPadraoURL(PadraoURL p) {
		PersistenceManager pm = PersistenceManager.getInstance();

		pm.beginTransaction();

		GenericDAO<PadraoURL> dao = pm.createGenericDAO(PadraoURL.class);
		dao.insert(p);

		pm.commitTransaction();

	}
	
	public static void deletePadraoURL(PadraoURL p){
		PersistenceManager pm = PersistenceManager.getInstance();

		pm.beginTransaction();

		GenericDAO<PadraoURL> dao = pm.createGenericDAO(PadraoURL.class);
		dao.delete(p);

		pm.commitTransaction();
	}
	
	public static List<PadraoURL> searchPadraoURL(String s) {
		PersistenceManager pm = PersistenceManager.getInstance();
		try {
			Query q = pm.createQuery("FROM PadraoURL WHERE nome LIKE :param "
					+ " OR regex LIKE :param "
					+ " OR id LIKE :param ");
			
			q.setParameter("param", "%"+s+"%");

			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}