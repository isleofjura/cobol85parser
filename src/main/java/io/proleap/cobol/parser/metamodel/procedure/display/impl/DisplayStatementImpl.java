/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.display.impl;

import java.util.ArrayList;
import java.util.List;

import io.proleap.cobol.Cobol85Parser.DisplayAtContext;
import io.proleap.cobol.Cobol85Parser.DisplayOperandContext;
import io.proleap.cobol.Cobol85Parser.DisplayStatementContext;
import io.proleap.cobol.Cobol85Parser.DisplayUponContext;
import io.proleap.cobol.Cobol85Parser.DisplayWithContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.Scope;
import io.proleap.cobol.parser.metamodel.call.Call;
import io.proleap.cobol.parser.metamodel.procedure.display.At;
import io.proleap.cobol.parser.metamodel.procedure.display.DisplayStatement;
import io.proleap.cobol.parser.metamodel.procedure.display.Operand;
import io.proleap.cobol.parser.metamodel.procedure.display.Upon;
import io.proleap.cobol.parser.metamodel.procedure.display.With;
import io.proleap.cobol.parser.metamodel.procedure.impl.StatementImpl;

public class DisplayStatementImpl extends StatementImpl implements DisplayStatement {

	protected At at;

	protected final DisplayStatementContext ctx;

	protected List<Operand> operands = new ArrayList<Operand>();

	protected Upon upon;

	protected With with;

	public DisplayStatementImpl(final ProgramUnit programUnit, final Scope scope, final DisplayStatementContext ctx) {
		super(programUnit, scope, ctx);

		this.ctx = ctx;
	}

	@Override
	public At addAt(final DisplayAtContext ctx) {
		At result = (At) getASGElement(ctx);

		if (result == null) {
			result = new AtImpl(programUnit, ctx);

			final Call atCall = createCall(ctx.identifier(), ctx.literal());
			result.setAtCall(atCall);

			at = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public Operand addOperand(final DisplayOperandContext ctx) {
		Operand result = (Operand) getASGElement(ctx);

		if (result == null) {
			result = new OperandImpl(programUnit, ctx);

			final Call operandCall = createCall(ctx.identifier(), ctx.literal(), ctx.otherKeyword());
			result.setOperandCall(operandCall);

			operands.add(result);
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public Upon addUpon(final DisplayUponContext ctx) {
		Upon result = (Upon) getASGElement(ctx);

		if (result == null) {
			result = new UponImpl(programUnit, ctx);

			final Call uponCall = createCall(ctx.mnemonicName(), ctx.mnemonicName());
			result.setUponCall(uponCall);

			upon = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public With addWith(final DisplayWithContext ctx) {
		With result = (With) getASGElement(ctx);

		if (result == null) {
			result = new WithImpl(programUnit, ctx);

			// no advancing
			result.setNoAdvancing(true);

			with = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public At getAt() {
		return at;
	}

	@Override
	public List<Operand> getOperands() {
		return operands;
	}

	@Override
	public Upon getUpon() {
		return upon;
	}

	@Override
	public With getWith() {
		return with;
	}

}
