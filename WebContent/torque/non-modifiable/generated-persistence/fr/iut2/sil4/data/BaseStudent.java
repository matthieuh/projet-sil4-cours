package fr.iut2.sil4.data;

import java.io.Serializable;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.torque.TorqueException;
import org.apache.torque.map.TableMap;
import org.apache.torque.om.ComboKey;
import org.apache.torque.om.DateKey;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.om.StringKey;
import org.apache.torque.om.BooleanKey;
import org.apache.torque.om.Persistent;
import org.apache.torque.om.ColumnAccessByName;
import org.apache.torque.criteria.Criteria;
import org.apache.torque.util.Transaction;
import org.apache.commons.lang.ObjectUtils;


/**
 * Student Table
 *
 * This class was autogenerated by Torque on:
 *
 * [Fri Jan 24 11:44:37 CET 2014]
 *
 * You should not use this class directly.  It should not even be
 * extended; all references should be to Student
 */
public abstract class BaseStudent 
    implements Persistent, Serializable, ColumnAccessByName
{
    /** Serial version */
    private static final long serialVersionUID = 1390560278002L;



    /** Student Id */
    private int studentId = 0;

    /** Student Absences */
    private int absences = 0;

    /** Student FirstName */
    private String firstname = null;

    /** Student Name */
    private String name = null;

    /** Whether this object was modified after loading or after last save. */
    private boolean modified = true;

    /** 
     * Whether this object was loaded from the database or already saved 
     * (false) or whether it is not yet in the database(true).
     */
    private boolean isNew = true;

    /** Flag which indicates whether this object is currently saving. */
    private boolean saving = false;

    /** 
     * Flag which indicates whether this object is currently loaded
     * from the database. 
     */
    private boolean loading = false;

    /** 
     * Flag which indicates whether this object was deleted from the database.
     * Note that this flags does not always display the current database state,
     * there is no magical connection between this flag and the database.
     */
    private boolean deleted = false;





    /**
     * Get the value of studentId.
     * The field is described as follows: 
     * Student Id
     *
     * @return int
     */
    public int getStudentId() 
    {
        
        return studentId;
    }

    /**
     * Set the value of studentId.
     * The field is described as follows: 
     * Student Id
     *
     * @param v new value
     */
    public void setStudentId(int v)
    {
        if (this.studentId != v)
        {
            setModified(true);
        }

        this.studentId = v;


    }
    
    /**
     * Get the value of absences.
     * The field is described as follows: 
     * Student Absences
     *
     * @return int
     */
    public int getAbsences() 
    {
        
        return absences;
    }

    /**
     * Set the value of absences.
     * The field is described as follows: 
     * Student Absences
     *
     * @param v new value
     */
    public void setAbsences(int v)
    {
        if (this.absences != v)
        {
            setModified(true);
        }

        this.absences = v;


    }
    
    /**
     * Get the value of firstname.
     * The field is described as follows: 
     * Student FirstName
     *
     * @return String
     */
    public String getFirstname() 
    {
        
        return firstname;
    }

    /**
     * Set the value of firstname.
     * The field is described as follows: 
     * Student FirstName
     *
     * @param v new value
     */
    public void setFirstname(String v)
    {
        if (!ObjectUtils.equals(this.firstname, v))
        {
            setModified(true);
        }

        this.firstname = v;


    }
    
    /**
     * Get the value of name.
     * The field is described as follows: 
     * Student Name
     *
     * @return String
     */
    public String getName() 
    {
        
        return name;
    }

    /**
     * Set the value of name.
     * The field is described as follows: 
     * Student Name
     *
     * @param v new value
     */
    public void setName(String v)
    {
        if (!ObjectUtils.equals(this.name, v))
        {
            setModified(true);
        }

        this.name = v;


    }
    

    /**
     * Returns whether the object has ever been saved.  This will
     * be false, if the object was retrieved from storage or was created
     * and then saved.
     *
     * @return true, if the object has never been persisted.
     */
    public boolean isNew()
    {
        return isNew;
    }

    /**
     * Sets whether the object has ever been saved.
     *
     * @param isNew true if the object has never been saved, false otherwise.
     */
    public void setNew(boolean isNew)
    {
        this.isNew = isNew;
    }

    /**
     * Returns whether the object has been modified.
     *
     * @return True if the object has been modified.
     */
    public boolean isModified()
    {
        return modified;
    }

    /**
     * Sets whether the object has been modified.
     *
     * @param modified true if the object has been modified, false otherwise.
     */
    public void setModified(boolean modified)
    {
        this.modified = modified;
    }

    /**
     * Sets the modified state for the object to be false.
     */
    public void resetModified()
    {
        modified = false;
    }


    /**
     * Returns whether this object is currently saving.
     *
     * @return true if this object is currently saving, false otherwise.
     */
    public boolean isSaving()
    {
        return saving;
    }

    /**
     * Sets whether this object is currently saving.
     *
     * @param saving true if this object is currently saving, false otherwise.
     */
    public void setSaving(boolean saving)
    {
        this.saving = saving;
    }


    /**
     * Returns whether this object is currently being loaded from the database.
     *
     * @return true if this object is currently loading, false otherwise.
     */
    public boolean isLoading()
    {
        return loading;
    }

    /**
     * Sets whether this object is currently being loaded from the database.
     *
     * @param loading true if this object is currently loading, false otherwise.
     */
    public void setLoading(boolean loading)
    {
        this.loading = loading;
    }


    /**
     * Returns whether this object was deleted from the database.
     * Note that this getter does not automatically reflect database state,
     * it will be set to true by Torque if doDelete() was called with this 
     * object. Bulk deletes and deletes via primary key do not change
     * this flag. Also, if doDelete() was called on an object which does
     * not exist in the database, the deleted flag is set to true even if
     * it was not deleted.
     *
     * @return true if this object was deleted, false otherwise.
     */
    public boolean isDeleted()
    {
        return deleted;
    }

    /**
     * Sets whether this object was deleted from the database.
     *
     * @param deleted true if this object was deleted, false otherwise.
     */
    public void setDeleted(boolean deleted)
    {
        this.deleted = deleted;
    }







    private static final List<String> FIELD_NAMES;

    static
    {
        List<String> fieldNames
                = new ArrayList<String>();
        fieldNames.add("StudentId");
        fieldNames.add("Absences");
        fieldNames.add("Firstname");
        fieldNames.add("Name");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    /**
     * Generate a list of field names.
     *
     * @return a list of field names
     */
    public static List<String> getFieldNames()
    {
        return FIELD_NAMES;
    }

    /**
     * Retrieves a field from the object by field (Java) name passed in as a String.
     *
     * @param name field name
     * @return value
     */
    public Object getByName(String name)
    {
        if (name.equals("StudentId"))
        {
            return new Integer(getStudentId());
        }
        if (name.equals("Absences"))
        {
            return new Integer(getAbsences());
        }
        if (name.equals("Firstname"))
        {
            return getFirstname();
        }
        if (name.equals("Name"))
        {
            return getName();
        }
        return null;
    }

    /**
     * Set a field in the object by field (Java) name.
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByName(String name, Object value)
        throws TorqueException, IllegalArgumentException
    {
        if (name.equals("StudentId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setStudentId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Absences"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setAbsences(((Integer) value).intValue());
            return true;
        }
        if (name.equals("Firstname"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setFirstname((String) value);
            return true;
        }
        if (name.equals("Name"))
        {
            // Object fields can be null
            if (value != null && ! String.class.isInstance(value))
            {
                throw new IllegalArgumentException("Invalid type of object specified for value in setByName");
            }
            setName((String) value);
            return true;
        }
        return false;
    }

    /**
     * Retrieves a field from the object by name passed in
     * as a String.  The String must be one of the static
     * Strings defined in this Class' Peer.
     *
     * @param name peer name
     * @return value
     */
    public Object getByPeerName(String name)
    {
        if (name.equals(fr.iut2.sil4.data.StudentPeer.STUDENT_ID))
        {
            return new Integer(getStudentId());
        }
        if (name.equals(fr.iut2.sil4.data.StudentPeer.ABSENCES))
        {
            return new Integer(getAbsences());
        }
        if (name.equals(fr.iut2.sil4.data.StudentPeer.FIRSTNAME))
        {
            return getFirstname();
        }
        if (name.equals(fr.iut2.sil4.data.StudentPeer.NAME))
        {
            return getName();
        }
        return null;
    }

    /**
     * Set field values by Peer Field Name
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPeerName(String name, Object value)
        throws TorqueException, IllegalArgumentException
    {
        if (fr.iut2.sil4.data.StudentPeer.STUDENT_ID.getSqlExpression().equals(name))
        {
            return setByName("StudentId", value);
        }
        if (fr.iut2.sil4.data.StudentPeer.ABSENCES.getSqlExpression().equals(name))
        {
            return setByName("Absences", value);
        }
        if (fr.iut2.sil4.data.StudentPeer.FIRSTNAME.getSqlExpression().equals(name))
        {
            return setByName("Firstname", value);
        }
        if (fr.iut2.sil4.data.StudentPeer.NAME.getSqlExpression().equals(name))
        {
            return setByName("Name", value);
        }
        return false;
    }

    /**
     * Retrieves a field from the object by Position as specified
     * in the xml schema.  Zero-based.
     *
     * @param pos position in xml schema
     * @return value
     */
    public Object getByPosition(int pos)
    {
        if (pos == 0)
        {
            return new Integer(getStudentId());
        }
        if (pos == 1)
        {
            return new Integer(getAbsences());
        }
        if (pos == 2)
        {
            return getFirstname();
        }
        if (pos == 3)
        {
            return getName();
        }
        return null;
    }

    /**
     * Set field values by its position (zero based) in the XML schema.
     *
     * @param position The field position
     * @param value field value
     * @return True if value was set, false if not (invalid position / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPosition(int position, Object value)
        throws TorqueException, IllegalArgumentException
    {
        if (position == 0)
        {
            return setByName("StudentId", value);
        }
        if (position == 1)
        {
            return setByName("Absences", value);
        }
        if (position == 2)
        {
            return setByName("Firstname", value);
        }
        if (position == 3)
        {
            return setByName("Name", value);
        }
        return false;
    }



    /**
     * Stores an object in the database.  If the object is new,
     * it is inserted; otherwise an update is performed.
     *
     * @param toSave the object to be saved, not null.
     *
     * @throws TorqueException if an error occurs during saving.
     */
    public void save() throws TorqueException
    {
        save(StudentPeer.DATABASE_NAME);
    }

    /**
     * Stores an object in the database.  If the object is new,
     * it is inserted; otherwise an update is performed.
     *
     * @param toSave the object to be saved, not null.
     * @param dbName the name of the database to which the object
     *        should be saved.
     *
     * @throws TorqueException if an error occurs during saving.
     */
    public void save(String dbName) 
            throws TorqueException
    {
        Connection con = null;
        try
        {
            con = Transaction.begin(dbName);
            save(con);
            Transaction.commit(con);
        }
        catch(TorqueException e)
        {
            Transaction.safeRollback(con);
            throw e;
        }
    }

    /**
     * Stores an object in the database.  If the object is new,
     * it is inserted; otherwise an update is performed.  This method
     * is meant to be used as part of a transaction, otherwise use
     * the save() method and the connection details will be handled
     * internally.
     *
     * @param toSave the object to be saved, not null.
     * @param con the connection to use for saving the object, not null.
     *
     * @throws TorqueException if an error occurs during saving.
     */
    public void save(Connection con) 
            throws TorqueException
    {
        if (isSaving())
        {
            return;
        }
        try
        {
            setSaving(true);
            // If this object has been modified, then save it to the database.
            if (isModified())
            {
                if (isNew())
                {
                    StudentPeer.doInsert((Student) this, con);
                    setNew(false);
                }
                else
                {
                    StudentPeer.doUpdate((Student) this, con);
                }
            }

        }
        finally
        {
            setSaving(false);
        }
    }




    /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param key studentId ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        
    {
        setStudentId(((NumberKey) key).intValue());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) 
    {
        setStudentId(Integer.parseInt(key));
    }


    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
        return SimpleKey.keyFor(getStudentId());
    }



    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     */
    public Student copy() throws TorqueException
    {
        return copy(true);
    }

    /**
     * Makes a copy of this object using a connection.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     *
     * @param con the database connection to read associated objects.
     */
    public Student copy(Connection con) throws TorqueException
    {
        return copy(true, con);
    }

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     */
    public Student copy(boolean deepcopy) throws TorqueException
    {
        Student student = new Student();

        return copyInto(student, deepcopy);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     * @param con the database connection to read associated objects.
     */
    public Student copy(boolean deepcopy, Connection con) throws TorqueException
    {
        Student student = new Student();

        return copyInto(student, deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    public Student copyInto(Student copyObj) throws TorqueException
    {
        return copyInto(copyObj, true);
    }

    /**
     * Fills the copyObj with the contents of this object using connection.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param con the database connection to read associated objects.
     */
    public Student copyInto(Student copyObj, Connection con) throws TorqueException
    {
        return copyInto(copyObj, true, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     */
    protected Student copyInto(Student copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setStudentId(0);
        copyObj.setAbsences(absences);
        copyObj.setFirstname(firstname);
        copyObj.setName(name);

        if (deepcopy)
        {
        }
        return copyObj;
    }
        
    
    /**
     * Fills the copyObj with the contents of this object using connection.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     * @param con the database connection to read associated objects.
     */
    public Student copyInto(Student copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setStudentId(0);
        copyObj.setAbsences(absences);
        copyObj.setFirstname(firstname);
        copyObj.setName(name);

        if (deepcopy)
        {
        }
        return copyObj;
    }

    /** The Peer class */
    private static final fr.iut2.sil4.data.StudentPeer peer
            = new fr.iut2.sil4.data.StudentPeer();

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public fr.iut2.sil4.data.StudentPeer getPeer()
    {
        return peer;
    }

    /**
     * Retrieves the TableMap object related to this Table data without
     * compiler warnings of using getPeer().getTableMap().
     *
     * @return The associated TableMap object.
     */
    public TableMap getTableMap() throws TorqueException
    {
        return fr.iut2.sil4.data.StudentPeer.getTableMap();
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Student:\n");
        str.append("studentId = ")
           .append(getStudentId())
           .append("\n");
        str.append("absences = ")
           .append(getAbsences())
           .append("\n");
        str.append("firstname = ")
           .append(getFirstname())
           .append("\n");
        str.append("name = ")
           .append(getName())
           .append("\n");
        return(str.toString());
    }

    /**
     * Compares the primary key of this instance with the key of another.
     *
     * @param toCompare The object to compare to.
     * @return Whether the primary keys are equal and the object have the
     *         same class.
     */
    public boolean equals(Object toCompare)
    {
        if (toCompare == null)
        {
            return false;
        }
        if (this == toCompare)
        {
            return true;
        }
        if (!getClass().equals(toCompare.getClass()))
        {
            return false;
        }
        Student other = (Student) toCompare;
        if (getPrimaryKey() == null || other.getPrimaryKey() == null)
        {
            return false;
        }
        return getPrimaryKey().equals(other.getPrimaryKey());
    }

    /**
     * If the primary key is not <code>null</code>, return the hashcode of the
     * primary key.  Otherwise calls <code>Object.hashCode()</code>.
     *
     * @return an <code>int</code> value
     */
    public int hashCode()
    {
        ObjectKey ok = getPrimaryKey();
        if (ok == null)
        {
            return super.hashCode();
        }

        return ok.hashCode();
    }



    /**
     * Compares the content of this object to another object
     *
     * @param toCompare The object to compare to.
     * @return true if all of the columns in the other object have 
     *         the same value as the objects in this class.
     */
    public boolean valueEquals(Student toCompare)
    {
        if (toCompare == null)
        {
            return false;
        }
        if (this == toCompare)
        {
            return true;
        }
        if (this.studentId != toCompare.getStudentId())
        {
            return false;
        }
        if (this.absences != toCompare.getAbsences())
        {
            return false;
        }
        if (!ObjectUtils.equals(this.firstname, toCompare.getFirstname()))
        {
            return false;
        }
        if (!ObjectUtils.equals(this.name, toCompare.getName()))
        {
            return false;
        }
        return true;
    }



}
