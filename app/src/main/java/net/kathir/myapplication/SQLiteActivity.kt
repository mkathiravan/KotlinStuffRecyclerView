package net.kathir.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SQLiteActivity : AppCompatActivity(){

    private var btnStore: Button? = null
    private var btnGetAll: Button? = null
    private var etName: EditText? = null
    private var databaseHelper: DatabaseHelper? = null
    private var tvnames: TextView? = null
    private var arrayList: ArrayList<String>? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sqlite_main)

        databaseHelper = DatabaseHelper(this)
        tvnames = findViewById(R.id.tvnames) as TextView
        btnStore = findViewById(R.id.btnstore) as Button
        btnGetAll = findViewById(R.id.btnget) as Button
        etName = findViewById(R.id.etname) as EditText

        btnStore!!.setOnClickListener {
            databaseHelper!!.addEmployeeDetail(etName!!.text.toString())
            etName!!.setText("")
            Toast.makeText(this@SQLiteActivity, "Stored Successfully!", Toast.LENGTH_SHORT).show()

        }

        btnGetAll!!.setOnClickListener {
            arrayList  = databaseHelper!!.allEmployeeList
            tvnames!!.text = ""
            for(i in arrayList!!.indices){
                tvnames!!.text = tvnames!!.text.toString() + " , " + arrayList!![i]
            }

        }


    }

}