/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.unstring.impl;

import io.proleap.cobol.Cobol85Parser.UnstringCountInContext;
import io.proleap.cobol.Cobol85Parser.UnstringDelimiterInContext;
import io.proleap.cobol.Cobol85Parser.UnstringIntoContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.call.Call;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.parser.metamodel.procedure.unstring.CountIn;
import io.proleap.cobol.parser.metamodel.procedure.unstring.DelimiterIn;
import io.proleap.cobol.parser.metamodel.procedure.unstring.Into;

public class IntoImpl extends CobolDivisionElementImpl implements Into {

	protected CountIn countIn;

	protected final UnstringIntoContext ctx;

	protected DelimiterIn delimiterIn;

	protected Call intoCall;

	public IntoImpl(final ProgramUnit programUnit, final UnstringIntoContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public CountIn addCountIn(final UnstringCountInContext ctx) {
		CountIn result = (CountIn) getASGElement(ctx);

		if (result == null) {
			result = new CountInImpl(programUnit, ctx);

			final Call countInCall = createCall(ctx.identifier());
			result.setCountInCall(countInCall);

			countIn = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public DelimiterIn addDelimiterIn(final UnstringDelimiterInContext ctx) {
		DelimiterIn result = (DelimiterIn) getASGElement(ctx);

		if (result == null) {
			result = new DelimiterInImpl(programUnit, ctx);

			final Call delimiterInCall = createCall(ctx.identifier());
			result.setDelimiterInCall(delimiterInCall);

			delimiterIn = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public CountIn getCountIn() {
		return countIn;
	}

	@Override
	public DelimiterIn getDelimiterIn() {
		return delimiterIn;
	}

	@Override
	public Call getIntoCall() {
		return intoCall;
	}

	@Override
	public void setIntoCall(final Call intoCall) {
		this.intoCall = intoCall;
	}

}
