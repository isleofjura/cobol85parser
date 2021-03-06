/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.data.workingstorage.impl;

import io.proleap.cobol.Cobol85Parser.WorkingStorageSectionContext;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.data.datadescription.impl.DataDescriptionEntryContainerImpl;
import io.proleap.cobol.parser.metamodel.data.workingstorage.WorkingStorageSection;

public class WorkingStorageSectionImpl extends DataDescriptionEntryContainerImpl implements WorkingStorageSection {

	protected final WorkingStorageSectionContext ctx;

	public WorkingStorageSectionImpl(final ProgramUnit programUnit, final WorkingStorageSectionContext ctx) {
		super(programUnit, ctx);

		this.ctx = ctx;
	}

}
