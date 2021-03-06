/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.use;

import java.util.List;

import io.proleap.cobol.parser.metamodel.CobolDivisionElement;
import io.proleap.cobol.parser.metamodel.call.Call;

public interface AfterOn extends CobolDivisionElement {

	enum Type {
		Extend, File, Input, InputOutput, Output
	}

	void addFileCall(Call fileCall);

	List<Call> getFileCalls();

	Type getType();

	void setType(Type type);

}
