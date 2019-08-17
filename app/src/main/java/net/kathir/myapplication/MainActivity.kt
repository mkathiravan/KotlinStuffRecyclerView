package net.kathir.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sqlite_btn = findViewById(R.id.kotlin_sqlite) as Button

        sqlite_btn.setOnClickListener(View.OnClickListener {

            val intent = Intent(this@MainActivity, SQLiteActivity::class.java)
            startActivity(intent)
        })

        val recyclerView_search = findViewById(R.id.recyclerView_search) as Button

        recyclerView_search.setOnClickListener(View.OnClickListener {

            val  intent = Intent(this@MainActivity,RecyclerViewSearch::class.java)
            startActivity(intent)
        })

        val webview_load = findViewById(R.id.load_webview) as Button

            webview_load.setOnClickListener(View.OnClickListener {

                val  intent = Intent(this@MainActivity,JavaScriptActivity::class.java)
                startActivity(intent)

            })

        val retrofit_view = findViewById(R.id.retrofit_view) as Button

            retrofit_view.setOnClickListener(View.OnClickListener {

                val  intent = Intent(this@MainActivity,RetrofitViewActivity::class.java)
                startActivity(intent)

            })


    }
}
