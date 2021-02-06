package com.ranshiroirie.felicasystem

import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ranshiroirie.felicasystem.felicautil.FelicaReader
import com.ranshiroirie.felicasystem.felicautil.FelicaReaderInterface
import com.ranshiroirie.felicasystem.ui.felica_device_read.FelicaDeviceReadInfoFragment
import kotlinx.android.synthetic.main.activity_main.*
import java.util.ArrayList

class MainActivity : AppCompatActivity(){

    var statusFragmentDisplayed : Int = R.id.nav_felica_device_read
    val felica = FelicaReader(this, this)
    val fragmentFelicaDeviceReadInfo = FelicaDeviceReadInfoFragment()
    lateinit var navController : NavController
    val bundle = Bundle()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        felica.setListener(felicaListener)

//        BtmNavViewHelper().customizeBtmView(navView)

       navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.

        //アカウント管理を無効化
        nav_view.menu.getItem(3).isCheckable = false
        nav_view.selectedItemId = R.id.nav_felica_device_read

        nav_view.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_felica_device_read-> {
                    changeBtmNavIconColor(R.color.color_btm_nav_icon_felica_device, R.id.nav_felica_device_read, getString(R.string.title_felica_device_read))
                }
                R.id.nav_osaihu_read -> {
                    changeBtmNavIconColor(R.color.color_btm_nav_icon_osaihu, R.id.nav_osaihu_read, getString(R.string.title_osaihu_read))
                }
                R.id.nav_database -> {
                    changeBtmNavIconColor(R.color.color_btm_nav_icon_database, R.id.nav_database, getString(R.string.title_database))
                }
//                R.id.nav_account -> {
//
//                }
            }
            true
        }


    }

    override fun onResume() {
        super.onResume()
        felica.start()
    }
    override fun onPause() {
        super.onPause()
        felica.stop()
    }

    override fun onBackPressed() {
//        super.onBackPressed()
    }

    private val felicaListener = object : FelicaReaderInterface {
        override fun onReadFelica(data: ArrayList<String>) {
            val id = data[0]
            val sys = data[1]
            val pmm = data[2]
            bundle.putString("felica_device_id", id)
            bundle.putString("felica_device_sys", sys)
            bundle.putString("felica_device_pmm", pmm)
            replaceFragment(fragmentFelicaDeviceReadInfo,"fragmentFelicaDeviceReadInfo")
        }

        private fun byteToHex(b : ByteArray) : String{
            var s : String = ""
            for (i in 0..b.size-1){
                s += "%02X".format(b[i])
            }
            return s
        }
    }

    private fun changeBtmNavIconColor(itemColorId : Int, navId : Int, fragmentName : String){
        nav_view.itemIconTintList = ContextCompat.getColorStateList(this, itemColorId)
        nav_view.itemTextColor = ContextCompat.getColorStateList(this, itemColorId)
        navController.navigate(navId)
        statusFragmentDisplayed = navId
        Log.d("navView",fragmentName)
    }

    fun replaceFragment(fragment: Fragment,tag: String) {
        fragment.arguments = bundle
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment).addToBackStack(tag)
        fragmentTransaction.commit()
    }
}