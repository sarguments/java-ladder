package saru.domain

import java.util.*

object LadderGameUtil {
    private val random = Random()

    fun getRand(limit: Int): Int {
        return random.nextInt(limit)
    }
}
