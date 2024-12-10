package org.example.ui

enum class MainMenu(private val description: String) {
    NEW_GAME("новая игра"),
    EXIT("выход");

    override fun toString(): String = description
}