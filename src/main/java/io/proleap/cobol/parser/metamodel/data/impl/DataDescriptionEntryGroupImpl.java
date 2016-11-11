/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.data.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.proleap.cobol.Cobol85Parser.DataDescriptionEntryFormat1Context;
import io.proleap.cobol.parser.metamodel.CobolDivision;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.data.DataDescriptionEntry;
import io.proleap.cobol.parser.metamodel.data.DataDescriptionEntryGroup;

public class DataDescriptionEntryGroupImpl extends DataDescriptionEntryImpl implements DataDescriptionEntryGroup {

	protected final DataDescriptionEntryFormat1Context ctx;

	protected List<DataDescriptionEntry> dataDescriptionEntries = new ArrayList<DataDescriptionEntry>();

	protected Map<String, DataDescriptionEntry> dataDescriptionEntriesByName = new HashMap<String, DataDescriptionEntry>();

	protected String pictureString;

	public DataDescriptionEntryGroupImpl(final String name, final ProgramUnit programUnit, final CobolDivision scope,
			final DataDescriptionEntryFormat1Context ctx) {
		super(name, programUnit, scope, ctx);

		this.ctx = ctx;
	}

	@Override
	public void addDataDescriptionEntry(final DataDescriptionEntry dataDescriptionEntry) {
		final String name = dataDescriptionEntry.getName();

		dataDescriptionEntries.add(dataDescriptionEntry);
		dataDescriptionEntriesByName.put(name, dataDescriptionEntry);
	}

	@Override
	public List<DataDescriptionEntry> getDataDescriptionEntries() {
		return dataDescriptionEntries;
	}

	@Override
	public DataDescriptionEntry getDataDescriptionEntry(final String name) {
		return dataDescriptionEntriesByName.get(name);
	}

	@Override
	public String getPictureString() {
		return pictureString;
	}

	@Override
	public Type getType() {
		final Type result;

		if (DataDescriptionEntry.LEVEL_NUMBER_SCALAR == levelNumber) {
			result = Type.Scalar;
		} else {
			result = Type.Group;
		}

		return result;
	}

	@Override
	public void setPictureString(final String pictureString) {
		this.pictureString = pictureString;
	}

}
