package com.fauji.commaseparated.model

import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.method.DigitsKeyListener
import com.fauji.commaseparated.utils.getDecimalFormattedString

class MoneyValueFormatter(sign: Boolean, decimal: Boolean, digits: Int) :
    DigitsKeyListener(sign, decimal) {
    private var digits: Int = 0

    init {
        this.digits = digits
    }

    override fun filter(
        source: CharSequence?,
        start: Int,
        end: Int,
        dest: Spanned?,
        dstart: Int,
        dend: Int
    ): CharSequence {
        val out = super.filter(source, start, end, dest, dstart, dend)

        var fsource: CharSequence? = source
        var fstart: Int = start
        var fend: Int = end

        // if changed, replace the source

        // if changed, replace the source
        if (out != null) {
            fsource = out
            fstart = 0
            fend = out.length
        }

        val len = fend - fstart

        // if deleting, source is empty
        // and deleting can't break anything

        // if deleting, source is empty
        // and deleting can't break anything
        if (len == 0) {
            return fsource!!
        }

        val dlen = dest!!.length

        // Find the position of the decimal .

        // Find the position of the decimal .
        for (i in 0 until dstart) {
            if (dest[i] == '.') {
                // being here means, that a number has
                // been inserted after the dot
                // check if the amount of digits is right
                return String().getDecimalFormattedString(
                    if (dlen - (i + 1) + len > digits) "" else SpannableStringBuilder(
                        fsource,
                        fstart,
                        fend
                    ).toString()
                )
            }
        }

        for (i in fstart until fend) {
            if (fsource!![i] == '.') {
                // being here means, dot has been inserted
                // check if the amount of digits is right
                return if (dlen - dend + (fend - (i + 1)) > digits) "" else break // return new SpannableStringBuilder(source,
                // start, end);
            }
        }

        // if the dot is after the inserted part,
        // nothing can break

        // if the dot is after the inserted part,
        // nothing can break
        return String().getDecimalFormattedString(
            SpannableStringBuilder(
                fsource,
                fstart,
                fend
            ).toString()
        )
    }
}