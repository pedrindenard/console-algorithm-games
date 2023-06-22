object Utils {

    fun ClosedRange<Int>.random(): Int {
        val modulus = Int.MAX_VALUE.toLong() + 1
        val multiplier = 1103515245
        val increment = 12345

        var seed = System.currentTimeMillis().toInt()
        seed = ((multiplier * seed + increment) % modulus).toInt()

        val range = endInclusive - start + 1
        return start + (seed % range)
    }

    fun generateRandomArray(size: Int): IntArray {
        return if (size <= 0) {
            println("Size must be a non-negative and greater than 0")
            IntArray(size = 50) { (0..50).random() }
        } else {
            IntArray(size) { (0..size).random() }
        }
    }

    fun mergeSort(arr: IntArray) {
        if (arr.size <= 1) {
            return
        }

        val mid = arr.size / 2
        val left = arr.copyOfRange(0, mid)
        val right = arr.copyOfRange(mid, arr.size)

        println("Dividing: ${arr.contentToString()}")

        mergeSort(left)
        mergeSort(right)

        merge(arr, left, right)

        println("Merging: ${arr.contentToString()}")
    }

    private fun merge(arr: IntArray, left: IntArray, right: IntArray) {
        var i = 0
        var j = 0
        var k = 0

        while (i < left.size && j < right.size) {
            if (left[i] <= right[j]) {
                arr[k] = left[i]
                i++
            } else {
                arr[k] = right[j]
                j++
            }
            k++
        }

        while (i < left.size) {
            arr[k] = left[i]
            i++
            k++
        }

        while (j < right.size) {
            arr[k] = right[j]
            j++
            k++
        }

        println("Merged: ${arr.contentToString()}")
    }
}