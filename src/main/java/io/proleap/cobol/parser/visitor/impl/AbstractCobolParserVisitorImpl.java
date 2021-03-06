/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.visitor.impl;

import org.antlr.v4.runtime.tree.ParseTree;

import io.proleap.cobol.Cobol85BaseVisitor;
import io.proleap.cobol.parser.applicationcontext.CobolParserContext;
import io.proleap.cobol.parser.metamodel.ASGElement;
import io.proleap.cobol.parser.metamodel.CompilationUnit;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.Scope;
import io.proleap.cobol.parser.registry.ASGElementRegistry;
import io.proleap.cobol.parser.util.ANTLRUtils;
import io.proleap.cobol.parser.visitor.ParserVisitor;

public abstract class AbstractCobolParserVisitorImpl extends Cobol85BaseVisitor<Boolean> implements ParserVisitor {

	protected CompilationUnit findCompilationUnit(final ParseTree ctx) {
		final ASGElementRegistry registry = CobolParserContext.getInstance().getASGElementRegistry();
		return ANTLRUtils.findParent(CompilationUnit.class, ctx, registry);
	}

	protected ProgramUnit findProgramUnit(final ParseTree ctx) {
		final ASGElementRegistry registry = CobolParserContext.getInstance().getASGElementRegistry();
		return ANTLRUtils.findParent(ProgramUnit.class, ctx, registry);
	}

	protected Scope findScope(final ParseTree ctx) {
		final ASGElementRegistry registry = CobolParserContext.getInstance().getASGElementRegistry();
		return ANTLRUtils.findParent(Scope.class, ctx, registry);
	}

	protected ASGElement getASGElement(final ParseTree ctx) {
		final ASGElement result = CobolParserContext.getInstance().getASGElementRegistry().getASGElement(ctx);
		return result;
	}
}
