/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.write.impl;

import io.proleap.cobol.Cobol85Parser.WriteAdvancingLinesContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.call.Call;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.parser.metamodel.procedure.write.AdvancingLines;

public class AdvancingLinesImpl extends CobolDivisionElementImpl implements AdvancingLines {

	protected WriteAdvancingLinesContext ctx;

	protected Call linesCall;

	public AdvancingLinesImpl(final ProgramUnit programUnit, final WriteAdvancingLinesContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public Call getLinesCall() {
		return linesCall;
	}

	@Override
	public void setLinesCall(final Call linesCall) {
		this.linesCall = linesCall;
	}

}
