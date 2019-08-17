package net.kathir.myapplication

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RetrofitViewActivity  : AppCompatActivity() {

    lateinit var progressDialog: ProgressDialog
    var dataList = ArrayList<DataModel> ()
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: DataAdpter



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.retrofit_view)
        recyclerView = findViewById(R.id.recycler_view)

        recyclerView.adapter = DataAdpter(dataList,this)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)


        progressDialog = ProgressDialog(this)
        progressDialog.setTitle("Loading")
        progressDialog.setCancelable(false)
        progressDialog.show()
        getData()
    }

    private fun getData() {
        val call : Call<List<DataModel>> = ApiClient.getClient.getPhotos()
        call.enqueue(object : Callback<List<DataModel>>
        {
            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                progressDialog.dismiss()

            }

            override fun onResponse(call: Call<List<DataModel>>, response: Response<List<DataModel>>) {
                progressDialog.dismiss()
                dataList.addAll(response!!.body()!!) // Sure the value won't be null
                recyclerView.adapter!!.notifyDataSetChanged()
            }

        }


        )

    }
}

