package com.tong.swoosh.controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tong.swoosh.R
import com.tong.swoosh.model.Player
import com.tong.swoosh.utilities.EXTRA_LEAGUE
import com.tong.swoosh.utilities.EXTRA_PLAYER
import com.tong.swoosh.utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_finish.*

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        //val league = intent.getStringExtra(EXTRA_LEAGUE)
        //val skill = intent.getStringExtra(EXTRA_SKILL)
        //searchLeagueText.text = "Looking for $league $skill nearing you..."

        val player = intent.getParcelableExtra<Player>(EXTRA_PLAYER)
        searchLeagueText.text = "Looking for ${player.league} ${player.skill} nearing you..."
    }
}
