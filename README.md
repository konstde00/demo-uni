# demo-uni

A Spring Boot service that models a university as a set of Maven modules, one per faculty,
each owning its own domain rather than dividing the system into controller, service and
repository layers.

## What it does

The medicine faculty maintains a register of residents. An `Ordinator` record comprises a
name, surname, speciality and contact address, across six specialities from anesthesiology to
surgery. The module owns the complete vertical: controller, entity, DTO, mapper, repository
and service, together with its own Liquibase changelog and the seed data applied at startup.

The business faculty recruits from that register. A single endpoint,

```
POST /api/business-faculty/v1/send-hire-emails?speciality=SURGERY
```

selects every resident holding the requested speciality and prepares recruitment
correspondence for them.

## How it is organized

| Module | Responsibility |
|---|---|
| `application-module` | Spring Boot entry point and the composition of the remaining modules |
| `medicine-faculty-module` | the resident domain, its migrations and its seed data |
| `business-faculty-module` | the recruitment endpoint and the correspondence path |
| `authentication-module` | reserved for account handling |
| `design-faculty-module` | reserved for a third faculty |

Java 17, Spring Boot, PostgreSQL, Liquibase, Maven. The API carries OpenAPI annotations.

## Running

Requires a JDK (17 or later), Maven and Docker.

```bash
docker compose up -d                              # PostgreSQL on localhost:5432
mvn -q -DskipTests install                        # builds and installs all five modules
mvn spring-boot:run -pl application-module        # starts the service on port 8080
```

Liquibase creates the `ordinators` table and loads the seed data on the first start.

## Where it led

The principle this repository was built to examine, that each part of a system should own its
data, its schema and its migrations, was carried forward directly:

- [multitenancy_overview](https://github.com/konstde00/multitenancy_overview) generalised the
  per-faculty modules into a single tenant-management module and gave every tenant a database
  of its own, provisioned while the system was running.
- [runtime-tenant-onboarding](https://github.com/konstde00/runtime-tenant-onboarding) is the
  current implementation, adding replica reconciliation, a benchmark harness, Kubernetes
  deployment and the measurements.
- [ty_yak_be](https://github.com/konstde00/ty_yak_be) and
  [ty_yak_fe](https://github.com/konstde00/ty_yak_fe) apply the same modular decomposition to
  a deployed service.

## License

Apache-2.0. See [LICENSE](LICENSE).
