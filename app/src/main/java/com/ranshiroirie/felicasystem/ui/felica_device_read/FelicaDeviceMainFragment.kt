package com.ranshiroirie.felicasystem.ui.felica_device_read

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProviders
import com.ranshiroirie.felicasystem.R
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.fragment_felica_device_read_main.*

class FelicaDeviceMainFragment : Fragment() {

    private lateinit var felicaDeviceMainViewModel: FelicaDeviceMainViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        felicaDeviceMainViewModel =
                ViewModelProviders.of(this).get(FelicaDeviceMainViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_felica_device_read_main, container, false)
//        felicaDeviceMainViewModel.text.observe(viewLifecycleOwner, Observer {
//        })

        val firstFragment = FelicaDeviceReadGuideFragment()
        val fragmentManager = parentFragmentManager.beginTransaction()
        fragmentManager.add(R.id.parent_fragment_felica_device, firstFragment)
        fragmentManager.commit()

        return root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//            back_button_felica_device_read_info.setOnClickListener {
//                val fragmentManager = parentFragmentManager
//                fragmentManager.popBackStack("fragmentFelicaDeviceReadInfo", FragmentManager.POP_BACK_STACK_INCLUSIVE)
//            back_button_felica_device_read_info.isVisible = false
//        }
    }
}