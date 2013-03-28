package com.digitalcr.android;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.SlidingDrawer;

public class Schedule_data extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DICTIONARY_TABLE_NAME = "SCHEDULE";
    static final String SNO = null;
	
	private static final String TIME = null;
	private static final String COLLEGE_ID = null;
	private static final String DEPT_NAME = null;
	private static final String BATCH = null;
	private static final String COLLEGE = "COLLEGE_INFO";
 static final String COLLEGE_NAME = null;
	private static final String COUNTRY = null;
	private static final String CITY = null;
	private static final String COLLEGE_NO = null;
	 private static final String COLLEGE_DETAILS =
             "CREATE TABLE " + COLLEGE + " (" +
             COLLEGE_NO + " INTEGER PRIMARY KEY, " +
             COLLEGE_NAME + " TEXT," +CITY+"TEXT,"+COUNTRY+"TEXT"+");";
 static final String COURSE = null;
	private static final String SCHEDULE = null;

    private static final String SCHEDULE_SCHEMA =
                "CREATE TABLE " + SCHEDULE + " (" +
               SNO  + " INTEGER PRIMARY KEY, " +
                COURSE + " TEXT, " +TIME+ "DATETIME, "
               +DEPT_NAME + "TEXT," +BATCH+ "INTEGER," 
                + COLLEGE_ID + " INTEGER  NOT NULL,"
               +COLLEGE_NAME+ "TEXT NOT NULL," 
                +COLLEGE_ID+ ","+COLLEGE_NAME+" FOREIGN KEY REFERENCES"+ COLLEGE+(COLLEGE_NO+","+ COLLEGE_NAME)+ ");";

    Schedule_data(Context context) {
        super(context, SCHEDULE, null, DATABASE_VERSION);
    } 

    @Override
    public void onCreate(SQLiteDatabase db) {
    
        db.execSQL(SCHEDULE);
    }
    public Cursor getdata(){
		String queries="SELECT DISTINCT * FROM"+SCHEDULE;
		SQLiteDatabase sqLiteDatabase=getReadableDatabase();
		
		Cursor cursor=sqLiteDatabase.rawQuery(queries, null);
		cursor.close();
		return cursor;
		}
    
    void putData(){
    	SQLiteDatabase sq=getWritableDatabase();
    	ContentValues contentValues=new ContentValues();
    	contentValues.put(Schedule_data.COLLEGE_ID, 1);
    	contentValues.put(Schedule_data.COURSE, "DATABASE");
    	contentValues.put(Schedule_data.BATCH, 2010-2014);
    	
    	contentValues.put(Schedule_data.SNO, 1);
    	 sq.insert(DICTIONARY_TABLE_NAME, null, contentValues);
      
    	contentValues.put(Schedule_data.COLLEGE_ID, 2);
    	contentValues.put(Schedule_data.COURSE, "OS");
    	contentValues.put(Schedule_data.BATCH, 2010-2014);
    	
    	contentValues.put(Schedule_data.SNO, 2);
    	sq.insert(DICTIONARY_TABLE_NAME, null, contentValues);
    
    	
    }

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}
