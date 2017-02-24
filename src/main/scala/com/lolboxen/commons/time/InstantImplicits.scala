package com.lolboxen.commons.time

import java.time.{Duration, Instant}

/**
  * Created by trent ahrens on 2/23/17.
  */
trait InstantImplicits {
  implicit final class InstantExt(lhs: Instant) {
    def - (rhs: Instant): Duration = Duration.between(rhs, lhs)

    def - (rhs: Duration): Instant = lhs.minus(rhs)

    def + (rhs: Duration): Instant = lhs.plus(rhs)

    def > (rhs: Instant): Boolean = lhs.isAfter(rhs)

    def < (rhs: Instant): Boolean = lhs.isBefore(rhs)

    def >= (rhs: Instant): Boolean = lhs.compareTo(rhs) >= 0

    def <= (rhs: Instant): Boolean = lhs.compareTo(rhs) <= 0

    def min (rhs: Instant): Instant = if (rhs < lhs) rhs else lhs

    def max (rhs: Instant): Instant = if (rhs > lhs) rhs else lhs
  }
}
