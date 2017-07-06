package com.uflowertv.dao.impl;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.uflowertv.dao.BaseDaoI;

@Repository("xxjBaseDao")
@SuppressWarnings("all")
public class XxjBaseDaoImpl<T> implements BaseDaoI<T> {

	 @Autowired
	 private SessionFactory sessionFactory;

	/**
	 * 获得当前事物的session
	 * 
	 * @return org.hibernate.Session
	 */
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Serializable save(T o) {
		if (o != null) {
            Session s = this.getCurrentSession();
			Serializable ser = s.save(o);
			s.flush();
			return ser;
		}
		return null;
	}

	@Override
	public T getById(Class<T> c, Serializable id) {
		return (T) getCurrentSession().get(c, id);
	}

	@Override
	public T getByHql(String hql) {
		Query q = getCurrentSession().createQuery(hql);
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	@Override
	public T getByHql(String hql, Map<String, Object> params) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);  
		        //这里考虑传入的参数是什么类型，不同类型使用的方法不同  
		        if(obj instanceof Collection<?>){  
	                  q.setParameterList(key, (Collection<?>)obj);  
	            }else if(obj instanceof Object[]){  
	                  q.setParameterList(key, (Object[])obj);  
	            }else{
	            	  q.setParameter(key, params.get(key));
	            }
			}
		}
		List<T> l = q.list();
		if (l != null && l.size() > 0) {
			return l.get(0);
		}
		return null;
	}

	@Override
	public void delete(T o) {
		if (o != null) {
			getCurrentSession().delete(o);
		}
	}

	@Override
	public void update(T o) {
		if (o != null) {
			getCurrentSession().update(o);
		}
	}

	@Override
	public void saveOrUpdate(T o) {
		if (o != null) {
			getCurrentSession().saveOrUpdate(o);
		}
	}

	@Override
	public List<T> find(String hql) {
		Query q = getCurrentSession().createQuery(hql);
		return q.list();
	}
	
	@Override
	public List<T> find(String sql,Class c) {
		Query q = getCurrentSession().createSQLQuery(sql).setResultTransformer(Transformers.aliasToBean(c));
		return q.list();
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);  
		        //这里考虑传入的参数是什么类型，不同类型使用的方法不同  
		        if(obj instanceof Collection<?>){  
	                  q.setParameterList(key, (Collection<?>)obj);  
	            }else if(obj instanceof Object[]){  
	                  q.setParameterList(key, (Object[])obj);  
	            }else{
	            	  q.setParameter(key, params.get(key));
	            }
			}
		}
		return q.list();
	}

	@Override
	public List<T> find(String hql, Map<String, Object> params, int page, int rows) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);  
		        //这里考虑传入的参数是什么类型，不同类型使用的方法不同  
		        if(obj instanceof Collection<?>){  
	                  q.setParameterList(key, (Collection<?>)obj);  
	            }else if(obj instanceof Object[]){  
	                  q.setParameterList(key, (Object[])obj);  
	            }else{
	            	  q.setParameter(key, params.get(key));
	            }
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public List<T> find(String hql, int page, int rows) {
		Query q = getCurrentSession().createQuery(hql);
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).list();
	}

	@Override
	public Long count(String hql) {
		Query q = getCurrentSession().createQuery(hql);
		return (Long) q.uniqueResult();
	}

	@Override
	public Long count(String hql, Map<String, Object> params) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);  
		        //这里考虑传入的参数是什么类型，不同类型使用的方法不同  
		        if(obj instanceof Collection<?>){  
	                  q.setParameterList(key, (Collection<?>)obj);  
	            }else if(obj instanceof Object[]){  
	                  q.setParameterList(key, (Object[])obj);  
	            }else{
	            	  q.setParameter(key, params.get(key));
	            }
			}
		}
		return (Long) q.uniqueResult();
	}

	@Override
	public int executeHql(String hql) {
		Query q = getCurrentSession().createQuery(hql);
		return q.executeUpdate();
	}

	@Override
	public int executeHql(String hql, Map<String, Object> params) {
		Query q = getCurrentSession().createQuery(hql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);  
		        //这里考虑传入的参数是什么类型，不同类型使用的方法不同  
		        if(obj instanceof Collection<?>){  
	                  q.setParameterList(key, (Collection<?>)obj);  
	            }else if(obj instanceof Object[]){  
	                  q.setParameterList(key, (Object[])obj);  
	            }else{
	            	  q.setParameter(key, params.get(key));
	            }
			}
		}
		return q.executeUpdate();
	}

	@Override
	public List<Map> findBySql(String sql) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		return q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@Override
	public List<Map> findBySql(String sql, int page, int rows) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@Override
	public List<Map> findBySql(String sql, Map<String, Object> params) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);  
		        //这里考虑传入的参数是什么类型，不同类型使用的方法不同  
		        if(obj instanceof Collection<?>){  
	                  q.setParameterList(key, (Collection<?>)obj);  
	            }else if(obj instanceof Object[]){  
	                  q.setParameterList(key, (Object[])obj);  
	            }else{
	            	  q.setParameter(key, params.get(key));
	            }
			}
		}
		return q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@Override
	public List<Map> findBySql(String sql, Map<String, Object> params, int page, int rows) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);  
		        //这里考虑传入的参数是什么类型，不同类型使用的方法不同  
		        if(obj instanceof Collection<?>){  
	                  q.setParameterList(key, (Collection<?>)obj);  
	            }else if(obj instanceof Object[]){  
	                  q.setParameterList(key, (Object[])obj);  
	            }else{
	            	  q.setParameter(key, params.get(key));
	            }
			}
		}
		return q.setFirstResult((page - 1) * rows).setMaxResults(rows).setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP).list();
	}

	@Override
	public int executeSql(String sql) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		return q.executeUpdate();
	}

	@Override
	public int executeSql(String sql, Map<String, Object> params) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);  
		        //这里考虑传入的参数是什么类型，不同类型使用的方法不同  
		        if(obj instanceof Collection<?>){  
	                  q.setParameterList(key, (Collection<?>)obj);  
	            }else if(obj instanceof Object[]){  
	                  q.setParameterList(key, (Object[])obj);  
	            }else{
	            	  q.setParameter(key, params.get(key));
	            }
			}
		}
		return q.executeUpdate();
	}

	@Override
	public BigInteger countBySql(String sql) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		return (BigInteger) q.uniqueResult();
	}

	@Override
	public BigInteger countBySql(String sql, Map<String, Object> params) {
		SQLQuery q = getCurrentSession().createSQLQuery(sql);
		if (params != null && !params.isEmpty()) {
			for (String key : params.keySet()) {
				Object obj = params.get(key);  
		        //这里考虑传入的参数是什么类型，不同类型使用的方法不同  
		        if(obj instanceof Collection<?>){  
	                  q.setParameterList(key, (Collection<?>)obj);  
	            }else if(obj instanceof Object[]){  
	                  q.setParameterList(key, (Object[])obj);  
	            }else{
	            	  q.setParameter(key, params.get(key));
	            }
			}
		}
		return (BigInteger) q.uniqueResult();
	}

	@Override
	public List<T> findByDetachCriteria(DetachedCriteria dc,int page,int rows) {
		return dc.getExecutableCriteria(getCurrentSession()).setFirstResult((page-1)*rows).setMaxResults(rows).list();
	}
}