package com.ontimize.jee.common.db.sql;

import java.util.List;

public class SQLUnique extends SQLConstraint {

    protected static final String UNIQUE = "UNIQUE ";

    /**
     * Creates a new <code>SQLUnique</code> indicating the name of the constraint and the columns in
     * where the constraint is applied.
     * @param constraintName The name of the constraint.
     * @param columns The column/s that are going to be included into the constraint.
     */
    public SQLUnique(String constraintName, List columns) {
        this.constraintName = constraintName;
        this.columns = columns;
    }

    /**
     * Creates a new <code>SQLPrimaryKey</code> just indicating the column/s in where the constraint is
     * applied. The name of the constraint is generated by default.
     * @param columns The column/s that are going to be included into the constraint.
     */
    public SQLUnique(List columns) {
        this.columns = columns;
    }

    /**
     * This method returns the SQL Statement to add a Unique constraint to a database table. Returns a
     * <code>String<code> with the SQL Statement.
     */
    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();

        if (this.getConstraintName() != null) {
            buffer.append(SQLConstraint.CONSTRAINT);
            buffer.append(this.getConstraintName()).append(" ");
        }
        buffer.append(SQLUnique.UNIQUE);
        buffer.append(this.getColumnList());
        return buffer.toString();
    }

}