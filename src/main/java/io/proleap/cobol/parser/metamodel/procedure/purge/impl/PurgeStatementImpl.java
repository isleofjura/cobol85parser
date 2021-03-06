/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.purge.impl;

import java.util.ArrayList;
import java.util.List;

import io.proleap.cobol.Cobol85Parser.PurgeStatementContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.Scope;
import io.proleap.cobol.parser.metamodel.call.Call;
import io.proleap.cobol.parser.metamodel.procedure.impl.StatementImpl;
import io.proleap.cobol.parser.metamodel.procedure.purge.PurgeStatement;

public class PurgeStatementImpl extends StatementImpl implements PurgeStatement {

	protected List<Call> communicationDescriptionEntryCalls = new ArrayList<Call>();

	protected final PurgeStatementContext ctx;

	public PurgeStatementImpl(final ProgramUnit programUnit, final Scope scope, final PurgeStatementContext ctx) {
		super(programUnit, scope, ctx);

		this.ctx = ctx;
	}

	@Override
	public void addCommunicationDescriptionEntryCall(final Call communicationDescriptionEntryCall) {
		communicationDescriptionEntryCalls.add(communicationDescriptionEntryCall);
	}

	@Override
	public List<Call> getCommunicationDescriptionEntryCalls() {
		return communicationDescriptionEntryCalls;
	}

}
