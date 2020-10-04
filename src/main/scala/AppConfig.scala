package com.molo.app

import cats.effect.{Blocker, ContextShift, Sync}
import pureconfig._
import pureconfig.generic.auto._
import pureconfig.module.catseffect.syntax._

final case class DbConfig(
    connectionThreads: Int,
    driver: String,
    url: String,
    user: String,
    pass: String
)

final case class HttpConfig(
    port: Int,
    host: String
)

final case class AppConfig(
    http: HttpConfig,
    db: DbConfig
)

object AppConfig {

  private val namespace = "app"

  def withConfig[F[_]: ContextShift, A](blocker: Blocker)(f: AppConfig => F[A])(implicit F: Sync[F]): F[A] =
    F.flatMap(ConfigSource.default.at(namespace).loadF[F, AppConfig](blocker))(f)

}
