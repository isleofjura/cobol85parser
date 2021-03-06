/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.sort.impl;

import io.proleap.cobol.Cobol85Parser.SortGivingContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.call.Call;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.parser.metamodel.procedure.sort.Giving;

public class GivingImpl extends CobolDivisionElementImpl implements Giving {

	protected CloseProcedure closeProcedure;

	protected final SortGivingContext ctx;

	protected Call fileCall;

	public GivingImpl(final ProgramUnit programUnit, final SortGivingContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public CloseProcedure getCloseProcedure() {
		return closeProcedure;
	}

	@Override
	public Call getFileCall() {
		return fileCall;
	}

	@Override
	public void setCloseProcedure(final CloseProcedure closeProcedure) {
		this.closeProcedure = closeProcedure;
	}

	@Override
	public void setFileCall(final Call fileCall) {
		this.fileCall = fileCall;
	}

}
