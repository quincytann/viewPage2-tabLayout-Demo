package com.example.demo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment1.*

class Fragment1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment1, container, false)


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val sp = activity?.getSharedPreferences("config", Context.MODE_PRIVATE) ?: return

        var cnt = sp.getInt("count", 0)
        val str = if (cnt == 0) "" else sp.getString(cnt.toString(), "")
        tv_show.text = str

        bt.setOnClickListener {
            val tmp = tv_show.text.toString()
            val text = tmp + "\n" + et.text
            tv_show.text = text
            cnt++
            with(sp.edit()) {
                remove((cnt - 1).toString())
                putString(cnt.toString(), text)
                putInt("count", cnt)
                commit()
            }
        }
    }
}