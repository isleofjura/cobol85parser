/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel;

import java.util.Collection;

public interface Program extends ASGElement {

	CompilationUnit getCompilationUnit(String name);

	Collection<CompilationUnit> getCompilationUnits();

	void registerCompilationUnit(CompilationUnit compilationUnit);
}
