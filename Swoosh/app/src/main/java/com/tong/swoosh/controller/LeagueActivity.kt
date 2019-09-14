package com.tong.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.tong.swoosh.R
import com.tong.swoosh.utilities.EXTRA_LEAGUE
import kotlinx.android.synthetic.main.activity_league.*

class LeagueActivity : BaseActivity() {

    var selectedLeague = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_league)
    }

    fun onMensClicked(view: View) {
        womenLeagueBtn.isChecked = false // can only select on type, set other button to un-check
        coedLeagueBtn.isChecked = false
        selectedLeague = "mens"
    }

    fun onWomensClicked(view: View) {
        mensLeagueBtn.isChecked = false
        coedLeagueBtn.isChecked = false
        selectedLeague = "womens"
    }

    fun onCoedClicked(view: View) {
        womenLeagueBtn.isChecked = false
        mensLeagueBtn.isChecked = false
        selectedLeague = "coed"
    }

    fun leagueNextClicked(view: View) {
        if (selectedLeague != "") { // at least one type need to choose
            val skillIntent = Intent(this, SkillActivity::class.java)
            skillIntent.putExtra(EXTRA_LEAGUE, selectedLeague)

            startActivity(skillIntent)
            //val finishActivity = Intent(this, FinishActivity::class.java)
            //startActivity(finishActivity)
        }
        else {
            Toast.makeText(this, "Please select a league", Toast.LENGTH_SHORT).show()
        }
    }

}
