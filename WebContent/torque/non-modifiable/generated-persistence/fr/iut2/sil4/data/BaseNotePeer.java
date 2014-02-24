package fr.iut2.sil4.data;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.NoRowsException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.Column;
import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.TorqueRuntimeException;
import org.apache.torque.adapter.IDMethod;
import org.apache.torque.criteria.Criteria;
import org.apache.torque.map.DatabaseMap;
import org.apache.torque.map.TableMap;
import org.apache.torque.map.ColumnMap;
import org.apache.torque.map.ForeignKeyMap;
import org.apache.torque.map.InheritanceMap;
import org.apache.torque.om.mapper.RecordMapper;
import org.apache.torque.om.mapper.CompositeMapper;
import org.apache.torque.om.DateKey;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.StringKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.util.Transaction;
import org.apache.torque.util.ColumnValues;
import org.apache.torque.util.JdbcTypedValue;



/**
 * Note Table
 *
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Sun Feb 23 23:29:29 CET 2014]
 *
 * You should not use this class directly.  It should not even be
 * extended; all references should be to NotePeer
 */

public abstract class BaseNotePeer
{
    /** The class log. */
    private static Log log = LogFactory.getLog(BaseNotePeerImpl.class);
    /** The default database name for this class. */
    public static final String DATABASE_NAME;

     /** The table name for this class. */
    public static final String TABLE_NAME;

     /** The table map for this class. */
    public static final TableMap TABLE;
    /** The column for the note_id field */
    public static final ColumnMap NOTE_ID;
    /** The column for the controle_id field */
    public static final ColumnMap CONTROLE_ID;
    /** The column for the points field */
    public static final ColumnMap POINTS;
    /** The column for the student_id field */
    public static final ColumnMap STUDENT_ID;

    /** number of columns for this peer */
    public static final int numColumns = 4;


    /** The implementation of the peer. */
    private static NotePeerImpl notePeerImpl;


    static
    {
        DatabaseMap dbMap = Torque.getOrCreateDatabase("napp")
                .getDatabaseMap();
        if (dbMap.getTable("note") == null)
        {
            dbMap.addTable("note");
        }
        DATABASE_NAME = "napp";
        TABLE_NAME = "note";

        TABLE = dbMap.getTable("note");
        TABLE.setJavaName("Note");
        TABLE.setOMClass(fr.iut2.sil4.data.Note.class);
        TABLE.setPeerClass(fr.iut2.sil4.data.NotePeer.class);
        TABLE.setDescription("Note Table");
        TABLE.setPrimaryKeyMethod(IDMethod.NATIVE);
        TABLE.setPrimaryKeyMethodInfo(IDMethod.ID_BROKER, TABLE.getName());
        TABLE.setPrimaryKeyMethodInfo(IDMethod.SEQUENCE, "note_SEQ");
        TABLE.setPrimaryKeyMethodInfo(IDMethod.AUTO_INCREMENT, "note");
        TABLE.setUseInheritance(true);


    // ------------- Column: note_id --------------------
        NOTE_ID = new ColumnMap("note_id", TABLE);
        NOTE_ID.setType(Integer.valueOf(0));
        NOTE_ID.setTorqueType("INTEGER");
        NOTE_ID.setUsePrimitive(true);
        NOTE_ID.setPrimaryKey(true);
        NOTE_ID.setNotNull(true);
        NOTE_ID.setJavaName("NoteId");
        NOTE_ID.setAutoIncrement(true);
        NOTE_ID.setProtected(false);
        NOTE_ID.setJavaType( "int" );
        NOTE_ID.setDescription("Group Id");
        NOTE_ID.setPosition(1);
        TABLE.addColumn(NOTE_ID);
    // ------------- Column: controle_id --------------------
        CONTROLE_ID = new ColumnMap("controle_id", TABLE);
        CONTROLE_ID.setType(Integer.valueOf(0));
        CONTROLE_ID.setTorqueType("INTEGER");
        CONTROLE_ID.setUsePrimitive(true);
        CONTROLE_ID.setPrimaryKey(false);
        CONTROLE_ID.setNotNull(true);
        CONTROLE_ID.setJavaName("ControleId");
        CONTROLE_ID.setAutoIncrement(true);
        CONTROLE_ID.setProtected(false);
        CONTROLE_ID.setJavaType( "int" );
        CONTROLE_ID.setDescription("Controle Id");
        CONTROLE_ID.setPosition(2);
        TABLE.addColumn(CONTROLE_ID);
    // ------------- Column: points --------------------
        POINTS = new ColumnMap("points", TABLE);
        POINTS.setType(Integer.valueOf(0));
        POINTS.setTorqueType("INTEGER");
        POINTS.setUsePrimitive(true);
        POINTS.setPrimaryKey(false);
        POINTS.setNotNull(true);
        POINTS.setJavaName("Points");
        POINTS.setAutoIncrement(true);
        POINTS.setProtected(false);
        POINTS.setJavaType( "int" );
        POINTS.setDescription("Points");
        POINTS.setPosition(3);
        TABLE.addColumn(POINTS);
    // ------------- Column: student_id --------------------
        STUDENT_ID = new ColumnMap("student_id", TABLE);
        STUDENT_ID.setType(Integer.valueOf(0));
        STUDENT_ID.setTorqueType("INTEGER");
        STUDENT_ID.setUsePrimitive(true);
        STUDENT_ID.setPrimaryKey(false);
        STUDENT_ID.setNotNull(true);
        STUDENT_ID.setJavaName("StudentId");
        STUDENT_ID.setAutoIncrement(true);
        STUDENT_ID.setProtected(false);
        STUDENT_ID.setJavaType( "int" );
        STUDENT_ID.setDescription("Foreign Key Author");
        STUDENT_ID.setPosition(4);
        TABLE.addColumn(STUDENT_ID);


    // ------------- Foreign keys --------------------
        ForeignKeyMap foreignKeyMap;
        TableMap foreignTable;
        String foreignTableName; 
        foreignTableName = "student"; 
        foreignTable = dbMap.getTable(foreignTableName);
        if (foreignTable == null)
        {
            foreignKeyMap = new ForeignKeyMap(TABLE, foreignTableName);
            foreignKeyMap.addColumns(new ForeignKeyMap.ColumnPair(
                foreignKeyMap,
                TABLE.getColumn("student_id"),
                "student_id"));
        }
        else
        {
            foreignKeyMap = new ForeignKeyMap(TABLE, foreignTable);
            foreignKeyMap.addColumns(new ForeignKeyMap.ColumnPair(
                foreignKeyMap,
                TABLE.getColumn("student_id"),
                foreignTable.getColumn("student_id")));
        }
        TABLE.addForeignKey(foreignKeyMap);


        initDatabaseMap();
    }

    /**
     * Creates a new instance of the  implementation of the peer.
     *
     * @return the new instance.
     */
    protected static NotePeerImpl createNotePeerImpl()
    {
        NotePeerImpl instance = new NotePeerImpl();
        return instance;
    }


    /**
     * Returns an instance of the implementation of the peer.
     * If no instance is currently cached, a new instance is created and cached.
     *
     * @return an instance of the implementation of the peer, not null.
     */
    public static NotePeerImpl getNotePeerImpl()
    {
        NotePeerImpl peerImplInstance = notePeerImpl;
        if (peerImplInstance == null)
        {
            peerImplInstance = NotePeer.createNotePeerImpl();
            notePeerImpl = peerImplInstance;
        }
        return peerImplInstance;
    }



    /**
     * Sets the instance of the implementation of the peer.
     *
     * @param an instance of the implementation of the peer, or null
     *        if a new instance should be created automatically.
     */
    public static void setNotePeerImpl(NotePeerImpl peerImplInstance)
    {
        notePeerImpl = peerImplInstance;
    }


    /**
     * Add all the columns needed to create a new object.
     *
     * @param criteria object containing the columns to add.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void addSelectColumns(Criteria criteria)
            throws TorqueException
    {
        getNotePeerImpl().addSelectColumns(criteria);
    }

    /**
     * changes the boolean values in the criteria to the appropriate type,
     * whenever a booleanchar or booleanint column is involved.
     * This enables the user to create criteria using Boolean values
     * for booleanchar or booleanint columns.
     *
     * @param criteria the criteria in which the boolean values
     *        should be corrected.
     *
     * @throws TorqueException if the database map for the criteria cannot be 
               obtained.
     */
    public static void correctBooleans(Criteria criteria) throws TorqueException
    {
        getNotePeerImpl().correctBooleans(criteria);
    }

    /**
     * Checks all columns in the criteria to see whether
     * booleanchar and booleanint columns are queried with a boolean.
     * If yes, the query values are mapped onto values the database
     * does understand, i.e. 0 and 1 for booleanints and N and Y for
     * booleanchar columns.
     *
     * @param columnValues The value to be checked for booleanint
     *        and booleanchar columns.
     * @throws TorqueException if the database map for the criteria cannot be
     *         retrieved.
     */
    public static void correctBooleans(
            ColumnValues columnValues)
        throws TorqueException
    {
        getNotePeerImpl().correctBooleans(columnValues);
    }
    
    /**
     * Selects Note objects from a database.
     *
     * @param criteria object used to create the SELECT statement.
     *
     * @return the list of selected objects, not null.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List<Note> doSelect(Criteria criteria)
            throws TorqueException
    {
        return getNotePeerImpl().doSelect(criteria);
    }

    /**
     * Selects Note objects from a database
     * within a transaction.
     *
     * @param criteria object used to create the SELECT statement.
     * @param connection the connection holding the transaction, not null.
     *
     * @return The list of selected objects, not null.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List<Note> doSelect(
                Criteria criteria,
                Connection connection)
            throws TorqueException
    {
        return getNotePeerImpl().doSelect(criteria, connection);
    }

    /**
     * Selects rows from a database an maps them to objects.
     *
     * @param criteria A Criteria specifying the records to select, not null.
     * @param mapper The mapper creating the objects from the resultSet,
     *        not null.
     *
     * @return The results of the query, not null.
     *
     * @throws TorqueException if querying the database fails.
     */
    public static <T> List<T> doSelect(
                Criteria criteria,
                RecordMapper<T> mapper)
            throws TorqueException
    {
        return getNotePeerImpl().doSelect(criteria, mapper);
    }

    /**
     * Selects rows from a database an maps them to objects.
     *
     * @param criteria A Criteria specifying the records to select, not null.
     * @param mapper The mapper creating the objects from the resultSet,
     *        not null.
     * @param connection the database connection for selecting records,
     *        not null.
     *
     * @return The results of the query, not null.
     * @throws TorqueException Error performing database query.
     */
    public static <T> List<T> doSelect(
            Criteria criteria,
            RecordMapper<T> mapper,
            Connection connection)
        throws TorqueException
    {
        return getNotePeerImpl().doSelect(
                criteria,
                mapper,
                connection);
    }

    /**
     * Selects rows from a database an maps them to objects.
     *
     * @param query the sql query to execute, not null.
     * @param mapper The mapper creating the objects from the resultSet,
     *        not null.
     * @param dbName The name of the database to create the connection for,
     *        or null for the default SDB.
     *
     * @return The results of the query, not null.
     *
     * @throws TorqueException if querying the database fails.
     */
    public static <T> List<T> doSelect(
                String query,
                RecordMapper<T> mapper,
                String dbName)
            throws TorqueException
    {
        return getNotePeerImpl().doSelect(
                query,
                mapper,
                dbName);
    }

    /**
     * Selects rows from a database an maps them to objects.
     *
     * @param query the SQL Query to execute, not null.
     * @param mapper The mapper creating the objects from the resultSet,
     *        not null.
     * @param connection the database connection, not null.
     *
     * @return The results of the query, not null.
     *
     * @throws TorqueException if querying the database fails.
     */
    public static <T> List<T> doSelect(
                String query,
                RecordMapper<T> mapper,
                Connection connection)
            throws TorqueException
    {
        return getNotePeerImpl().doSelect(
                query,
                mapper,
                connection);
    }

    /**
     * Selects Note objects from the database which have
     * the same content as the passed object.
     *
     * @return The list of selected objects, not null.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List<Note> doSelect(Note obj)
            throws TorqueException
    {
        return getNotePeerImpl().doSelect(obj);
    }

    /**
     * Selects at most one Note object from a database.
     *
     * @param criteria object used to create the SELECT statement.
     *
     * @return the selected Object, or null if no object was selected.
     *
     * @throws TorqueException If more than one record is selected or if
     *         an error occurs when processing the query.
     */
    public static Note doSelectSingleRecord(
                Criteria criteria)
            throws TorqueException
    {
        return getNotePeerImpl().doSelectSingleRecord(criteria);
    }

    /**
     * Selects at most one Note object from a database
     * within a transaction.
     *
     * @param criteria object used to create the SELECT statement.
     * @param connection the connection holding the transaction, not null.
     *
     * @return the selected Object, or null if no object was selected.
     *
     * @throws TorqueException If more than one record is selected or if
     *         an error occurs when processing the query.
     */
    public static Note doSelectSingleRecord(
                Criteria criteria,
                Connection connection)
            throws TorqueException
    {
        return getNotePeerImpl().doSelectSingleRecord(criteria, connection);
    }

    /**
     * Selects at most a single row from a database an maps them to objects.
     *
     * @param criteria A Criteria specifying the records to select, not null.
     * @param mapper The mapper creating the objects from the resultSet,
     *        not null.
     *
     * @return The selected row, or null if no records was selected.
     *
     * @throws TorqueException if querying the database fails.
     */
    public static <T> T doSelectSingleRecord(
                org.apache.torque.criteria.Criteria criteria,
                RecordMapper<T> mapper)
            throws TorqueException
    {
        return getNotePeerImpl().doSelectSingleRecord(
                criteria,
                mapper);
    }

    /**
     * Selects at most a single row from a database an maps them to objects.
     *
     * @param criteria A Criteria specifying the records to select, not null.
     * @param mapper The mapper creating the objects from the resultSet,
     *        not null.
     * @param connection the database connection, not null.
     *
     * @return The selected row, or null if no records was selected.
     *
     * @throws TorqueException if querying the database fails.
     */
    public static <T> T doSelectSingleRecord(
                org.apache.torque.criteria.Criteria criteria,
                RecordMapper<T> mapper,
                Connection connection)
            throws TorqueException
    {
        return getNotePeerImpl().doSelectSingleRecord(
                criteria,
                mapper,
                connection);
    }

    /**
     * Selects at most one Note object from the database
     * which has the same content as the passed object.
     *
     * @return the selected Object, or null if no object was selected.
     *
     * @throws TorqueException If more than one record is selected or if
     *         an error occurs when processing the query.
     */
    public static Note doSelectSingleRecord(
                Note obj)
            throws TorqueException
    {
        return getNotePeerImpl().doSelectSingleRecord(obj);
    }


    /**
     * Returns a new instance of the Data object class
     */
    public static Note getDbObjectInstance()
    {
        return getNotePeerImpl().getDbObjectInstance();
    }


    /**
     * Method to do inserts.
     *
     * @param columnValues the values to insert.
     *
     * @return the primary key of the inserted row.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static ObjectKey doInsert(ColumnValues columnValues) 
            throws TorqueException
    {
        return getNotePeerImpl().doInsert(columnValues);
    }

    /**
     * Method to do inserts.  This method is to be used during a transaction,
     * otherwise use the doInsert(Criteria) method.
     *
     * @param columnValues the values to insert.
     * @param con the connection to use, not null.
     *
     * @return the primary key of the inserted row.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static ObjectKey doInsert(ColumnValues columnValues, Connection con)
            throws TorqueException
    {
        return getNotePeerImpl().doInsert(columnValues, con);
    }
    /**
     * Method to do inserts
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doInsert(Note obj)
            throws TorqueException
    {
        getNotePeerImpl().doInsert(obj);
    }

    /**
     * Method to do inserts.  This method is to be used during a transaction,
     * otherwise use the doInsert(Note) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to insert into the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static void doInsert(Note obj, Connection con)
            throws TorqueException
    {
        getNotePeerImpl().doInsert(obj, con);
    }

    /**
     * Method to do updates.
     *
     * @param columnValues the values to update plus the primary key
     *        identifying the row to update.
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static int doUpdate(ColumnValues columnValues) throws TorqueException
    {
        return getNotePeerImpl().doUpdate(columnValues);
    }

    /**
     * Method to do updates.  This method is to be used during a transaction,
     * otherwise use the doUpdate(Criteria) method.  It will take care of
     * the connection details internally.
     *
     * @param columnValues the values to update plus the primary key
     *        identifying the row to update.
     * @param con the connection to use, not null.
     *
     * @return the number of affected rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static int doUpdate(ColumnValues columnValues, Connection con)
        throws TorqueException
    {
        return getNotePeerImpl().doUpdate(columnValues, con);
    }

    /**
     * Executes an update against the database. The rows to be updated
     * are selected using <code>criteria</code> and updated using the values
     * in <code>updateValues</code>.
     *
     * @param criteria selects which rows of which table should be updated.
     * @param updateValues Which columns to update with which values, not null.
     *
     * @return the number of affected rows.
     *
     * @throws TorqueException if updating fails.
     */
    public static int doUpdate(
                Criteria selectCriteria,
                ColumnValues updateValues)
            throws TorqueException
    {
        return getNotePeerImpl().doUpdate(
            selectCriteria,
            updateValues);
    }

    /**
     * Executes an update against the database. The rows to be updated
     * are selected using <code>criteria</code> and updated using the values
     * in <code>updateValues</code>.
     *
     * @param criteria selects which rows of which table should be updated.
     * @param updateValues Which columns to update with which values, not null.
     * @param connection the database connection to use, not null.
     *
     * @return the number of affected rows.
     *
     * @throws TorqueException if updating fails.
     */
    public static int doUpdate(
                Criteria criteria,
                ColumnValues updateValues,
                Connection connection)
            throws TorqueException
    {
        return getNotePeerImpl().doUpdate(
            criteria,
             updateValues,
              connection);
    }

    /**
     * Updates an Note in the database.
     * The primary key is used to identify the object to update.
     *
     * @param obj the data object to update in the database.
     *
     * @return the number of affected rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static int doUpdate(Note obj) throws TorqueException
    {
        return getNotePeerImpl().doUpdate(obj);
    }

    /**
     * Updates a Note in the database.
     * The primary key is used to identify the object to update.
     * This method is to be used during a transaction,
     * otherwise the doUpdate(Note) method can be used.
     *
     * @param obj the data object to update in the database.
     * @param con the connection to use, not null.
     
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static int doUpdate(Note obj, Connection con)
        throws TorqueException
    {
        return getNotePeerImpl().doUpdate(obj, con);
    }

    /**
     * Utility method which executes a given sql statement
     * as prepared statement.
     * This method should be used for update, insert, and delete statements.
     * Use executeQuery() for selects.
     *
     * @param statementString A String with the sql statement to execute.
     *
     * @return The number of rows affected.
     *
     * @throws TorqueException if executing the statement fails
     *         or no database connection can be established.
     */
    public static int executeStatement(String statementString) 
            throws TorqueException
    {
        return getNotePeerImpl().executeStatement(statementString);
    }

    /**
     * Utility method which executes a given sql statement
     * as prepared statement.
     * This method should be used for update, insert, and delete statements.
     * Use executeQuery() for selects.
     *
     * @param statementString A String with the sql statement to execute.
     * @param replacementValues values to use as placeholders in the query.
     *        or null or empty if no placeholders need to be filled.
     *
     * @return The number of rows affected.
     *
     * @throws TorqueException if executing the statement fails
     *         or no database connection can be established.
     */
    public static int executeStatement(
                String statementString,
                List<JdbcTypedValue> replacementValues)
            throws TorqueException
    {
        return getNotePeerImpl().executeStatement(
                statementString, 
                replacementValues);
    }

    /**
     * Utility method which executes a given sql statement
     * as prepared statement.
     * This method should be used for update, insert, and delete statements.
     * Use executeQuery() for selects.
     *
     * @param statementString A String with the sql statement to execute.
     * @param dbName The name of the database to execute the statement against,
     *        or null for the default DB.
     * @param replacementValues values to use as placeholders in the query.
     *        or null or empty if no placeholders need to be filled.
     *
     * @return The number of rows affected.
     *
     * @throws TorqueException if executing the statement fails
     *         or no database connection can be established.
     */
    public static int executeStatement(
            String statementString,
            String dbName,
            List<JdbcTypedValue> replacementValues)
        throws TorqueException
    {
        return getNotePeerImpl().executeStatement(
                statementString, 
                dbName,
                replacementValues);
    }

    /**
     * Utility method which executes a given sql statement
     * as prepared statement.
     * This method should be used for update, insert, and delete statements.
     * Use executeQuery() for selects.
     *
     * @param statementString A String with the sql statement to execute.
     * @param con The database connection to use.
     * @param replacementValues values to use as placeholders in the query.
     *        or null or empty if no placeholders need to be filled.
     *
     * @return The number of rows affected.
     *
     * @throws TorqueException if executing the statement fails.
     */
    public static int executeStatement(
            String statementString,
            Connection con,
            List<JdbcTypedValue> replacementValues)
        throws TorqueException
    {
        return getNotePeerImpl().executeStatement(
                statementString, 
                con,
                replacementValues);
    }

    /**
     * Deletes rows from a database table.
     *
     * @param criteria defines the rows to be deleted, not null.
     *
     * @return the number of deleted rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
     public static int doDelete(Criteria criteria) throws TorqueException
     {
        return getNotePeerImpl().doDelete(criteria);
     }

    /**
     * Deletes rows from a table.
     * This method uses the passed connection to delete the rows;
     * if a transaction is open in the connection, the deletion happens inside
     * this transaction.
    *
     * @param criteria defines the rows to be deleted, not null.
     * @param con the connection to use, not null.
     *
     * @return the number of deleted rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
     public static int doDelete(Criteria criteria, Connection con)
        throws TorqueException
     {
        return getNotePeerImpl().doDelete(criteria, con);
     }

    /**
     * Deletes a data object, i.e. a row in a table, in the database.
     *
     * @param obj the data object to delete in the database, not null.
     *
     * @return the number of deleted rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static int doDelete(Note obj) throws TorqueException
    {
        return getNotePeerImpl().doDelete(obj);
    }

    /**
     * Deletes a data object, i.e. a row in a table, in the database.
     * This method uses the passed connection to delete the rows;
     * if a transaction is open in the connection, the deletion happens inside
     * this transaction.
     *
     * @param obj the data object to delete in the database, not null.
     * @param con the connection to use, not null.
     *
     * @return the number of deleted rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static int doDelete(Note obj, Connection con)
        throws TorqueException
    {
        return getNotePeerImpl().doDelete(obj, con);
    }

    /**
     * Deletes data objects, i.e. rows in a table, in the database.
     *
     * @param objects the datas object to delete in the database, not null,
     *        may not contain null.
     *
     * @return the number of deleted rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static int doDelete(Collection<Note> objects)
            throws TorqueException
    {
        return getNotePeerImpl().doDelete(objects);
    }

    /**
     * Deletes data objects, i.e. rows in a table, in the database.
     * This method uses the passed connection to delete the rows;
     * if a transaction is open in the connection, the deletion happens inside
     * this transaction.
     *
     * @param objects the datas object to delete in the database, not null,
     *        may not contain null.
     * @param con the connection to use for deleting, not null.
     *
     * @return the number of deleted rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static int doDelete(
            Collection<Note> objects,
            Connection con)
        throws TorqueException
    {
        return getNotePeerImpl().doDelete(objects, con);
    }

    /**
     * Deletes a row in the database.
     *
     * @param pk the ObjectKey that identifies the row to delete.
     *
     * @return the number of deleted rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static int doDelete(ObjectKey pk) throws TorqueException
    {
        return getNotePeerImpl().doDelete(pk);
    }

    /**
     * Deletes a row in the database.
     * This method uses the passed connection to delete the rows;
     * if a transaction is open in the connection, the deletion happens inside
     * this transaction.
     *
     * @param pk the ObjectKey that identifies the row to delete.
     * @param con the connection to use for deleting, not null.
     *
     * @return the number of deleted rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static int doDelete(ObjectKey pk, Connection con)
        throws TorqueException
    {
        return getNotePeerImpl().doDelete(pk, con);
    }

    /** 
     * Build a Criteria object which selects all objects which have a given
     * primary key.
     *
     * @param pk the primary key value to build the criteria from, not null.
     */
    public static Criteria buildCriteria(ObjectKey pk)
    {
        return getNotePeerImpl().buildCriteria(pk);
    }

    /** 
     * Build a Criteria object which selects all objects which primary keys
     * are contained in the passed collection.
     *
     * @param pks the primary key values to build the criteria from, not null,
     *        may not contain null.
     */
    public static Criteria buildCriteria(Collection<ObjectKey> pks)
    {
        return getNotePeerImpl().buildCriteria(pks);
    }

    /** 
     * Build a Criteria object which selects all passed objects using their
     * primary key. Objects which do not yet have a primary key are ignored.
     *
     * @param objects the objects to build the criteria from, not null,
     *        may not contain null.
     */
    public static Criteria buildPkCriteria(
            Collection<Note> objects)
    {
        return getNotePeerImpl().buildPkCriteria(objects);
    }

    /** 
     * Build a Criteria object from the data object for this peer.
     *
     * @param obj the object to build the criteria from, not null.
     */
    public static Criteria buildCriteria(Note obj)
    {
        return getNotePeerImpl().buildCriteria(obj);
    }

    /** 
     * Build a Criteria object from the data object for this peer,
     * skipping all binary columns.
     *
     * @param obj the object to build the criteria from, not null.
     */
    public static Criteria buildSelectCriteria(Note obj)
    {
        return getNotePeerImpl().buildSelectCriteria(obj);
    }

    /** 
     * Returns the contents of the object as ColumnValues object
     *
     * @throws TorqueException if the table map cannot be retrieved
     *         (should not happen).
     */
    public static ColumnValues buildColumnValues(Note note)
            throws TorqueException
    {
        
        return getNotePeerImpl().buildColumnValues(note);
    }

    /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws NoRowsException Primary key was not found in database.
     * @throws TooManyRowsException Primary key was not found in database.
     */
    public static Note retrieveByPK(int pk)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        return getNotePeerImpl().retrieveByPK(pk);
    }

    /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws NoRowsException Primary key was not found in database.
     * @throws TooManyRowsException Primary key was not found in database.
     */
    public static Note retrieveByPK(int pk, Connection con)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        return getNotePeerImpl().retrieveByPK(pk, con);
    }
    
    
    

    /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws NoRowsException Primary key was not found in database.
     * @throws TooManyRowsException Primary key was not found in database.
     */
    public static Note retrieveByPK(ObjectKey pk)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        return getNotePeerImpl().retrieveByPK(pk);
    }

    /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws NoRowsException Primary key was not found in database.
     * @throws TooManyRowsException Primary key was not found in database.
     */
    public static Note retrieveByPK(ObjectKey pk, Connection con)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        return getNotePeerImpl().retrieveByPK(pk, con);
    }


    /**
     * Retrieve a multiple objects by pk
     *
     * @param pks List of primary keys
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List<Note> retrieveByPKs(Collection<ObjectKey> pks)
        throws TorqueException
    {
        return getNotePeerImpl().retrieveByPKs(pks);
    }

    /**
     * Retrieve multiple objects by pk
     *
     * @param pks List of primary keys
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List<Note> retrieveByPKs(Collection<ObjectKey> pks, Connection con)
        throws TorqueException
    {
        return getNotePeerImpl().retrieveByPKs(pks,con);
    }


    /**
     * Selects a collection of dbObjectClassName objects pre-filled with their
     * Student objects.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List<Note> doSelectJoinStudent(Criteria criteria)
        throws TorqueException
    {
        return getNotePeerImpl().doSelectJoinStudent(criteria);
    }

    /**
     * Selects a collection of Note objects pre-filled with their
     * Student objects.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public static List<Note> doSelectJoinStudent(
            Criteria criteria, Connection conn)
        throws TorqueException
    {
        return getNotePeerImpl().doSelectJoinStudent(criteria, conn);
    }



    /**
     * Returns the TableMap related to this peer.
     *
     * @return the table map, not null.
     *
     * @throws TorqueException if the Peer instance does not hold a Table map.
     */
    public static TableMap getTableMap()
        throws TorqueException
    {
        return getNotePeerImpl().getTableMap();
    }

    public static void initDatabaseMap()
    {
    }


}
