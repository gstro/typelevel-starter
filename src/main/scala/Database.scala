package com.molo.app

import cats.effect.{Async, Blocker, ContextShift, Resource}
import doobie._
import doobie.hikari._

object Database {

  def transactor[F[_]: Async: ContextShift](config: DbConfig): Resource[F, HikariTransactor[F]] =
    for {
      ce <- ExecutionContexts.fixedThreadPool(config.connectionThreads)
      te <- Blocker[F]
      xa <- HikariTransactor.newHikariTransactor(
        config.driver,
        config.url,
        config.user,
        config.pass,
        ce,
        te
      )
    } yield xa
}
