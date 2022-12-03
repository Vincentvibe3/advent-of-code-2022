fun main() {
    fun part1(input: List<String>): Int {
        var total = 0
        val mapping = HashMap<Char, Int>()
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray().forEachIndexed{ i: Int, c: Char ->
            mapping[c] = i+1
        }
        for (line in input){
            var common = arrayListOf<Char>()
            val midPoint = line.length/2-1
            val compartment1 = line.substring(0..midPoint)
            val compartment2 = line.substring(midPoint+1 until line.length)
            for (char in compartment1){
                if (common.contains(char)){
                    continue
                }
                if (compartment2.contains(char)){
                    common.add(char)
                    val priority = mapping[char]
                    priority?.let { total+=it }
                }
            }
        }
        return total
    }

    fun part2(input: List<String>): Int {
        var total = 0
        val mapping = HashMap<Char, Int>()
        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray().forEachIndexed{ i: Int, c: Char ->
            mapping[c] = i+1
        }
        val currentGroupSacks = arrayListOf<String>()
        val common = arrayListOf<Char>()
        for (index in input.indices){
            val line = input[index]
            if (currentGroupSacks.size==2){
                val groupCommon = arrayListOf<Char>()
                for (char in line){
                    var charOk = true
                    for (sack in currentGroupSacks) {
                        if (!sack.contains(char)){
                            charOk = false
                            break
                        }
                    }
                    if (charOk&&!groupCommon.contains(char)){
                        groupCommon.add(char)
                    }
                }
                groupCommon.forEach {
                    common.add(it)
                }
                currentGroupSacks.clear()
            } else {
                currentGroupSacks.add(line)
            }
        }
        common.forEach {
            val priority = mapping[it]
            priority?.let { value -> total+=value }
        }
        return total
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 157)
    check(part2(testInput) == 70)

    val input = readInput("Day03")
    println(part1(input))
    println(part2(input))
}
