package com.myproject.repository.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myproject.entity.User;
import com.myproject.repository.UserRepository;

@Repository
@Transactional(rollbackFor = Exception.class)
public class UserRepositoryImpl implements UserRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public List<User> findAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			// Viết câu truy vấn HQL
			String sql = "FROM users";
			Query<User> query = session.createQuery(sql, User.class);
			return query.getResultList();

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.find(User.class, id);
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean save(User model) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(model);
			return true;
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			User user = session.find(User.class, id);
			session.delete(user);
			return true;

		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return false;
	}

	public User findByEmail(String email) {
		String queryString = "FROM users WHERE email = :email";
		Session session = sessionFactory.getCurrentSession();
		try {
			Query<User> query = session.createQuery(queryString, User.class);
			query.setParameter("email", email);
			List<User> users = query.getResultList();
			if (users.size() > 0) {
				return users.get(0);
			}
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
		return null;
	}
}
