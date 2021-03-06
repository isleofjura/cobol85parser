/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.data.programlibrary;

import io.proleap.cobol.parser.metamodel.CobolDivisionElement;
import io.proleap.cobol.parser.metamodel.Literal;

public interface ImportAttribute extends CobolDivisionElement {

	enum Type {
		ByFunction, ByTitle
	}

	Literal getFunctionLiteral();

	Literal getParameterLiteral();

	Literal getTitleLiteral();

	Type getType();

	void setFunctionLiteral(Literal functionLiteral);

	void setParameterLiteral(Literal parameterLiteral);

	void setTitleLiteral(Literal titleLiteral);

	void setType(Type type);
}
