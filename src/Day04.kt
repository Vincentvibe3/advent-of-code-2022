fun main() {
    fun part1(input: List<String>): Int {
        var fullyContained = 0
        for (line in input) {
            val pair = line.split(",").map { rangeString ->
                rangeString.split("-").map {
                    it.toInt()
                }
            }
            if (pair[0][0]<=pair[1][0]&&pair[0][1]>=pair[1][1]){
                fullyContained++
            } else if (pair[1][0]<=pair[0][0]&&pair[1][1]>=pair[0][1]){
                fullyContained++
            }
        }
        return fullyContained
    }

    fun part2(input: List<String>): Int {
        var overlap = 0
        for (line in input) {
            val pair = line.split(",").map { rangeString ->
                rangeString.split("-").map {
                    it.toInt()
                }
            }
            val overlapSections = (pair[0][0]..pair[0][1]).toSet().intersect(pair[1][0]..pair[1][1])
            if (overlapSections.isNotEmpty()){
                overlap++
            }
        }
        return overlap
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day04_test")
    check(part1(testInput) == 2)
    check(part2(testInput) == 4)

    val input = readInput("Day04")
    println(part1(input))
    println(part2(input))
}
