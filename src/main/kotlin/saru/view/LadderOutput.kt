package saru.view

import saru.domain.LadderGame
import saru.domain.Line
import saru.domain.User
import java.util.*

class LadderOutput {

    private val userChoice: String
        get() = scanner.nextLine()

    fun sendOutputObject(ladderGame: LadderGame) {
        printUserNames(ladderGame.getUsers())
        printLadder(ladderGame.getLadderLines())
        printDestination(ladderGame.destinations)

        var isAllResult = false
        while (!isAllResult) {
            isAllResult = promptResult(ladderGame)
        }
    }

    private fun printUserNames(users: List<User>) {
        for (user in users) {
            System.out.printf("%-6s", user.name)
        }
        println()
    }

    // TODO 리팩토링 필요
    private fun promptResult(ladderGame: LadderGame): Boolean {
        println(RESULT_PROMPT)
        val userChoice = userChoice

        val users = ladderGame.getUsers()
        val results = ladderGame.result
        val destination = ladderGame.destinations

        if (userChoice == "all") {
            printAllResult(users, results!!, destination)
            return true
        }

        val matchIndex = getUserMatchIndex(users, userChoice)
        println(destination[results!![matchIndex] / 2])

        return false
    }

    // TODO 인덴트를 못 줄이겠습니다.
    private fun getUserMatchIndex(users: List<User>, userName: String): Int {

        for (i in users.indices) {
            if (users[i].name == userName) {
                return i
            }
        }

        return -1
    }

    private fun printAllResult(users: List<User>, results: List<Int>, destination: List<String>) {
        for (i in results.indices) {
            println(users[i].name + " : " + destination[results[i] / 2])
        }
    }

    private fun printDestination(destinations: List<String>) {
        for (destination in destinations) {
            System.out.printf("%-6s", destination)
        }
        print("\n\n")
    }

    private fun printLadder(lines: List<Line>) {
        for (line in lines) {
            printMultiLines(line.getPoints())
        }
    }

    private fun printMultiLines(arr: List<Boolean>) {
        for (i in arr.indices) {
            printIndividualLine(arr, i)
        }
        println()
    }

    private fun printIndividualLine(arr: List<Boolean>, index: Int) {
        if (index % 2 == 1) {
            printInterPoint(arr[index])
            return
        }
        print(COLUMN_LINE)
    }

    private fun printInterPoint(isTrue: Boolean) {
        if (isTrue) {
            print(ROW_LINE)
            return
        }
        print(ROW_BLANK_LINE)
    }

    companion object {
        private val scanner = Scanner(System.`in`)

        private val RESULT_PROMPT = "결과를 보고 싶은 사람은?"
        private val ROW_BLANK_LINE = "     "
        private val COLUMN_LINE = "|"
        private val ROW_LINE = "-----"
    }
}
