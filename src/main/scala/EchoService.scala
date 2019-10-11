package com.molo.app

import cats.implicits._
import cats.effect.Sync
import doobie.util.transactor.Transactor
import org.http4s.HttpRoutes
import doobie.implicits._
import org.http4s.dsl.Http4sDsl

class EchoService[F[_]: Sync](dao: EchoDao[F]) extends Http4sDsl[F] {

  val routes: HttpRoutes[F] = HttpRoutes.of[F] {
    case GET -> Root / "echo-int" / IntVar(n) =>
      dao.getInt(n).flatMap(result => Ok(s"Selected: $result"))
  }

}

class EchoDao[F[_]: Sync](xa: Transactor[F]) {

  def getInt(n: Int): F[Int] =
    EchoQueries.select(n)
      .unique
      .transact(xa)

}

object EchoQueries {
  import doobie.util.query.Query0

  def select(n: Int): Query0[Int] =
    sql"SELECT $n".query[Int]
}