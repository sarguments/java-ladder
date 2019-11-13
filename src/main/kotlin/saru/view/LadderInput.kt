package saru.view

import java.util.*

class LadderInput {

    val userName: Array<String>
        get() {
            println(INPUT_USER_NAMES)
            val userInput = LadderInput.scanner.nextLine()
            return userInput.split(REGEX.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        }

    val destination: Array<String>
        get() {
            println(INPUT_DESTINATION)
            val userInput = LadderInput.scanner.nextLine()
            return userInput.split(REGEX.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        }

    val height: Int
        get() {
            val userInput: String

            println(INPUT_MAX_LADDER_LENGTH)
            userInput = LadderInput.scanner.next()
            return Integer.parseInt(userInput)
        }

    fun checkValid(names: Array<String>, destination: Array<String>, height: Int): Boolean {
        if (checkCondition(height <= 0, INCORRECT_HEIGHT_INPUT))
            return false

        return if (checkCondition(
                !checkNamesProc(names),
                INCORRECT_NAME_INPUT
            )
        ) false else !checkCondition(!checkNamesProc(destination), INCORRECT_DESTINATION)

    }

    fun flush() {
        scanner.nextLine()
    }

    private fun checkCondition(condition: Boolean, errorMsg: String): Boolean {
        if (condition) {
            println(errorMsg)
            return true
        }
        return false
    }

    private fun checkNamesProc(names: Array<String>): Boolean {
        var faultNum = 0

        for (name in names) {
            faultNum += countCheckNameFault(name)
        }

        return faultNum == 0
    }

    private fun countCheckNameFault(name: String): Int {
        return if (checkNameLength(name)) 0 else 1
    }

    private fun checkNameLength(name: String): Boolean {
        return name.length <= MAX_NAME_LENGTH
    }

    companion object {
        private val INCORRECT_NAME_INPUT = "이름을 제대로 입력하세요"
        private val INCORRECT_DESTINATION = "실행 결과를 제대로 입력하세요"
        private val INCORRECT_HEIGHT_INPUT = "높이를 제대로 입력하세요"
        private val INPUT_USER_NAMES = "참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)"
        private val INPUT_DESTINATION = "실행 결과를 입력하세요. (결과는 쉼표(,)로 구분하세요)"
        private val INPUT_MAX_LADDER_LENGTH = "최대 사다리 높이는 몇 개인가요?"
        private val REGEX = ","
        private val MAX_NAME_LENGTH = 5
        private val scanner = Scanner(System.`in`)
    }
}
