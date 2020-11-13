package leetcode.threenumbersum

fun main(args: Array<String>) {

    val nums = arrayOf(-1, -2, -4, 0, 5, 4, 2, 3)
    val result = Array(100) { IntArray(3)}
    var i = 0
    var resultNumber = 0
    while (i < nums.size) {
        var j = i + 1
        while (j < nums.size) {
            var k = j + 1
            while (k < nums.size) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    result[resultNumber][0] = nums[i]
                    result[resultNumber][1] = nums[j]
                    result[resultNumber][2] = nums[k]
                    resultNumber++
                }
                k++
            }
            j++
        }
        i++
    }
    i = 0
    while (i < resultNumber) {
        println("[ ${result[i][0]} ${result[i][1]} ${result[i][2]} ]" )
        i++
    }

}