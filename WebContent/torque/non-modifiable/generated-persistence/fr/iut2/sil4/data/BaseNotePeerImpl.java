package fr.iut2.sil4.data;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.NoRowsException;
import org.apache.torque.OptimisticLockingFailedException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.TorqueRuntimeException;
import org.apache.torque.criteria.Criteria;
import org.apache.torque.criteria.Criterion;
import org.apache.torque.om.mapper.RecordMapper;
import org.apache.torque.om.mapper.CompositeMapper;
import org.apache.torque.om.DateKey;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.StringKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.om.ComboKey;
import org.apache.torque.map.TableMap;
import org.apache.torque.util.Transaction;
import org.apache.torque.util.ColumnValues;
import org.apache.torque.util.JdbcTypedValue;



/**
 * Note Table
 *
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Sun Feb 23 17:07:41 CET 2014]
 *
 * You should not use this class directly.  It should not even be
 * extended; all references should be to NotePeer
 */

public abstract class BaseNotePeerImpl
    extends org.apache.torque.util.BasePeerImpl<Note>
{
    /** The class log. */
    private static Log log = LogFactory.getLog(BaseNotePeerImpl.class);

    /** Serial version */
    private static final long serialVersionUID = 1393171661316L;



    /**
     * Constructor.
     * The recordMapper, tableMap and databaseName fields are correctly
     * initialized.
     */
    public BaseNotePeerImpl()
    {
        this(new NoteRecordMapper(),
            NotePeer.TABLE,
            NotePeer.DATABASE_NAME);
    }

    /**
     * Constructor providing the objects to be injected as parameters.
     *
     * @param recordMapper a record mapper to map JDBC result sets to objects
     * @param tableMap the default table map
     * @param databaseName the name of the database
     */
    public BaseNotePeerImpl(
            RecordMapper<Note> recordMapper, 
            TableMap tableMap,
            String databaseName)
    {
        super(recordMapper, tableMap, databaseName);
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
    public List<Note> doSelect(Note obj)
            throws TorqueException
    {
        return doSelect(buildSelectCriteria(obj));
    }

    /**
     * Selects at most one Note object from the database
     * which has the same content as the passed object.
     *
     * @return the selected Object, or null if no object was selected.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public Note doSelectSingleRecord(
                Note obj)
            throws TorqueException
    {
        List<Note> noteList = doSelect(obj);
        Note note = null;
        if (noteList.size() > 1)
        {
            throw new TooManyRowsException("Object " + obj 
                + " matched more than one record");
        }
        if (!noteList.isEmpty())
        {
            note = noteList.get(0);
        }
        return note;
    }

    /**
     * Returns a new instance of the Data object class
     */
    public Note getDbObjectInstance()
    {
        return new Note();
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
    public ObjectKey doInsert(ColumnValues columnValues) throws TorqueException
    {
        Connection connection = null;
        try
        {
            connection = Transaction.begin(
                    NotePeer.DATABASE_NAME);
            ObjectKey result = doInsert(columnValues, connection);
            Transaction.commit(connection);
            connection = null;
            return result;
        }
        finally
        {
            if (connection != null)
            {
                Transaction.safeRollback(connection);
            }
        }
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
    public ObjectKey doInsert(ColumnValues columnValues, Connection con)
        throws TorqueException
    {
        correctBooleans(columnValues);
        return super.doInsert(columnValues, con);
    }

    /**
     * Method to do inserts
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public void doInsert(Note obj) throws TorqueException
    {
        obj.setPrimaryKey(doInsert(buildColumnValues(obj)));
        obj.setNew(false);
        obj.setModified(false);
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
    public void doInsert(Note obj, Connection con)
        throws TorqueException
    {
        ObjectKey primaryKey = doInsert(buildColumnValues(obj), con);
        if (primaryKey != null)
        {
            obj.setPrimaryKey(primaryKey);
        }
        obj.setNew(false);
        obj.setModified(false);
    }

    /**
     * Method to do updates.
     *
     * @param columnValues the values to update plus the primary key
     *        identifying the row to update.
     *
     * @return the number of affected rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public int doUpdate(ColumnValues columnValues) throws TorqueException
    {
        Connection connection = null;
        try
        {
            connection = Transaction.begin(
                    NotePeer.DATABASE_NAME);
            int result = doUpdate(columnValues, connection);
            Transaction.commit(connection);
            connection = null;
            return result;
        }
        finally
        {
            if (connection != null)
            {
                Transaction.safeRollback(connection);
            }
        }
    }

    /**
     * Method to do updates.  This method is to be used during a transaction,
     * otherwise use the doUpdate(Criteria) method.
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
    public int doUpdate(ColumnValues columnValues, Connection con)
        throws TorqueException
    {
        Criteria selectCriteria 
                = new Criteria(NotePeer.DATABASE_NAME);
        correctBooleans(columnValues);

        selectCriteria.where(
                NotePeer.NOTE_ID,
                columnValues.remove(NotePeer.NOTE_ID).getValue());


        int rowCount = doUpdate(selectCriteria, columnValues, con);
        return rowCount;
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
    public int doUpdate(Note obj) throws TorqueException
    {
        ColumnValues columnValues = buildColumnValues(obj);
        int result = doUpdate(columnValues);
        obj.setModified(false);
        return result;
    }

    /**
     * Updates a Note in the database.
     * The primary key is used to identify the object to update.
     * This method is to be used during a transaction,
     * otherwise the doUpdate(Note) method can be used.
     *
     * @param obj the data object to update in the database.
     * @param con the connection to use, not null.
     
     * @return the number of affected rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public int doUpdate(Note obj, Connection con)
        throws TorqueException
    {
        ColumnValues columnValues = buildColumnValues(obj);
        int result = doUpdate(columnValues, con);
        obj.setModified(false);
        return result;
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
    public int doDelete(Note obj) throws TorqueException
    {
        int result = doDelete(buildCriteria(obj.getPrimaryKey()));
        obj.setDeleted(true);
        return result;
    }

    /**
     * Deletes a data object, i.e. a row in a table, in the database.
     * This method is to be used during a transaction, otherwise use the
     * doDelete(Note) method.
     *
     * @param obj the data object to delete in the database, not null.
     * @param con the connection to use, not null.
     *
     * @return the number of deleted rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public int doDelete(Note obj, Connection con)
        throws TorqueException
    {
        int result = doDelete(buildCriteria(obj.getPrimaryKey()), con);
        obj.setDeleted(true);
        return result;
    }

    /**
     * Deletes data objects, i.e. rows in a table, in the database.
     *
     * @param objects the data object to delete in the database, not null,
     *        may not contain null.
     *
     * @return the number of deleted rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public int doDelete(Collection<Note> objects)
            throws TorqueException
    {
        int result = doDelete(buildPkCriteria(objects));
        for (Note object : objects)
        {
            object.setDeleted(true);
        }
        return result;
    }

    /**
     * Deletes data objects, i.e. rows in a table, in the database.
     * This method uses the passed connection to delete the rows;
     * if a transaction is open in the connection, the deletion happens inside
     * this transaction.
     *
     * @param objects the data objects to delete in the database, not null,
     *        may not contain null.
     * @param con the connection to use for deleting, not null.
     *
     * @return the number of deleted rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public int doDelete(
            Collection<Note> objects,
            Connection con)
        throws TorqueException
    {
        int result = doDelete(buildPkCriteria(objects), con);
        for (Note object : objects)
        {
            object.setDeleted(true);
        }
        return result;
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
    public int doDelete(ObjectKey pk) throws TorqueException
    {
        Connection connection = null;
        try
        {
            connection = Transaction.begin(
                    NotePeer.DATABASE_NAME);
            int deletedRows = doDelete(pk, connection);
            Transaction.commit(connection);
            connection = null;
            return deletedRows;
        }
        finally
        {
            if (connection != null)
            {
                Transaction.safeRollback(connection);
            }
        }
    }

    /**
     * Deletes a row in the database.
     * This method is to be used during a transaction,
     * otherwise use the doDelete(ObjectKey) method.
     *
     * @param pk the ObjectKey that identifies the row to delete.
     * @param con the connection to use for deleting, not null.
     *
     * @return the number of deleted rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public int doDelete(ObjectKey pk, Connection con)
        throws TorqueException
    {
        return doDelete(buildCriteria(pk), con);
    }

    /** 
     * Build a Criteria object which selects all objects which have a given
     * primary key.
     *
     * @param pk the primary key value to build the criteria from, not null.
     */
    public Criteria buildCriteria(ObjectKey pk)
    {
        Criteria criteria = new Criteria();
        criteria.and(NotePeer.NOTE_ID, pk);
        return criteria;
     }

    /** 
     * Build a Criteria object which selects all objects which primary keys
     * are contained in the passed collection.
     *
     * @param pks the primary key values to build the criteria from, not null,
     *        may not contain null.
     */
    public Criteria buildCriteria(Collection<ObjectKey> pks)
    {
        Criteria criteria = new Criteria();
        criteria.andIn(NotePeer.NOTE_ID, pks);
        return criteria;
     }


    /** 
     * Build a Criteria object which selects all passed objects using their
     * primary key. Objects which do not yet have a primary key are ignored.
     *
     * @param objects the objects to build the criteria from, not null,
     *        may not contain null.
     */
    public Criteria buildPkCriteria(
            Collection<Note> objects)
    {
        List<ObjectKey> pks = new ArrayList<ObjectKey>(objects.size());
        for (Note object : objects)
        {
            ObjectKey pk = object.getPrimaryKey();
            if (pk != null)
            {
                pks.add(pk);
            }
        }
        return buildCriteria(pks);
    }

    /** 
     * Build a Criteria object from the data object for this peer.
     * The primary key columns are only added if the object is not new.
     *
     * @param obj the object to build the criteria from, not null.
     */
    public Criteria buildCriteria(Note obj)
    {
        Criteria criteria = new Criteria(NotePeer.DATABASE_NAME);
        if (!obj.isNew())
        {
            criteria.and(NotePeer.NOTE_ID, obj.getNoteId());
        }
        criteria.and(NotePeer.CONTROLE_ID, obj.getControleId());
        criteria.and(NotePeer.POINTS, obj.getPoints());
        criteria.and(NotePeer.STUDENT_ID, obj.getStudentId());
        return criteria;
    }

    /** 
     * Build a Criteria object from the data object for this peer,
     * skipping all binary columns.
     *
     * @param obj the object to build the criteria from, not null.
     */
    public Criteria buildSelectCriteria(Note obj)
    {
        Criteria criteria = new Criteria(NotePeer.DATABASE_NAME);
        if (!obj.isNew())
        {
            criteria.and(NotePeer.NOTE_ID, obj.getNoteId());
        }
        criteria.and(NotePeer.CONTROLE_ID, obj.getControleId());
        criteria.and(NotePeer.POINTS, obj.getPoints());
        criteria.and(NotePeer.STUDENT_ID, obj.getStudentId());
        return criteria;
    }

    /** 
     * Returns the contents of the object as ColumnValues object.
     * Primary key columns which are generated on insertion are not
     * added to the returned object if they still have their initial
     * value. Also, columns which have the useDatabaseDefaultValue
     * flag set to true are also not added to the returned object
     * if they still have their initial value.
     *
     * @throws TorqueException if the table map cannot be retrieved
     *         (should not happen).
     */
    public ColumnValues buildColumnValues(Note note)
            throws TorqueException
    {
        ColumnValues columnValues = new ColumnValues();
        if (!note.isNew() 
            || note.getNoteId() != 0)
        {
            columnValues.put(
                    NotePeer.NOTE_ID,
                    new JdbcTypedValue(
                        note.getNoteId(),
                        4));
        }
        columnValues.put(
                NotePeer.CONTROLE_ID,
                new JdbcTypedValue(
                    note.getControleId(),
                    4));
        columnValues.put(
                NotePeer.POINTS,
                new JdbcTypedValue(
                    note.getPoints(),
                    4));
        columnValues.put(
                NotePeer.STUDENT_ID,
                new JdbcTypedValue(
                    note.getStudentId(),
                    4));
        return columnValues;
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
    public Note retrieveByPK(int pk)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        return retrieveByPK(SimpleKey.keyFor(pk));
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
    public Note retrieveByPK(int pk, Connection con)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        return retrieveByPK(SimpleKey.keyFor(pk), con);
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
    public Note retrieveByPK(ObjectKey pk)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        Connection connection = null;
        try
        {
            connection = Transaction.begin(NotePeer.DATABASE_NAME);
            Note result = retrieveByPK(pk, connection);
            Transaction.commit(connection);
            connection = null;
            return result;
        }
        finally
        {
            if (connection != null)
            {
                Transaction.safeRollback(connection);
            }
        }
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
    public Note retrieveByPK(ObjectKey pk, Connection con)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        Criteria criteria = buildCriteria(pk);
        List<Note> v = doSelect(criteria, con);
        if (v.size() == 0)
        {
            throw new NoRowsException("Failed to select a row.");
        }
        else if (v.size() > 1)
        {
            throw new TooManyRowsException("Failed to select only one row.");
        }
        else
        {
            return (Note)v.get(0);
        }
    }


    /**
     * Retrieve a multiple objects by pk
     *
     * @param pks List of primary keys
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public List<Note> retrieveByPKs(Collection<ObjectKey> pks)
        throws TorqueException
    {
        Connection connection = null;
        try
        {
            connection = Transaction.begin(NotePeer.DATABASE_NAME);
            List<Note> result = retrieveByPKs(pks, connection);
            Transaction.commit(connection);
            connection = null;
            return result;
        }
        finally
        {
            if (connection != null)
            {
                Transaction.safeRollback(connection);
            }
        }
    }

    /**
     * Retrieve multiple objects by pk
     *
     * @param pks List of primary keys
     * @param dbcon the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public List<Note> retrieveByPKs(
                Collection<ObjectKey> pks,
                Connection dbcon)
            throws TorqueException
    {
        if (pks == null || pks.size() == 0)
        {
            return new ArrayList<Note>();
        }
        Criteria criteria = buildCriteria(pks);
        List<Note> result = doSelect(criteria, dbcon);
        return result;
    }


    /**
     * Selects a collection of dbObjectClassName objects pre-filled with their
     * Student objects.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public List<Note> doSelectJoinStudent(Criteria criteria)
        throws TorqueException
    {
        Connection connection = null;
        try
        {
            connection = Transaction.begin(
                    NotePeer.DATABASE_NAME);
            List<Note> result
                    = NotePeer.doSelectJoinStudent(criteria, connection);
            Transaction.commit(connection);
            connection = null;
            return result;
        }
        finally
        {
            if (connection != null)
            {
                Transaction.safeRollback(connection);
            }
        }
    }

    /**
     * Selects a collection of Note objects pre-filled with their
     * Student objects.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public List<Note> doSelectJoinStudent(
            Criteria criteria, Connection conn)
        throws TorqueException
    {
        setDbName(criteria);

        addSelectColumns(criteria);
        fr.iut2.sil4.data.StudentPeer.addSelectColumns(criteria);

        CompositeMapper compositeMapper = new CompositeMapper();
        compositeMapper.addMapper(
                new NoteRecordMapper(),
                0);
        compositeMapper.addMapper(
                new StudentRecordMapper(),
                NotePeer.numColumns);
        criteria.addJoin(NotePeer.STUDENT_ID,
            fr.iut2.sil4.data.StudentPeer.STUDENT_ID);

        correctBooleans(criteria);

        List<Note> result = new ArrayList<Note>();
        List<List<Object>> rawResult = doSelect(
                criteria, compositeMapper, conn);
        for (List<Object> rawResultRow : rawResult)
        {
            Note obj1 = (Note) rawResultRow.get(0);
            Student obj2 = (Student) rawResultRow.get(1);

            boolean newObject = true;
            for (int j = 0; j < result.size(); j++)
            {
                Note temp_obj1 = result.get(j);
                fr.iut2.sil4.data.Student temp_obj2 = temp_obj1.getStudent();
                if (temp_obj2.getPrimaryKey().equals(obj2.getPrimaryKey()))
                {
                    newObject = false;
                    temp_obj2.addNote(obj1);
                    break;
                }
            }
            if (newObject)
            {
                obj2.initNotes();
                obj2.addNote(obj1);
            }
            result.add(obj1);
        }
        return result;
    }




}