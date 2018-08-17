// Copyright (C) 2014-2017 Anduin Transactions Inc.
// Heavily modified for FreeACS

package com.github.freeacs.state

import akka.cluster.ddata.ReplicatedData
import com.github.freeacs.xml.{SOAPRequest, SOAPResponse}

import scala.concurrent.{ExecutionContext, Future}

final case class FSM(currentState: FSMState) extends ReplicatedData {
  def transition(
      request: SOAPRequest,
      transform: Transformation
  )(implicit ec: ExecutionContext): Future[(SOAPResponse, FSM)] =
    transform(currentState, request).map(t => (t._1, FSM(t._2)))

  override type T = FSM
  override def merge(that: FSM): FSM =
    FSM(that.currentState)
}
