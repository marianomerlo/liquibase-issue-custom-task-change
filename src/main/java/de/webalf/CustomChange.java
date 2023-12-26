package de.webalf;

import liquibase.change.custom.CustomTaskChange;
import liquibase.change.custom.CustomTaskRollback;
import liquibase.database.Database;
import liquibase.exception.ValidationErrors;
import liquibase.resource.ResourceAccessor;

public class CustomChange implements CustomTaskChange, CustomTaskRollback {
	private static boolean executed = false;
	private static boolean rollbacked = false;

	@Override
	public void execute(Database database) {
		if (executed) {
			throw new RuntimeException("Already executed");
		}
		executed = true;
		System.out.println("!!! EXECUTE");
	}

	@Override
	public String getConfirmationMessage() {
		return "confirmation message";
	}

	@Override
	public void setUp() {
		//noop
	}

	@Override
	public void setFileOpener(ResourceAccessor resourceAccessor) {
		//noop
	}

	@Override
	public ValidationErrors validate(Database database) {
		return null;
	}

	@Override
    public void rollback(Database database) {
		if (rollbacked) {
			throw new RuntimeException("Already rollbacked");
		}
		rollbacked = true;
		System.out.println("!!! ROLLBACKED");
	}
}
