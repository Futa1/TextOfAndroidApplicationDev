package com.websarva.wings.android.hellosample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 表示ボタンをクリック->メッセージを表示
        val msgDisplayButton = findViewById<Button>(R.id.btClick)
        val clickButtonListener = ClickDisplayButtonListener()
        msgDisplayButton.setOnClickListener(clickButtonListener)
        // クリアボタンをクリック->メッセージを非表示
        val msgClearButton = findViewById<Button>(R.id.btClear)
        msgClearButton.setOnClickListener(clickButtonListener)
    }

    // ボタンをクリックしたときのリスナクラス
    private inner class ClickDisplayButtonListener : View.OnClickListener {
        override fun onClick(view: View) {
            val nameInputArea = findViewById<EditText>(R.id.etName)
            val msgOutputArea = findViewById<TextView>(R.id.tvOutput)
            
            // 押したボタンに応じて処理を変更
            when (view.id) {
                R.id.btClick -> {
                    val name = nameInputArea.text.toString()
                    msgOutputArea.text = name + "さん、こんにちは！"
                }

                R.id.btClear -> {
                    nameInputArea.setText("")
                    msgOutputArea.text = ""
                }
            }
        }
    }
}