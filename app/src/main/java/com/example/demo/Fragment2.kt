package com.example.demo

import android.os.Bundle
import android.provider.CallLog
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment2.*
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class Fragment2 : Fragment() {

    private val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment2, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val root = "/storage/emulated/0/"
        val files = File(root).listFiles()
        if (!files.isNullOrEmpty()) {
            var text = ""
            for (f in files) {
                if (f.isDirectory) {
                    val time = f.lastModified()
                    text += f.name + "  " + sdf.format(time) + "\n"
                }
            }
            tv_show2.text = text
        }
    }

}