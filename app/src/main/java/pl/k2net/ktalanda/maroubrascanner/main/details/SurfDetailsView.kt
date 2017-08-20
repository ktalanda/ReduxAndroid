package pl.k2net.ktalanda.maroubrascanner.main.details

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import pl.k2net.ktalanda.maroubrascanner.App
import pl.k2net.ktalanda.maroubrascanner.R

class SurfDetailsView : LinearLayout {

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        val inflater = context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.view_surf_details, this, true)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        ((context as Activity).application as App).component.inject(this)
    }

}
