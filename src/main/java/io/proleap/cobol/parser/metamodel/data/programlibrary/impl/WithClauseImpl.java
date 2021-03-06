/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.data.programlibrary.impl;

import java.util.ArrayList;
import java.util.List;

import io.proleap.cobol.Cobol85Parser.LibraryEntryProcedureWithClauseContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.data.programlibrary.WithClause;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.parser.metamodel.valuestmt.ValueStmt;

public class WithClauseImpl extends CobolDivisionElementImpl implements WithClause {

	protected LibraryEntryProcedureWithClauseContext ctx;

	protected List<ValueStmt> withValueStmts = new ArrayList<ValueStmt>();

	public WithClauseImpl(final ProgramUnit programUnit, final LibraryEntryProcedureWithClauseContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public void addWithValueStmt(final ValueStmt withValueStmt) {
		withValueStmts.add(withValueStmt);
	}

	@Override
	public List<ValueStmt> getWithValueStmts() {
		return withValueStmts;
	}

}
