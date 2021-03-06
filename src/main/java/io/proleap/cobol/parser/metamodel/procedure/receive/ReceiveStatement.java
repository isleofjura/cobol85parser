/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.receive;

import io.proleap.cobol.Cobol85Parser.ReceiveFromStatementContext;
import io.proleap.cobol.Cobol85Parser.ReceiveIntoStatementContext;
import io.proleap.cobol.parser.metamodel.procedure.NotOnException;
import io.proleap.cobol.parser.metamodel.procedure.OnException;
import io.proleap.cobol.parser.metamodel.procedure.Statement;

/**
 * Obtains data from another program.
 */
public interface ReceiveStatement extends Statement {

	enum Type {
		From, Into
	}

	ReceiveFromStatement addReceiveFromStatement(ReceiveFromStatementContext ctx);

	ReceiveIntoStatement addReceiveIntoStatement(ReceiveIntoStatementContext ctx);

	NotOnException getNotOnException();

	OnException getOnException();

	ReceiveFromStatement getReceiveFromStatement();

	ReceiveIntoStatement getReceiveIntoStatement();

	Type getType();

	void setNotOnException(NotOnException notOnException);

	void setOnException(OnException onException);

	void setType(Type type);

}
