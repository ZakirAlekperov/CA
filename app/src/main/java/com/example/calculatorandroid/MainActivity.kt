package com.example.calculatorandroid

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    var resultField // текстовое поле для вывода результата
            : TextView? = null
    var result : Double = 0.0
    var operand: String? = null // операнд операции
    var operandIsSet: Boolean = false

    var lastOperation = "=" // последняя операция

    val operation = MathOperation()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // получаем все поля по id из activity_main.xml
        resultField = findViewById(R.id.resultField);

    }

    fun sendMessage(view: android.view.View) {

    }

    fun onNumberClick(view: android.view.View) {

        val button: Button = view as Button
        if(operandIsSet){
            resultField?.setText(button.getText())
            operandIsSet = false
        }
        else{
            resultField?.append(button.getText())
        }
    }
    fun onOperationClick(view: android.view.View) {
        var button: Button = view as Button
        operand = button.getText() as String?
        resultField?.setText(button.getText())
        operandIsSet = true

        when(operand){
            "-" -> result = operation.substraction(result, resultField?.getText() as Double)
            "+" -> result = result?.let { operation.addition(it, resultField?.getText() as Double) }
            "*" -> result = result?.let {operation.multiplication(it, resultField?.getText() as Double)}
            "/" -> result = result?.let {operation.division(it, resultField?.getText() as Double)}
        }

    }
    fun onEqualClick(view: View){
        resultField?.setText(result.toString())
        operandIsSet = true
    }
    fun onClearClick(view: View){
        resultField?.setText("")
    }
}

class MathOperation{

    fun addition(rezult: Double, textfield: Double): Double{
        return rezult + textfield
    }

    fun substraction(rezult: Double, textfield: Double): Double {
        return rezult - textfield
    }

    fun multiplication(rezult: Double, textfield: Double): Double{
        return  rezult * textfield
    }

    fun division(rezult: Double, textfield: Double): Double{
        return rezult * textfield
    }

    fun sign(rezult: Double, textfield: Double): Double{
        return -rezult
    }
    fun percent(rezult: Double, textfield: Double): Double{
        return rezult
    }

}