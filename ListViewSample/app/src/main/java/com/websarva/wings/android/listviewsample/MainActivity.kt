package com.websarva.wings.android.listviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // リストをタップ->定食情報を表示
        val lvMenu = findViewById<ListView>(R.id.lvMenu)
        lvMenu.onItemClickListener = MenuListClickListener()
    }

    // リストタップ->トーストで定食情報を表示
    private inner class MenuListClickListener : AdapterView.OnItemClickListener {
        /**
         * イベントハンドラ
         * @param[parent] 親要素のリストビュー全体
         * @param[view] タップされた1行分の画面部品
         * @param[position] タップされた行番号
         * @param[id] DBの主キー or positionと同じ値
         */
        override fun onItemClick(parent: AdapterView<*>?, view: View, position: Int, id: Long) {
            val item = parent.getItemAtPosition(position) as String
            val display = "あなたが選んだ定食：${item}"
            Toast.makeText(this@MainActivity, display, Toast.LENGTH_LONG).show()
        }
    }
}