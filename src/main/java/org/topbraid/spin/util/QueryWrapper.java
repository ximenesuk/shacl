package org.topbraid.spin.util;

import org.apache.jena.query.Query;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.topbraid.spin.model.Command;


/**
 * A CommandWrapper that wraps a SPARQL query 
 * (in contrast to UpdateWrapper for UPDATE requests).
 * 
 * @author Holger Knublauch
 */
public class QueryWrapper extends CommandWrapper {
	
	private Query query;
	
	private org.topbraid.spin.model.Query spinQuery;
	
	
	public QueryWrapper(Query query, Resource source, String text, org.topbraid.spin.model.Query spinQuery, String label, Statement statement, boolean thisUnbound, boolean thisDeep) {
		super(source, text, label, statement, thisUnbound, thisDeep);
		this.query = query;
		this.spinQuery = spinQuery;
	}
	
	
	public Query getQuery() {
		return query;
	}
	
	
	@Override
	public Command getSPINCommand() {
		return getSPINQuery();
	}


	public org.topbraid.spin.model.Query getSPINQuery() {
		return spinQuery;
	}
}
