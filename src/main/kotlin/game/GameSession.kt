package org.example.game

import org.example.ui.Gallows
import org.example.ui.MessagePrinter
import org.example.dictionary.Dictionary
import org.example.dictionary.DifficultLevel

class GameSession(
    dictionary: Dictionary,
    difficulty: DifficultLevel
) {
    private val wordToGuess = dictionary.getWord(difficulty).toCharArray()
    private val userWordResult = CharArray(wordToGuess.size) { '*' }
    private val userInputLetters = sortedSetOf<Char>()
    private var currentStage = 0

    fun start() {
        while (true) {
            MessagePrinter.printGameState(userWordResult, userInputLetters, currentStage)
            val userInput = readUserInput()

            when {
                userInput == "exit" -> break
                userInput.isBlank() -> MessagePrinter.printInvalidCommand()
                isNotCyrillicString(userInput) -> MessagePrinter.printIsNotCyrillicInput()
                userInput.length > 1 -> handleWordGuess(userInput)
                else -> handleLetterGuess(userInput[0])
            }

            if (isGameWon()) {
                MessagePrinter.printWinMessage(wordToGuess)
                break
            }

            if (isGameLost()) {
                MessagePrinter.printLoseMessage(wordToGuess)
                break
            }
        }
    }

    private fun handleWordGuess(word: String) {
        if (word == wordToGuess.concatToString()) {
            userWordResult.indices.forEach { userWordResult[it] = wordToGuess[it] }
        } else {
            Gallows.draw(currentStage)
            MessagePrinter.printWrongWord(word)
            currentStage++
        }
    }

    private fun handleLetterGuess(letter: Char) {
        if (isLetterAlreadyGuessed(letter)) {
            MessagePrinter.printAlreadyGuessedLetter(letter)
            return
        }

        userInputLetters.add(letter)

        if (isLetterInWord(letter)) {
            handleCorrectGuess(letter)
        } else {
            handleWrongGuess(letter)
        }
    }

    private fun isLetterAlreadyGuessed(letter: Char): Boolean {
        return userInputLetters.contains(letter)
    }

    private fun isLetterInWord(letter: Char): Boolean {
        return wordToGuess.contains(letter)
    }

    private fun handleCorrectGuess(letter: Char) {
        updateUserWordResult(letter)
        MessagePrinter.printCorrectLetter(letter)
    }

    private fun handleWrongGuess(letter: Char) {
        Gallows.draw(currentStage)
        MessagePrinter.printWrongLetter(letter)
        currentStage++
    }

    private fun updateUserWordResult(letter: Char) {
        wordToGuess.forEachIndexed { index, char ->
            if (char == letter) userWordResult[index] = char
        }
    }

    private fun isNotCyrillicString(string: String): Boolean {
        val cyrillicRegex = "^\\p{IsCyrillic}+$".toRegex()
        return !cyrillicRegex.matches(string)
    }

    private fun isGameWon() = wordToGuess.contentEquals(userWordResult)

    private fun isGameLost() = currentStage >= Gallows.maxStages

    private fun readUserInput(): String = readlnOrNull()?.trim()?.lowercase() ?: ""
}