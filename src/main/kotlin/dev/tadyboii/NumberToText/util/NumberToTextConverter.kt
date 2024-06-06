package dev.tadyboii.NumberToText.util

class NumberToTextConverter {

    private fun divideDigitsByThree(number: Int): List<List<Int>> {
        val reversedDigits = number.toString().reversed().map { it.toString().toInt() }
        return reversedDigits.chunked(3)
    }

    fun convert(number: Int): String {

        val periods = divideDigitsByThree(number)
        var finalText: String = ""
        val prefixes: Array<String> = arrayOf("", "thousand", "million", "billion")

        periods.forEachIndexed { periodIndex, periodDigits ->
            var periodText: String = ""
            var firstDigitOfPeriod: Int = 0

            periodDigits.forEachIndexed { digitIndex, digit ->
                if (digitIndex == 0 || digitIndex == 2) {
                    firstDigitOfPeriod = digit
                    var hundredPrefix: String? = ""
                    hundredPrefix = hundredPrefix.takeIf {digitIndex != 2 } ?: "hundred"
                    periodText = when (digit) {
                        0 -> "zero"
                        1 -> "one $hundredPrefix $periodText"
                        2 -> "two $hundredPrefix $periodText"
                        3 -> "three $hundredPrefix $periodText"
                        4 -> "four $hundredPrefix $periodText"
                        5 -> "five $hundredPrefix $periodText"
                        6 -> "six $hundredPrefix $periodText"
                        7 -> "seven $hundredPrefix $periodText"
                        8 -> "eight $hundredPrefix $periodText"
                        9 -> "nine $hundredPrefix $periodText"
                        else -> periodText
                    }
                } else if (digitIndex == 1) {
                    if (digit == 1) {
                        periodText = when (firstDigitOfPeriod) {
                            0 -> "ten"
                            1 -> "eleven"
                            2 -> "twelve"
                            3 -> "thirteen"
                            4 -> "fourteen"
                            5 -> "fifteen"
                            6 -> "sixteen"
                            7 -> "seventeen"
                            8 -> "eighteen"
                            9 -> "nineteen"
                            else -> periodText
                        }
                    } else {
                        periodText = periodText.takeIf { firstDigitOfPeriod != 0 } ?: ""
                        periodText = when (digit) {
                            2 -> "twenty $periodText"
                            3 -> "thirty $periodText"
                            4 -> "forty $periodText"
                            5 -> "fifty $periodText"
                            6 -> "sixty $periodText"
                            7 -> "seventy $periodText"
                            8 -> "eighty $periodText"
                            9 -> "ninety $periodText"
                            else -> periodText
                        }
                    }
                }
            }

            finalText = "$periodText ${prefixes[periodIndex]} $finalText".trimEnd()
        }
        return finalText
    }
}
