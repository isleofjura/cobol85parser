/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.enable;

import io.proleap.cobol.parser.metamodel.call.Call;
import io.proleap.cobol.parser.metamodel.procedure.Statement;
import io.proleap.cobol.parser.metamodel.procedure.disable.DisableStatement;

/**
 * Notifies the MCS to allow data transfer between specified output queues and
 * destinations (for output) or between specified sources and input queues (for
 * input).
 *
 * @see DisableStatement
 */
public interface EnableStatement extends Statement {

	enum Type {
		Input, InputOutput, Output
	}

	Call getCommunicationDescriptionCall();

	Call getKeyCall();

	Type getType();

	boolean isTerminal();

	void setCommunicationDescriptionCall(Call communicationDescriptionCall);

	void setKeyCall(Call keyCall);

	void setTerminal(boolean terminal);

	void setType(Type type);

}
