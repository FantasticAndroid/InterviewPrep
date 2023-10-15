package com.offline.first.programmings

/**
 * https://www.toptal.com/android/functional-reactive-programming-part-1
 * Given a list of names, return a list containing only the names with at least three vowels
 * and with the vowels shown in uppercase letters.
 */
object FunctionalReactiveProgramming {

    private val vowels = listOf('A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u')
    /**
     *
     * @param input List<String>
     * @return List<String>
     */
    private fun getNamesImperative(input: List<String>): List<String> {
        val result = mutableListOf<String>()

        for (name in input) { // loop 1
            var vowelsCount = 0

            for (char in name) { // loop 2
                if (isVowel(char)) {
                    vowelsCount++

                    if (vowelsCount == 3) {
                        val uppercaseName = StringBuilder()

                        for (finalChar in name) { // loop 3
                            var transformedChar = finalChar

                            // ignore that the first letter might be uppercase
                            if (isVowel(finalChar)) {
                                transformedChar = finalChar.uppercaseChar()
                            }
                            uppercaseName.append(transformedChar)
                        }

                        result.add(uppercaseName.toString())
                        break
                    }
                }
            }
        }

        return result
    }

    /**
     * Let’s look at our names problem. Our smaller problems from the imperative solution are:
     *
     * isVowel :: Char -> Bool: Given a Char, return whether it’s a vowel or not (Bool).
     * countVowels :: String -> Int: Given a String, return the number of vowels in it (Int).
     * hasThreeVowels :: String -> Bool: Given a String, return whether it has at least three vowels (Bool).
     * uppercaseVowels :: String -> String: Given a String, return a new String with uppercase vowels.
     * Reactive approach can solve above problem like below:
     * @param input List<String>
     * @return List<String>
     */
    private fun getNamesReactive(input: List<String>): List<String> = input.filter { name ->
        name.count(::isVowel) >= 3
    }.map { name ->
        name.map { char ->
            if (isVowel(char, vowels)) char.uppercaseChar() else char
        }.joinToString("")
    }

    private fun isVowel(char: Char): Boolean {
        return vowels.contains(char)
    }

    /**
     * PURE Function
     * @param char Char
     * @param vowels List<Char>
     * @return Boolean
     */
    private fun isVowel(char: Char, vowels: List<Char>): Boolean {
        return vowels.contains(char)
    }


    fun applyFunctionalReactiveProgramming() {
        val namesList = listOf("Iliyan", "Annabel", "Nicole", "John", "Anthony", "Ben", "Ken")
        println(getNamesImperative(namesList))
        println(getNamesReactive(namesList))
        // Output: [IlIyAn, AnnAbEl, NIcOlE]
    }
}