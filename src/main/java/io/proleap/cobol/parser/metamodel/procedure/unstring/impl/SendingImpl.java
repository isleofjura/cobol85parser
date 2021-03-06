/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.unstring.impl;

import java.util.ArrayList;
import java.util.List;

import io.proleap.cobol.Cobol85Parser.UnstringDelimitedByPhraseContext;
import io.proleap.cobol.Cobol85Parser.UnstringOrAllPhraseContext;
import io.proleap.cobol.Cobol85Parser.UnstringSendingPhraseContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.call.Call;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.parser.metamodel.procedure.unstring.DelimitedBy;
import io.proleap.cobol.parser.metamodel.procedure.unstring.OrAll;
import io.proleap.cobol.parser.metamodel.procedure.unstring.Sending;

public class SendingImpl extends CobolDivisionElementImpl implements Sending {

	protected final UnstringSendingPhraseContext ctx;

	protected DelimitedBy delimitedBy;

	protected List<OrAll> orAlls = new ArrayList<OrAll>();

	protected Call sendingCall;

	public SendingImpl(final ProgramUnit programUnit, final UnstringSendingPhraseContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public DelimitedBy addDelimitedBy(final UnstringDelimitedByPhraseContext ctx) {
		DelimitedBy result = (DelimitedBy) getASGElement(ctx);

		if (result == null) {
			result = new DelimitedByImpl(programUnit, ctx);

			final Call delimitedByCall = createCall(ctx.identifier(), ctx.literal());
			result.setDelimitedByCall(delimitedByCall);

			delimitedBy = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public OrAll addOrAll(final UnstringOrAllPhraseContext ctx) {
		OrAll result = (OrAll) getASGElement(ctx);

		if (result == null) {
			result = new OrAllImpl(programUnit, ctx);

			final Call orAllCall = createCall(ctx.identifier(), ctx.literal());
			result.setOrAllCall(orAllCall);

			orAlls.add(result);
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public DelimitedBy getDelimitedBy() {
		return delimitedBy;
	}

	@Override
	public List<OrAll> getOrAlls() {
		return orAlls;
	}

	@Override
	public Call getSendingCall() {
		return sendingCall;
	}

	@Override
	public void setSendingCall(final Call sendingCall) {
		this.sendingCall = sendingCall;
	}

}
