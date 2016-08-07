/**
 * ReportController
 *
 * @author ${author}
 * @since 06-Aug-2016
 */
package com.leonarduk.reportserver.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.leonarduk.reportserver.db.Report;
import com.leonarduk.reportserver.db.ReportDao;

@Controller
@RequestMapping("/report")
public class ReportController {

	@Autowired
	private ReportDao dao;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
	public Report getReport(@PathVariable final int id) {
		return this.dao.findById(id);

	}

	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
	public List<Report> getReports() {
		return this.dao.list();
	}

}
