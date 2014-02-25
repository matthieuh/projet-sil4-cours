package fr.iut2.sil4.data;

import java.util.List;

import org.apache.torque.TorqueException;
import org.apache.torque.criteria.Criteria;


/**
 * Student Table
 *
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Mon Jan 06 15:59:13 CET 2014]
 *
 * You should add additional methods to this class to meet the
 * application requirements.  This class will only be generated as
 * long as it does not already exist in the output directory.
 */

public  class Student
    extends fr.iut2.sil4.data.BaseStudent
{
    /** Serial version */
    private static final long serialVersionUID = 1389020353919L;

    public float getMoyenne() {
    	int total = 0;
    	float moy = 0;
    	
    	try {
    		if(this.getNotes().size() > 0){
				for(Note note : this.getNotes()) {
					total += note.getPoints();
				}
				moy = (float) (total / (this.getNotes().size() * 1.0));
    		}
		} catch (TorqueException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return moy;
    	
    }
}
