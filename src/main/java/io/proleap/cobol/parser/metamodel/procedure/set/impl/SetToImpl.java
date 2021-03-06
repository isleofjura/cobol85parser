/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.set.impl;

import java.util.ArrayList;
import java.util.List;

import io.proleap.cobol.Cobol85Parser.SetToContext;
import io.proleap.cobol.Cobol85Parser.SetToStatementContext;
import io.proleap.cobol.Cobol85Parser.SetToValueContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.call.Call;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.parser.metamodel.procedure.set.SetTo;
import io.proleap.cobol.parser.metamodel.procedure.set.To;
import io.proleap.cobol.parser.metamodel.procedure.set.Value;

public class SetToImpl extends CobolDivisionElementImpl implements SetTo {

	protected SetToStatementContext ctx;

	protected List<To> tos = new ArrayList<To>();

	protected List<Value> values = new ArrayList<Value>();

	public SetToImpl(final ProgramUnit programUnit, final SetToStatementContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public To addTo(final SetToContext ctx) {
		To result = (To) getASGElement(ctx);

		if (result == null) {
			result = new ToImpl(programUnit, ctx);

			final Call toCall = createCall(ctx.identifier());
			result.setToCall(toCall);

			tos.add(result);
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public Value addValue(final SetToValueContext ctx) {
		Value result = (Value) getASGElement(ctx);

		if (result == null) {
			result = new ValueImpl(programUnit, ctx);

			// type
			final Value.Type type;

			if (ctx.ON() != null) {
				type = Value.Type.On;
			} else if (ctx.OFF() != null) {
				type = Value.Type.Off;
			} else {
				type = Value.Type.Call;

				// call
				final Call valueCall = createCall(ctx.identifier(), ctx.literal());
				result.setValueCall(valueCall);
			}

			result.setType(type);

			values.add(result);
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public List<To> getTos() {
		return tos;
	}

	@Override
	public List<Value> getValues() {
		return values;
	}

}
