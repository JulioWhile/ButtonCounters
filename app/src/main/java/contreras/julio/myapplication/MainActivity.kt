package contreras.julio.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    var minValue = 0
    var maxValue = 100
    var num: Int = 0
    var clickeado = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Declaraciones
        val label: TextView = findViewById(R.id.etiqueta)
        val down: Button = findViewById(R.id.down)
        val up: Button = findViewById(R.id.up)
        val generate: Button = findViewById(R.id.generate)
        val adivinado: Button = findViewById(R.id.adivinado)

        // onClickListener
        generate.setOnClickListener {
            if(minValue == maxValue) {
                label.setText("Ganaste!")
            } else {
                num = Random.nextInt(minValue,maxValue)
                label.setText(num.toString())
            }
        }
        up.setOnClickListener {
            establecerMaximo()
        }
        down.setOnClickListener {
            establecerMinimo()
        }
        adivinado.setOnClickListener {
            if (clickeado == 0) {
                generate.isEnabled = false
                up.isEnabled = false
                down.isEnabled = false

                label.setText("Lo adiviné, se encuentra entre " + minValue + " y " + maxValue)
                adivinado.setText("Reiniciar")
                clickeado += 1
            } else {
                generate.isEnabled = true
                up.isEnabled = true
                down.isEnabled = true

                minValue = 0
                maxValue = 100
                num = 0
                clickeado = 0

                adivinado.setText("Adivinado")
                label.setText("Pulse Generate para empezar")
            }
        }
    }

    fun establecerMinimo() {
        maxValue = num
        num = Random.nextInt(minValue, maxValue)
    }
    fun establecerMaximo() {
        minValue = num
        num = Random.nextInt(minValue, maxValue)
    }


}
