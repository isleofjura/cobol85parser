/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.sort.impl;

import io.proleap.cobol.Cobol85Parser.SortDuplicatesPhraseContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.impl.CobolDivisionElementImpl;
import io.proleap.cobol.parser.metamodel.procedure.sort.Duplicates;

public class DuplicatesImpl extends CobolDivisionElementImpl implements Duplicates {

	protected final SortDuplicatesPhraseContext ctx;

	protected boolean duplicatesInOrder;

	public DuplicatesImpl(final ProgramUnit programUnit, final SortDuplicatesPhraseContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

	@Override
	public boolean isDuplicatesInOrder() {
		return duplicatesInOrder;
	}

	@Override
	public void setDuplicatesInOrder(final boolean duplicatesInOrder) {
		this.duplicatesInOrder = duplicatesInOrder;
	}

}
