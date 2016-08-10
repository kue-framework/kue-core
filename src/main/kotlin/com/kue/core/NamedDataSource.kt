package com.kue.core

import javax.sql.DataSource


/**
 * @author Michael Vaughan
 */
data class NamedDataSource(val name: String, val dataSource: DataSource)
data class NamedDataSourceCollection(val dataSources: List<NamedDataSource>)