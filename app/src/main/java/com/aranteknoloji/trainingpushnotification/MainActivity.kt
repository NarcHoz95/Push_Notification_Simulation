package com.aranteknoloji.trainingpushnotification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.iid.FirebaseInstanceId
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.GlobalScope

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.textObservable().observe(this, Observer {
            text_view.text = it.text
        })
        //viewModel.setTextToDb("Merhaba Dunya")

        FirebaseInstanceId.getInstance().instanceId
            .addOnCompleteListener {
                if (!it.isSuccessful) {
                    println("Instance ID is not successful")
                    return@addOnCompleteListener
                }
                println("Token from Main Activity -> ${it.result?.token}")
                Toast.makeText(this@MainActivity,
                    "Instance ID has been saved", Toast.LENGTH_LONG).show()
            }
    }
}
