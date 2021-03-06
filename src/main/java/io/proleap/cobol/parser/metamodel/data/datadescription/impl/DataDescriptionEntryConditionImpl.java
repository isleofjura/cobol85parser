/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.data.datadescription.impl;

import io.proleap.cobol.Cobol85Parser.DataDescriptionEntryFormat3Context;
import io.proleap.cobol.Cobol85Parser.DataValueClauseContext;
import io.proleap.cobol.Cobol85Parser.DataValueIntervalContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.data.datadescription.DataDescriptionEntryCondition;
import io.proleap.cobol.parser.metamodel.data.datadescription.ValueClause;

public class DataDescriptionEntryConditionImpl extends DataDescriptionEntryImpl
		implements DataDescriptionEntryCondition {

	protected final DataDescriptionEntryFormat3Context ctx;

	protected ValueClause valueClause;

	public DataDescriptionEntryConditionImpl(final String name, final ProgramUnit programUnit,
			final DataDescriptionEntryFormat3Context ctx) {
		super(name, programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public ValueClause addValueClause(final DataValueClauseContext ctx) {
		ValueClause result = (ValueClause) getASGElement(ctx);

		if (result == null) {
			result = new ValueClauseImpl(programUnit, ctx);

			for (final DataValueIntervalContext dataValueIntervalContext : ctx.dataValueInterval()) {
				result.addValueInterval(dataValueIntervalContext);
			}

			valueClause = result;
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public Type getType() {
		return Type.Condition;
	}

	@Override
	public ValueClause getValueClause() {
		return valueClause;
	}

}
