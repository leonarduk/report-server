/**
 * Report
 *
 * @author ${author}
 * @since 06-Aug-2016
 */
package com.leonarduk.reportserver.db;

import java.time.LocalDate;
import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Report")
public class Report {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private LocalDate	reportDate;
	private String		content;
	private String[]	recipients;

	public String getContent() {
		return this.content;
	}

	public int getId() {
		return this.id;
	}

	public String[] getRecipients() {
		return this.recipients;
	}

	public LocalDate getReportDate() {
		return this.reportDate;
	}

	public void setContent(final String content) {
		this.content = content;
	}

	public void setId(final int id) {
		this.id = id;
	}

	public void setRecipients(final String[] recipients) {
		this.recipients = recipients;
	}

	public void setReportDate(final LocalDate reportDate) {
		this.reportDate = reportDate;
	}

	@Override
	public String toString() {
		return "Report [id=" + this.id + ", reportDate=" + this.reportDate + ", content="
		        + this.content + ", recipients=" + Arrays.toString(this.recipients) + "]";
	}
}
