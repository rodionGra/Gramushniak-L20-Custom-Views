package com.a13acdhmwcustomviewandviewgroup

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import com.a13acdhmwcustomviewandviewgroup.databinding.CardMainInfoViewGroupBinding

class CustomCardView
@JvmOverloads constructor(context: Context, attrs: AttributeSet? = null)
: ConstraintLayout(context, attrs) {

    private val binding =
        CardMainInfoViewGroupBinding.bind(inflate(context, R.layout.card_main_info_view_group, this))

    init {
        val typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomCardView)

        binding.apply {
            ivPoster.setImageDrawable(typedArray.getDrawable(R.styleable.CustomCardView_iv_poster))
            tvTitle.text = typedArray.getString(R.styleable.CustomCardView_tv_title)
            tvCategory.text = typedArray.getString(R.styleable.CustomCardView_tv_category)
            ratingBar.rating = typedArray.getFloat(R.styleable.CustomCardView_rating_bar, 4.5F)
            tvPrice.text = typedArray.getString(R.styleable.CustomCardView_tv_price)
        }

        typedArray.recycle()
    }

    fun setImagePoster(@DrawableRes imagePoster : Int){
        binding.ivPoster.setImageResource(imagePoster)
    }

    fun setTitle(@StringRes titleStringRes: Int){
        binding.tvTitle.text = resources.getString(titleStringRes)
    }

    fun setTitle(titleString: String){
        binding.tvTitle.text = titleString
    }

    fun setCategory(@StringRes categoryStringRes: Int){
        binding.tvCategory.text = resources.getString(categoryStringRes)
    }

    fun setCategory(categoryString: String){
        binding.tvCategory.text = categoryString
    }

    fun setRating(rating: Float){
        binding.ratingBar.rating = rating
    }

    fun setPrice(price : Float){
        binding.tvPrice.text = resources.getString(R.string.price_uan, price)
    }

}