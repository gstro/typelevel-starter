package com.molo.app

import cats.effect._
import doobie.util.transactor.Transactor
import org.http4s._
import org.http4s.implicits._
import org.http4s.server.blaze.BlazeServerBuilder
import scala.concurrent.ExecutionContext.global

object Server extends IOApp {

  private def buildServices(xa: Transactor[IO]): IO[HttpApp[IO]] =
    IO {
      val dao = new EchoDao[IO](xa)
      val app = new EchoService[IO](dao).routes.orNotFound
      new ErrorHandler(app).wrapped
    }

  private def startServer(config: HttpConfig, app: HttpApp[IO]): IO[Unit] =
    BlazeServerBuilder[IO](global)
      .bindHttp(config.port, config.host)
      .withHttpApp(app)
      .serve
      .compile
      .drain

  override def run(args: List[String]): IO[ExitCode] = {
    Blocker[IO].use { blocker =>
      AppConfig.withConfig(blocker) { cfg =>
        Database.transactor[IO](cfg.db).use { xa =>
          for {
            app <- buildServices(xa)
            _   <- startServer(cfg.http, app)
          } yield ExitCode.Success
        }
      }
    }
  }

}
