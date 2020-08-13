package com.yethiha.newsapp_kt.fragement

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.yethiha.newsapp_kt.MainActivity2
import com.yethiha.newsapp_kt.R
import com.yethiha.newsapp_kt.adapter.TopHeadLineAAdapter
import com.yethiha.newsapp_kt.model.Article
import com.yethiha.newsapp_kt.model.News
import com.yethiha.newsapp_kt.viewmodel.Newsviewmodel
import kotlinx.android.synthetic.main.fragment_topheadline.*


class TopHeadLineFragment : Fragment() ,TopHeadLineAAdapter.ClickListener {
    lateinit var viewModel: Newsviewmodel

    var topHeadLineAAdapter: TopHeadLineAAdapter = TopHeadLineAAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_topheadline, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var viewmodel = ViewModelProvider(this).get(Newsviewmodel::class.java)


        viewmodel.LoadResult()
        recyclerView_toheadline.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = topHeadLineAAdapter


        }
        topHeadLineAAdapter.setOnclicklistener(this)



        viewmodel.getResult().observe(viewLifecycleOwner, Observer<News> { news ->
            topHeadLineAAdapter.updateArticel((news.articles))


        })


        viewmodel.getLoading().observe(viewLifecycleOwner, Observer { isLoading ->

            progressLoading.visibility = if (isLoading) {
                View.VISIBLE
            } else {
                View.INVISIBLE
            }
        })

        viewmodel.getErrorStatus().observe(viewLifecycleOwner, Observer { status ->
            if (status) {
                viewmodel.getErrorMessage().observe(viewLifecycleOwner, Observer { message ->
                    error.text = message


                })
            }

        })
    }

    override fun Click(article: Article) {
        var action =
            TopHeadLineFragmentDirections.actionTopHeadLineFragmentToTwoFragment(article.publishedAt,article.urlToImage)
        findNavController().navigate(action)
    }

//    @RequiresApi(Build.VERSION_CODES.M)
//    fun isOnline(context: Context): Boolean {
//        val connectivityManager =
//            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        if (connectivityManager != null) {
//            val capabilities =
//                connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
//            if (capabilities != null) {
//                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
//                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_CELLULAR")
//                    return true
//                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
//                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_WIFI")
//                    return true
//                } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET)) {
//                    Log.i("Internet", "NetworkCapabilities.TRANSPORT_ETHERNET")
//                    return true
//                }
//            }
//        }
//        return false
//
//
//    }
}


    /*  override fun Click(article: Article) {
          Log.d("hello","hello")
          var action = TopHeadLineFragmentDirections.actionTopHeadLineFragmentToTwoFragment(article.description)
          findNavController().navigate(action)

      }*/
