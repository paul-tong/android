package com.tong.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Toast
import com.tong.swoosh.R
import com.tong.swoosh.model.Player
import com.tong.swoosh.utilities.EXTRA_LEAGUE
import com.tong.swoosh.utilities.EXTRA_PLAYER
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    // var selectedLeague = ""
    var player = Player("", "")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
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

    fun onMensClicked(view: View) {
        womenLeagueBtn.isChecked = false // can only select on type, set other button to un-check
        coedLeagueBtn.isChecked = false
        player.league = "mens"
    }

    fun onWomensClicked(view: View) {
        mensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false
        player.league = "womens"
    }

    fun onCoedClicked(view: View) {
        womenLeagueBtn.isChecked = false
        mensLeagueBtn.isChecked = false
        player.league = "coed"
    }

    fun leagueNextClicked(view: View) {
        if (player.league != "") { // at least one type need to choose
            val skillIntent = Intent(this, SkillActivity::class.java)
            // skillIntent.putExtra(EXTRA_LEAGUE, selectedLeague)
            skillIntent.putExtra(EXTRA_PLAYER, player)
            startActivity(skillIntent)
        }
        else {
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
        }
    }

}
