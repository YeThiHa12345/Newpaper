package com.yethiha.newsapp_kt.fragement

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.GlideBuilder
import com.yethiha.newsapp_kt.R
import com.yethiha.newsapp_kt.adapter.TopHeadLineAAdapter
import kotlinx.android.synthetic.main.fragment_two.*
import kotlinx.android.synthetic.main.item_topheadline.view.*


class twoFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_two, container, false)
    }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    var messageArgs = arguments?.let {
          twoFragmentArgs.fromBundle(it)
       }
      var message:String? = messageArgs?.message.toString()
       text.text =message

      var image:String? = messageArgs?.image.toString()

//      Glide.with(this).load(image).into(image12)
      Glide.with(this).load(image).into(image12)

   }
    }
// var message:String? = messageArgs?.mesage.toString()
//        txt_two.text = message