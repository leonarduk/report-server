/**
 * ReportDaoImpl
 *
 * @author ${author}
 * @since 06-Aug-2016
 */
package com.leonarduk.reportserver.db;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;

@Service
public class ReportDaoImpl implements ReportDao {
	private SessionFactory sessionFactory;

	@Override
	public Report findById(final int id) {
		try (final Session session = this.sessionFactory.openSession();) {
			session.beginTransaction();
			final Report report = session.get(Report.class, Integer.valueOf(id));
			return report;
		}
	}

	@Override
	public List<Report> list() {
		try (final Session session = this.sessionFactory.openSession();) {
			final List<Report> personList = session.createQuery("from Report").list();
			return personList;
		}
	}

	@Override
	public void save(final Report p) {
		try (final Session session = this.sessionFactory.openSession();) {
			final Transaction tx = session.beginTransaction();
			session.persist(p);
			tx.commit();
		}
	}

	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
}
