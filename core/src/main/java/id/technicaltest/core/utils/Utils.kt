package id.technicaltest.core.utils

import android.app.Activity
import android.widget.Toast

fun Activity.showToast(message: String?, isLongDuration: Boolean = false) {
    runOnUiThread {
        val duration = if (isLongDuration) Toast.LENGTH_LONG else Toast.LENGTH_SHORT
        Toast.makeText(this, message, duration).show()
    }
}