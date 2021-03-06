/*
 * Copyright (C) 2016, Ulrich Wolffgang <u.wol@wwu.de>
 * All rights reserved.
 *
 * This software may be modified and distributed under the terms
 * of the BSD 3-clause license. See the LICENSE file for details.
 */

package io.proleap.cobol.parser.visitor.impl;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTree;

import io.proleap.cobol.Cobol85Parser;
import io.proleap.cobol.parser.applicationcontext.CobolParserContext;
import io.proleap.cobol.parser.metamodel.Scope;
import io.proleap.cobol.parser.metamodel.procedure.ProcedureDivision;
import io.proleap.cobol.parser.registry.ASGElementRegistry;
import io.proleap.cobol.parser.util.ANTLRUtils;

/**
 * Visitor for analyzing statements in the AST.
 */
public class CobolProcedureStatementVisitorImpl extends AbstractCobolParserVisitorImpl {

	protected ProcedureDivision findProcedureDivision(final ParseTree ctx) {
		final ASGElementRegistry registry = CobolParserContext.getInstance().getASGElementRegistry();
		return ANTLRUtils.findParent(ProcedureDivision.class, ctx, registry);
	}

	@Override
	public Boolean visitAcceptStatement(@NotNull final Cobol85Parser.AcceptStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addAcceptStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitAddStatement(@NotNull final Cobol85Parser.AddStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addAddStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitAlterStatement(@NotNull final Cobol85Parser.AlterStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addAlterStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitCallStatement(@NotNull final Cobol85Parser.CallStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addCallStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitCancelStatement(@NotNull final Cobol85Parser.CancelStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addCancelStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitCloseStatement(@NotNull final Cobol85Parser.CloseStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addCloseStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitComputeStatement(@NotNull final Cobol85Parser.ComputeStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addComputeStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitContinueStatement(@NotNull final Cobol85Parser.ContinueStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addContinueStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitDeleteStatement(@NotNull final Cobol85Parser.DeleteStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addDeleteStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitDisableStatement(@NotNull final Cobol85Parser.DisableStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addDisableStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitDisplayStatement(@NotNull final Cobol85Parser.DisplayStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addDisplayStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitDivideStatement(@NotNull final Cobol85Parser.DivideStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addDivideStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitEnableStatement(@NotNull final Cobol85Parser.EnableStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addEnableStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitEntryStatement(@NotNull final Cobol85Parser.EntryStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addEntryStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitEvaluateStatement(@NotNull final Cobol85Parser.EvaluateStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addEvaluateStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitExitStatement(@NotNull final Cobol85Parser.ExitStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addExitStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitGenerateStatement(@NotNull final Cobol85Parser.GenerateStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addGenerateStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitGobackStatement(@NotNull final Cobol85Parser.GobackStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addGobackStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitGoToStatement(@NotNull final Cobol85Parser.GoToStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addGoToStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitIfStatement(@NotNull final Cobol85Parser.IfStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addIfStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitInitializeStatement(@NotNull final Cobol85Parser.InitializeStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addInitializeStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitInitiateStatement(@NotNull final Cobol85Parser.InitiateStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addInitiateStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitInspectStatement(@NotNull final Cobol85Parser.InspectStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addInspectStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitMergeStatement(@NotNull final Cobol85Parser.MergeStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addMergeStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitMoveToStatement(@NotNull final Cobol85Parser.MoveToStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addMoveToStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitMultiplyStatement(@NotNull final Cobol85Parser.MultiplyStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addMultiplyStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitOpenStatement(@NotNull final Cobol85Parser.OpenStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addOpenStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitPerformStatement(@NotNull final Cobol85Parser.PerformStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addPerformStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitPurgeStatement(@NotNull final Cobol85Parser.PurgeStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addPurgeStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitReadStatement(@NotNull final Cobol85Parser.ReadStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addReadStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitReceiveStatement(@NotNull final Cobol85Parser.ReceiveStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addReceiveStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitReleaseStatement(@NotNull final Cobol85Parser.ReleaseStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addReleaseStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitReturnStatement(@NotNull final Cobol85Parser.ReturnStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addReturnStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitRewriteStatement(@NotNull final Cobol85Parser.RewriteStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addRewriteStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitSearchStatement(@NotNull final Cobol85Parser.SearchStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addSearchStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitSendStatement(@NotNull final Cobol85Parser.SendStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addSendStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitSetStatement(@NotNull final Cobol85Parser.SetStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addSetStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitSortStatement(@NotNull final Cobol85Parser.SortStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addSortStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitStartStatement(@NotNull final Cobol85Parser.StartStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addStartStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitStopStatement(@NotNull final Cobol85Parser.StopStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addStopStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitStringStatement(@NotNull final Cobol85Parser.StringStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addStringStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitSubtractStatement(@NotNull final Cobol85Parser.SubtractStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addSubtractStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitTerminateStatement(@NotNull final Cobol85Parser.TerminateStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addTerminateStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitUnstringStatement(@NotNull final Cobol85Parser.UnstringStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addUnstringStatement(ctx);

		return visitChildren(ctx);
	}

	@Override
	public Boolean visitWriteStatement(@NotNull final Cobol85Parser.WriteStatementContext ctx) {
		final Scope scope = findScope(ctx);

		scope.addWriteStatement(ctx);

		return visitChildren(ctx);
	}

}
