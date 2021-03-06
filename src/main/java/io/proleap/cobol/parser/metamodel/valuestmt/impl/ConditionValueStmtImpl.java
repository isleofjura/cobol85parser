/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.valuestmt.impl;

import io.proleap.cobol.Cobol85Parser.ConditionContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.valuestmt.ConditionValueStmt;

public class ConditionValueStmtImpl extends ValueStmtImpl implements ConditionValueStmt {

	protected ConditionContext ctx;

	public ConditionValueStmtImpl(final ProgramUnit programUnit, final ConditionContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public String getValue() {
		return null;
	}

}
