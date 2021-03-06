/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.evaluate.impl;

import io.proleap.cobol.Cobol85Parser.EvaluateSelectContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.parser.metamodel.procedure.evaluate.Select;
import io.proleap.cobol.parser.metamodel.valuestmt.ValueStmt;

public class SelectImpl extends CobolDivisionElementImpl implements Select {

	protected final EvaluateSelectContext ctx;

	protected ValueStmt selectValueStmt;

	public SelectImpl(final ProgramUnit programUnit, final EvaluateSelectContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public ValueStmt getSelectValueStmt() {
		return selectValueStmt;
	}

	@Override
	public void setSelectValueStmt(final ValueStmt selectValueStmt) {
		this.selectValueStmt = selectValueStmt;
	}

}
