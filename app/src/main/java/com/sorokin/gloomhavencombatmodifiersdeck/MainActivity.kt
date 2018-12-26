package com.sorokin.gloomhavencombatmodifiersdeck

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)

        next_card_button.setOnClickListener {
            shown_card.setImageResource(R.drawable.card_back)
        }

        shuffle_button.setOnClickListener {
            shown_card.setImageResource(0)
        }
    }
}
