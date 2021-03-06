/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.data.file.impl;

import io.proleap.cobol.Cobol85Parser.CodeSetClauseContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.data.file.CodeSetClause;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;

public class CodeSetClauseImpl extends CobolDivisionElementImpl implements CodeSetClause {

	protected String alphabetName;

	protected final CodeSetClauseContext ctx;

	public CodeSetClauseImpl(final ProgramUnit programUnit, final CodeSetClauseContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public String getAlphabetName() {
		return alphabetName;
	}

	@Override
	public void setAlhpabetName(final String alphabetName) {
		this.alphabetName = alphabetName;
	}

}
