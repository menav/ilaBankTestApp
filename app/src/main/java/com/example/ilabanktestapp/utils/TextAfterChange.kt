package com.example.ilabanktestapp.utils

import android.text.Editable
import android.text.TextWatcher

class TextAfterChange(val afterChange: (String) -> Unit) : TextWatcher {
    override fun afterTextChanged(editable: Editable?) {
        afterChange(editable.toString())
    }

    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
}