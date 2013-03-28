package com.digitalcr.android;



import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Shout_data extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String SHOUT_TABLE = "SHOUT";
	private static final String SNO = null;
	private static final String SUBJECT = null;
	private static final String TIME = null;
	private static final String COLLEGE_ID = null;
	private static final String DEPT_NAME = null;
	private static final String BATCH = null;
	private static final String COLLEGE = "COLLEGE_INFO";
	private static final String COLLEGE_NAME = null;
	private static final String COUNTRY = null;
	private static final String CITY = null;
	 private static final String COLLEGE_DETAILS =
             "CREATE TABLE " + COLLEGE + " (" +
             COLLEGE_ID + " INTEGER PRIMARY KEY, " +
             COLLEGE_NAME + " TEXT," +CITY+"TEXT,"+COUNTRY+"TEXT"+");";
	private static final String PERSON_TABLE = null;
	private static final String PERSON_ID = null;
	private static final String FIRST_NAME = null;
	private static final String LAST_NAME = null;
	private static final String DEPTT = null;
	 private static final String PERSON =
             "CREATE TABLE " + PERSON_TABLE + " (" +
             PERSON_ID + " INTEGER PRIMARY KEY, " +
             FIRST_NAME + " TEXT," +LAST_NAME+"TEXT,"+DEPTT+"TEXT"+");";
	private static final String TEMPLATE = null;
	private static final String COLLEGE_NO = null;

    private static final String SHOUT =
                "CREATE TABLE " + SHOUT_TABLE + " (" +
               SNO  + " INTEGER PRIMARY KEY, "
               +   TEMPLATE + " TEXT, " 
               +TIME+ "DATETIME,"
               + COLLEGE_ID 
               + " INTEGER  NOT NULL,"+ COLLEGE_NAME+ "TEXT NOT NULL," +COLLEGE_ID+"," +COLLEGE_NAME+"FOREIGN KEY REFERENCES" + COLLEGE+(COLLEGE_NO +","+COLLEGE_NAME)+","
               + PERSON_ID + " INTEGER  NOT NULL FOREIGN KEY REFERENCES" + PERSON_TABLE+(PERSON_ID)+ ");";

    Shout_data(Context context) {
        super(context, SHOUT_TABLE, null, DATABASE_VERSION);
    }
    public Cursor getdata(){
  		String queries="SELECT * FROM"+SHOUT_TABLE;
  		SQLiteDatabase sqLiteDatabase=getReadableDatabase();
  		Cursor cursor=sqLiteDatabase.rawQuery(queries, null);
  		cursor.close();
  		return cursor;
  		}
      

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SHOUT_TABLE);
    }

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}
}

