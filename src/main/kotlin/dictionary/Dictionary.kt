package org.example.dictionary

import java.io.File

class Dictionary {
    private val wordLists: Map<DifficultLevel, List<String>> by lazy {
        loadWordLists()
    }

    fun getWord(level: DifficultLevel = DifficultLevel.EASY): String {
        val wordList = wordLists.getValue(level)
        return wordList.random()
    }

    private fun loadWordLists(): Map<DifficultLevel, List<String>> {
        return DifficultLevel.entries.associateWith { level ->
            loadWordsForLevel(level, "src/main/resources/dictionary/${level.name.lowercase()}")
        }
    }

    private val defaultWordLists: Map<DifficultLevel, List<String>> = mapOf(
        DifficultLevel.EASY to listOf("язык", "мир", "муха", "гриб"),
        DifficultLevel.MEDIUM to listOf("кальян", "тетрадь", "велосипед"),
        DifficultLevel.HARD to listOf("автомобилестроение", "электростанция", "достопримечательность")
    )

    private fun loadWordsForLevel(level: DifficultLevel, path: String): List<String> {
        return runCatching {
            loadWordsFromFile(path)
        }.getOrElse {
            println("Ошибка при чтении файла для уровня ${level.name}: ${it.message}")
            println("Использую словарь по умолчанию для уровня: ${level.name}")
            defaultWordLists.getValue(level)
        }
    }

    private fun loadWordsFromFile(path: String): List<String> {
        return File(path).useLines { lines ->
            lines.map { it.lowercase() }.toList()
        }
    }
}