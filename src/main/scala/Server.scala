package com.molo.app

import cats.effect._
import doobie.util.transactor.Transactor
import org.http4s._
import org.http4s.implicits._
import org.http4s.server.blaze.BlazeServerBuilder

object Server extends IOApp {

  private def services(xa: Transactor[IO]): IO[HttpApp[IO]] =
    IO {
      val dao = new EchoDao[IO](xa)
      new EchoService[IO](dao)
        .routes
        .orNotFound
    }

  private def server(config: HttpConfig, app: HttpApp[IO]): IO[Unit] =
    BlazeServerBuilder[IO]
      .bindHttp(config.port, config.host)
      .withHttpApp(app)
      .serve
      .compile
      .drain

  override def run(args: List[String]): IO[ExitCode] =
    AppConfig.withConfig { cfg =>
      Database.transactor[IO](cfg.db).use { xa =>
        for {
          app <- services(xa)
          _   <- server(cfg.http, app)
        } yield ExitCode.Success
      }
    }
}