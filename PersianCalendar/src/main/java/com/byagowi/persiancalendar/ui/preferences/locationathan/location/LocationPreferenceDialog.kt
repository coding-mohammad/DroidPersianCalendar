package com.byagowi.persiancalendar.ui.preferences.locationathan.location

import androidx.appcompat.app.AlertDialog
import androidx.preference.PreferenceDialogFragmentCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.byagowi.persiancalendar.utils.getAllCities

/**
 * persian_calendar
 * Author: hamidsafdari22@gmail.com
 * Date: 1/17/16
 */
class LocationPreferenceDialog : PreferenceDialogFragmentCompat() {

    override fun onPrepareDialogBuilder(builder: AlertDialog.Builder?) {
        super.onPrepareDialogBuilder(builder)
        if (builder == null) return
        builder.also {
            it.setView(RecyclerView(builder.context).apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(context)
                adapter = LocationAdapter(
                    this@LocationPreferenceDialog,
                    getAllCities(context, true)
                )
            })
            it.setPositiveButton("", null)
            it.setNegativeButton("", null)
        }
    }

    override fun onDialogClosed(positiveResult: Boolean) {}

    fun selectItem(city: String) {
        (preference as LocationPreference).setSelected(city)
        dismiss()
    }
}
