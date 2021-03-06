/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.identification.impl;

import io.proleap.cobol.Cobol85Parser.DateWrittenParagraphContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.identification.DateWrittenParagraph;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;

public class DateWrittenParagraphImpl extends CobolDivisionElementImpl implements DateWrittenParagraph {

	protected final DateWrittenParagraphContext ctx;

	public DateWrittenParagraphImpl(final ProgramUnit programUnit, final DateWrittenParagraphContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

}
