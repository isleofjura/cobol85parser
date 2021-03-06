/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.use.impl;

import io.proleap.cobol.Cobol85Parser.FileNameContext;
import io.proleap.cobol.Cobol85Parser.UseAfterClauseContext;
import io.proleap.cobol.Cobol85Parser.UseAfterOnContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.call.Call;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.parser.metamodel.procedure.use.After;
import io.proleap.cobol.parser.metamodel.procedure.use.AfterOn;

public class AfterImpl extends CobolDivisionElementImpl implements After {

	protected UseAfterClauseContext ctx;

	protected boolean global;

	protected AfterOn afterOn;

	public AfterImpl(final ProgramUnit programUnit, final UseAfterClauseContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public AfterOn addAfterOn(final UseAfterOnContext ctx) {
		AfterOn result = (AfterOn) getASGElement(ctx);

		if (result == null) {
			result = new AfterOnImpl(programUnit, ctx);

			// type
			final AfterOn.Type type;

			if (!ctx.fileName().isEmpty()) {
				type = AfterOn.Type.File;
			} else if (ctx.INPUT() != null) {
				type = AfterOn.Type.Input;
			} else if (ctx.I_O() != null) {
				type = AfterOn.Type.InputOutput;
			} else if (ctx.OUTPUT() != null) {
				type = AfterOn.Type.Output;
			} else {
				type = null;
			}

			result.setType(type);

			// files
			for (final FileNameContext fileNameContext : ctx.fileName()) {
				final Call fileCall = createCall(fileNameContext);
				result.addFileCall(fileCall);
			}

			afterOn = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public AfterOn getAfterOn() {
		return afterOn;
	}

	@Override
	public boolean isGlobal() {
		return global;
	}

	@Override
	public void setGlobal(final boolean global) {
		this.global = global;
	}

}
