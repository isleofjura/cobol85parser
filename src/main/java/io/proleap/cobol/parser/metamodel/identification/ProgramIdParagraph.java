/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.identification;

import io.proleap.cobol.parser.metamodel.CobolDivisionElement;
import io.proleap.cobol.parser.metamodel.NamedElement;

/**
 * Specifies program name and assigns attributes to it.
 */
public interface ProgramIdParagraph extends CobolDivisionElement, NamedElement {

	enum Attribute {
		Common, Definition, Initial, Library
	}

	Attribute getAttribute();

	void setAttribute(Attribute attribute);
}
