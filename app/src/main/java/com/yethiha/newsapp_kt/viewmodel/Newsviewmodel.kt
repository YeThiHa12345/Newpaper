package com.yethiha.newsapp_kt.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yethiha.newsapp_kt.API.ApiClient
import com.yethiha.newsapp_kt.model.News
import kotlinx.android.synthetic.main.fragment_topheadline.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Newsviewmodel : ViewModel() {



    private  var result: MutableLiveData <News> = MutableLiveData()
    private  var errorMessage : MutableLiveData<String> = MutableLiveData()
    private  var errorStatus: MutableLiveData<Boolean> = MutableLiveData()
    private  var Loading : MutableLiveData<Boolean> = MutableLiveData()

    fun getResult():LiveData<News> = result
    fun getErrorMessage():LiveData<String> = errorMessage
    fun getErrorStatus():LiveData<Boolean> = errorStatus
    fun  getLoading():LiveData<Boolean> = Loading

    fun  LoadResult(){
        var apiClient = ApiClient()
        var apiCall = apiClient.getTopHeadLines()

        apiCall.enqueue(object : Callback<News> {
            override fun onFailure(call: Call<News>, t: Throwable) {
                Loading.value = false
               errorStatus.value= true
                errorMessage.value = t.toString()

            }

            override fun onResponse(call: Call<News>, response: Response<News>) {
                //txtResponse.text = response.body()?.articles!!.get(1).author
                Loading.value = false
                errorStatus.value = false
                result.value = response.body()

            }


        })
    }

}