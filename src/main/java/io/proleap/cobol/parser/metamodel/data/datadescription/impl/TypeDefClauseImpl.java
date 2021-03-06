/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.data.datadescription.impl;

import io.proleap.cobol.Cobol85Parser.DataTypeDefClauseContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.data.datadescription.TypeDefClause;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;

public class TypeDefClauseImpl extends CobolDivisionElementImpl implements TypeDefClause {

	protected DataTypeDefClauseContext ctx;

	protected boolean typeDef;

	public TypeDefClauseImpl(final ProgramUnit programUnit, final DataTypeDefClauseContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public boolean isTypeDef() {
		return typeDef;
	}

	@Override
	public void setTypeDef(final boolean typeDef) {
		this.typeDef = typeDef;
	}

}
