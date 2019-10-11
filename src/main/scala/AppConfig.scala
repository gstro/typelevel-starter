package com.molo.app

import cats.effect.Sync

import pureconfig._
import pureconfig.generic.auto._
import pureconfig.module.catseffect._

case class DbConfig(
  connectionThreads: Int,
  driver: String,
  url: String,
  user: String,
  pass: String
)

case class HttpConfig(
  port: Int,
  host: String
)

case class AppConfig(
  http: HttpConfig,
  db: DbConfig
)

object AppConfig {

  private val namespace = "app"

  def withConfig[F[_], A](f: AppConfig => F[A])(implicit F: Sync[F]): F[A] =
    F.flatMap(ConfigSource.default.at(namespace).loadF[F, AppConfig])(f)

}