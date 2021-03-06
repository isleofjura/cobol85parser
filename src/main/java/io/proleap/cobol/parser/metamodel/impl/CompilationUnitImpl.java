/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.impl;

import java.util.ArrayList;
import java.util.List;

import org.antlr.v4.runtime.tree.ParseTree;

import io.proleap.cobol.Cobol85Parser.CompilationUnitContext;
import io.proleap.cobol.Cobol85Parser.ProgramUnitContext;
import io.proleap.cobol.parser.applicationcontext.CobolParserContext;
import io.proleap.cobol.parser.metamodel.ASGElement;
import io.proleap.cobol.parser.metamodel.CompilationUnit;
import io.proleap.cobol.parser.metamodel.Program;
import io.proleap.cobol.parser.metamodel.ProgramUnit;

public class CompilationUnitImpl extends ASGElementImpl implements CompilationUnit {

	protected CompilationUnitContext ctx;

	protected final String name;

	protected final Program program;

	protected final List<ProgramUnit> programUnits = new ArrayList<ProgramUnit>();

	public CompilationUnitImpl(final String name, final Program program, final CompilationUnitContext ctx) {
		super(ctx);

		this.name = name;
		this.program = program;
		this.ctx = ctx;

		registerASGElement(this);
		program.registerCompilationUnit(this);
	}

	@Override
	public ProgramUnit addProgramUnit(final ProgramUnitContext ctx) {
		ProgramUnit result = (ProgramUnit) getASGElement(ctx);

		if (result == null) {
			result = new ProgramUnitImpl(this, ctx);

			registerASGElement(result);
			programUnits.add(result);

			// identification division
			result.addIdentificationDivision(ctx.identificationDivision());

			// environment division
			if (ctx.environmentDivision() != null) {
				result.addEnvironmentDivision(ctx.environmentDivision());
			}

			// data division
			if (ctx.dataDivision() != null) {
				result.addDataDivision(ctx.dataDivision());
			}

			// procedure division
			if (ctx.procedureDivision() != null) {
				result.addProcedureDivision(ctx.procedureDivision());
			}
		}

		return result;
	}

	protected ASGElement getASGElement(final ParseTree ctx) {
		final ASGElement result = CobolParserContext.getInstance().getASGElementRegistry().getASGElement(ctx);
		return result;
	}

	@Override
	public CompilationUnitContext getCtx() {
		return ctx;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ProgramUnit getProgramUnit() {
		final ProgramUnit result;

		if (programUnits.isEmpty()) {
			result = null;
		} else {
			result = programUnits.get(0);
		}

		return result;
	}

	@Override
	public List<ProgramUnit> getProgramUnits() {
		return programUnits;
	}

	protected void registerASGElement(final ASGElement asgElement) {
		assert asgElement != null;
		assert asgElement.getCtx() != null;

		CobolParserContext.getInstance().getASGElementRegistry().addASGElement(asgElement);
	}

	@Override
	public String toString() {
		return "name=[" + name + "]";
	}
}
