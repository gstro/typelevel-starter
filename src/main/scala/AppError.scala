package com.molo.app

import cats.data.Kleisli
import cats.effect.Sync
import cats.implicits._
import org.http4s.dsl.Http4sDsl
import org.http4s.HttpApp

sealed trait AppError extends Exception with Product with Serializable
object AppError {
  case object InvalidBody extends AppError
}

class ErrorHandler[F[_]: Sync](service: HttpApp[F]) extends Http4sDsl[F] {

  def wrapped: HttpApp[F] = Kleisli { request =>
    service(request).recoverWith {
      case AppError.InvalidBody => BadRequest("No good")
    }
  }
}
