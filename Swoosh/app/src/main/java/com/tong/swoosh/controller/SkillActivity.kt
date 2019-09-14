package com.tong.swoosh.controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.tong.swoosh.utilities.EXTRA_LEAGUE
import com.tong.swoosh.R
import com.tong.swoosh.model.Player
import com.tong.swoosh.utilities.EXTRA_PLAYER
import com.tong.swoosh.utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {
    var league = ""
    var skill = ""

    lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        player = intent.getParcelableExtra(EXTRA_PLAYER)
        // league = intent.getStringExtra(EXTRA_LEAGUE)
    }

    // save player to the state
    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        outState?.putParcelable(EXTRA_PLAYER, player)
    }

    // get player from saved state (after rotation)
    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER)
        }
    }

    fun onSkillBallerClicked(view: View) {
        beginnerSkillBtn.isChecked = false
        player.skill = "baller"

    }

    fun onSkillBeginnerClicked(view: View) {
        ballerSkillBtn.isChecked = false
        player.skill = "beginner"
    }

    fun onSkillFinishClicked(view: View) {
        if (player.skill != "") {
            val finishIntent = Intent(this, FinishActivity::class.java)
            //finishIntent.putExtra(EXTRA_LEAGUE, league)
            //finishIntent.putExtra(EXTRA_SKILL, skill)
            finishIntent.putExtra(EXTRA_PLAYER, player)
            startActivity(finishIntent)
        }
        else {
            Toast.makeText(this, "Please select a skill", Toast.LENGTH_SHORT).show()
        }
    }
}
