fun main() {
    fun part1(input: List<String>): Int {
        var max = -1
        var currentElf = 0
        for (line in input) {
            if (line.isBlank()){
                if (currentElf>max){
                    max = currentElf
                }
                currentElf = 0
            } else{
                currentElf+=line.toInt()
            }
        }
        return max
    }

    fun part2(input: List<String>): Int {
        val elves = mutableListOf(0)
        for (line in input) {
            if (line.isBlank()){
                elves.add(0)
            } else{
                elves[elves.lastIndex]+=line.toInt()
            }
        }
        return elves.sorted().reversed().subList(0, 3).sum()
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 24000)
    check(part2(testInput) == 45000)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}
