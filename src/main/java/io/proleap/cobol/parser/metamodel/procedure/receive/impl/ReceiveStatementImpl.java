/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.receive.impl;

import io.proleap.cobol.Cobol85Parser.ReceiveBeforeContext;
import io.proleap.cobol.Cobol85Parser.ReceiveFromStatementContext;
import io.proleap.cobol.Cobol85Parser.ReceiveIntoStatementContext;
import io.proleap.cobol.Cobol85Parser.ReceiveSizeContext;
import io.proleap.cobol.Cobol85Parser.ReceiveStatementContext;
import io.proleap.cobol.Cobol85Parser.ReceiveStatusContext;
import io.proleap.cobol.Cobol85Parser.ReceiveThreadContext;
import io.proleap.cobol.Cobol85Parser.ReceiveWithContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.Scope;
import io.proleap.cobol.parser.metamodel.call.Call;
import io.proleap.cobol.parser.metamodel.procedure.NotOnException;
import io.proleap.cobol.parser.metamodel.procedure.OnException;
import io.proleap.cobol.parser.metamodel.procedure.impl.StatementImpl;
import io.proleap.cobol.parser.metamodel.procedure.receive.ReceiveFromStatement;
import io.proleap.cobol.parser.metamodel.procedure.receive.ReceiveIntoStatement;
import io.proleap.cobol.parser.metamodel.procedure.receive.ReceiveStatement;

public class ReceiveStatementImpl extends StatementImpl implements ReceiveStatement {

	protected final ReceiveStatementContext ctx;

	protected NotOnException notOnException;

	protected OnException onException;

	protected ReceiveFromStatement receiveFromStatement;

	protected ReceiveIntoStatement receiveIntoStatement;

	protected Type type;

	public ReceiveStatementImpl(final ProgramUnit programUnit, final Scope scope, final ReceiveStatementContext ctx) {
		super(programUnit, scope, ctx);

		this.ctx = ctx;
	}

	@Override
	public ReceiveFromStatement addReceiveFromStatement(final ReceiveFromStatementContext ctx) {
		ReceiveFromStatement result = (ReceiveFromStatement) getASGElement(ctx);

		if (result == null) {
			result = new ReceiveFromStatementImpl(programUnit, ctx);

			// data
			final Call dataCall = createCall(ctx.dataName());
			result.setDataCall(dataCall);

			// from
			result.addFrom(ctx.receiveFrom());

			// before
			for (final ReceiveBeforeContext receiveBeforeContext : ctx.receiveBefore()) {
				result.addBefore(receiveBeforeContext);
			}

			// with
			for (final ReceiveWithContext receiveWithContext : ctx.receiveWith()) {
				result.addWith(receiveWithContext);
			}

			// thread
			for (final ReceiveThreadContext receiveThreadContext : ctx.receiveThread()) {
				result.addThread(receiveThreadContext);
			}

			// size
			for (final ReceiveSizeContext receiveSizeContext : ctx.receiveSize()) {
				result.addSize(receiveSizeContext);
			}

			// status
			for (final ReceiveStatusContext receiveStatusContext : ctx.receiveStatus()) {
				result.addStatus(receiveStatusContext);
			}

			receiveFromStatement = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public ReceiveIntoStatement addReceiveIntoStatement(final ReceiveIntoStatementContext ctx) {
		ReceiveIntoStatement result = (ReceiveIntoStatement) getASGElement(ctx);

		if (result == null) {
			result = new ReceiveIntoStatementImpl(programUnit, ctx);

			// communication description entry
			final Call cdNameCall = createCall(ctx.cdName());
			result.setCommunicationDescriptionCall(cdNameCall);

			// type
			final ReceiveIntoStatement.Type type;

			if (ctx.MESSAGE() != null) {
				type = ReceiveIntoStatement.Type.Message;
			} else if (ctx.SEGMENT() != null) {
				type = ReceiveIntoStatement.Type.Segment;
			} else {
				type = null;
			}

			result.setType(type);

			// into call
			final Call intoCall = createCall(ctx.identifier());
			result.setIntoCall(intoCall);

			// no data
			if (ctx.receiveNoData() != null) {
				result.addNoData(ctx.receiveNoData());
			}

			// with data
			if (ctx.receiveWithData() != null) {
				result.addWithData(ctx.receiveWithData());
			}

			receiveIntoStatement = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public NotOnException getNotOnException() {
		return notOnException;
	}

	@Override
	public OnException getOnException() {
		return onException;
	}

	@Override
	public ReceiveFromStatement getReceiveFromStatement() {
		return receiveFromStatement;
	}

	@Override
	public ReceiveIntoStatement getReceiveIntoStatement() {
		return receiveIntoStatement;
	}

	@Override
	public Type getType() {
		return type;
	}

	@Override
	public void setNotOnException(final NotOnException notOnException) {
		this.notOnException = notOnException;
	}

	@Override
	public void setOnException(final OnException onException) {
		this.onException = onException;
	}

	@Override
	public void setType(final Type type) {
		this.type = type;
	}

}
