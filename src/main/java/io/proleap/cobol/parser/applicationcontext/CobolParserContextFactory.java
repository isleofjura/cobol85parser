/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.applicationcontext;

import io.proleap.cobol.applicationcontext.CobolGrammarContextFactory;
import io.proleap.cobol.parser.registry.impl.ASGElementRegistryImpl;
import io.proleap.cobol.parser.resolver.impl.NameResolverImpl;
import io.proleap.cobol.parser.runner.impl.CobolParserRunnerImpl;

public class CobolParserContextFactory {

	public static void configureDefaultApplicationContext() {
		CobolGrammarContextFactory.configureDefaultApplicationContext();

		CobolParserContext.getInstance().reset();

		CobolParserContext.getInstance().setASGElementRegistry(new ASGElementRegistryImpl());
		CobolParserContext.getInstance().setNameResolver(new NameResolverImpl());
		CobolParserContext.getInstance().setParserRunner(new CobolParserRunnerImpl());
	}
}
