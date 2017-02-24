package com.lolboxen.commons.time

import java.time.Duration.{ZERO, ofSeconds}

import test.Spec

/**
  * Created by trent ahrens on 3/9/16.
  */
class DurationExtTest extends Spec with DurationImplicits {
  import NumericDuration._

  val longer = ofSeconds(2)
  val shorter = ofSeconds(1)

  behavior of "subtraction"

  it should "yield the difference as a duration" in {
    longer - longer shouldBe ZERO
  }

  behavior of "addition"

  it should "yield the sum as a duration" in {
    longer + longer shouldBe ofSeconds(4)
  }

  behavior of "multiplication"

  it should "yield the product as a duration" in {
    longer * 3 shouldBe ofSeconds(6)
  }

  behavior of "greater than"

  it should "longer > shorter" in {
    longer > shorter shouldBe true
  }

  it should "not longer > shorter" in {
    shorter > longer shouldBe false
  }

  behavior of "less than"

  it should "shorter < longer" in {
    shorter < longer shouldBe true
  }

  it should "not shorter < longer" in {
    longer < shorter shouldBe false
  }

  behavior of "greater than equal to"

  it should "longer >= shorter" in {
    longer >= shorter shouldBe true
  }

  it should "same >= same" in {
    shorter >= shorter shouldBe true
  }

  it should "not shorter >= longer" in {
    shorter >= longer shouldBe false
  }

  behavior of "less than equal to"

  it should "shorter <= longer" in {
    shorter <= longer shouldBe true
  }

  it should "same <= same" in {
    shorter <= shorter shouldBe true
  }

  it should "not longer <= shorter" in {
    longer <= shorter shouldBe false
  }
}
