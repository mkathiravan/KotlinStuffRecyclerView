package net.kathir.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION)


{

    val allEmployeeList: ArrayList<String> get() {
        val employeeArrayList = ArrayList<String> ()
        var name = " "
        val selectQuery = "SELECT  * FROM $TABLE_EMPLOYEE"
        val db = this.readableDatabase
        val c = db.rawQuery(selectQuery,null)
        if(c.moveToFirst()){
            do {
                name = c.getString(c.getColumnIndex(KEY_FIRST_NAME))
                employeeArrayList.add(name)
            }while (c.moveToNext())
            Log.d("array", employeeArrayList.toString())
        }

        return employeeArrayList
    }


    init {
        Log.d("table", CREATE_TABLE_EMPLOYEE)
    }



    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(CREATE_TABLE_EMPLOYEE)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {

        db.execSQL("DROP TABLE IF EXISTS '$TABLE_EMPLOYEE'")
        onCreate(db)
    }

    fun addEmployeeDetail(employee: String): Long {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(KEY_FIRST_NAME,employee)
        return db.insert(TABLE_EMPLOYEE,null,values)
    }


    companion object
    {
        var DATABASE_NAME = "employee_database"
        private val DATABASE_VERSION = 1
        private val TABLE_EMPLOYEE = "employee"
        private val KEY_ID = "id"
        private val KEY_FIRST_NAME = "name"


        /*CREATE TABLE employee ( id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);*/

        private val CREATE_TABLE_EMPLOYEE = ("CREATE TABLE "
                + TABLE_EMPLOYEE + "(" + KEY_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT," + KEY_FIRST_NAME + " TEXT );")
    }
}






