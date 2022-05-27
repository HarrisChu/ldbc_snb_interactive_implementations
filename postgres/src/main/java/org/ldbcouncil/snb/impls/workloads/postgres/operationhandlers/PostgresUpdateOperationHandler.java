package org.ldbcouncil.snb.impls.workloads.postgres.operationhandlers;

import org.ldbcouncil.snb.driver.Operation;
import org.ldbcouncil.snb.driver.workloads.interactive.LdbcNoResult;
import org.ldbcouncil.snb.impls.workloads.operationhandlers.UpdateOperationHandler;
import org.ldbcouncil.snb.impls.workloads.postgres.PostgresDbConnectionState;

public abstract class PostgresUpdateOperationHandler<TOperation extends Operation<LdbcNoResult>>
        extends PostgresOperationHandler
        implements UpdateOperationHandler<TOperation, PostgresDbConnectionState> {

    @Override
    public String getQueryString(PostgresDbConnectionState state, TOperation operation) {
        throw new IllegalStateException();
    }

}