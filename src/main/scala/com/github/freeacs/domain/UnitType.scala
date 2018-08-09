package com.github.freeacs.domain

final case class UnitType(
    unitTypeName: String,
    protocol: String,
    unitTypeId: Option[Long] = None,
    matcherId: Option[String] = None,
    vendorName: Option[String] = None,
    description: Option[String] = None,
    params: Seq[UnitTypeParameter] = Seq.empty
)
