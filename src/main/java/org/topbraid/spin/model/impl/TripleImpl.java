/*******************************************************************************
 * Copyright (c) 2009 TopQuadrant, Inc.
 * All rights reserved. 
 *******************************************************************************/
package org.topbraid.spin.model.impl;

import org.topbraid.spin.model.Triple;
import org.topbraid.spin.model.print.PrintContext;
import org.topbraid.spin.vocabulary.SP;

import org.apache.jena.enhanced.EnhGraph;
import org.apache.jena.graph.Node;
import org.apache.jena.rdf.model.Resource;


public abstract class TripleImpl extends TupleImpl implements Triple {

	public TripleImpl(Node node, EnhGraph graph) {
		super(node, graph);
	}


	@Override
    public Resource getPredicate() {
		return (Resource) getRDFNodeOrVariable(SP.predicate);
	}
	
	
	@Override
    public void print(PrintContext p) {
		print(getSubject(), p);
		p.print(" ");
		print(getPredicate(), p, true);
		p.print(" ");
		print(getObject(), p);
	}
}
