package com.molo.app

import cats.data.Kleisli
import cats.effect.Sync
import cats.implicits._
import org.http4s.dsl.Http4sDsl
import org.http4s.{HttpApp, Response}

sealed trait AppError extends Exception with Product with Serializable
object AppError {
  case object InvalidBody extends AppError
}

class ErrorHandler[F[_]: Sync](service: HttpApp[F]) extends Http4sDsl[F] {

  private type Handler[E <: Exception with Product with Serializable] = E => F[Response[F]]

  private val appErrorHandler: Handler[AppError] = {
    case AppError.InvalidBody => BadRequest("No good")
  }

  def wrapped: HttpApp[F] = Kleisli { request =>
    service(request).recoverWith {
      case e: AppError => appErrorHandler(e)
    }
  }
}
