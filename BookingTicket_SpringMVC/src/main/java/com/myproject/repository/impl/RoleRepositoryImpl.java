package com.myproject.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.entity.Role;
import com.myproject.repository.RoleRepository;

@Repository
@Transactional(rollbackFor = Exception.class)
public class RoleRepositoryImpl implements RoleRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Role> findAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			// Viết câu truy vấn HQL
			String sql = "FROM roles";
			Query<Role> query = session.createQuery(sql, Role.class);
			return query.getResultList();

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Role findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.find(Role.class, id);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void save(Role model) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(model);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public void delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Role Role = session.find(Role.class, id);
			session.delete(Role);

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}

	public List<Role> findNotAdmin() {
		Session session = sessionFactory.getCurrentSession();
		try {
			// Viết câu truy vấn HQL
			String sql = "FROM roles WHERE name <> :name";
			Query<Role> query = session.createQuery(sql, Role.class);
			query.setParameter("name", "ROLE_ADMIN");
			return query.getResultList();

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}
}
