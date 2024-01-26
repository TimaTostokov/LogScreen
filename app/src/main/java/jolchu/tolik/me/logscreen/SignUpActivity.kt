package jolchu.tolik.me.logscreen

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.Firebase
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.firestore

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val sp = getSharedPreferences("PC", Context.MODE_PRIVATE)

        val email: TextView = findViewById(R.id.email)
        val password: TextView = findViewById(R.id.password)
        val button: TextView = findViewById(R.id.button)

        button.setOnClickListener {
            if (email.text.isEmpty() || email.text.contains("@") == false) {
                Toast.makeText(this, "Проверьте поле email!", Toast.LENGTH_SHORT).show()
            } else if (password.text.isEmpty() || password.text.length < 6) {
                Toast.makeText(this, "Пароль должен быть больше 5 символов", Toast.LENGTH_SHORT)
                    .show()
            } else {
                val db = Firebase.firestore
                val user = hashMapOf(
                    "email" to email.text.toString(),
                    "password" to password.text.toString()
                )

                db.collection("users")
                    .add(user)
                    .addOnSuccessListener {
                        sp.putString("Email",email.text.toString())
                        startActivity(Intent(this,SecondActivity::class.java))
                    }

                    .addOnFailureListener {
                        Toast.makeText(
                            this,
                            "Не получилось попробуйте попозже!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            }
        }
    }

}