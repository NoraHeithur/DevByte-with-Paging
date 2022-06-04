package com.nora.devbyte.ui.utils

import android.text.format.DateUtils
import org.joda.time.DateTime

object DateUtil {

    fun convertToTimeElapsed(timeString: String): CharSequence {
        val targetTimeInMillis = DateTime(timeString).millis
        val now = DateTime().millis

        return DateUtils.getRelativeTimeSpanString(
            targetTimeInMillis,
            now,
            DateUtils.SECOND_IN_MILLIS
        )
    }
}