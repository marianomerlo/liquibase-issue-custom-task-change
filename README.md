# liquibase-issue-custom-task-change
Minimally reproducible example of a custom task change getting executed twice.

## Steps
1. Execute `mvn liquibase:update`
2. Execute `mvn liquibase:rollback -Dliquibase.rollbackCount=1`
2. Error: rollback method is called twice

To compare with an old version, empty the database and set liquibase.version in `pom.xml` to the last working version 4.19.0.
