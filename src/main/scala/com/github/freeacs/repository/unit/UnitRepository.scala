package com.github.freeacs.repository.unit

import com.github.freeacs.repository.Db
import slick.basic.DatabaseConfig
import slick.jdbc.JdbcProfile

import scala.concurrent.{ExecutionContext, Future}

class UnitRepository(val config: DatabaseConfig[JdbcProfile])(implicit ec: ExecutionContext)
  extends Db with UnitTable {

  import config.profile.api._

  def list(): Future[Seq[Unit]] =
    db.run(units.result)

}