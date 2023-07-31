package com.example.database

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import androidx.core.content.contentValuesOf
import kotlin.math.log

class DataBaseHelper(context : Context , name : String,factory: SQLiteDatabase.CursorFactory? ,version: Int): SQLiteOpenHelper(context,name,factory,1){
    override fun onCreate(db: SQLiteDatabase?) {
        var createtable = "create table DatabaseForm(id Integer primary key autoincrement,Fname text , Lname text, Email text , Pass text , Number Integer , Age Integer , City text , State text)"
        db?.execSQL(createtable)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

    fun insertData(
        Fname: String,
        Lname: String,
        Email: String,
        Pass: String,
        Number: String,
        Age: String,
        City: String,
        State: String
    )
    {
        var c = ContentValues()
        c.put("Fname ",Fname)
        c.put("Lname ",Lname)
        c.put("Email ",Email)
        c.put("Pass ",Pass)
        c.put("Number ",Number)
        c.put("Age ",Age)
        c.put("City ",City)
        c.put("State ",State)

        var write = writableDatabase

        var result = write.insert("DatabaseForm",null,c)

        Log.e("TAG", "insertData: "+result)
    }

    fun Display
                (  Fname: String,
                  Lname: String,
                  Email: String,
                  Pass: String,
                  Number: String,
                  Age: String,
                  City: String,
                  State: String)
    {
        var read = readableDatabase
        var query = "select * from DatabaseForm"
        var cursor : Cursor = read.rawQuery(query,null)
        cursor.moveToFirst()
        do {

            var id = cursor.getInt(0)
            var Fname = cursor.getString(1)
            var Lname = cursor.getString(2)
            var Email = cursor.getString(3)
            var Pass = cursor.getString(4)
            var Number = cursor.getInt(5)
            var Age = cursor.getInt(6)
            var City = cursor.getString(7)
            var State = cursor.getString(8)


            Log.e("TAG", "Display: "+id +"  " + Fname +"  " + Lname +"  " + Email +"  " + Pass +"  " + Number +"  " + Age
                    +"  " + City +"  " + State  )

        }while (cursor.moveToNext())
    }

    fun update  (id:Int)
    {
        var update = writableDatabase
        var c = ContentValues()
        c.put("name", "prachi")
        var result = update.update("DatabaseForm",c,"id=?", arrayOf(id.toString()))
        Log.e("TAG", "update: "+ result )
    }

    fun delete(id:Int)
    {
        var delete = writableDatabase
        var result = delete.delete("DatabaseForm","id=?", arrayOf(id.toString()))
        Log.e("TAG", "delete: "+ result )
    }

}