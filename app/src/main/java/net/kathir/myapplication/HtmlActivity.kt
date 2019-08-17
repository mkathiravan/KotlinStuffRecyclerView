package net.kathir.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.webkit.WebView

class HtmlActivity : AppCompatActivity()
{

    private var webView : WebView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_html)

        webView = findViewById(R.id.webView)

        val htmlText = "" +
                "<html>" +
                "<head>" +
                "<style = 'text/css'>" +
                ".head{background: #cecb33;color: white;padding: 10px;border-radius: 7px;}" +
                ".body{background: #FF4081;height: 75%;color: white;padding: 10px;border-radius: 7px;}" +
                ".foot{background: #40ff56;color: white;padding: 10px;border-radius: 7px;}" +
                "</style>" +
                "</head>" +
                "<body>" +
                "<div class='head'>" +
                "<h1>This HTML is loaded in WebView</h1>" +
                "</div>" +
                "<br>" +
                "<div class='body'>" +
                "<p>Body of the page</p>" +
                "<h2>Header 2</h2>" +
                "<h3>Header 3</h3>" +
                "<h4>Header 4</h4>" +
                "<h5>Header 5</h5>" +
                "</div>" +
                "<br>" +
                "<div class='foot'>" +
                "<p>Footer of the page</p>" +
                "</div>" +
                "</body>" +
                "</html>"

        webView!!.loadData(htmlText,"text/html",null)
    }


}