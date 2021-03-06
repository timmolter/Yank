package org.knowm.yank.handlers;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class BigDecimalScalarHandler extends ScalarHandler<BigDecimal> {

  /** The column number to retrieve. */
  private final int columnIndex;

  /** The column name to retrieve. Either columnName or columnIndex will be used but never both. */
  private final String columnName;

  /**
   * Creates a new instance of ColumnListHandler. The first column of each row will be returned from
   * <code>handle()</code>.
   */
  public BigDecimalScalarHandler() {
    this(1, null);
  }

  /**
   * Creates a new instance of ColumnListHandler.
   *
   * @param columnIndex The index of the column to retrieve from the <code>ResultSet</code>.
   */
  public BigDecimalScalarHandler(int columnIndex) {
    this(columnIndex, null);
  }

  /**
   * Creates a new instance of ColumnListHandler.
   *
   * @param columnName The name of the column to retrieve from the <code>ResultSet</code>.
   */
  public BigDecimalScalarHandler(String columnName) {
    this(1, columnName);
  }

  /**
   * Private Helper
   *
   * @param columnIndex The index of the column to retrieve from the <code>ResultSet</code>.
   * @param columnName The name of the column to retrieve from the <code>ResultSet</code>.
   */
  private BigDecimalScalarHandler(int columnIndex, String columnName) {
    super();
    this.columnIndex = columnIndex;
    this.columnName = columnName;
  }

  /**
   * Returns one <code>ResultSet</code> column as an object via the <code>ResultSet.getObject()
   * </code> method that performs type conversions.
   *
   * @param rs <code>ResultSet</code> to process.
   * @return The column or <code>null</code> if there are no rows in the <code>ResultSet</code>.
   * @throws SQLException if a database access error occurs
   * @throws ClassCastException if the class datatype does not match the column type
   * @see org.apache.commons.dbutils.ResultSetHandler#handle(java.sql.ResultSet)
   */
  @Override
  public BigDecimal handle(ResultSet rs) throws SQLException {

    if (rs.next()) {
      if (this.columnName == null) {
        return new BigDecimal(((Number) rs.getObject(this.columnIndex)).toString());
      }
      return new BigDecimal(((Number) rs.getObject(this.columnIndex)).toString());
    }
    return null;
  }
}
