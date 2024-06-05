package dev.tadyboii.NumberToText.util

class NumberToTextConverter {

    fun convert(number: Int): String {

        val digits = number.toString().reversed().map { it.toString().toInt() }.toIntArray()
        var text: String = ""

        digits.forEachIndexed { index, digit ->
            if (index == 0 || index == 3) {
                text = text.takeIf { index != 3 } ?: "thousand $text"
                text = when (digit) {
                    0 -> "zero $text"
                    1 -> "one $text"
                    2 -> "two $text"
                    3 -> "three $text"
                    4 -> "four $text"
                    5 -> "five $text"
                    6 -> "six $text"
                    7 -> "seven $text"
                    8 -> "eight $text"
                    9 -> "nine $text"
                    else -> text
                }
            } else if (index == 1){
                if(digit == 1) {
                    text = when (text) {
                        "zero" -> "ten"
                        "one" -> "eleven"
                        "two" -> "twelve"
                        "three" -> "thirteen"
                        "four" -> "fourteen"
                        "five" -> "fifteen"
                        "six" -> "sixteen"
                        "seven" -> "seventeen"
                        "eight" -> "eighteen"
                        "nine" -> "nineteen"
                        else -> text
                    }
                }else{
                    text = text.takeIf { it != "zero" } ?: ""
                    text = when (digit) {
                        2 -> "twenty $text"
                        3 -> "thirty $text"
                        4 -> "forty $text"
                        5 -> "fifty $text"
                        6 -> "sixty $text"
                        7 -> "seventy $text"
                        8 -> "eighty $text"
                        9 -> "ninety $text"
                        else -> text
                    }
                }
            }else if (index == 2){
                text = text.takeIf { it != "zero" } ?: ""
                text = when (digit) {
                    1 -> "one hundred $text"
                    2 -> "two hundred $text"
                    3 -> "three hundred $text"
                    4 -> "four hundred $text"
                    5 -> "five hundred $text"
                    6 -> "six hundred $text"
                    7 -> "seven hundred $text"
                    8 -> "eight hundred $text"
                    9 -> "nine hundred $text"
                    else -> text
                }
            }
        }

        return text
    }
}