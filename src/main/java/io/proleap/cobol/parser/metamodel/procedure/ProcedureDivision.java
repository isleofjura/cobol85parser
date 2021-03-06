/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure;

import java.util.List;

import io.proleap.cobol.Cobol85Parser.ParagraphContext;
import io.proleap.cobol.Cobol85Parser.ParagraphNameContext;
import io.proleap.cobol.Cobol85Parser.ProcedureDeclarativesContext;
import io.proleap.cobol.parser.metamodel.Scope;
import io.proleap.cobol.parser.metamodel.procedure.declaratives.Declaratives;

/**
 * Contains procedures to manipulate the data from data division.
 */
public interface ProcedureDivision extends Scope {

	Declaratives addDeclaratives(ProcedureDeclarativesContext ctx);

	Paragraph addParagraph(ParagraphContext ctx);

	ParagraphName addParagraphName(ParagraphNameContext ctx);

	Declaratives getDeclaratives();

	Paragraph getParagraph(String name);

	List<Paragraph> getParagraphs();

}
