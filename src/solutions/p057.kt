package solutions

import util.Interval
import java.util.*
import kotlin.collections.ArrayList

// https://leetcode.com/problems/insert-interval/description/
class p057 {
    fun insert(intervals: List<Interval>, newInterval: Interval): List<Interval> {
        val preMerged = ArrayList<Interval>()
        if (intervals.isEmpty()) {
            return Collections.singletonList(newInterval)
        }
        if (newInterval.start < intervals.first().start) {
            if (newInterval.end < intervals.first().start) {
                preMerged.add(newInterval);
            } else {
                preMerged.add(Interval(newInterval.start, intervals.first().start))
            }
        }
        for (i in 0 until intervals.size) {
            preMerged.add(intervals[i])
            if (i == intervals.size - 1) {
                // Last interval
                if (newInterval.end > intervals[i].end) {
                    if (newInterval.start > intervals[i].end) {
                        preMerged.add(newInterval)
                    } else {
                        preMerged.add(Interval(intervals[i].end, newInterval.end))
                    }
                }
                break
            }
            val gap = Interval(intervals[i].end, intervals[i + 1].start)
            if (inside(newInterval, gap)) {
                preMerged.add(newInterval)
                continue
            }
            if (gap.start < newInterval.end && gap.start >= newInterval.start ) {
                preMerged.add(Interval(gap.start, Math.min(gap.end, newInterval.end)))
                continue
            }
            if (gap.end > newInterval.start && gap.end <= newInterval.end) {
                preMerged.add(Interval(newInterval.start, Math.min(gap.end, newInterval.end)))
                continue
            }
        }
        val merged = ArrayList<Interval>()
        for (interval in preMerged) {
            if (merged.isEmpty()) {
                merged.add(interval)
            } else {
                if (merged.last().end == interval.start) {
                    merged.last().end = interval.end
                } else {
                    merged.add(interval)
                }
            }
        }
        return merged
    }

    private fun inside(source: Interval, dest: Interval): Boolean {
        return (source.start >= dest.start && source.end <= dest.end)
    }
}
