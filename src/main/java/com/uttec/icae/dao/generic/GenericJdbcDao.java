package com.uttec.icae.dao.generic;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class GenericJdbcDao extends JdbcDaoSupport {

	@Autowired
	public void setJdbcDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}
	
}
