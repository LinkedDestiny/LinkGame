package com.android.game.databasetest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.android.game.R;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;


public class DBManager {

	public static final String DB_NAME = "gamedata.db";
	public static final String PACKAGE_NAME = "com.android.game";
	public static final String DB_PATH = "/data" + Environment.getDataDirectory().getAbsolutePath() + "/"
			+ PACKAGE_NAME + "/database/";
	
	protected SQLiteDatabase database = null;
	private Context context;
	
	public DBManager( Context context ){
		this.context = context;
	}
	
	/**
	 * @function open the Database
	 */
	public void openDatabase(){
		if( database != null && database.isOpen() ){
			return;
		}
		this.database = this.openDatabase( DB_PATH + "/" + DB_NAME );
	}
	
	/**
	 * @function open or copy the Database
	 * @param dbfile
	 * 	path and name of the Database
	 * @return
	 * 	SQLiteDatabaes
	 */
	public SQLiteDatabase openDatabase( String dbfile ){
		try{
			File file = new File( DB_PATH );
			if( !file.exists() ){
				file.mkdir();
			}
			if (!(new File(dbfile)).exists()){   
	            InputStream is = this.context.getResources().openRawResource(R.raw.data);
	            FileOutputStream fos = new FileOutputStream(dbfile);   
	            byte[] buffer = new byte[8192];   
	            int count = 0;   
	            while ((count = is.read(buffer)) > 0)   
	            {   
	                fos.write(buffer, 0, count);  
	            }   
	
	            fos.close();   
	            is.close();   
	        }
	        	
	    }catch (Exception e){   
	    	e.printStackTrace();
	    }
		SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(dbfile, null );
		return db; 
	}
	
	/**
	 * @function close the Database
	 */
	public void closeDatabase(){
		this.database.close();
	}
	
	public void execSQL( String sql ){
		database.execSQL(sql);
	}
	
	public Cursor rawQuery( String sql ){
		return database.rawQuery(sql, null);
	}
	
	public void resetDatabase(){
		(new File(DB_PATH + "/" + DB_NAME)).delete();
		this.database = this.openDatabase( DB_PATH + "/" + DB_NAME );
	}
}