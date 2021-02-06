package com.ranshiroirie.felicasystem.ui.osaihu_read

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.ranshiroirie.felicasystem.R
import kotlinx.android.synthetic.main.activity_main.view.*

class OsaihuReadMainFragment : Fragment() {

    private lateinit var osaihuReadMainViewModel: OsaihuReadMainViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        osaihuReadMainViewModel =
                ViewModelProviders.of(this).get(OsaihuReadMainViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_osaihu_read_main, container, false)
        val textView: TextView = root.findViewById(R.id.text_osaihu_read_main)
        osaihuReadMainViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })

        return root
    }
}