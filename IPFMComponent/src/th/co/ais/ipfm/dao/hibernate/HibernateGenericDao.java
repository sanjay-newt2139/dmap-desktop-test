package th.co.ais.ipfm.dao.hibernate;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.InvalidDataAccessApiUsageException;

import th.co.ais.ipfm.dao.IGenericDao;
import th.co.ais.ipfm.util.IPFMDataUtility;

public class HibernateGenericDao<T> implements IGenericDao<T, Long> {

	private Class<T> persistentClass;

	private SessionFactory sessionFactory;
	
	private SessionFactory vsfmSessionFactory;

	@SuppressWarnings("unchecked")
	public HibernateGenericDao() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<T> persistentClass) {
		this.persistentClass = persistentClass;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getVsfmSessionFactory() {
		return vsfmSessionFactory;
	}

	public void setVsfmSessionFactory(SessionFactory vsfmSessionFactory) {
		this.vsfmSessionFactory = vsfmSessionFactory;
	}

	@SuppressWarnings("unchecked")
	public List<T> getByHQLCriteria(String hql) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		List<T> entityList = session.createQuery(hql).list();
		return entityList;
	}

	@SuppressWarnings("unchecked")
	public T getByPrimaryKey(String rowId) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();

		T entity = (T) session.get(getPersistentClass(), rowId);

		if (entity == null) {
			try {
				entity = (T) session.load(getPersistentClass(), rowId);
			} catch (ObjectNotFoundException ex) {
				entity = null;
			}
		}

		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> getBySQLCriteria(String sql) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		List<T> entityList = session.createSQLQuery(sql).addEntity(
				getPersistentClass()).list();
		return entityList;
	}

	public void insert(T entity) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		try {
			IPFMDataUtility.injectCreatDateToDomain(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InvalidDataAccessApiUsageException(e.getMessage());
		}
		
		try {
			session.save(entity);
			//		Fix Bug JTA : Unknown Reason 
			session.flush();		
		} catch(Exception e) {
			e.printStackTrace();
			throw new InvalidDataAccessApiUsageException(e.getMessage());
		}


	}
	
	public void merge(T entity) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		try {
			IPFMDataUtility.injectCreatDateToDomain(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InvalidDataAccessApiUsageException(e.getMessage());
		}
		
		try {
			session.merge(entity);
			//		Fix Bug JTA : Unknown Reason 
			session.flush();		
		} catch(Exception e) {
			e.printStackTrace();
			throw new InvalidDataAccessApiUsageException(e.getMessage());
		}


	}
	
	public void persist(T entity) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		try {
			IPFMDataUtility.injectCreatDateToDomain(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InvalidDataAccessApiUsageException(e.getMessage());
		}
		
		try {
			session.persist(entity);
			//		Fix Bug JTA : Unknown Reason 
//			session.flush();		
		} catch(Exception e) {
			e.printStackTrace();
			throw new InvalidDataAccessApiUsageException(e.getMessage());
		}


	}

	public void update(T entity) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		try {
			IPFMDataUtility.injectModifiedDateToDomain(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InvalidDataAccessApiUsageException(e.getMessage());
		}
		
		try {
		session.update(entity);
//		Fix Bug JTA : Unknown Reason 
		session.flush();
		} catch(Exception e) {
			e.printStackTrace();
			throw new InvalidDataAccessApiUsageException(e.getMessage());
		}
	}
	

	public void delete(T entity) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		session.delete(entity);
		//Fix Bug JTA : Unknown Reason 
		session.flush();
	}

	public void updateExceptInjectCreatDateToDomain(T entity) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		session.update(entity);
//		Fix Bug JTA : Unknown Reason 
		session.flush();
	}

	@Override
	public void saveOrUpdate(T entity) throws DataAccessException {
		Session session = sessionFactory.getCurrentSession();
		try {
			IPFMDataUtility.injectModifiedDateToDomain(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new InvalidDataAccessApiUsageException(e.getMessage());
		}
		session.saveOrUpdate(entity);
//		Fix Bug JTA : Unknown Reason 
		session.flush();
		
		
	}
	
	

}
