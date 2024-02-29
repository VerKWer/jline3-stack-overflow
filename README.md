# JLine3 StackOverflowException Example
In the current version 3.25.1 of JLine, the `LineReaderImpl.redisplay` method can get itself into an infinite recursion
and throw a `StackOverflowException` when run in a Docker container brought up via `compose`. This is a minimal example
to reproduce the issue.

**Note:** This does not seem to affect starting the container directly via `docker run` (even if detached).

## How To Run
```bash
$ git clone https://github.com/VerKWer/jline3-stack-overflow && cd "$(basename "$_")"
$ ./gradlew fatJar
$ docker compose build
$ docker compose up
```
