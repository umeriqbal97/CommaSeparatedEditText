package com.fauji.commaseparated.widget

import android.content.Context
import android.content.res.TypedArray
import android.text.Editable
import android.text.InputFilter
import android.text.TextWatcher
import android.text.method.DigitsKeyListener
import android.util.AttributeSet
import com.fauji.commaseparated.R
import com.fauji.commaseparated.model.MoneyValueFormatter
import com.fauji.commaseparated.utils.getDecimalFormattedString
import com.google.android.material.textfield.TextInputEditText

class CommaSeparatedEditText constructor(context: Context,attributeSet: AttributeSet):
    TextInputEditText(context,attributeSet), TextWatcher {

    private var attr=attributeSet
    private var isSeparatedByCommas: Boolean = false
    private var noOdfDecimals: Int = 2

    init{
        parseAttributes(context.obtainStyledAttributes(attr, R.styleable.CommaSeparatedEditText))
        this.addTextChangedListener(this)
        this.keyListener = DigitsKeyListener.getInstance("0123456789.")
        initNoOfDecimals()
    }

    private fun parseAttributes(a: TypedArray) {
        isSeparatedByCommas = a.getBoolean(
            R.styleable.CommaSeparatedEditText_isSeparateByCommas,
            true
        )
        noOdfDecimals=a.getInteger(
            R.styleable.CommaSeparatedEditText_noOfDecimals,
            2
        )
    }

    private fun initNoOfDecimals(){
        this@CommaSeparatedEditText.filters= arrayOf<InputFilter>(
            MoneyValueFormatter(
                sign = false,
                decimal = true,
                digits = noOdfDecimals
            )
        )
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
    }

    override fun afterTextChanged(p0: Editable?) {
        if (isSeparatedByCommas) {
            val cursorPosition: Int = this@CommaSeparatedEditText.selectionEnd
            val originalStr: String = this@CommaSeparatedEditText.text.toString()

            try {
                this@CommaSeparatedEditText.removeTextChangedListener(this)
                val value: String = this@CommaSeparatedEditText.text.toString()
                if (value != "") {
                    if (value.startsWith(".")) {
                        this@CommaSeparatedEditText.setText("0.")
                    }
                    val str: String = this@CommaSeparatedEditText.text.toString().replace(
                        ",".toRegex(),
                        ""
                    )
                    if (value != "") this@CommaSeparatedEditText.setText(
                        String().getDecimalFormattedString(
                            str
                        )
                    )
                    val diff: Int = this@CommaSeparatedEditText.text.toString().length - originalStr.length
                    this@CommaSeparatedEditText.setSelection(cursorPosition + diff)
                }
                this@CommaSeparatedEditText.addTextChangedListener(this)
            } catch (ex: Exception) {
                ex.printStackTrace()
                this@CommaSeparatedEditText.addTextChangedListener(this)
            }
        }
    }

    fun getTextWithoutCommas(): String{
        return super.getText().toString().replace(",","")
    }
    fun getTextWithCommas(): String{
        return super.getText().toString()
    }

}