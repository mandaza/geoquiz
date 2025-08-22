package com.bignerdranch.android.geoquiz

import androidx.lifecycle.ViewModel

class CheatViewModel : ViewModel() {
    var answerShown = false
        private set
    
    fun setAnswerShown(shown: Boolean) {
        answerShown = shown
    }
}
