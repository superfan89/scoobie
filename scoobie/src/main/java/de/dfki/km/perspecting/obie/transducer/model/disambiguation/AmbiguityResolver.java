/*
    Copyright (c) 2011, 
    Benjamin Adrian <benjamin.horak@gmail.com>
    German Research Center for Artificial Intelligence (DFKI) <info@dfki.de>
    
    All rights reserved.

    This file is part of SCOOBIE.

    SCOOBIE is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    SCOOBIE is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with SCOOBIE.  If not, see <http://www.gnu.org/licenses/>.
 */
package de.dfki.km.perspecting.obie.transducer.model.disambiguation;

import de.dfki.km.perspecting.obie.connection.KnowledgeBase;
import de.dfki.km.perspecting.obie.model.Document;
import de.dfki.km.perspecting.obie.model.RDFEdge;
import edu.uci.ics.jung.graph.DirectedGraph;
import gnu.trove.TIntHashSet;
import gnu.trove.TIntObjectHashMap;

import java.util.Set;

public abstract class AmbiguityResolver {
	
	
	public abstract TIntObjectHashMap<TIntHashSet> resolve(
			DirectedGraph<Integer, RDFEdge> graph,
			Set<Set<Integer>> literalSubjectPairs, Document document, KnowledgeBase kb);
	
	
	
	/**
	 * @param c
	 * @return
	 */
	protected TIntHashSet getAmbiguousURIRefs(Set<Integer> c) {
		TIntHashSet subjects = new TIntHashSet();
		for (int i : c) {
			if (i >= 0) {
				subjects.add(i);
			}
		}
		return subjects;
	}

}