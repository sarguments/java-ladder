package saru

import saru.domain.LadderGame
import saru.view.LadderInput
import saru.view.LadderOutput

fun main() {
    val ladderInput = LadderInput()
    val ladderOutput = LadderOutput()

    var nameArr: Array<String>
    var destination: Array<String>
    var ladderHeight: Int

    do {
        nameArr = ladderInput.userName
        destination = ladderInput.destination
        ladderHeight = ladderInput.height
        ladderInput.flush()
    } while (!ladderInput.checkValid(nameArr, destination, ladderHeight))

    ladderOutput.sendOutputObject(LadderGame(ladderHeight, destination, nameArr))
}