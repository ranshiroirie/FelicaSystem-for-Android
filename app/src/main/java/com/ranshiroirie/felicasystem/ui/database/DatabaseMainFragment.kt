package com.ranshiroirie.felicasystem.ui.database

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

class DatabaseMainFragment : Fragment() {

    private lateinit var databaseMainViewModel: DatabaseMainViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        databaseMainViewModel =
                ViewModelProviders.of(this).get(DatabaseMainViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_database_main, container, false)
        val textView: TextView = root.findViewById(R.id.text_database_main)
        databaseMainViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}