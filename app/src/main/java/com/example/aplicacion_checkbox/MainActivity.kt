package com.example.aplicacion_checkbox

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var input1: EditText;
    lateinit var input2: EditText;
    lateinit var btnCheckboxSuma: CheckBox;
    lateinit var btnCheckboxResta: CheckBox;
    lateinit var btnCheckboxDividir: CheckBox;
    lateinit var btnCheckboxMultiplicar: CheckBox;
    lateinit var textView: TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        input1 = findViewById<EditText>(R.id.input1);
        input2 = findViewById<EditText>(R.id.input2);
        btnCheckboxSuma = findViewById<CheckBox>(R.id.checkBoxSuma);
        btnCheckboxResta = findViewById<CheckBox>(R.id.checkBoxResta);
        btnCheckboxDividir = findViewById<CheckBox>(R.id.checkBoxDividir);
        btnCheckboxMultiplicar = findViewById<CheckBox>(R.id.checkBoxMultiplicacion)
        textView = findViewById<TextView>(R.id.textView);

    }

    fun resolver (view: View) {

        var numero1 = input1.text.toString();
        var numero2 = input2.text.toString();
        var resultado1: Double = 0.0;
        var resultado2: Double = 0.0;
        var resultado3: Double = 0.0;
        var resultado4: Double = 0.0;
        var resultados = StringBuilder();

        if (numero1 != "" && numero2 != "") {
            if (btnCheckboxSuma.isChecked) {
                resultado1 = numero1.toDouble() + numero2.toDouble();
                resultados.append("Suma: $resultado1\n")
            }

            if (btnCheckboxResta.isChecked) {
                resultado2 = numero1.toDouble() - numero2.toDouble();
                resultados.append("Resta: $resultado2\n")
            }

            if (btnCheckboxMultiplicar.isChecked) {
                resultado3 = numero1.toDouble() *  numero2.toDouble();
                resultados.append("Multiplicación: $resultado3\n")
            }

            if (btnCheckboxDividir.isChecked) {
                resultado4 = numero1.toDouble() /  numero2.toDouble();
                resultados.append("División $resultado4")
            }

            if (resultados.isEmpty()) {
                resultados.append("Operador Faltante");
                Toast.makeText(this, "Error: Favor de seleccionar un operador", Toast.LENGTH_SHORT).show();
                return;
            }
        } else {
            resultados.append("Numero Faltante")
            Toast.makeText(this, "Favor de ingresar los numeros faltantes", Toast.LENGTH_SHORT).show();
            return;
        }

        textView.text = resultados.toString()
        Toast.makeText(this, "Problema resuelto :D", Toast.LENGTH_SHORT).show();
    }

    fun limpíar (view: View) {
        input1.text.clear();
        input2.text.clear();
        btnCheckboxSuma.isChecked = false;
        btnCheckboxResta.isChecked = false;
        btnCheckboxDividir.isChecked = false;
        btnCheckboxMultiplicar.isChecked = false;
        textView.text = "Lipieza exitosa"
        Toast.makeText(this, "Se han borrado los datos :D", Toast.LENGTH_SHORT).show();
    }
}