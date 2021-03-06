/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.procedure.send;

import io.proleap.cobol.Cobol85Parser.SendAdvancingPhraseContext;
import io.proleap.cobol.Cobol85Parser.SendFromPhraseContext;
import io.proleap.cobol.Cobol85Parser.SendWithPhraseContext;
import io.proleap.cobol.parser.metamodel.CobolDivisionElement;
import io.proleap.cobol.parser.metamodel.call.Call;

public interface Sync extends CobolDivisionElement {

	Advancing addAdvancing(SendAdvancingPhraseContext ctx);

	From addFrom(SendFromPhraseContext ctx);

	With addWith(SendWithPhraseContext ctx);

	Advancing getAdvancing();

	From getFrom();

	Call getReceivingProgramCall();

	boolean isReplacing();

	With getWith();

	void setReceivingProgramCall(Call receivingProgramCall);

	void setReplacing(boolean replacing);

}
