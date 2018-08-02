package com.github.freeacs.xml

sealed trait SOAPRequest

final case class InformRequest(
  deviceId: DeviceIdStruct,
  eventList: Seq[EventStruct],
  params: Seq[ParameterValueStruct]
) extends SOAPRequest

object EmptyRequest extends SOAPRequest