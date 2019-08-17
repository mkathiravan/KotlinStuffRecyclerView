package net.kathir.myapplication

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.BufferedReader
import java.io.InputStreamReader

class JavaScriptActivity : AppCompatActivity()
{

    private var webView: WebView? = null
    private var editText: EditText? = null
    private var button: Button? = null


    private val htmlData: String get() {
        val html = StringBuilder()
        try {

            val  assetManager = assets
            val input = assetManager.open("load_JS.html")
            val  br = BufferedReader(InputStreamReader(input))
            var line : String
            while ((br.readLine().also { line = it } != null))
            {
                html.append(line)
            }

            br.close()

        }
        catch (e : Exception)
        {

        }

        return html.toString()
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_java_script)

        webView = findViewById(R.id.mybrowser) as WebView

        val myJavaScriptInterface = MyJavaScriptInterface(this)
        webView!!.addJavascriptInterface(myJavaScriptInterface,"AndroidFunction")

        webView!!.settings.javaScriptEnabled = true
        webView!!.loadData(htmlData, "text/html", "UTF-8")

        editText = findViewById(R.id.msg) as EditText
        button = findViewById(R.id.sendmsg) as Button

        button!!.setOnClickListener{
            val msgToSend = editText!!.text.toString()
            webView!!.loadUrl("javascript:callFromActivity(\"$msgToSend\")")
        }
    }


    inner class MyJavaScriptInterface internal constructor(internal var mContext: Context)
    {
        @JavascriptInterface
        fun showToast(toast : String)
        {
            Toast.makeText(mContext,toast,Toast.LENGTH_SHORT).show()
        }

        @JavascriptInterface
        fun openAndroidDialog()
        {
            val myDialog = AlertDialog.Builder(this@JavaScriptActivity)
            myDialog.setTitle("Dialog of JS!")
            myDialog.setMessage("This is the Webview and html-JS file !!!")
            myDialog.setPositiveButton("Cool!", null)
            myDialog.show()
        }

    }


}