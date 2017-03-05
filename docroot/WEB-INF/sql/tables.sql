create table TEST_TestEntity (
	itemId LONG not null primary key,
	itemKey VARCHAR(75) null,
	itemCompanyId LONG,
	itemGroupId LONG,
	itemCreatorUserId LONG,
	itemCreateDate DATE null,
	itemLastModifiedDate DATE null,
	itemStatus VARCHAR(75) null,
	TestStringField VARCHAR(75) null
);