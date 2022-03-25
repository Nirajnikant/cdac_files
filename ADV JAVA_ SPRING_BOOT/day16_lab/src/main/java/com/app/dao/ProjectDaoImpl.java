package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional // skip service layer
public class ProjectDaoImpl implements IProjectDao {
	@Autowired
	private SessionFactory sf;

	@Override
	public List<String> getAllProjectTitles() {
		String jpql = "select p.title from Project p";
		return sf.getCurrentSession().createQuery(jpql, String.class).getResultList();
	}

}
