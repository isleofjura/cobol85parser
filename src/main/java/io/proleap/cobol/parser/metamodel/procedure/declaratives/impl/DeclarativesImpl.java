/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.declaratives.impl;

import java.util.ArrayList;
import java.util.List;

import io.proleap.cobol.Cobol85Parser.ProcedureDeclarativeContext;
import io.proleap.cobol.Cobol85Parser.ProcedureDeclarativesContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.parser.metamodel.procedure.declaratives.Declarative;
import io.proleap.cobol.parser.metamodel.procedure.declaratives.Declaratives;

public class DeclarativesImpl extends CobolDivisionElementImpl implements Declaratives {

	protected final ProcedureDeclarativesContext ctx;

	protected List<Declarative> declaratives = new ArrayList<Declarative>();

	public DeclarativesImpl(final ProgramUnit programUnit, final ProcedureDeclarativesContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public Declarative addDeclarative(final ProcedureDeclarativeContext ctx) {
		Declarative result = (Declarative) getASGElement(ctx);

		if (result == null) {
			result = new DeclarativeImpl(programUnit, ctx);

			result.addSectionHeader(ctx.procedureSectionHeader());
			result.addUseStatement(ctx.useStatement());

			declaratives.add(result);
			registerASGElement(result);
		}

		return result;
	}

	@Override
	public List<Declarative> getDeclaratives() {
		return declaratives;
	}

}
