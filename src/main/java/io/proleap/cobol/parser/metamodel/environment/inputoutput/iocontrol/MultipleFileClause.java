/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.environment.inputoutput.iocontrol;

import java.util.List;

import io.proleap.cobol.Cobol85Parser.MultipleFilePositionContext;
import io.proleap.cobol.parser.metamodel.CobolDivisionElement;

public interface MultipleFileClause extends CobolDivisionElement {

	MultipleFilePosition addMultipleFilePosition(MultipleFilePositionContext ctx);

	List<MultipleFilePosition> getMultipleFilePositions();
}
