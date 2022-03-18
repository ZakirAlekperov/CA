package com.example.calculatorandroid

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var resultField // текстовое поле для вывода результата
            : TextView? = null
    var result : Double? = 0.0
    var operand: String? = null // операнд операции
    var operandIsSet: Boolean = false
    var lastResult: Double? = 0.0 // последнее введенное значение
    var lastOperation = "=" // последняя операция

    val operation = MathOperation()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // получаем все поля по id из activity_main.xml
        resultField = findViewById(R.id.resultField)

    }

    fun sendMessage(view: android.view.View) {

    }

    fun onNumberClick(view: android.view.View) {

        val button: Button = view as Button
        if(operandIsSet){
            resultField?.text = button.text
            operandIsSet = false
        }
        else{
            resultField?.append(button.text)
        }
    }
    fun onOperationClick(view: android.view.View) {
        /*var button: Button = view as Button
        (button.text as String?).also { operand = it }
        result = resultField?.getText() as Double?
        resultField?.setText(operand)
        true.also { operandIsSet = it }*/

        var button: Button = view as Button
        operand = button.text as String?
        operandIsSet = true
        var resulttext: String? = resultField?.getText().toString()
        result =  resulttext
        resultField?.text=operand

    }
    fun onEqualClick(view: View){
        /*lastResult = resultField?.getText() as Double

        resultField?.text = result.toString()
        operandIsSet = true*/
        //result = resultField?.text as Double
        //result /= 2
 //       var resulttext: String? = resultField?.getText().toString()
  //      var rezult = resulttext as Double?
        //resultField?.setText(result.toString())

        lastResult = resultField?.getText() as Double?
        /*
        when(operand){
            "-" -> result = operation.substraction(result, lastResult)
            "+" -> result = operation.addition(result, lastResult)
            "*" -> result = operation.multiplication(result, lastResult)
            "/" -> result = operation.division(result, lastResult)
        }
*/
        //resultField?.setText(result.toString())
        val text: String = lastResult.toString() + result.toString()
        resultField?.setText(text)
    }
    fun onClearClick(view: View){
        resultField?.setText("")
    }
}


class MathOperation{

    fun addition(rezult: Double?, textfield: Double?): Double? {
        return if (rezult != null) {
            rezult + textfield!!
        } else{
            null
        }
    }

    fun substraction(rezult: Double?, textfield: Double?): Double? {
        return if (rezult != null) {
            rezult - textfield!!
        } else {
            null
        }
        }

    fun multiplication(rezult: Double?, textfield: Double?): Double?{
        return if (rezult != null) {
            rezult * textfield!!
        } else {
            null
        }
    }

    fun division(rezult: Double?, textfield: Double?): Double?{
        return if (rezult != null) {
            rezult / textfield!!
        } else {
            null
        }
    }

    fun sign(rezult: Double, textfield: Double): Double{
        return -rezult
    }
    fun percent(rezult: Double, textfield: Double): Double{
        return rezult
    }

}