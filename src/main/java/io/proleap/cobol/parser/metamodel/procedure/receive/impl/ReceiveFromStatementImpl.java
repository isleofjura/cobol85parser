/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.receive.impl;

import io.proleap.cobol.Cobol85Parser.ReceiveBeforeContext;
import io.proleap.cobol.Cobol85Parser.ReceiveFromContext;
import io.proleap.cobol.Cobol85Parser.ReceiveFromStatementContext;
import io.proleap.cobol.Cobol85Parser.ReceiveSizeContext;
import io.proleap.cobol.Cobol85Parser.ReceiveStatusContext;
import io.proleap.cobol.Cobol85Parser.ReceiveThreadContext;
import io.proleap.cobol.Cobol85Parser.ReceiveWithContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.call.Call;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.parser.metamodel.procedure.receive.Before;
import io.proleap.cobol.parser.metamodel.procedure.receive.From;
import io.proleap.cobol.parser.metamodel.procedure.receive.ReceiveFromStatement;
import io.proleap.cobol.parser.metamodel.procedure.receive.Size;
import io.proleap.cobol.parser.metamodel.procedure.receive.Status;
import io.proleap.cobol.parser.metamodel.procedure.receive.Thread;
import io.proleap.cobol.parser.metamodel.procedure.receive.With;

public class ReceiveFromStatementImpl extends CobolDivisionElementImpl implements ReceiveFromStatement {

	protected Before before;

	protected final ReceiveFromStatementContext ctx;

	protected Call dataCall;

	protected From from;

	protected Size size;

	protected Status status;

	protected Thread thread;

	protected With with;

	public ReceiveFromStatementImpl(final ProgramUnit programUnit, final ReceiveFromStatementContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public Before addBefore(final ReceiveBeforeContext ctx) {
		Before result = (Before) getASGElement(ctx);

		if (result == null) {
			result = new BeforeImpl(programUnit, ctx);

			final Call timeCall = createCall(ctx.identifier(), ctx.numericLiteral());
			result.setTimeCall(timeCall);

			before = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public From addFrom(final ReceiveFromContext ctx) {
		From result = (From) getASGElement(ctx);

		if (result == null) {
			result = new FromImpl(programUnit, ctx);

			// type
			final From.Type type;

			if (ctx.LAST() != null) {
				type = From.Type.LastThread;
			} else if (ctx.ANY() != null) {
				type = From.Type.AnyThread;
			} else if (ctx.dataName() != null) {
				type = From.Type.Thread;
			} else {
				type = null;
			}

			result.setType(type);

			// thread call
			final Call threadCall = createCall(ctx.dataName());
			result.setThreadCall(threadCall);

			from = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public Size addSize(final ReceiveSizeContext ctx) {
		Size result = (Size) getASGElement(ctx);

		if (result == null) {
			result = new SizeImpl(programUnit, ctx);

			final Call sizeCall = createCall(ctx.numericLiteral(), ctx.identifier());
			result.setSizeCall(sizeCall);

			size = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public Status addStatus(final ReceiveStatusContext ctx) {
		Status result = (Status) getASGElement(ctx);

		if (result == null) {
			result = new StatusImpl(programUnit, ctx);

			final Call statusCall = createCall(ctx.identifier());
			result.setStatusCall(statusCall);

			status = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public Thread addThread(final ReceiveThreadContext ctx) {
		Thread result = (Thread) getASGElement(ctx);

		if (result == null) {
			result = new ThreadImpl(programUnit, ctx);

			final Call threadInCall = createCall(ctx.dataName());
			result.setThreadInCall(threadInCall);

			thread = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public With addWith(final ReceiveWithContext ctx) {
		With result = (With) getASGElement(ctx);

		if (result == null) {
			result = new WithImpl(programUnit, ctx);

			result.setNoWait(true);

			with = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public Before getBefore() {
		return before;
	}

	@Override
	public Call getDataCall() {
		return dataCall;
	}

	@Override
	public From getFrom() {
		return from;
	}

	@Override
	public Size getSize() {
		return size;
	}

	@Override
	public Status getStatus() {
		return status;
	}

	@Override
	public Thread getThread() {
		return thread;
	}

	@Override
	public With getWith() {
		return with;
	}

	@Override
	public void setDataCall(final Call dataCall) {
		this.dataCall = dataCall;
	}

}
