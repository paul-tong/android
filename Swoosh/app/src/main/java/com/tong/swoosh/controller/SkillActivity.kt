package com.tong.swoosh.controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.tong.swoosh.utilities.EXTRA_LEAGUE
import com.tong.swoosh.R
import com.tong.swoosh.utilities.EXTRA_SKILL
import kotlinx.android.synthetic.main.activity_skill.*

class SkillActivity : AppCompatActivity() {
    var league = ""
    var skill = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_skill)

        league = intent.getStringExtra(EXTRA_LEAGUE)
        println("skill activity: $league")

    }

    fun onSkillFinishClicked(view: View) {
        if (skill != "") {
            val finishIntent = Intent(this, FinishActivity::class.java)
            finishIntent.putExtra(EXTRA_LEAGUE, league)
            finishIntent.putExtra(EXTRA_SKILL, skill)

            startActivity(finishIntent)
        }
        else {
            Toast.makeText(this, "Please select a skill", Toast.LENGTH_SHORT).show()
        }
    }

    fun onSkillBallerClicked(view: View) {
        beginnerSkillBtn.isChecked = false
        skill = "baller"

    }

    fun onSkillBeginnerClicked(view: View) {
        ballerSkillBtn.isChecked = false
        skill = "beginner"
    }
}
