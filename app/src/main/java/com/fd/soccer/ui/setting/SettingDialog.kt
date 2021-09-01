package com.fd.soccer.ui.setting

import android.app.Activity
import com.fd.soccer.databinding.BottomSheetSettingBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class SettingDialog constructor(private val activity: Activity) {

    private var listener: Listener? = null

    interface Listener {
        fun onItemClick(selectedIdLeague: String)
    }

    fun setListener(listener: Listener) {
        this.listener = listener
    }

    fun show() {
        val bottomSheetDialog = BottomSheetDialog(activity)
        val dialogBinding = BottomSheetSettingBinding.inflate(bottomSheetDialog.layoutInflater)
        bottomSheetDialog.setContentView(dialogBinding.root)
        dialogBinding.tvEngland.setOnClickListener {
            listener?.onItemClick(dialogBinding.tvEngland.tag.toString())
            bottomSheetDialog.dismiss()
        }
        dialogBinding.tvItaly.setOnClickListener {
            listener?.onItemClick(dialogBinding.tvItaly.tag.toString())
            bottomSheetDialog.dismiss()
        }
        dialogBinding.tvSpain.setOnClickListener {
            listener?.onItemClick(dialogBinding.tvSpain.tag.toString())
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.show()
    }

}