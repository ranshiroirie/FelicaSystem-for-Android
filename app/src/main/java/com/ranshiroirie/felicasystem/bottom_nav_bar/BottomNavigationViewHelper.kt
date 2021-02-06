package com.ranshiroirie.felicasystem.bottom_nav_bar

import android.annotation.SuppressLint
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.bottomnavigation.BottomNavigationView


object BottomNavigationViewHelper {
    /**
     * BottomNavigationViewのアイテムのサイズの調整、アイコンサイズ調整、タイトルの削除
     *
     * @param view
     */
    @SuppressLint("RestrictedApi")
    fun disableShiftMode(view: BottomNavigationView) {
        val menuView = view.getChildAt(0) as BottomNavigationMenuView
        try {
//            val shiftingMode = menuView.javaClass.getDeclaredField("mShiftingMode")
//            shiftingMode.isAccessible = true
//            shiftingMode.setBoolean(menuView, false)
//            shiftingMode.isAccessible = false
            for (i in 0 until menuView.childCount) {
                /**
                 * アイテムの幅調整
                 */
                val bottomNavigationItemView = menuView.getChildAt(i) as BottomNavigationItemView
                // noinspection RestrictedApi
                bottomNavigationItemView.setShifting(false)
                // チェックされた値を設定すると、ビューが更新されるみたい
                // noinspection RestrictedApi
                bottomNavigationItemView.setChecked(false)
            }
        } catch (e: NoSuchFieldException) {
            e.printStackTrace()
        } catch (e: IllegalAccessException) {
            e.printStackTrace()
        }
    }
}