/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.start;

import io.proleap.cobol.parser.metamodel.CobolDivisionElement;
import io.proleap.cobol.parser.metamodel.call.Call;

public interface Key extends CobolDivisionElement {

	enum Type {
		Equal, Greater, GreaterOrEqual
	}

	Call getComparisonCall();

	Type getType();

	void setComparisonCall(Call comparisonCall);

	void setType(Type type);
}
