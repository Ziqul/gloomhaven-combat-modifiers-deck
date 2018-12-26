package com.sorokin.gloomhavencombatmodifiersdeck

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.setContentView(R.layout.activity_main)

        val defaultDeckData: Array<String> =
                resources.getStringArray(R.array.default_deck)

        val defaultDeck: ArrayList<String> = arrayListOf()
        defaultDeckData.forEach {
            val amount: Int = it.split(Regex("\\|")).get(1).toInt()
            for (i in 1..amount) {
                defaultDeck.add(it.split(Regex("\\|")).get(0))
            }
        }

        cards_left_value.text = "" + defaultDeck.size

        next_card_button.setOnClickListener {
            if (defaultDeck.size > 0) {
                shown_card.setImageResource(
                    resources.getIdentifier(
                        defaultDeck.removeAt(Random().nextInt(defaultDeck.size)),
                        "drawable",
                        "com.sorokin.gloomhavencombatmodifiersdeck"))
            }

            if (defaultDeck.size < 1) {
                hidden_card.setImageResource(R.drawable.card_transparent)
            }

            cards_left_value.text = "" + defaultDeck.size
        }

        shuffle_button.setOnClickListener {
            hidden_card.setImageResource(R.drawable.card_back)
            shown_card.setImageResource(R.drawable.card_transparent)
            defaultDeck.clear()
            defaultDeckData.forEach {
                val amount: Int = it.split(Regex("\\|")).get(1).toInt()
                for (i in 1..amount) {
                    defaultDeck.add(it.split(Regex("\\|")).get(0))
                }
            }

            cards_left_value.text = "" + defaultDeck.size
        }
    }
}
