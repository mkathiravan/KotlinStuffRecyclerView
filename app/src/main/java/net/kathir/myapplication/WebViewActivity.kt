package net.kathir.myapplication

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button

class WebViewActivity : AppCompatActivity()
{

    private var btnHtml: Button? = null
    private var btnJS: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.webview_main)

        btnHtml = findViewById(R.id.btnHtml) as Button
        btnJS = findViewById(R.id.btnJS) as Button

        btnHtml!!.setOnClickListener {
            val intent = Intent(this@WebViewActivity, HtmlActivity::class.java)
            startActivity(intent)
        }
        btnJS!!.setOnClickListener {
            val intent = Intent(this@WebViewActivity, JavaScriptActivity::class.java)
            startActivity(intent)
        }
    }



}