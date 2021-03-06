/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.continuestmt.impl;

import io.proleap.cobol.Cobol85Parser.ContinueStatementContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.Scope;
import io.proleap.cobol.parser.metamodel.procedure.continuestmt.ContinueStatement;
import io.proleap.cobol.parser.metamodel.procedure.impl.StatementImpl;

public class ContinueStatementImpl extends StatementImpl implements ContinueStatement {

	protected final ContinueStatementContext ctx;

	public ContinueStatementImpl(final ProgramUnit programUnit, final Scope scope, final ContinueStatementContext ctx) {
		super(programUnit, scope, ctx);

		this.ctx = ctx;
	}

}
