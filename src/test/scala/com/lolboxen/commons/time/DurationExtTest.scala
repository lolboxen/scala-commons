package com.lolboxen.commons.time

import java.time.Duration.{ZERO, ofSeconds}

import test.Spec

/**
  * Created by trent ahrens on 3/9/16.
  */
class DurationExtTest extends Spec {

  val twoSeconds = ofSeconds(2)

  "subtracting two duration" must "yield the difference as a duration" in {
    twoSeconds - twoSeconds shouldBe ZERO
  }

  "adding two durations" must "yield the sum as a duration" in {
    twoSeconds + twoSeconds shouldBe ofSeconds(4)
  }

  "multiplying a duration with a number" must "yield the product as a duration" in {
    twoSeconds * 3 shouldBe ofSeconds(6)
  }

  "a greater duration" must "be greater than a lesser duration" in {
    twoSeconds > ZERO shouldBe true
  }

  "a lesser duration" must "not be greater than a greater duration" in {
    ZERO > twoSeconds shouldBe false
  }

  "a lesser duration" must "be less than a greater duration" in {
    ZERO < twoSeconds shouldBe true
  }

  "a greater duration" must "not be less than a lesser duration" in {
    twoSeconds < ZERO shouldBe false
  }

  "a greater duration" must "be greater than or equal to a lesser duration" in {
    twoSeconds >= ZERO shouldBe true
  }

  "the same duration" must "be greater than or equal to itself" in {
    twoSeconds >= twoSeconds shouldBe true
  }

  "a lesser duration" must "not be greater than or equal to a greater duration" in {
    ZERO >= twoSeconds shouldBe false
  }

  "a lesser duration" must "be less than or equal to a greater duration" in {
    ZERO <= twoSeconds shouldBe true
  }

  "the same duration" must "be less than or equal to itself" in {
    twoSeconds <= twoSeconds shouldBe true
  }

   "a greater duration" must "not be less than or equal a lesser duration" in {
     twoSeconds <= ZERO shouldBe false
   }
}
