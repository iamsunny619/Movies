package com.example.movies.ui.utils

import android.graphics.Color
import android.net.Uri
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.ColorRes
import androidx.annotation.StringRes
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.movies.R
import com.facebook.common.util.UriUtil
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.interfaces.DraweeController
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.common.Priority
import com.facebook.imagepipeline.request.ImageRequest
import com.facebook.imagepipeline.request.ImageRequestBuilder
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.textview.MaterialTextView
import timber.log.Timber

/**
 * Data Binding adapters specific to the app.
 */

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("imageUriForFresco")
    fun imageUriUsingFresco(
        imageView: SimpleDraweeView,
        imageUriForFresco: String?
    ) {
        when (imageUriForFresco) {
            null -> {
                Timber.e("Unsetting image url")
                val uri = Uri.Builder()
                    .scheme(UriUtil.LOCAL_RESOURCE_SCHEME)
                    .path(R.drawable.ic_place_holder.toString())
                    .build()
                imageView.setImageURI(uri, imageView.context)
            }
            else -> {

                /*val circularProgressDrawable = CircularProgressDrawable(imageView.context)
                circularProgressDrawable.strokeWidth = 12f
                circularProgressDrawable.centerRadius = 60f
                circularProgressDrawable.progressRotation = 0.9f
                circularProgressDrawable.setColorSchemeColors(
                    ContextCompat.getColor(
                        imageView.context,
                        R.color.red_cc0000
                    )
                )
                circularProgressDrawable.start()*/

//                val postprocessor: Postprocessor = BlurPostprocessor(imageView.context, 50)

                val request: ImageRequest =
                    ImageRequestBuilder.newBuilderWithSource(Uri.parse(imageUriForFresco))
                        .setProgressiveRenderingEnabled(false)
//                        .setResizeOptions(ResizeOptions(250, 250))
                        .setRequestPriority(Priority.HIGH)
                        .setLocalThumbnailPreviewsEnabled(true)
//                        .setResizingAllowedOverride(true)
                        .setLowestPermittedRequestLevel(ImageRequest.RequestLevel.FULL_FETCH)
                        .setCacheChoice(ImageRequest.CacheChoice.DEFAULT)
                        /*.setPostprocessor(postprocessor)*/
                        .build()

                val controller: DraweeController = Fresco.newDraweeControllerBuilder()
                    .setImageRequest(request)
                    /*  .setLowResImageRequest(request)*/
                    .setOldController(imageView.controller)
                    .build()

//                imageView.hierarchy.setProgressBarImage(circularProgressDrawable)
                imageView.controller = controller
                //imageView.setImageURI(Uri.parse(imageUriForFresco), imageView.context)
            }
        }
    }

    @JvmStatic
    @BindingAdapter("imageResourceForFresco")
    fun imageResourceUsingFresco(
        imageView: SimpleDraweeView,
        imageResourceForFresco: Int?
    ) {
        when (imageResourceForFresco) {
            null -> {
                Timber.e("Unsetting image url")
                val uri = Uri.Builder()
                    .scheme(UriUtil.LOCAL_RESOURCE_SCHEME)
                    .path(R.drawable.ic_place_holder.toString())
                    .build()
                imageView.setImageURI(uri, imageView.context)
            }
            else -> {
                val uri = Uri.Builder()
                    .scheme(UriUtil.LOCAL_RESOURCE_SCHEME)
                    .path(imageResourceForFresco.toString())
                    .build()
                imageView.setImageURI(uri, imageView.context)
            }
        }
    }

    @JvmStatic
    @BindingAdapter("startText", "endText", requireAll = false)
    fun setText(textView: MaterialTextView, startText: String?, endText: String?) {
        when {
            !startText.isNullOrBlank() && !endText.isNullOrEmpty() -> {
                textView.text = textView.context.getString(R.string.s_or_s, startText, endText)
            }
            startText.isNullOrBlank() && !endText.isNullOrBlank() -> {
                textView.text = endText
            }
            !startText.isNullOrBlank() && endText.isNullOrBlank() -> {
                textView.text = startText
            }
            else -> {
                textView.text = ""
            }
        }
    }

    /* @JvmStatic
     @BindingAdapter("currencyValue", "currencyType", requireAll = false)
     fun setCurrencySymbolAndValue(
         materialTextView: MaterialTextView,
         currencyValue: String?,
         currencyType: String?
     ) {

         if (currencyType?.isNotEmpty() == true && currencyValue?.isNotEmpty() == true) {
             when {
                 currencyType.toLowerCase(Locale.getDefault()) == materialTextView.context.getString(
                     R.string.usd_currency_type
                 ) -> {
                     materialTextView.text =
                         materialTextView.context.getString(R.string.dollars, currencyValue)
                 }
                 currencyType.toLowerCase(Locale.getDefault()) == materialTextView.context.getString(
                     R.string.inr_currency_type
                 ) -> {
                     materialTextView.text =
                         materialTextView.context.getString(
                             R.string.rupee_symbol_s,
                             currencyValue
                         )
                 }
             }
         } else if (currencyValue?.isNotEmpty() == true) {
             materialTextView.text = currencyValue
         }

     }
 */
    @JvmStatic
    @BindingAdapter("app:errorText")
    fun setError(view: TextInputLayout, @StringRes message: Int?) {
        view.error = message?.let { view.context.getText(it) }
        view.errorIconDrawable = null // hide error icon
    }


    @JvmStatic
    @BindingAdapter("android:tint")
    fun setTint(view: ImageView, @ColorRes colorRes: Int) {
        view.setColorFilter(ContextCompat.getColor(view.context, colorRes))
    }


    @JvmStatic
    @BindingAdapter("app:cardBackgroundColorRes")
    fun setCardBackgroundColorRes(view: CardView, @ColorRes colorRes: Int) {
        view.setCardBackgroundColor(ContextCompat.getColor(view.context, colorRes))
    }

    /*@JvmStatic
    @BindingAdapter("selectedDate", "dateFormat", requireAll = false)
    fun setSelectedDate(view: TextView, selectedDate: LocalDate?, dateFormat: String?) {
        view.text = selectedDate?.format(
            DateTimeFormatter.ofPattern(
                dateFormat.takeUnless { it.isNullOrBlank() }
                    ?: DateTimeUtil.DATE_FORMAT_MMM_DD_YYYY)
        )
    }*/

    /*  @JvmStatic
      @BindingAdapter("stringDate", "dateFormat", "extraTextToAppend", requireAll = false)
      fun setDateFromString(
          view: TextView,
          stringDate: String?,
          dateFormat: String?,
          extraTextToAppend: String?
      ) {
          try {
              view.text = stringDate?.let {
                  OffsetDateTime.parse(stringDate)
                      .format(DateTimeFormatter.ofPattern(dateFormat.takeUnless { it.isNullOrBlank() }
                          ?: DateTimeUtil.DATE_FORMAT_MMM_DD_YYYY)).plus(" ")
                      .plus(extraTextToAppend.takeUnless { it.isNullOrBlank() } ?: "")
              }
          } catch (e: Exception) {
              e.printStackTrace()
          }
      }

      @JvmStatic
      @BindingAdapter("selectedTime", "timeFormat", requireAll = false)
      fun setSelectedTime(view: TextView, selectedTime: LocalTime?, timeFormat: String?) {
          view.text = selectedTime?.format(
              DateTimeFormatter.ofPattern(
                  timeFormat.takeUnless { it.isNullOrBlank() }
                      ?: DateTimeUtil.DATE_FORMAT_hh_mm_a)
          )
      }

      @JvmStatic
      @BindingAdapter("selectedDateTime", "dateTimeFormat", requireAll = false)
      fun setSelectedDateTime(
          view: TextView,
          selectedDateTime: LocalDateTime?,
          dateTimeFormat: String?
      ) {
          view.text = selectedDateTime?.format(
              DateTimeFormatter.ofPattern(
                  dateTimeFormat.takeUnless { it.isNullOrBlank() }
                      ?: DateTimeUtil.DATE_FORMAT_MMM_dd_yyyy_hh_mm_a)
          )
      }*/

    @JvmStatic
    @BindingAdapter("spanRequireText")
    fun setMustFill(view: TextView, @StringRes spanRequireText: Int?) {
        val spannableString = spanRequireText?.let { view.context.getText(it) }
        spannableString.toString().plus("*")
        val spannableStr = SpannableString(spannableString.toString())
        spannableStr.setSpan(
            ForegroundColorSpan(Color.RED),
            spannableString.toString().length.minus(1),
            spannableString.toString().length.minus(1),
            Spannable.SPAN_INCLUSIVE_EXCLUSIVE
        )
        view.text = spannableStr
    }

}
