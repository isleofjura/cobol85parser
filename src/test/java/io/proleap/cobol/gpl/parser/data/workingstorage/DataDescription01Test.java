package io.proleap.cobol.gpl.parser.data.workingstorage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import io.proleap.cobol.CobolTestSupport;
import io.proleap.cobol.parser.applicationcontext.CobolParserContext;
import io.proleap.cobol.parser.metamodel.CompilationUnit;
import io.proleap.cobol.parser.metamodel.Program;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.data.DataDivision;
import io.proleap.cobol.parser.metamodel.data.datadescription.DataDescriptionEntry;
import io.proleap.cobol.parser.metamodel.data.workingstorage.WorkingStorageSection;
import io.proleap.cobol.preprocessor.CobolPreprocessor.CobolSourceFormatEnum;

public class DataDescription01Test extends CobolTestSupport {

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void test() throws Exception {
		final File inputFile = new File(
				"src/test/resources/io/proleap/cobol/gpl/parser/data/workingstorage/DataDescription01.cbl");
		final Program program = CobolParserContext.getInstance().getParserRunner().analyzeFile(inputFile,
				CobolSourceFormatEnum.TANDEM);

		final CompilationUnit compilationUnit = program.getCompilationUnit("DataDescription01");
		final ProgramUnit programUnit = compilationUnit.getProgramUnit();
		final DataDivision dataDivision = programUnit.getDataDivision();
		final WorkingStorageSection workingStorageSection = dataDivision.getWorkingStorageSection();

		assertEquals(3, workingStorageSection.getDataDescriptionEntries().size());
		assertEquals(1, workingStorageSection.getRootDataDescriptionEntries().size());

		final DataDescriptionEntry dataDescriptionEntryItems = workingStorageSection.getDataDescriptionEntry("ITEMS");

		assertNotNull(dataDescriptionEntryItems);
		assertEquals("ITEMS", dataDescriptionEntryItems.getName());
		assertEquals(DataDescriptionEntry.Type.Group, dataDescriptionEntryItems.getType());
		assertEquals(new Integer(1), dataDescriptionEntryItems.getLevelNumber());
		assertNull(dataDescriptionEntryItems.getParentDataDescriptionEntryGroup());

		final DataDescriptionEntry dataDescriptionEntryItem1 = workingStorageSection.getDataDescriptionEntry("ITEM1");
		assertNotNull(dataDescriptionEntryItem1);
		assertEquals("ITEM1", dataDescriptionEntryItem1.getName());
		assertEquals(DataDescriptionEntry.Type.Group, dataDescriptionEntryItem1.getType());
		assertEquals(new Integer(2), dataDescriptionEntryItem1.getLevelNumber());
		assertEquals(dataDescriptionEntryItems, dataDescriptionEntryItem1.getParentDataDescriptionEntryGroup());

		final DataDescriptionEntry dataDescriptionEntryItem2 = workingStorageSection.getDataDescriptionEntry("ITEM2");
		assertNotNull(dataDescriptionEntryItem2);
		assertEquals("ITEM2", dataDescriptionEntryItem2.getName());
		assertEquals(DataDescriptionEntry.Type.Group, dataDescriptionEntryItem2.getType());
		assertEquals(new Integer(2), dataDescriptionEntryItem2.getLevelNumber());
		assertEquals(dataDescriptionEntryItems, dataDescriptionEntryItem2.getParentDataDescriptionEntryGroup());
	}
}
