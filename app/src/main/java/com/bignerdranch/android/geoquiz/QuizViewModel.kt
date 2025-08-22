package com.bignerdranch.android.geoquiz

import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {
    
    // Book-style question bank
    val questionBank = listOf(
        Question(R.string.question_oceans, true),
        Question(R.string.question_africa, true),
        Question(R.string.question_australia, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_america, true),
        Question(R.string.question_asia, true),
    )
    
    var currentIndex = 0
        private set
    
    var isCheater = BooleanArray(questionBank.size)
        private set
    
    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }
    
    fun moveToPrevious() {
        currentIndex = if (currentIndex == 0) questionBank.lastIndex else currentIndex - 1
    }
    
    fun setCheated(cheated: Boolean) {
        isCheater[currentIndex] = cheated
    }
    
    fun getCurrentQuestion(): Question {
        return questionBank[currentIndex]
    }
    
    fun isCurrentQuestionCheated(): Boolean {
        return isCheater[currentIndex]
    }
}
