/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.environment.inputoutput.filecontrol;

import io.proleap.cobol.parser.metamodel.CobolDivisionElement;
import io.proleap.cobol.parser.metamodel.call.Call;

public interface AlternateRecordKeyClause extends CobolDivisionElement {

	Call getDataCall();

	PasswordClause getPasswordClause();

	void setDataCall(Call dataCall);

	void setPasswordClause(PasswordClause passwordClause);

}
