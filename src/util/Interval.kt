package util

class Interval(var start: Int = 0, var end: Int = 0) {
    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Interval)
            return false
        return start == other.start && end == other.end
    }

    override fun hashCode(): Int = start.hashCode() * 31 + end

    override fun toString(): String {
        return "[$start, $end]"
    }
}