package io.proleap.cobol.gpl.parser.procedure.merge;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import io.proleap.cobol.CobolTestSupport;
import io.proleap.cobol.parser.applicationcontext.CobolParserContext;
import io.proleap.cobol.parser.metamodel.CompilationUnit;
import io.proleap.cobol.parser.metamodel.Program;
import io.proleap.cobol.parser.metamodel.ProgramUnit;
import io.proleap.cobol.parser.metamodel.call.Call;
import io.proleap.cobol.parser.metamodel.procedure.ProcedureDivision;
import io.proleap.cobol.parser.metamodel.procedure.merge.Alphanumeric;
import io.proleap.cobol.parser.metamodel.procedure.merge.CollatingSequence;
import io.proleap.cobol.parser.metamodel.procedure.merge.Giving;
import io.proleap.cobol.parser.metamodel.procedure.merge.Givings;
import io.proleap.cobol.parser.metamodel.procedure.merge.MergeStatement;
import io.proleap.cobol.parser.metamodel.procedure.merge.National;
import io.proleap.cobol.parser.metamodel.procedure.merge.OnKey;
import io.proleap.cobol.parser.metamodel.procedure.merge.OutputProcedure;
import io.proleap.cobol.parser.metamodel.procedure.merge.OutputThrough;
import io.proleap.cobol.parser.metamodel.procedure.merge.Using;
import io.proleap.cobol.preprocessor.CobolPreprocessor.CobolSourceFormatEnum;

public class MergeStatementTest extends CobolTestSupport {

	@Override
	@Before
	public void setUp() throws Exception {
		super.setUp();
	}

	@Test
	public void test() throws Exception {
		final File inputFile = new File(
				"src/test/resources/io/proleap/cobol/gpl/parser/procedure/merge/MergeStatement.cbl");
		final Program program = CobolParserContext.getInstance().getParserRunner().analyzeFile(inputFile,
				CobolSourceFormatEnum.TANDEM);

		final CompilationUnit compilationUnit = program.getCompilationUnit("MergeStatement");
		final ProgramUnit programUnit = compilationUnit.getProgramUnit();
		final ProcedureDivision procedureDivision = programUnit.getProcedureDivision();

		{
			final MergeStatement mergeStatement = (MergeStatement) procedureDivision.getStatements().get(0);
			assertNotNull(mergeStatement);

			{
				final Call fileCall = mergeStatement.getFileCall();
				assertNotNull(fileCall);
				assertEquals(Call.CallType.UndefinedCall, fileCall.getCallType());
			}

			{
				assertEquals(2, mergeStatement.getOnKeys().size());

				{
					final OnKey onKey = mergeStatement.getOnKeys().get(0);
					assertEquals(OnKey.Type.Descending, onKey.getType());
					assertEquals(1, onKey.getKeyCalls().size());

					{
						final Call keyCall = onKey.getKeyCalls().get(0);
						assertEquals(Call.CallType.UndefinedCall, keyCall.getCallType());
					}
				}

				{
					final OnKey onKey = mergeStatement.getOnKeys().get(1);
					assertEquals(OnKey.Type.Ascending, onKey.getType());
					assertEquals(2, onKey.getKeyCalls().size());

					{
						final Call keyCall = onKey.getKeyCalls().get(0);
						assertEquals(Call.CallType.UndefinedCall, keyCall.getCallType());
					}

					{
						final Call keyCall = onKey.getKeyCalls().get(1);
						assertEquals(Call.CallType.UndefinedCall, keyCall.getCallType());
					}
				}
			}

			{
				final CollatingSequence collatingSequence = mergeStatement.getCollatingSequence();
				assertEquals(2, collatingSequence.getAlphabetCalls().size());

				{
					final Alphanumeric alphaNumeric = collatingSequence.getAlphaNumeric();
					assertNotNull(alphaNumeric);

					final Call alphabetCall = alphaNumeric.getAlphabetCall();
					assertEquals(Call.CallType.UndefinedCall, alphabetCall.getCallType());
				}

				{
					final National national = collatingSequence.getNational();
					assertNotNull(national);

					final Call alphabetCall = national.getAlphabetCall();
					assertEquals(Call.CallType.UndefinedCall, alphabetCall.getCallType());
				}
			}

			{
				assertEquals(1, mergeStatement.getUsings().size());

				final Using using = mergeStatement.getUsings().get(0);
				assertEquals(1, using.getFileCalls().size());

				final Call fileCall = using.getFileCalls().get(0);
				assertEquals(Call.CallType.UndefinedCall, fileCall.getCallType());
			}

			{
				final OutputProcedure outputProcedure = mergeStatement.getOutputProcedure();
				assertNotNull(outputProcedure);

				{
					final Call procedureCall = outputProcedure.getProcedureCall();
					assertNotNull(procedureCall);
					assertEquals(Call.CallType.UndefinedCall, procedureCall.getCallType());
				}

				{
					final OutputThrough outputThrough = outputProcedure.getOutputThrough();
					assertNotNull(outputThrough);

					final Call procedureCall = outputThrough.getProcedureCall();
					assertNotNull(procedureCall);
					assertEquals(Call.CallType.UndefinedCall, procedureCall.getCallType());
				}
			}

			{
				assertEquals(1, mergeStatement.getGivings().size());

				final Givings givings = mergeStatement.getGivings().get(0);
				assertNotNull(givings);
				assertEquals(1, givings.getGivings().size());

				{
					final Giving giving = givings.getGivings().get(0);
					assertNotNull(giving);
					assertEquals(Giving.CloseProcedure.NoRewind, giving.getCloseProcedure());

					final Call fileCall = giving.getFileCall();
					assertEquals(Call.CallType.UndefinedCall, fileCall.getCallType());
				}
			}
		}
	}
}