/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.metamodel.data;

import java.util.List;

public interface DataDescriptionEntryGroup extends DataDescriptionEntry {

	void addDataDescriptionEntry(DataDescriptionEntry dataDescriptionEntry);

	List<DataDescriptionEntry> getDataDescriptionEntries();

	DataDescriptionEntry getDataDescriptionEntry(String name);

	String getPictureString();

	void setPictureString(String pictureString);

}
