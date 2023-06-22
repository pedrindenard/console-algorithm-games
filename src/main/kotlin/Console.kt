import Utils.generateRandomArray

fun main(args: Array<String>) {
    println("Program arguments: ${args.joinToString()}")
    println("Welcome to the Game Menu!")

    var input: String? = null

    while (input != "5") {
        println("Please select a game to play:")

        println("1. Tower of Hanoi Game")
        println("2. Guessing Game")
        println("3. Sort by Divide and Conquer Game")
        println("4. Minimum Change Game")
        println("5. Exit")

        print("Enter your choice (1-5): ")
        input = readLine()

        when (input) {
            "1" -> {
                println("Welcome to the Tower Of Hanoi Game!")
                print("Enter your number of disks:")
                val disks = readLine()?.toIntOrNull() ?: 5

                Games.recursion(disks)
            }
            "2" -> {
                println("Welcome to the Guessing Game!")
                print("Enter your min number:")
                val minNumber = readLine()?.toIntOrNull() ?: 1

                print("Enter your max number:")
                val maxNumber = readLine()?.toIntOrNull() ?: 100

                Games.divination(minNumber, maxNumber)
            }
            "3" -> {
                println("Welcome to the Minimum Change Game!")
                print("Enter your number of items in array:")
                val arraySize = readLine()?.toIntOrNull() ?: 50
                val array = generateRandomArray(arraySize)

                Games.ordination(array)
            }
            "4" -> {
                println("Welcome to the Sort by Divide and Conquer Game!")
                print("Enter your amount:")
                val amount = readLine()?.toIntOrNull() ?: 76

                Games.sweetTooth(amount)
            }
            "5" -> {
                println("Check back often...")
                println("Exiting...")
            }
            else -> {
                println("Invalid choice. Please try again.")
            }
        }

        println()
    }
}