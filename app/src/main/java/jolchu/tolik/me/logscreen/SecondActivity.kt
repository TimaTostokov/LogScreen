package jolchu.tolik.me.logscreen

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val sp = getSharedPreferences("PC", Context.MODE_PRIVATE)
        sp.edit().putString("TY", "9").apply()
        val emailName: TextView = findViewById(R.id.emailName)
        emailName.text = sp.getString("Email", "Не загрузилось (")
    }

    @Deprecated("Deprecated in Java",
        ReplaceWith("super.onBackPressed()", "androidx.appcompat.app.AppCompatActivity")
    )
    override fun onBackPressed() {
        super.onBackPressed()
    }

}