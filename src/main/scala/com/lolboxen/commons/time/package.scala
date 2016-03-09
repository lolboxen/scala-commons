package com.lolboxen.commons

import java.time.{Instant, Duration}

/**
  * Created by trent ahrens on 1/29/16.
  */
package object time {

  implicit final class InstantExt(left: Instant) {
    def - (right: Instant): Duration = Duration.between(right, left)

    def - (right: Duration): Instant = left.minus(right)

    def + (right: Duration): Instant = left.plus(right)

    def > (right: Instant): Boolean = left.isAfter(right)

    def < (right: Instant): Boolean = left.isBefore(right)

    def >= (right: Instant): Boolean = left.compareTo(right) >= 0

    def <= (right: Instant): Boolean = left.compareTo(right) <= 0
  }

  implicit final class DurationExt(private val left: Duration) extends AnyVal {
    def - (right: Duration): Duration = left.minus(right)

    def + (right: Duration): Duration = left.plus(right)

    def * (right: Long): Duration = left.multipliedBy(right)

    def > (right: Duration): Boolean = left.compareTo(right) > 0

    def < (right: Duration): Boolean = left.compareTo(right) < 0

    def >= (right: Duration): Boolean = left.compareTo(right) >= 0

    def <= (right: Duration): Boolean = left.compareTo(right) <= 0
  }

  implicit object NumericDuration extends Numeric[Duration] {
    override def plus(x: Duration, y: Duration): Duration = x.plus(y)

    override def toDouble(x: Duration): Double = x.toNanos.toDouble

    override def toFloat(x: Duration): Float = x.toNanos.toFloat

    override def toInt(x: Duration): Int = x.toNanos.toInt

    override def negate(x: Duration): Duration = x.negated()

    override def fromInt(x: Int): Duration = Duration.ofNanos(x)

    override def toLong(x: Duration): Long = x.toNanos

    override def times(x: Duration, y: Duration): Duration = x.multipliedBy(y.getNano)

    override def minus(x: Duration, y: Duration): Duration = x.minus(y)

    override def compare(x: Duration, y: Duration): Int = x.compareTo(y)
  }
}
