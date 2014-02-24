package fr.iut2.sil4.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.Column;
import org.apache.torque.TorqueException;
import org.apache.torque.criteria.CriteriaInterface;
import org.apache.torque.om.mapper.RecordMapper;


/**
 * Maps ResultSet rows into Abscence objects.
 *
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Sun Feb 23 23:29:29 CET 2014]
 *
 */
public class BaseAbscenceRecordMapper implements RecordMapper<Abscence>
{

    /** The class log. */
    private static Log log
            = LogFactory.getLog(BaseAbscenceRecordMapper.class);

    /**
     * Constructs the object from the current row in the resultSet.
     *
     * @param resultSet the resultSet to operate on, already pointing
     *        to the correct row. Not null.
     * @param a possible offset in the columns to be considered
     *        (if previous columns contain other objects),
     *        or 0 for no offset.
     * @param criteria The criteria which created the result set.
     *        If set, the attributes to set in the data object
     *        are determined from the select columns in the criteria;
     *        if no matching column can be found, null is returned.
     *        If not set, all of the table's columns are read from the
     *        result set in the order defined in the table definition.
     *
     * @return the mapped object, not null.
     *
     * @throws TorqueException when reading fields from the RecordSet fails
     *         or if a Criteria is passed which contains select columns other
     *         than the columns in the abscence table.
     */
    public Abscence processRow(
                ResultSet resultSet,
                int offset,
                CriteriaInterface<?> criteria)
            throws TorqueException
    {
        Abscence abscence = new Abscence();

        try 
        {
            abscence.setLoading(true);
            if (criteria == null)
            {
                abscence.setAbscenceId(
                        getAbscenceId(resultSet, offset + 1));
                abscence.setDate(
                        getDate(resultSet, offset + 2));
                abscence.setMotif(
                        getMotif(resultSet, offset + 3));
                abscence.setStudentId(
                        getStudentId(resultSet, offset + 4));
            }
            else
            {
                // try to get columns to be mapped
                // from criteria's select columns
                boolean columnMapped = false;
                int totalOffset = offset + 1;
                List<Column> selectColumns = criteria.getSelectColumns();
                List<Column> columnsWithoutOffset = selectColumns.subList(
                        offset, 
                        selectColumns.size());
                for (Column column : columnsWithoutOffset)
                {
                    if (BaseAbscencePeer.ABSCENCE_ID.getSqlExpression().equals(
                            column.getSqlExpression()))
                    {
                        abscence.setAbscenceId(
                            getAbscenceId(resultSet, totalOffset));
                        columnMapped = true;
                    }
                    else if (BaseAbscencePeer.DATE.getSqlExpression().equals(
                            column.getSqlExpression()))
                    {
                        abscence.setDate(
                            getDate(resultSet, totalOffset));
                        columnMapped = true;
                    }
                    else if (BaseAbscencePeer.MOTIF.getSqlExpression().equals(
                            column.getSqlExpression()))
                    {
                        abscence.setMotif(
                            getMotif(resultSet, totalOffset));
                        columnMapped = true;
                    }
                    else if (BaseAbscencePeer.STUDENT_ID.getSqlExpression().equals(
                            column.getSqlExpression()))
                    {
                        abscence.setStudentId(
                            getStudentId(resultSet, totalOffset));
                        columnMapped = true;
                    }
                    totalOffset++;
                }
                if (!columnMapped)
                {
                    log.debug("no columns to map found in criteria, "
                        + "returning null");
                    return null;
                }
            }
            abscence.setNew(false);
            abscence.setModified(false);
        }
        finally
        {
            abscence.setLoading(false);
        }
        return abscence;
    }

        /**
         * Reads the value of the <code>columnIndex</code>'th column
         * in the <code>resultSet</code> so that it can be used to set
         * the field abscenceId in Abscence.
         *
         * @param dbObject the database object to fill, not null.
         * @param resultSet the ResultSet to read from, not null.
         * @param columnIndex the index in the resultSet which should be read.
         *
         * @return the content of the column.
         *
         * @throws SQLException if a problem occurs when reading
         *         from the resultSet.
         */
        protected int getAbscenceId(
                    ResultSet resultSet,
                    int columnIndex)
                throws TorqueException
        {
            try
            {
                return resultSet.getInt(columnIndex);
            }
            catch (SQLException e)
            {
                throw new TorqueException(e);
            }
        }

        /**
         * Reads the value of the <code>columnIndex</code>'th column
         * in the <code>resultSet</code> so that it can be used to set
         * the field date in Abscence.
         *
         * @param dbObject the database object to fill, not null.
         * @param resultSet the ResultSet to read from, not null.
         * @param columnIndex the index in the resultSet which should be read.
         *
         * @return the content of the column.
         *
         * @throws SQLException if a problem occurs when reading
         *         from the resultSet.
         */
        protected java.util.Date getDate(
                    ResultSet resultSet,
                    int columnIndex)
                throws TorqueException
        {
            try
            {
                java.util.Date value = resultSet.getDate(columnIndex);
                if (resultSet.wasNull())
                {
                    value = null;
                }
                return value;
            }
            catch (SQLException e)
            {
                throw new TorqueException(e);
            }
        }

        /**
         * Reads the value of the <code>columnIndex</code>'th column
         * in the <code>resultSet</code> so that it can be used to set
         * the field motif in Abscence.
         *
         * @param dbObject the database object to fill, not null.
         * @param resultSet the ResultSet to read from, not null.
         * @param columnIndex the index in the resultSet which should be read.
         *
         * @return the content of the column.
         *
         * @throws SQLException if a problem occurs when reading
         *         from the resultSet.
         */
        protected String getMotif(
                    ResultSet resultSet,
                    int columnIndex)
                throws TorqueException
        {
            try
            {
                return resultSet.getString(columnIndex);
            }
            catch (SQLException e)
            {
                throw new TorqueException(e);
            }
        }

        /**
         * Reads the value of the <code>columnIndex</code>'th column
         * in the <code>resultSet</code> so that it can be used to set
         * the field studentId in Abscence.
         *
         * @param dbObject the database object to fill, not null.
         * @param resultSet the ResultSet to read from, not null.
         * @param columnIndex the index in the resultSet which should be read.
         *
         * @return the content of the column.
         *
         * @throws SQLException if a problem occurs when reading
         *         from the resultSet.
         */
        protected int getStudentId(
                    ResultSet resultSet,
                    int columnIndex)
                throws TorqueException
        {
            try
            {
                return resultSet.getInt(columnIndex);
            }
            catch (SQLException e)
            {
                throw new TorqueException(e);
            }
        }


}
