package br.cefetrj.webdep.services;

import br.cefetrj.webdep.model.dao.PersistenceManager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hsqldb.persist.PersistentStoreCollectionSession;

import br.cefetrj.webdep.model.dao.GenericDAO;
import br.cefetrj.webdep.model.entity.Versao;

public class VersaoServices {
	public static void insertVersion(Versao v) {
		PersistenceManager pm = PersistenceManager.getInstance();

		pm.beginTransaction();

		GenericDAO<Versao> dao = pm.createGenericDAO(Versao.class);
		dao.insert(v);

		pm.commitTransaction();

	}

	public static List<Versao> searchVersion(String s) {
		PersistenceManager pm = PersistenceManager.getInstance();
		try {
			Query q = pm.createQuery("FROM Versao WHERE nome LIKE :param "
					+ " OR timestampLiberacao LIKE :param "
					+ " OR sistema  LIKE :param");
			
			q.setParameter("param", "%"+s+"%");

			return q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void deleteVersion(Versao v){
		PersistenceManager pm = PersistenceManager.getInstance();
		
		pm.beginTransaction();

		GenericDAO<Versao> dao = pm.createGenericDAO(Versao.class);
		dao.delete(v);

		pm.commitTransaction();
	}
	
	public static void changeVersion(Versao v){
		PersistenceManager pm = PersistenceManager.getInstance();
		
		pm.beginTransaction();

		GenericDAO<Versao> dao = pm.createGenericDAO(Versao.class);
		dao.update(v);

		pm.commitTransaction();
	}
}