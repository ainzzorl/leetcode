package solutions

// https://leetcode.com/problems/super-washing-machines/description/
class p517 {
    var machines: IntArray = IntArray(0)
    var target = 0

    fun findMinMoves(machines: IntArray): Int {
        this.machines = machines
        val sum = machines.sum()
        if (sum % machines.size != 0) {
            System.out.println(sum)
            System.out.println(machines.size)
            System.out.println(sum % machines.size)
            return -1
        }
        this.target = sum / machines.size
        return find(machines.size - 1, 0, -1)
    }

    private fun find(start: Int, end: Int, direction: Int): Int {
        var s = start
        var e = end

        if (Math.abs(s - e) < 1) {
            return 0
        }
        var result = 0
        while (s >= 0 && s < machines.size && machines[s] >= target) {
            val delta = machines[s] - target
            if (delta > 0 && s + direction >= 0 && s + direction < machines.size) {
                machines[s] -= delta
                machines[s + direction] += delta
            }
            result = Math.max(result, delta)
            s += direction
        }
        if (s < 0 || s >= machines.size) {
            return result
        }
        var i = 1
        var sum = machines[s]
        while (sum < i * target) {
            sum += machines[s + i * direction]
            i += 1
        }
        val pivot = s + (i - 1) * direction
        val delta = (i - 1) * target - (sum - machines[pivot])
        result = Math.max(result, machines[pivot] - target)
        machines[pivot - direction] += delta
        machines[pivot] -= delta
        result = Math.max(result, find(pivot - direction, s, -direction))
        result = Math.max(result, find(pivot, e, direction))
        return result
    }
}
