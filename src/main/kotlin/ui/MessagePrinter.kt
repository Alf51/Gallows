package org.example.ui

object  MessagePrinter {
    fun printGameState(
        userWordResult: CharArray,
        userInputLetters: Set<Char>,
        currentStage: Int
    ) {
        println("Слово: ${userWordResult.concatToString()}")
        println("Названные буквы: ${userInputLetters.joinToString(", ")}")
        println("Осталось попыток: ${Gallows.maxStages - currentStage}")
        printIsNotCyrillicInput()
    }

    fun printInvalidCommand() {
        println("Некорректный ввод, попробуйте снова или напишите exit для выхода")
    }

    fun printIsNotCyrillicInput() {
        println("Введите букву или слово на кириллице")
    }

    fun printWrongWord(word: String) {
        println("Неправильное слово: $word")
    }

    fun printWrongLetter(letter: Char) {
        println("Неправильная буква: $letter")
    }

    fun printCorrectLetter(letter: Char) {
        println("Вы угадали букву: $letter")
    }

    fun printAlreadyGuessedLetter(letter: Char) {
        println("Вы уже называли букву: $letter")
    }

    fun printWinMessage(wordToGuess: CharArray) {
        println("Поздравляем! Вы угадали слово: ${wordToGuess.concatToString()}")
    }

    fun printLoseMessage(wordToGuess: CharArray) {
        println("Вы проиграли. Загаданное слово: ${wordToGuess.concatToString()}")
    }
}