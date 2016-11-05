/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.visitor.impl;

import org.antlr.v4.runtime.misc.NotNull;

import io.proleap.cobol.Cobol85Parser;
import io.proleap.cobol.parser.metamodel.Program;
import io.proleap.cobol.parser.metamodel.impl.CopyBookImpl;

/**
 * Visitor for collecting units in the AST.
 */
public class CobolUnitVisitorImpl extends AbstractCobolParserVisitorImpl {

	protected final String copyBookName;

	protected final Program program;

	public CobolUnitVisitorImpl(final Program program, final String copyBookName) {
		super(null);

		this.program = program;
		this.copyBookName = copyBookName;
	}

	@Override
	public Boolean visitCompilationUnit(@NotNull final Cobol85Parser.CompilationUnitContext ctx) {
		copyBook = new CopyBookImpl(copyBookName, program, ctx);

		return visitChildren(ctx);
	}

}