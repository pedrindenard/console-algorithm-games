import Utils.mergeSort
import Utils.random

object Games {

    fun recursion(numDiscs: Int, sourceTower: Char = 'A', auxTower: Char = 'B', destinationTower: Char = 'C') {
        if (numDiscs == 1) {
            println("Move disk 1 from tower $sourceTower to tower $destinationTower\n")
            return
        }

        recursion(numDiscs = numDiscs - 1, sourceTower, destinationTower, auxTower)

        println("Move disk $numDiscs from tower $sourceTower to tower $destinationTower\n")

        recursion(numDiscs = numDiscs - 1, auxTower, sourceTower, destinationTower)
    }

    fun divination(minNumber: Int, maxNumber: Int) {
        println("Try to guess a number between $minNumber and $maxNumber.")

        val secretNumber = (minNumber..maxNumber).random()

        var attempts = 0
        var guess = 0

        do {
            print("Enter your guess: ")
            guess = readLine()?.toIntOrNull() ?: continue

            if (guess < secretNumber) {
                println("Too low. Try again.")
            } else if (guess > secretNumber) {
                println("Too high. Try again.")
            }

            attempts++

        } while (guess != secretNumber)

        println("Congratulations! You guessed the secret number $secretNumber in $attempts attempts.")
    }

    fun ordination(array: IntArray) {
        println("Original array: ${array.contentToString()}")

        mergeSort(array)

        println("Sorted array: ${array.contentToString()}")
    }

    fun sweetTooth(amount: Int) {
        println("Amount: $amount cents")

        val coins = listOf(25, 10, 5, 1)
        val change = mutableMapOf<Int, Int>()

        var remainingAmount = amount

        for (coin in coins) {
            val coinCount = remainingAmount / coin
            if (coinCount > 0) {
                change[coin] = coinCount
                remainingAmount %= coin
            }
        }

        println("Minimum change:")

        for ((coin, count) in change) {
            println("$coin cents: $count")
        }
    }
}