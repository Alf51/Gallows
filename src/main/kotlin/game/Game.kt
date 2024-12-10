package org.example.game

import org.example.ui.MainMenu
import org.example.ui.MessagePrinter
import org.example.dictionary.Dictionary
import org.example.dictionary.DifficultLevel
import kotlin.system.exitProcess

class Game(private val dictionary: Dictionary) {
    fun startNewGame() {
        while (true) {
            printMainMenu()
            when (readUserInput()) {
                "1" -> chooseDifficulty()
                "2" -> exitGame()
                else -> MessagePrinter.printInvalidCommand()
            }
        }
    }

    private fun printMainMenu() {
        println("Введите цифру для выбора пункта меню")
        println("1. ${MainMenu.NEW_GAME}")
        println("2. ${MainMenu.EXIT}")
    }

    private fun chooseDifficulty() {
        while (true) {
            printDifficultyMenu()
            when (readUserInput()) {
                "1" -> GameSession(dictionary, DifficultLevel.EASY).start()
                "2" -> GameSession(dictionary, DifficultLevel.MEDIUM).start()
                "3" -> GameSession(dictionary, DifficultLevel.HARD).start()
                "4" -> return
                else -> MessagePrinter.printInvalidCommand()
            }
        }
    }

    private fun printDifficultyMenu() {
        println("Выберите уровень сложности")
        println("1. ${DifficultLevel.EASY} (3–4 буквы)")
        println("2. ${DifficultLevel.MEDIUM} (5–7 букв)")
        println("3. ${DifficultLevel.HARD} (11+ букв)")
        println("4. Назад")
    }

    private fun exitGame() {
        println("Выход из игры. До свидания!")
        exitProcess(0)
    }

    private fun readUserInput(): String = readlnOrNull()?.trim() ?: ""
}