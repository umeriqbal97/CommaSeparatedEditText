package com.fauji.commasparatededittextexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import androidx.core.widget.addTextChangedListener
import com.fauji.commaseparated.widget.CommaSeparatedEditText

class MainActivity : AppCompatActivity() {
    lateinit var commaSeparatedEditText: CommaSeparatedEditText
    private lateinit var withOutCommaText: TextView
    lateinit var withCommaText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        commaSeparatedEditText = findViewById(R.id.commaSeparatedEditText)
        withOutCommaText = findViewById(R.id.withOutCommaText)
        withCommaText = findViewById(R.id.WithCommaText)

        commaSeparatedEditText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                withCommaText.text = "With Commas: "+commaSeparatedEditText.getTextWithCommas()
                withOutCommaText.text = "Without Commas: "+commaSeparatedEditText.getTextWithoutCommas()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }
}