/**
 * ReportDao
 *
 * @author ${author}
 * @since 06-Aug-2016
 */
package com.leonarduk.reportserver.db;

import java.util.List;

public interface ReportDao {
	Report findById(int id);

	List<Report> list();

	void save(Report report);
}
