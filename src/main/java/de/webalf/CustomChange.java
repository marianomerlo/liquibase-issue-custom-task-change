package de.webalf;

import liquibase.change.custom.CustomTaskChange;
import liquibase.database.Database;
import liquibase.exception.ValidationErrors;
import liquibase.resource.ResourceAccessor;

public class CustomChange implements CustomTaskChange {
	private static boolean executed = false;

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
}
