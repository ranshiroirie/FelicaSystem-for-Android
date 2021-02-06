package com.ranshiroirie.felicasystem.ui.felica_device_read

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ranshiroirie.felicasystem.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_felica_device_read_info.*

private const val ARG_PARAM_FELICA_DEVICE_NAME = "felica_device_name"
private const val ARG_PARAM_FELICA_ID = "felica_device_id"
private const val ARG_PARAM_FELICA_PMM = "felica_device_pmm"
private const val ARG_PARAM_FELICA_SYS = "felica_device_sys"
private const val ARG_PARAM_FELICA_REG_DATE = "felica_device_reg_date"

class FelicaDeviceReadInfoFragment : Fragment() {
    private var paramFelicaDeviceName: String? = null
    private var paramFelicaID: String? = null
    private var paramFelicaPMM: String? = null
    private var paramFelicaSYS: String? = null
    private var paramFelicaRegDate: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paramFelicaDeviceName = it.getString(ARG_PARAM_FELICA_DEVICE_NAME)
            paramFelicaID = it.getString(ARG_PARAM_FELICA_ID)
            paramFelicaPMM = it.getString(ARG_PARAM_FELICA_PMM)
            paramFelicaSYS = it.getString(ARG_PARAM_FELICA_SYS)
            paramFelicaRegDate = it.getString(ARG_PARAM_FELICA_REG_DATE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_felica_device_read_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        textView_felica_info_bar_id.text = paramFelicaID
        textView_felica_info_bar_pmm.text = paramFelicaPMM
        textView_felica_info_bar_sys.text = paramFelicaSYS

//        parentFragment.back_button_felica_device_read_info?.isVisible = true
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String, param3: String, param4: String, param5: String) =
            FelicaDeviceReadInfoFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM_FELICA_DEVICE_NAME, param1)
                    putString(ARG_PARAM_FELICA_ID, param2)
                    putString(ARG_PARAM_FELICA_PMM, param3)
                    putString(ARG_PARAM_FELICA_SYS, param4)
                    putString(ARG_PARAM_FELICA_REG_DATE, param5)
                }
            }
    }
}