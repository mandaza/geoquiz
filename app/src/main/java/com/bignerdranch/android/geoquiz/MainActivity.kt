package com.bignerdranch.android.geoquiz


import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }

    private val quizViewModel: QuizViewModel by viewModels()

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button

    private lateinit var prevButton: Button
    private lateinit var questionTextView: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        nextButton = findViewById(R.id.next_button)
        questionTextView = findViewById(R.id.questionText)
        prevButton = findViewById(R.id.prev_button)
        val cheatButton: Button = findViewById(R.id.cheat_button)
        cheatButton.setOnClickListener {
            val answerIsTrue = quizViewModel.getCurrentQuestion().answerTrue
            val intent = CheatActivity.newIntent(this, answerIsTrue)
            cheatLauncher.launch(intent)
        }


        prevButton.setOnClickListener {
            quizViewModel.moveToPrevious()
            updateQuestion()
        }

        updateQuestion()

        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }

        nextButton.setOnClickListener {
            quizViewModel.moveToNext()
            updateQuestion()
        }

        // Tap the question to advance (book does this too)
        questionTextView.setOnClickListener {
            quizViewModel.moveToNext()
            updateQuestion()
        }


    }


    override fun onStart() {
        super.onStart()
        android.util.Log.d(TAG, "onStart()")
    }

    override fun onResume() {
        super.onResume()
        android.util.Log.d(TAG, "onResume()")
    }

    override fun onPause() {
        super.onPause()
        android.util.Log.d(TAG, "onPause()")
    }

    override fun onStop() {
        super.onStop()
        android.util.Log.d(TAG, "onStop()")
    }

    override fun onDestroy() {
        super.onDestroy()
        android.util.Log.d(TAG, "onDestroy()")
    }




    private fun updateQuestion() {
        val questionResId = quizViewModel.getCurrentQuestion().textResId
        questionTextView.setText(questionResId)
    }



    private fun checkAnswer(userPressedTrue: Boolean) {
        val correctAnswer = quizViewModel.getCurrentQuestion().answerTrue
        val messageId = when {
            quizViewModel.isCurrentQuestionCheated() -> R.string.judgment_toast
            userPressedTrue == correctAnswer -> R.string.correct_toast
            else -> R.string.incorrect_toast
        }
        Toast.makeText(this, messageId, Toast.LENGTH_SHORT).show()
    }


    private val cheatLauncher = registerForActivityResult(
        androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == android.app.Activity.RESULT_OK) {
            val didCheat = result.data?.getBooleanExtra(CheatActivity.EXTRA_ANSWER_SHOWN, false) ?: false
            if (didCheat) quizViewModel.setCheated(true)
        }
    }

}

