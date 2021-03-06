/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.impl;

import io.proleap.cobol.Cobol85Parser.NotOnExceptionClauseContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.impl.ScopeImpl;
import io.proleap.cobol.parser.metamodel.procedure.NotOnException;

public class NotOnExceptionImpl extends ScopeImpl implements NotOnException {

	protected final NotOnExceptionClauseContext ctx;

	public NotOnExceptionImpl(final ProgramUnit programUnit, final NotOnExceptionClauseContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

}
