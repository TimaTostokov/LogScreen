package jolchu.tolik.me.logscreen

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sp = getSharedPreferences("PC", Context.MODE_PRIVATE)

        if (sp.getString("TY", "-9") != "-9") {
            startActivity(Intent(this, SecondActivity::class.java))
        } else {
            val signuptext: TextView = findViewById(R.id.singuptext)

            signuptext.setOnClickListener {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }

}