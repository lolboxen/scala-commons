package com.lolboxen.commons.time

import java.time.Duration

/**
  * Created by trent ahrens on 2/23/17.
  */
trait DurationImplicits extends DurationNumberImplicits with DurationOrderingImplicits {
  implicit final class DurationExt(lhs: Duration) {
    def * (rhs: Long): Duration = lhs.multipliedBy(rhs)
  }
}
