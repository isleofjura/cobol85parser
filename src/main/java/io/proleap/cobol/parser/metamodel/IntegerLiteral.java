/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel;

import io.proleap.cobol.Cobol85Parser.IntegerLiteralContext;

public interface IntegerLiteral extends CobolDivisionElement {

	@Override
	IntegerLiteralContext getCtx();

	Integer getValue();
}
