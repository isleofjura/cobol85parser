/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.evaluate.impl;

import io.proleap.cobol.Cobol85Parser.EvaluateAlsoConditionContext;
import io.proleap.cobol.Cobol85Parser.EvaluateConditionContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.parser.metamodel.procedure.evaluate.AlsoCondition;
import io.proleap.cobol.parser.metamodel.procedure.evaluate.Condition;
import io.proleap.cobol.parser.metamodel.valuestmt.ValueStmt;

public class AlsoConditionImpl extends CobolDivisionElementImpl implements AlsoCondition {

	protected Condition condition;

	protected final EvaluateAlsoConditionContext ctx;

	public AlsoConditionImpl(final ProgramUnit programUnit, final EvaluateAlsoConditionContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public Condition addCondition(final EvaluateConditionContext ctx) {
		Condition result = (Condition) getASGElement(ctx);

		if (result == null) {
			result = new ConditionImpl(programUnit, ctx);

			// type and condition
			final Condition.Type type;
			final ValueStmt conditionValueStmt;

			if (ctx.ANY() != null) {
				type = Condition.Type.Any;
				conditionValueStmt = null;
			} else if (ctx.condition() != null) {
				type = Condition.Type.Condition;
				conditionValueStmt = createConditionValueStmt(ctx.condition());
			} else if (ctx.booleanLiteral() != null) {
				type = Condition.Type.Boolean;
				conditionValueStmt = createBooleanLiteralValueStmt(ctx.booleanLiteral());
			} else if (ctx.evaluateThrough() != null) {
				type = Condition.Type.ValueThrough;
				conditionValueStmt = null;
			} else if (ctx.evaluateValue() != null) {
				type = Condition.Type.Value;
				conditionValueStmt = null;
			} else {
				type = null;
				conditionValueStmt = null;
			}

			result.setType(type);
			result.setConditionValueStmt(conditionValueStmt);

			// not
			if (ctx.NOT() != null) {
				result.setNot(true);
			}

			// value
			if (ctx.evaluateValue() != null) {
				result.addValue(ctx.evaluateValue());
			}

			// through
			if (ctx.evaluateThrough() != null) {
				result.addThrough(ctx.evaluateThrough());
			}

			condition = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public Condition getCondition() {
		return condition;
	}

}
