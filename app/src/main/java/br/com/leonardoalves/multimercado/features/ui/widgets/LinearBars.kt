package br.com.leonardoalves.multimercado.features.ui.widgets

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import br.com.leonardoalves.multimercado.R
import android.graphics.Color.LTGRAY
import android.R.attr.y
import android.R.attr.x
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat


class LinearBars(context:Context, attrs: AttributeSet) : View(context, attrs) {
    private var mPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var mPaintTriangle: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    private var showText: Boolean
    private var showArrow: Boolean
    private var ratingMax: Int
    private var rating: Int
    private var colors :ArrayList<Int> = arrayListOf(R.color.bar1, R.color.bar2, R.color.bar3,
            R.color.bar4, R.color.bar5)

    init {
        mPaint.style = Paint.Style.FILL
        mPaintTriangle.style = Paint.Style.FILL
        mPaintTriangle.color = ContextCompat.getColor(context, R.color.black)
        val a = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.LinearBars,
                0, 0)
        try {
            showText = a.getBoolean(R.styleable.LinearBars_showText, false)
            showArrow = a.getBoolean(R.styleable.LinearBars_showArrow, false)
            ratingMax = a.getInteger(R.styleable.LinearBars_ratingMax, 5)
            rating = a.getInteger(R.styleable.LinearBars_rating, 3)
            Log.d("Rating", rating.toString())
            Log.d("RatingMax", ratingMax.toString())
        } finally {

        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        var i = 0
        val sizeWidth = width/ratingMax
        Log.d("size", sizeWidth.toString())
        var vectorDrawable = VectorDrawableCompat.create(context.resources, R.drawable.ic_keyboard_arrow_down_black_24dp, null)
        vectorDrawable?.setBounds(
                ((sizeWidth*(rating-1))+sizeWidth/2)-(bottom/2),
                0,
                ((sizeWidth*(rating-1))+sizeWidth/2)+(bottom/2),
                bottom/2)
        vectorDrawable?.draw(canvas)
        while (i < ratingMax) {
            mPaint.color = ContextCompat.getColor(context, colors[i%5])
            canvas?.drawRect(i*sizeWidth.toFloat(),
                    if (i==rating-1){bottom.toFloat()/2}else{bottom*9/16.toFloat()},
                    (i*sizeWidth)+sizeWidth.toFloat() - 2F,
                    if (i==rating-1){bottom.toFloat()}else{bottom*15/16.toFloat()} , mPaint)
            i++
        }
    }

    fun setRating(rating:Int){
        this.rating = rating
        invalidate()
        requestLayout()
    }
}