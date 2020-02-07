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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Declaraciones
        val label: TextView = findViewById(R.id.etiqueta)
        val down: Button = findViewById(R.id.down)
        val up: Button = findViewById(R.id.up)
        val generate: Button = findViewById(R.id.generate)

        // onClickListener
        generate.setOnClickListener {
            num = Random.nextInt(minValue,maxValue)
            label.setText(num.toString())
        }
        up.setOnClickListener {
            establecerMaximo()
        }
        down.setOnClickListener {
            establecerMinimo()
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
