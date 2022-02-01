package com.codingchallenge.view

import android.content.Context
import android.text.Editable
import android.text.SpannableString
import android.text.Spanned
import android.text.TextWatcher
import android.text.style.BackgroundColorSpan
import android.text.style.ForegroundColorSpan
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText
import com.codingchallenge.view.model.SpanData

class CustomEditText(context: Context, attrs: AttributeSet?) : AppCompatEditText(context, attrs) {

    private var lockStart = 0
    private var lockEnd = 0
    private var spanData: List<SpanData>? = null

    private var spannableString: SpannableString? = null

    init {
        addTextChangedListener(object : TextWatcher {
            var previousText: String = ""
            override fun beforeTextChanged(
                text: CharSequence,
                start: Int,
                lengthBefore: Int,
                lengthAfter: Int
            ) {
                previousText = text.toString()
            }

            override fun onTextChanged(
                text: CharSequence,
                start: Int,
                lengthBefore: Int,
                lengthAfter: Int
            ) {
                if (start == lockStart - 1) {
                    setText(previousText)
                    buildSpan(true)
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }
        })
    }

    fun reset() {
        spannableString = null
        lockStart = 0
        lockEnd = 0
        spanData = null
        text = null
    }

    fun setSelectionLocks(start: Int, end: Int) {
        lockStart = start
        lockEnd = end
    }

    fun setSpanData(spanData: List<SpanData>) {
        this.spanData = spanData
    }

    override fun onTextChanged(
        text: CharSequence?,
        start: Int,
        lengthBefore: Int,
        lengthAfter: Int
    ) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter)
        buildSpan()
    }

    override fun onSelectionChanged(selStart: Int, selEnd: Int) {
        super.onSelectionChanged(selStart, selEnd)

        try {
            val textLength = text?.length ?: 0
            if (selStart < lockStart) {
                setSelection(lockStart)
            } else if (selEnd > textLength - lockEnd) {
                setSelection(textLength - lockEnd)
            }
        } catch (e: IndexOutOfBoundsException) {
            // Just don't want to handle that now
        } catch (e: Throwable) {
            // Big bada bum!
        }
    }

    private fun buildSpan(force: Boolean = false) {
        val textLength = text?.length ?: 0
        if (force || spannableString == null || spannableString.toString() != text.toString()) {
            spannableString = SpannableString(text)
            spannableString?.clearBackgroundSpans()
            spanData?.forEach {
                if (textLength > it.startIndex) {
                    val endIndex = if (textLength > it.endIndex) it.endIndex else textLength
                    spannableString?.setSpan(
                        ForegroundColorSpan(it.color),
                        it.startIndex,
                        endIndex,
                        Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
                    )
                }
            }

            val currentSelection = selectionStart
            setText(spannableString)
            setSelection(currentSelection)
        }
    }

    private fun SpannableString.clearBackgroundSpans() {
        val spans = getSpans(0, text?.length ?: 0, ForegroundColorSpan::class.java)
        for (i in spans.indices) {
            removeSpan(spans[i])
        }
    }
}