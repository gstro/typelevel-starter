name := "typelevel-starter"

version := "0.1"

scalaVersion := "2.13.3"

lazy val CatsEffectVersion = "2.2.0"
lazy val Fs2Version        = "2.4.4"
lazy val Http4sVersion     = "0.21.7"
lazy val CirceVersion      = "0.13.0"
lazy val DoobieVersion     = "0.9.2"
lazy val FlywayVersion     = "7.0.0"
lazy val RefinedVersion    = "0.9.17"
lazy val PureConfigVersion = "0.14.0"
lazy val LogbackVersion    = "1.2.3"
lazy val ScalaTestVersion  = "3.2.2"
lazy val ScalaCheckVersion = "1.14.3"

libraryDependencies ++= Seq(
  // http
  "org.http4s"            %% "http4s-blaze-server"    % Http4sVersion,
  "org.http4s"            %% "http4s-circe"           % Http4sVersion,
  "org.http4s"            %% "http4s-dsl"             % Http4sVersion,

  // effects and streaming
  "org.typelevel"         %% "cats-effect"            % CatsEffectVersion,
  "co.fs2"                %% "fs2-core"               % Fs2Version,

  // json
  "org.http4s"            %% "http4s-circe"           % Http4sVersion,
  "io.circe"              %% "circe-core"             % CirceVersion,
  "io.circe"              %% "circe-generic"          % CirceVersion,
  "io.circe"              %% "circe-refined"          % CirceVersion,

  // database
  "org.flywaydb"          %  "flyway-core"            % FlywayVersion,
  "org.tpolecat"          %% "doobie-core"            % DoobieVersion,
  "org.tpolecat"          %% "doobie-postgres"        % DoobieVersion,
  "org.tpolecat"          %% "doobie-hikari"          % DoobieVersion,

  // config
  "com.github.pureconfig" %% "pureconfig"             % PureConfigVersion,
  "com.github.pureconfig" %% "pureconfig-cats-effect" % PureConfigVersion,
  "com.github.pureconfig" %% "pureconfig-http4s"      % PureConfigVersion,
  "eu.timepit"            %% "refined-pureconfig"     % RefinedVersion,

  // logging
  "ch.qos.logback"        %  "logback-classic"        % LogbackVersion,

  // tests
  "org.scalatest"         %% "scalatest"              % ScalaTestVersion  % Test,
  "org.scalacheck"        %% "scalacheck"             % ScalaCheckVersion % Test,
  "org.tpolecat"          %% "doobie-scalatest"       % DoobieVersion     % Test
)

// these don't seem to play well with tagless-final style
wartremoverErrors ++= Warts.allBut(
  Wart.Any,
  Wart.Nothing
)

resolvers += Resolver.sonatypeRepo("releases")
addCompilerPlugin("org.typelevel" %% "kind-projector"     % "0.11.0" cross CrossVersion.full)
addCompilerPlugin("com.olegpy"    %% "better-monadic-for" % "0.3.1")
addCompilerPlugin(scalafixSemanticdb)
scalacOptions += "-Yrangepos"
scalacOptions += "-Ywarn-unused"

Compile / run / fork := true

// Use development.conf only for local dev,
// application.conf will be packaged for deployment
Test / run / javaOptions += "-Dconfig.file=development.conf"

enablePlugins(DockerPlugin)