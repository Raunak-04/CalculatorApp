package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
class MainActivity : AppCompatActivity() {
    private lateinit var resultTextView: TextView
    private lateinit var previousCalculationTextView: TextView

    private var firstNumber=0.0
    private var operation=""
    private var isNewOperation=true



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        resultTextView=findViewById(R.id.resultdisplay)
        previousCalculationTextView=findViewById(R.id.calculataiondisplay)

        val button: Button=findViewById(R.id.btn0)
        val button1: Button=findViewById(R.id.btnno1)
        val button2: Button=findViewById(R.id.btnno2)
        val button3: Button=findViewById(R.id.btnno3)
        val button4: Button=findViewById(R.id.btnno4)
        val button5: Button=findViewById(R.id.btnno5)
        val button6: Button=findViewById(R.id.btnno6)
        val button7: Button=findViewById(R.id.btnno7)
        val button8: Button=findViewById(R.id.btnno8)
        val button9: Button=findViewById(R.id.btnno9)
        val button0: Button=findViewById(R.id.btn0)
        val button00: Button=findViewById(R.id.btn00)


        val buttonplus: Button=findViewById(R.id.btnplus)
        val buttonminus: Button=findViewById(R.id.btnminus)
        val buttonmultiply: Button=findViewById(R.id.btnmultiply)
        val buttondivision: Button=findViewById(R.id.btndivision)
        val buttondot: Button=findViewById(R.id.btndot)
        val buttonPercantage: Button=findViewById(R.id.btnPercantage)


        val btnbackspace: Button=findViewById(R.id.btnbackspace)
        val buttonequal: Button=findViewById(R.id.btnequal)
        val buttonclear: Button=findViewById(R.id.btnClear)

//action to be on each button

        button.setOnClickListener{appendNumber("0")}
        button1.setOnClickListener{appendNumber("1")}
        button2.setOnClickListener{appendNumber("2")}
        button3.setOnClickListener{appendNumber("3")}
        button4.setOnClickListener{appendNumber("4")}
        button5.setOnClickListener{appendNumber("5")}
        button6.setOnClickListener{appendNumber("6")}
        button7.setOnClickListener{appendNumber("7")}
        button8.setOnClickListener{appendNumber("8")}
        button9.setOnClickListener{appendNumber("9")}

        button0.setOnClickListener{appendNumber("0")}
        button00.setOnClickListener{appendNumber("00")}
        //special character
        buttondot.setOnClickListener{appendNumber(".")}
        buttonequal.setOnClickListener{calculateResult()}

        buttonplus.setOnClickListener{ setOperation("+")}
        buttonminus.setOnClickListener{ setOperation("-")}
        buttonmultiply.setOnClickListener{ setOperation("*")}
        buttondivision.setOnClickListener{ setOperation("/")}
        buttonPercantage.setOnClickListener{ setOperation("%")}
        buttonclear.setOnClickListener{clearCalculator()}

        btnbackspace.setOnClickListener { deleteNum() }


        }
    private fun appendNumber(number: String) {
         if(isNewOperation){
             resultTextView.text= number
             isNewOperation=false

         }else{
             resultTextView.text="${resultTextView.text}$number"
         }
    }
    private fun setOperation(op: String){
        firstNumber=resultTextView.text.toString().toDouble()
        operation=op
        isNewOperation=true
        previousCalculationTextView.text="$firstNumber $operation"
    }
    private fun calculateResult(){
        try{
            val secondnumber: Double=resultTextView.text.toString().toDouble()
            val result:Double=when(operation){
                "+"->firstNumber+secondnumber
                "-"->firstNumber-secondnumber
                "*"->firstNumber*secondnumber
                "/"->firstNumber/secondnumber
                "%"->(firstNumber*secondnumber)/100
                else->throw IllegalArgumentException("Invalid operation")
            }
            previousCalculationTextView.text="$firstNumber $operation $secondnumber ="
            resultTextView.text=result.toString()
            isNewOperation=true

        } catch (e:Exception){
            resultTextView.text="Error"
        }
    }
    private fun clearCalculator(){
        resultTextView.text="0"
        previousCalculationTextView.text=""
        firstNumber=0.0
        operation=""
        isNewOperation=true
    }

    private fun MainActivity.deleteNum() {
       resultTextView.text=resultTextView.text.dropLast(1)

        }
    }

