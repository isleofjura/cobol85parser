/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.merge.impl;

import java.util.ArrayList;
import java.util.List;

import io.proleap.cobol.Cobol85Parser.MergeOnKeyClauseContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.call.Call;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.parser.metamodel.procedure.merge.OnKey;

public class OnKeyImpl extends CobolDivisionElementImpl implements OnKey {

	protected final MergeOnKeyClauseContext ctx;

	protected List<Call> keyCalls = new ArrayList<Call>();

	protected Type type;

	public OnKeyImpl(final ProgramUnit programUnit, final MergeOnKeyClauseContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public void adKeyCall(final Call keyCall) {
		keyCalls.add(keyCall);
	}

	@Override
	public List<Call> getKeyCalls() {
		return keyCalls;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public void setType(final Type type) {
		this.type = type;
	}

}
