# typelevel-starter

Starter Scala web-service template using the [Typelevel](https://typelevel.org/)
ecosystem. This starter project is built on the these core Typelevel libraries:
- [Cats Effect](https://typelevel.org/cats-effect/)
- [FS2](https://fs2.io/)
- [Http4s](https://http4s.org/)
- [Doobie](https://tpolecat.github.io/doobie/)
- [Circe](https://circe.github.io/circe/)

This project also includes a simple `docker-compose` file to provide a Postgres
database instance container for the service.

### Running the Service

Start the docker container for the Postgres instance
```
docker-compose up &
```

Start SBT
```
sbt
```

Start the app with reloading capabilities
```
sbt:typelevel-starter> reStart
```

(Can also use `run` to run the app normally)

### Stopping the Service

Stop the app
```
sbt:typelevel-starter> reStop
```

If you want to stop the Postgres container
```
docker-compose down
```

### Other SBT Commands Available

- `dependencyUpdates`
- `dependencyCheck`
- `dumpLicenseReport`

### Dependencies and Plugins

Other libraries and plugins used by this project
- [Flyway](https://flywaydb.org/)
- [refined](https://github.com/fthomas/refined)
- [pureconfig](https://github.com/pureconfig/pureconfig)
- [ScalaTest](https://www.scalatest.org/)
- [ScalaCheck](https://www.scalacheck.org/)
- [kind-projector](https://github.com/typelevel/kind-projector)
- [better-monadic-for](https://github.com/oleg-py/better-monadic-for)
- [sbt-tpolecat](https://github.com/DavidGregory084/sbt-tpolecat)
- [sbt-native-packager](https://github.com/sbt/sbt-native-packager)
- [sbt-license-report](https://github.com/sbt/sbt-license-report)
- [sbt-updates](https://github.com/rtimush/sbt-updates)
- [sbt-dependency-check](https://github.com/albuch/sbt-dependency-check)
- [sbt-revolver](https://github.com/spray/sbt-revolver)
- [sbt-wartremover](https://github.com/wartremover/wartremover)
- [sbt-scalafix](https://github.com/scalacenter/sbt-scalafix)
- [sbt-scalafmt](https://github.com/scalameta/sbt-scalafmt)
- [sbt-errors-summary](https://github.com/Duhemm/sbt-errors-summary)
- [splain](https://github.com/tek/splain)
