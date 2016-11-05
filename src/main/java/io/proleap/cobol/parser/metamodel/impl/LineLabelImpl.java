/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.impl;

import io.proleap.cobol.Cobol85Parser.ParagraphNameContext;
import io.proleap.cobol.parser.metamodel.CobolScope;
import io.proleap.cobol.parser.metamodel.CopyBook;
import io.proleap.cobol.parser.metamodel.LineLabel;

public class LineLabelImpl extends CobolScopedElementImpl implements LineLabel {

	protected final ParagraphNameContext ctx;

	protected final String name;

	public LineLabelImpl(final String name, final CopyBook copyBook, final CobolScope superScope,
			final ParagraphNameContext ctx) {
		super(copyBook, superScope, ctx);

		this.name = name;
		this.ctx = ctx;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "name=[" + name + "]";
	}

}