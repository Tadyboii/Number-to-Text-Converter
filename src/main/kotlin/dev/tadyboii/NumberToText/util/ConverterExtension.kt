package dev.tadyboii.NumberToText.util

fun Int.toText(): String {
    val number = this
    val numberToText = NumberToTextConverter()
    return numberToText.convert(number)
}


