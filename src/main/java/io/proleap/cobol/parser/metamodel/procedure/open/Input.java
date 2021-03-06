/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.open;

import io.proleap.cobol.parser.metamodel.CobolDivisionElement;
import io.proleap.cobol.parser.metamodel.call.Call;

public interface Input extends CobolDivisionElement {

	enum Type {
		NoRewind, Reversed
	}

	Call getFileCall();

	Type getType();

	void setFileCall(Call fileCall);

	void setType(Type type);
}
