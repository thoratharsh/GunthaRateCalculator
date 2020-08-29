package com.example.rajvardhan.guntharatecalculator

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.util.TypedValue
import android.view.inputmethod.InputMethodManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calculateButton.setOnClickListener { view ->
            if (inputLength.text.toString().isEmpty() && inputWidth.text.toString().isEmpty() && inputRate.text.toString().isEmpty()){
                textViewError.setTextSize(TypedValue.COMPLEX_UNIT_SP,15f)
                textViewError.text = "कृपया योग्य लांबी, रुंदी व दर भरा "
            } else if (inputLength.text.toString().isEmpty() && inputWidth.text.toString().isEmpty()){
                textViewError.setTextSize(TypedValue.COMPLEX_UNIT_SP,15f)
                textViewError.text = "कृपया योग्य लांबी व रुंदी भरा "
            } else if (inputWidth.text.toString().isEmpty() && inputRate.text.toString().isEmpty()){
                textViewError.setTextSize(TypedValue.COMPLEX_UNIT_SP,15f)
                textViewError.text = "कृपया योग्य रुंदी व दर भरा "
            } else if (inputLength.text.toString().isEmpty() && inputRate.text.toString().isEmpty()){
                textViewError.setTextSize(TypedValue.COMPLEX_UNIT_SP,15f)
                textViewError.text = "कृपया योग्य लांबी व दर भरा "
            } else if(inputLength.text.toString().isEmpty()){
                textViewError.setTextSize(TypedValue.COMPLEX_UNIT_SP,15f)
                textViewError.text = "कृपया योग्य लांबी भरा "
            } else if (inputWidth.text.toString().isEmpty()){
                textViewError.setTextSize(TypedValue.COMPLEX_UNIT_SP,15f)
                textViewError.text = "कृपया योग्य रुंदी भरा "
            } else if (inputRate.text.toString().isEmpty()){
                textViewError.setTextSize(TypedValue.COMPLEX_UNIT_SP,15f)
                textViewError.text = "कृपया योग्य दर भरा"
            } else {
                textViewError.setTextSize(TypedValue.COMPLEX_UNIT_SP,0f)
                textViewError.text = ""
            }

            if (textViewError.text.isEmpty()){
                val length = inputLength.text.toString().toDouble()
                val width = inputWidth.text.toString().toDouble()
                val rate = inputRate.text.toString().toDouble()

                val price = length * width * rate / 1089

                val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(currentFocus.windowToken, 0)

                textViewPrice.text = price.toInt().toString() + " रुपये"
                Snackbar.make(view, "Price is $price", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
            }
        }

        clearButton.setOnClickListener{ view ->
            inputLength.text.clear()
            inputWidth.text.clear()
            inputRate.text.clear()
            textViewPrice.text = ""
            textViewError.text = ""
            textViewError.setTextSize(TypedValue.COMPLEX_UNIT_SP,0f)
        }

        otherFormulasButton.setOnClickListener { view ->
            openOtherFormulasActivity()
        }

    }

    private fun openOtherFormulasActivity(){
        val intent = Intent(this, OtherFormulasActivity::class.java)
        startActivity(intent)
    }
}
