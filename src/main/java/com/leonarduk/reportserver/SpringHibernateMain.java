/**
 * SpringHibernateMain
 *
 * @author ${author}
 * @since 06-Aug-2016
 */
package com.leonarduk.reportserver;

import java.time.LocalDate;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.leonarduk.reportserver.db.Report;
import com.leonarduk.reportserver.db.ReportDao;

public class SpringHibernateMain {

	public static void main(final String[] args) {
		try (final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
		        "spring.xml");) {

			final ReportDao dao = context.getBean(ReportDao.class);

			final Report report = new Report();
			report.setContent("test message");
			report.setRecipients(new String[] { "steve@leonarduk.com" });
			report.setReportDate(LocalDate.now());

			dao.save(report);

			System.out.println("Report::" + report);

			final List<Report> list = dao.list();

			for (final Report report2 : list) {
				System.out.println("Report List::" + report2);
			}
		}
	}
}
