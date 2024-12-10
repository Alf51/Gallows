package org.example.dictionary

enum class DifficultLevel(private val descriptions: String) {
    EASY("лёгкий"),
    MEDIUM("средний"),
    HARD("тяжёлый");

    override fun toString(): String = descriptions
}