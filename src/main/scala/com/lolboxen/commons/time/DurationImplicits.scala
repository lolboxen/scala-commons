package com.lolboxen.commons.time

import java.time.Duration

/**
  * Created by trent ahrens on 2/23/17.
  */
trait DurationImplicits extends DurationNumberImplicits {
  implicit final class DurationExt(lhs: Duration) {
    def - (rhs: Duration): Duration = NumericDuration.minus(lhs, rhs)

    def + (rhs: Duration): Duration = NumericDuration.plus(lhs, rhs)

    def * (rhs: Long): Duration = lhs.multipliedBy(rhs)

    def > (rhs: Duration): Boolean = NumericDuration.gt(lhs, rhs)

    def < (rhs: Duration): Boolean = NumericDuration.lt(lhs, rhs)

    def >= (rhs: Duration): Boolean = NumericDuration.gteq(lhs, rhs)

    def <= (rhs: Duration): Boolean = NumericDuration.lteq(lhs, rhs)
  }
}
