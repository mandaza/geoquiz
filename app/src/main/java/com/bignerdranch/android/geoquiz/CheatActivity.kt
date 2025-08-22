package com.bignerdranch.android.geoquiz

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels

class CheatActivity : AppCompatActivity() {

    companion object {
        private const val EXTRA_ANSWER_IS_TRUE = "com.bignerdranch.android.geoquiz.answer_is_true"
        const val EXTRA_ANSWER_SHOWN = "com.bignerdranch.android.geoquiz.answer_shown"

        fun newIntent(context: Context, answerIsTrue: Boolean): Intent =
            Intent(context, CheatActivity::class.java).apply {
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
            }
    }

    private val cheatViewModel: CheatViewModel by viewModels()
    private var answerIsTrue: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        answerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)

        val answerText: TextView = findViewById(R.id.answer_text)
        val showAnswerButton: Button = findViewById(R.id.show_answer_button)
        val apiLevelText: TextView = findViewById(R.id.api_level_text)


        apiLevelText.text = getString(R.string.api_level, android.os.Build.VERSION.SDK_INT)

        if (cheatViewModel.answerShown) {
            answerText.text = if (answerIsTrue) getString(R.string.true_button)
            else getString(R.string.false_button)
            setAnswerShownResult(true) // ensure MainActivity still sees "cheated" after rotate
        }

        showAnswerButton.setOnClickListener {
            answerText.text = if (answerIsTrue) getString(R.string.true_button)
            else getString(R.string.false_button)
            cheatViewModel.setAnswerShown(true)
            setResult(Activity.RESULT_OK, Intent().putExtra(EXTRA_ANSWER_SHOWN, true))
        }
    }



    private fun setAnswerShownResult(shown: Boolean) {
        setResult(Activity.RESULT_OK, Intent().putExtra(EXTRA_ANSWER_SHOWN, shown))
    }
}


