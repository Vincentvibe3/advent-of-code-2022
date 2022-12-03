fun main() {
    fun part1(input: List<String>): Int {
        val DRAW = 3
        val WIN = 6
        val LOSS = 0

        val ROCK = 1
        val PAPER = 2
        val SCISSORS = 3

        var totalPoints = 0

        for (line in input) {
            var roundPoints = 0
            val split = line.split(" ");
            val opponent = split[0]
            val player = split[1]

            if (
                (opponent == "A" && player == "Y") ||
                (opponent == "B" && player == "Z") ||
                (opponent == "C" && player == "X")
            ) {
                roundPoints += WIN
            } else if (
                (opponent == "A" && player == "X") ||
                (opponent == "B" && player == "Y") ||
                (opponent == "C" && player == "Z")
            ) {
                roundPoints += DRAW
            }
            if (player == "X") {
                roundPoints += ROCK
            } else if (player == "Y") {
                roundPoints += PAPER
            } else if (player == "Z") {
                roundPoints += SCISSORS
            }
            totalPoints+=roundPoints
        }
        return totalPoints
    }

    fun part2(input: List<String>): Int {
        val DRAW = 3
        val WIN = 6
        val LOSS = 0

        val ROCK = 1
        val PAPER = 2
        val SCISSORS = 3

        var totalPoints = 0

        for (line in input) {
            var roundPoints = 0
            val split = line.split(" ");
            val opponent = split[0]
            val player = split[1]

            if (player == "X") {
                roundPoints += LOSS
                if (opponent=="A"){
                    roundPoints+=SCISSORS
                } else if (opponent =="B"){
                    roundPoints+=ROCK
                }else if (opponent =="C"){
                    roundPoints+=PAPER
                }
            } else if (player == "Y") {
                roundPoints += DRAW
                if (opponent=="A"){
                    roundPoints+=ROCK
                } else if (opponent =="B"){
                    roundPoints+=PAPER
                }else if (opponent =="C"){
                    roundPoints+=SCISSORS
                }
            } else if (player == "Z") {
                roundPoints += WIN
                if (opponent=="A"){
                    roundPoints+=PAPER
                } else if (opponent =="B"){
                    roundPoints+=SCISSORS
                }else if (opponent =="C"){
                    roundPoints+=ROCK
                }
            }
            totalPoints+=roundPoints
        }
        return totalPoints
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 15)
    check(part2(testInput) == 12)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
