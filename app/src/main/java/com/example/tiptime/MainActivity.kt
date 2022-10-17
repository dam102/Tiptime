package com.example.tiptime

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tiptime.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.ceil

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.calculateButton.setOnClickListener {calculateTip()}

    }

    private fun calculateTip() {
        val stringInTextField=binding.costOfService.text
        val cost=stringInTextField.toString().toDouble()
        val selectedId=binding.radioGroup.checkedRadioButtonId
        val percentageTip= when(selectedId){
            R.id.tipoptions1 -> 0.20
            R.id.tipoptions2 -> 0.18
            else -> 0.15
        }
        var tip = percentageTip * cost

        var roundUp= binding.switch1.isChecked

        if (roundUp){
            tip= ceil(tip)
        }
        val formattedtip= NumberFormat.getCurrencyInstance().format(tip)

        binding.tipResult.text= getString(R.string.tip_amount, formattedtip)
    }

    //Activamos binding añadido en gradle
    lateinit var binding:ActivityMainBinding
}