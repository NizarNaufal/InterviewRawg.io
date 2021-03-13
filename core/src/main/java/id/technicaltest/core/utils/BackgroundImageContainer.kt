package id.technicaltest.core.utils

import android.app.Activity
import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import com.bumptech.glide.request.RequestOptions
import id.technicaltest.core.R

fun backgroundImageContainer(
    context: Context? = null,
    activity: Activity? = null,
    imagePath: String? = null,
    view: ImageView
) {
    if (imagePath != null) {
        lateinit var circularProgressDrawable: CircularProgressDrawable

        if (context != null) {
            circularProgressDrawable = CircularProgressDrawable(context)
            circularProgressDrawable.centerRadius = 10f
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.start()
            Glide.with(context).load(imagePath).apply(
                RequestOptions.overrideOf(640, 360).placeholder(circularProgressDrawable)
                    .transform(CenterCrop(), GranularRoundedCorners(15F, 15F, 0F, 0F))
                    .error(R.drawable.ic_broken_time)
            ).into(view)
        } else if (activity != null) {
            circularProgressDrawable = CircularProgressDrawable(activity)
            circularProgressDrawable.centerRadius = 10f
            circularProgressDrawable.strokeWidth = 5f
            circularProgressDrawable.start()
            Glide.with(activity).load(imagePath).apply(
                RequestOptions.overrideOf(640, 360).placeholder(circularProgressDrawable)
                    .transform(CenterCrop(), GranularRoundedCorners(15F, 15F, 0F, 0F))
                    .error(R.drawable.ic_broken_time)
            ).into(view)
        }
    }
}