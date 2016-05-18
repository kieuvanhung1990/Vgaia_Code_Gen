<script runat="template">
private Regex cleanRegEx = new Regex(@"\s+|_|-|\.", RegexOptions.Compiled);
private Regex cleanID = new Regex(@"(_ID|_id|_Id|\.ID|\.id|\.Id|ID|Id)", RegexOptions.Compiled);

public string CleanName(string name)
{
	return cleanRegEx.Replace(name, "");
}

public string CamelCase(string name)
{
	string output = CleanName(name);
	return char.ToLower(output[0]) + output.Substring(1);
}

public string PascalCase(string name)
{
	string output = CleanName(name);
	return char.ToUpper(output[0]) + output.Substring(1);
}

public string MakePlural(string name)
{
	Regex plural1 = new Regex("(?<keep>[^aeiou])y$");
	Regex plural2 = new Regex("(?<keep>[aeiou]y)$");
	Regex plural3 = new Regex("(?<keep>[sxzh])$");
	Regex plural4 = new Regex("(?<keep>[^sxzhy])$");

	if(plural1.IsMatch(name))
		return plural1.Replace(name, "${keep}ies");
	else if(plural2.IsMatch(name))
		return plural2.Replace(name, "${keep}s");
	else if(plural3.IsMatch(name))
		return plural3.Replace(name, "${keep}es");
	else if(plural4.IsMatch(name))
		return plural4.Replace(name, "${keep}s");

	return name;
}

public string MakeSingle(string name)
{
	Regex plural1 = new Regex("(?<keep>[^aeiou])ies$");
	Regex plural2 = new Regex("(?<keep>[aeiou]y)s$");
	Regex plural3 = new Regex("(?<keep>[sxzh])es$");
	Regex plural4 = new Regex("(?<keep>[^sxzhyu])s$");

	if(plural1.IsMatch(name))
		return plural1.Replace(name, "${keep}y");
	else if(plural2.IsMatch(name))
		return plural2.Replace(name, "${keep}");
	else if(plural3.IsMatch(name))
		return plural3.Replace(name, "${keep}");
	else if(plural4.IsMatch(name))
		return plural4.Replace(name, "${keep}");

	return name;
}

public bool IsManyToManyTable(TableSchema table)
{
	if (table.Columns.Count == 2 && table.PrimaryKey != null && table.PrimaryKey.MemberColumns.Count == 2 && table.ForeignKeys.Count == 2)
//	if (table.Columns.Count >= 2 && table.PrimaryKey != null && table.PrimaryKey.MemberColumns.Count == 2 && table.ForeignKeys.Count >= 2)
		return true;
	else
		return false;
}

public bool IsOneToOneTable(TableKeySchema primaryKey)
{
	if (primaryKey.ForeignKeyMemberColumns[0].IsPrimaryKeyMember)
	{
		// Check if the current table is the primary key with one-to-one mappings to several tables.
		// If so, generate polymorphic classes using joined sub-classes & corresponding C# classes.
		int count = 0;
		foreach(TableKeySchema pk in SourceTable.PrimaryKeys)
		{
			// check if other end of the link is the primary key for the table (if count > 1 then it may
			// be a composite primary key and most likely a many-to-many link table which can be ignored)
			if (pk.ForeignKeyMemberColumns[0].IsPrimaryKeyMember && pk.ForeignKeyTable.PrimaryKey.MemberColumns.Count == 1)
				count++;
		}
		if (count > 1)
			return false;

		return true;
	}
	return false;
}

public bool IsSubClassTable(TableKeySchema primaryKey)
{
	if (primaryKey.ForeignKeyMemberColumns[0].IsPrimaryKeyMember)
	{
		// Check if the current table is the primary key with one-to-one mappings to several tables.
		// If so, generate polymorphic classes using joined sub-classes & corresponding C# classes.
		int count = 0;
		foreach(TableKeySchema pk in SourceTable.PrimaryKeys)
		{
			// check if other end of the link is the primary key for the table (if count > 1 then it may
			// be a composite primary key and most likely a many-to-many link table which can be ignored)
			if (pk.ForeignKeyMemberColumns[0].IsPrimaryKeyMember && pk.ForeignKeyTable.PrimaryKey.MemberColumns.Count == 1)
				count++;
		}
		if (count > 1)
			return true;

		return false;
	}
	return false;
}

public bool ColumnIsString(ColumnSchema column)
{
	switch (column.DataType)
	{
		case DbType.String:
		case DbType.AnsiStringFixedLength:
		case DbType.AnsiString: return true;
		default: return false;
	}
}

public bool ColumnIsDecimal(ColumnSchema column)
{
	switch (column.DataType)
	{
		case DbType.Currency:
		case DbType.Decimal:
		case DbType.VarNumeric:
			return true;
		default: return false;
	}
}

public bool ColumnIsDate(ColumnSchema column)
{
 	switch (column.DataType)
	{
		case DbType.Date:
		case DbType.DateTime:
		case DbType.Time:
			return true;
		default: return false;
	}
}

public string CSharpType(ColumnSchema column)
{
	if (column.Name.EndsWith("TypeCode")) return column.Name;

	switch (column.DataType)
	{
		case DbType.AnsiString: return "string";
		case DbType.AnsiStringFixedLength: return "string";
		case DbType.Binary: return "byte[]";
		case DbType.Boolean: return "bool";
		case DbType.Byte: return "byte";
		case DbType.Currency: return "decimal";
		case DbType.Date: return "DateTime";
		case DbType.DateTime: return "DateTime";
		case DbType.Decimal: return "decimal";
		case DbType.Double: return "double";
		case DbType.Guid: return "Guid";
		case DbType.Int16: return "short";
		case DbType.Int32: return "int";
		case DbType.Int64: return "long";
		case DbType.Object: return "object";
		case DbType.SByte: return "sbyte";
		case DbType.Single: return "float";
		case DbType.String: return "string";
		case DbType.StringFixedLength: return "string";
		case DbType.Time: return "TimeSpan";
		case DbType.UInt16: return "ushort";
		case DbType.UInt32: return "uint";
		case DbType.UInt64: return "ulong";
		case DbType.VarNumeric: return "decimal";
		default:
		{
			return "__UNKNOWN__" + column.NativeType;
		}
	}
}

public string GetDbType(ColumnSchema column)
{
	if (column.Name.EndsWith("TypeCode")) return column.Name;

	switch (column.DataType)
	{
		case DbType.AnsiString: return "VarChar";
		case DbType.AnsiStringFixedLength: return "VarChar";
		case DbType.Binary: return "Byte[]";
		case DbType.Boolean: return "Boolean";
		case DbType.Byte: return "TinyInt";
		case DbType.Currency: return "Decimal";
		case DbType.Date: return "DateTime";
		case DbType.DateTime: return "DateTime";
		case DbType.Decimal: return "Decimal";
		case DbType.Double: return "Double";
		case DbType.Guid: return "Guid";
		case DbType.Int16: 
		case DbType.Int32: 
		case DbType.Int64: return "Int";
		case DbType.Object: return "BinaryBlob";
		case DbType.SByte: return "Byte";
		case DbType.Single: return "Single";
		case DbType.String: return "NVarChar";
		case DbType.StringFixedLength: return "NVarChar";
		case DbType.Time: return "DateTime";
		case DbType.UInt16: return "Int16";
		case DbType.UInt32: return "Int32";
		case DbType.UInt64: return "Int64";
		case DbType.VarNumeric: return "Decimal";
		default:
		{
			return "__UNKNOWN__" + column.NativeType;
		}
	}
}

public string GetStringValue(ColumnSchema column, string reader)
{
	if (column.Name.EndsWith("TypeCode")) return column.Name;

	switch (column.DataType)
	{
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
		case DbType.String: 
		case DbType.StringFixedLength:
		if(column.AllowDBNull)
		{
			return string.Format("{0}[\"{1}\"]!=  DBNull.Value? {0}[\"{1}\"].ToString(): string.Empty;", reader, column.Name); 
		}
		else
		{
			return string.Format("{0}[\"{1}\"].ToString();", reader, column.Name); 
		}
		
		case DbType.Binary: return "Byte[]";
		case DbType.Boolean: 
		if(column.AllowDBNull)
		{
			return string.Format("{0}[\"{1}\"]!=  DBNull.Value? Convert.ToBoolean({0}[\"{1}\"]): false;", reader, column.Name); 
		}
		else
		{
			return string.Format("Convert.ToBoolean({0}[\"{1}\"]);", reader, column.Name); 
		}
		
		case DbType.Byte:
		if(column.AllowDBNull)
		{
			return string.Format("{0}[\"{1}\"]!=  DBNull.Value? Convert.ToByte({0}[\"{1}\"]): 0;", reader, column.Name); 
		}
		else
		{
			return string.Format("Convert.ToByte({0}[\"{1}\"]);", reader, column.Name); 
		}
		
		case DbType.Currency:
		case DbType.Decimal:
		case DbType.VarNumeric:
		if(column.AllowDBNull)
		{
			return string.Format("{0}[\"{1}\"]!= DBNull.Value? GolineConvert.ToDecimalEnUS({0}[\"{1}\"]): 0;", reader, column.Name); 
		}
		else
		{
			return string.Format("GolineConvert.ToDecimalEnUS({0}[\"{1}\"]);", reader, column.Name); 
		}
		case DbType.Date: 
		case DbType.DateTime: 
		case DbType.Time: 
		if(column.AllowDBNull)
		{
			return string.Format("{0}[\"{1}\"]!=  DBNull.Value? Convert.ToDateTime({0}[\"{1}\"]): (DateTime?)null;", reader, column.Name); 
		}
		else
		{
			return string.Format("Convert.ToDateTime({0}[\"{1}\"]);", reader, column.Name); 
		}
		
		case DbType.Double:
		if(column.AllowDBNull)
		{
			return string.Format("{0}[\"{1}\"]!= DBNull.Value? Convert.ToDouble({0}[\"{1}\"]): 0;", reader, column.Name); 
		}
		else
		{
			return string.Format("Convert.ToDouble({0}[\"{1}\"]);", reader, column.Name); 
		}
		case DbType.Guid:
		if(column.AllowDBNull)
		{
			return string.Format("{0}[\"{1}\"]!=  DBNull.Value? new Guid({0}[\"{1}\"]): Guid.Empty;", reader, column.Name); 
		}
		else
		{
			return string.Format("new Guid({0}[\"{1}\"]);", reader, column.Name); 
		}
		
		case DbType.Int16: 
		case DbType.UInt16:
		if(column.AllowDBNull)
		{
			return string.Format("{0}[\"{1}\"]!=  DBNull.Value? Convert.ToInt16({0}[\"{1}\"]): 0;", reader, column.Name); 
		}
		else
		{
			return string.Format("Convert.ToInt16({0}[\"{1}\"]);", reader, column.Name); 
		}
		case DbType.Int32: 
		case DbType.UInt32:
		if(column.AllowDBNull)
		{
			return string.Format("{0}[\"{1}\"]!=  DBNull.Value? Convert.ToInt32({0}[\"{1}\"]): 0;", reader, column.Name); 
		}
		else
		{
			return string.Format("Convert.ToInt32({0}[\"{1}\"]);", reader, column.Name); 
		}
		case DbType.Int64:
		case DbType.UInt64: 
		if(column.AllowDBNull)
		{
			return string.Format("{0}[\"{1}\"]!=  DBNull.Value? Convert.ToInt64({0}[\"{1}\"]): 0;", reader, column.Name); 
		}
		else
		{
			return string.Format("Convert.ToInt64({0}[\"{1}\"]);", reader, column.Name); 
		}
		case DbType.Object: return "BinaryBlob";
		case DbType.SByte: return "Byte";
		case DbType.Single: return "Single";
		
		
		
		default:
		{
			return "__UNKNOWN__" + column.NativeType;
		}
	}
}

public string NHibernateType(ColumnSchema column)
{
	if (column.Name.EndsWith("TypeCode")) return column.Name;

	switch (column.DataType)
	{
		case DbType.AnsiString: return "String";
		case DbType.AnsiStringFixedLength: return "String";
		case DbType.Binary: return "Byte[]";
		case DbType.Boolean: return "Boolean";
		case DbType.Byte: return "Byte";
		case DbType.Currency: return "Decimal";
		case DbType.Date: return "DateTime";
		case DbType.DateTime: return "DateTime";
		case DbType.Decimal: return "Decimal";
		case DbType.Double: return "Double";
		case DbType.Guid: return "Guid";
		case DbType.Int16: return "Int16";
		case DbType.Int32: return "Int32";
		case DbType.Int64: return "Int64";
		case DbType.Object: return "BinaryBlob";
		case DbType.SByte: return "Byte";
		case DbType.Single: return "Single";
		case DbType.String: return "String";
		case DbType.StringFixedLength: return "String";
		case DbType.Time: return "DateTime";
		case DbType.UInt16: return "Int16";
		case DbType.UInt32: return "Int32";
		case DbType.UInt64: return "Int64";
		case DbType.VarNumeric: return "Decimal";
		default:
		{
			return "__UNKNOWN__" + column.NativeType;
		}
	}
}

private Regex sqlCharacters = new Regex(@"[\s|~|-|!|{|%|}|\^|'|&|.|\(|\\|\)|`]", RegexOptions.Compiled);
private Regex sqlReserved = new Regex(@"^(ADD|EXCEPT|PERCENT|ALL|EXEC|PLAN|ALTER|EXECUTE|PRECISION|AND|EXISTS|PRIMARY|ANY|EXIT|PRINT|AS|FETCH|PROC|ASC|FILE|PROCEDURE|AUTHORIZATION|FILLFACTOR|PUBLIC|BACKUP|FOR|RAISERROR|BEGIN|FOREIGN|READ|BETWEEN|FREETEXT|READTEXT|BREAK|FREETEXTTABLE|RECONFIGURE|BROWSE|FROM|REFERENCES|BULK|FULL|REPLICATION|BY|FUNCTION|RESTORE|CASCADE|GOTO|RESTRICT|CASE|GRANT|RETURN|CHECK|GROUP|REVOKE|CHECKPOINT|HAVING|RIGHT|CLOSE|HOLDLOCK|ROLLBACK|CLUSTERED|IDENTITY|ROWCOUNT|COALESCE|IDENTITY_INSERT|ROWGUIDCOL|COLLATE|IDENTITYCOL|RULE|COLUMN|IF|SAVE|COMMIT|IN|SCHEMA|COMPUTE|INDEX|SELECT|CONSTRAINT|INNER|SESSION_USER|CONTAINS|INSERT|SET|CONTAINSTABLE|INTERSECT|SETUSER|CONTINUE|INTO|SHUTDOWN|CONVERT|IS|SOME|CREATE|JOIN|STATISTICS|CROSS|KEY|SYSTEM_USER|CURRENT|KILL|TABLE|CURRENT_DATE|LEFT|TEXTSIZE|CURRENT_TIME|LIKE|THEN|CURRENT_TIMESTAMP|LINENO|TO|CURRENT_USER|LOAD|TOP|CURSOR|NATIONAL||TRAN|DATABASE|NOCHECK|TRANSACTION|DBCC|NONCLUSTERED|TRIGGER|DEALLOCATE|NOT|TRUNCATE|DECLARE|NULL|TSEQUAL|DEFAULT|NULLIF|UNION|DELETE|OF|UNIQUE|DENY|OFF|UPDATE|DESC|OFFSETS|UPDATETEXT|DISK|ON|USE|DISTINCT|OPEN|USER|DISTRIBUTED|OPENDATASOURCE|VALUES|DOUBLE|OPENQUERY|VARYING|DROP|OPENROWSET|VIEW|DUMMY|OPENXML|WAITFOR|DUMP|OPTION|WHEN|ELSE|OR|WHERE|END|ORDER|WHILE|ERRLVL|OUTER|WITH|ESCAPE|OVER|WRITETEXT)$", RegexOptions.Compiled | RegexOptions.IgnoreCase);
private Regex sqlFuture = new Regex(@"^(ABSOLUTE|FOUND|PRESERVE|ACTION|FREE|PRIOR|ADMIN|GENERAL|PRIVILEGES|AFTER|GET|READS|AGGREGATE|GLOBAL|REAL|ALIAS|GO|RECURSIVE|ALLOCATE|GROUPING|REF|ARE|HOST|REFERENCING|ARRAY|HOUR|RELATIVE|ASSERTION|IGNORE|RESULT|AT|IMMEDIATE|RETURNS|BEFORE|INDICATOR|ROLE|BINARY|INITIALIZE|ROLLUP|BIT|INITIALLY|ROUTINE|BLOB|INOUT|ROW|BOOLEAN|INPUT|ROWS|BOTH|INT|SAVEPOINT|BREADTH|INTEGER|SCROLL|CALL|INTERVAL|SCOPE|CASCADED|ISOLATION|SEARCH|CAST|ITERATE|SECOND|CATALOG|LANGUAGE|SECTION|CHAR|LARGE|SEQUENCE|CHARACTER|LAST|SESSION|CLASS|LATERAL|SETS|CLOB|LEADING|SIZE|COLLATION|LESS|SMALLINT|COMPLETION|LEVEL|SPACE|CONNECT|LIMIT|SPECIFIC|CONNECTION|LOCAL|SPECIFICTYPE|CONSTRAINTS|LOCALTIME|SQL|CONSTRUCTOR|LOCALTIMESTAMP|SQLEXCEPTION|CORRESPONDING|LOCATOR|SQLSTATE|CUBE|MAP|SQLWARNING|CURRENT_PATH|MATCH|START|CURRENT_ROLE|MINUTE|STATE|CYCLE|MODIFIES|STATEMENT|DATA|MODIFY|STATIC|DATE|MODULE|STRUCTURE|DAY|MONTH|TEMPORARY|DEC|NAMES|TERMINATE|DECIMAL|NATURAL|THAN|DEFERRABLE|NCHAR|TIME|DEFERRED|NCLOB|TIMESTAMP|DEPTH|NEW|TIMEZONE_HOUR|DEREF|NEXT|TIMEZONE_MINUTE|DESCRIBE|NO|TRAILING|DESCRIPTOR|NONE|TRANSLATION|DESTROY|NUMERIC|TREAT|DESTRUCTOR|OBJECT|TRUE|DETERMINISTIC|OLD|UNDER|DICTIONARY|ONLY|UNKNOWN|DIAGNOSTICS|OPERATION|UNNEST|DISCONNECT|ORDINALITY|USAGE|DOMAIN|OUT|USING|DYNAMIC|OUTPUT|VALUE|EACH|PAD|VARCHAR|END-EXEC|PARAMETER|VARIABLE|EQUALS|PARAMETERS|WHENEVER|EVERY|PARTIAL|WITHOUT|EXCEPTION|PATH|WORK|EXTERNAL|POSTFIX|WRITE|FALSE|PREFIX|YEAR|FIRST|PREORDER|ZONE|FLOAT|PREPARE)$", RegexOptions.Compiled | RegexOptions.IgnoreCase);

public string SqlIdentifier(string sqlIdentifier)
{
	if (sqlCharacters.IsMatch(sqlIdentifier) || sqlReserved.IsMatch(sqlIdentifier) || sqlFuture.IsMatch(sqlIdentifier))
		return String.Format("`{0}`", sqlIdentifier);
	else
		return sqlIdentifier;
}

public string TableClass(TableSchema table)
{
	string className = table.Name;
	if(isCoreTable(className)!=-1){		
		return coreObject[isCoreTable(className)];
	}
	//if (className.StartsWith(RemoveTablePrefix))
	//	className = className.Substring(RemoveTablePrefix.Length);
		
	return String.Format("{0}", MakeSingle(PascalCase(className)));
}

public string TableClassFull(TableSchema table)
{
	//return table.Name;
	if(isCoreTable(table.Name)!=-1){		
		//Response.WriteLine(table.Name);
		return String.Format("{0}.{1}, {2}", coreNamespace , coreObject[isCoreTable(table.Name)], coreAssembly );
	}
	else if(isEmployeeTable(table.Name)!=-1)
	{
		return String.Format("{0}.{1}, {2}", coreEmployeeNamespace  , coreEmployeeObject[isEmployeeTable(table.Name)], coreEmployeeAssembly  );
	}
	else
	{
		return String.Format("{0}", TableClass(table));
	}	
}

public string TableCollection(TableSchema table)
{
	string className = table.Name;
	//if (className.StartsWith(RemoveTablePrefix))
	//	className = className.Substring(RemoveTablePrefix.Length);
	return String.Format("{0}", MakePlural(PascalCase(className)));
}
public string ClassName(TableSchema table)
{
	return TableClass(table);
}
public string ClassNameAtt(TableSchema table)
{
	return String.Format(" name=\"{0}\"", TableClassFull(table));
}
public string ClassTable(TableSchema table)
{
	return table.Name;
}
public string ClassTableAtt(TableSchema table)
{
	return String.Format(" table=\"{0}\"", SqlIdentifier(table.Name));
}

public string IdMemberName(TableSchema table)
{
	/*if (ForceId)
		return "_id";
	else */
	return MemberName(table.PrimaryKey.MemberColumns[0]);
}
public string IdName(TableSchema table)
{
	/*if (ForceId)
		return "Id";
	else*/
	return PropertyName(table.PrimaryKey.MemberColumns[0]);
}
public string IdNameAtt(TableSchema table)
{
	return String.Format(" name=\"{0}\"", IdName(table));
}
public string IdMemberType(TableSchema table)
{
	return MemberType(table.PrimaryKey.MemberColumns[0]);
}
public string IdType(TableSchema table)
{
	return PropertyType(table.PrimaryKey.MemberColumns[0]);
}
public string IdTypeAtt(TableSchema table)
{
	return String.Format(" type=\"{0}\"", PropertyType(table.PrimaryKey.MemberColumns[0]));
}
public string IdUnsavedValueAtt(TableSchema table)
{
	ColumnSchema column = table.PrimaryKey.MemberColumns[0];
	if (column.Size == 0)
		return String.Format(" unsaved-value=\"{0}\"", 0);
	else
		return String.Format(" unsaved-value=\"{0}\"", "-1");
}

public string PropertyName(ColumnSchema column)
{
	return PascalCase(column.Name);
}
public string MemberName(ColumnSchema column)
{
	return CamelCase(column.Name);
}
public string ParameterName(ColumnSchema column)
{
	return CamelCase(column.Name);
}
public string PropertyNameAtt(ColumnSchema column)
{
	return String.Format(" name=\"{0}\"", PropertyName(column));
}
public string PropertyType(ColumnSchema column)
{
	return NHibernateType(column);
}
public string MemberType(ColumnSchema column)
{
	return CSharpType(column);
}
public string PropertyTypeAtt(ColumnSchema column)
{
	return String.Format(" type=\"{0}\"", PropertyType(column));
}

public string ColumnName(ColumnSchema column)
{
	return column.Name;
}
public string ColumnNameAtt(ColumnSchema column)
{
	return String.Format(" name=\"{0}\"", SqlIdentifier(ColumnName(column)));
}
public string ColumnLength(ColumnSchema column)
{
	if (column.Size > 0)
		return column.Size.ToString();
	else
		return String.Empty;
}
public string ColumnLengthAtt(ColumnSchema column)
{
	if (column.Size > 0)
		return String.Format(" length=\"{0}\"", column.Size);
	else
		return String.Empty;
}
public string ColumnSqlTypeAtt(ColumnSchema column)
{
	return String.Format(" sql-type=\"{0}\"", column.NativeType);
}
public string ColumnNotNullAtt(ColumnSchema column)
{
	return String.Format(" not-null=\"{0}\"", (!column.AllowDBNull).ToString().ToLower());
}
public string ColumnUniqueAtt(ColumnSchema column)
{
	if (column.IsUnique)
		return String.Format(" unique=\"{0}\"", column.IsUnique.ToString().ToLower());
	else
		return String.Empty;
}
public string ColumnIndexAtt(TableSchema table, ColumnSchema column)
{
	foreach(IndexSchema index in table.Indexes)
	{
		if (index.MemberColumns.Contains(column))
		{
			return String.Format(" index=\"{0}\"", index.Name);
		}
	}
	return String.Empty;
}

public string ManyToOneName(TableKeySchema foreignKey)
{
	string className = TableClass(foreignKey.PrimaryKeyTable);

	string thiskey = foreignKey.ForeignKeyMemberColumns[0].Name;
	string primarykey = foreignKey.PrimaryKeyMemberColumns[0].Name;

	string differentiator = thiskey.Replace(primarykey, "").Replace("ID","");
	
	string returnName = (differentiator == "" ? className : differentiator);

	return returnName;
}
public string ManyToOneMemberName(TableKeySchema foreignKey)
{
	return "_" + CamelCase(ManyToOneName(foreignKey));
}
public string ManyToOneParameterName(TableKeySchema foreignKey)
{
	return CamelCase(ManyToOneName(foreignKey));
}
public string ManyToOneNameAtt(TableKeySchema foreignKey)
{
	return String.Format(" name=\"{0}\"", ManyToOneName(foreignKey));
}
public string ManyToOneClass(TableKeySchema foreignKey)
{
	string className = TableClass(foreignKey.PrimaryKeyTable);

	return className;
}
public string ManyToOneClassAtt(TableKeySchema foreignKey)
{
	string className = TableClassFull(foreignKey.PrimaryKeyTable);

	return String.Format(" class=\"{0}\"", className);
}

public string OneToOneName(TableKeySchema primaryKey)
{
	string className = TableClass(primaryKey.ForeignKeyTable);

	string thiskey = primaryKey.PrimaryKeyMemberColumns[0].Name;
	string primarykey = primaryKey.ForeignKeyMemberColumns[0].Name;

	string differentiator = thiskey.Replace(primarykey, "");

	return className + differentiator;
}
public string OneToOneMemberName(TableKeySchema primaryKey)
{
	return "_" + CamelCase(OneToOneName(primaryKey));
}
public string OneToOneNameAtt(TableKeySchema primaryKey)
{
	return String.Format(" name=\"{0}\"", OneToOneName(primaryKey));
}
public string OneToOneClass(TableKeySchema primaryKey)
{
	string className = TableClass(primaryKey.ForeignKeyTable);

	return className;
}
public string OneToOneClassAtt(TableKeySchema primaryKey)
{
	string className = TableClassFull(primaryKey.ForeignKeyTable);

	return String.Format(" class=\"{0}\"", className);
}

public string JoinedSubclassName(TableKeySchema primaryKey)
{
	string className = TableClass(primaryKey.ForeignKeyTable);

	string thiskey = primaryKey.PrimaryKeyMemberColumns[0].Name;
	string primarykey = primaryKey.ForeignKeyMemberColumns[0].Name;

	string differentiator = thiskey.Replace(primarykey, "");

	return className + differentiator;
}
public string JoinedSubclassNameAtt(TableKeySchema primaryKey)
{
	string className = TableClassFull(primaryKey.ForeignKeyTable);
	return String.Format(" name=\"{0}\"", className);
}
public string JoinedSubclassTable(TableKeySchema primaryKey)
{
	return primaryKey.ForeignKeyTable.Name;
}
public string JoinedSubclassTableAtt(TableKeySchema primaryKey)
{
	return String.Format(" table=\"{0}\"", SqlIdentifier(primaryKey.ForeignKeyTable.Name));
}

public string CollectionName(TableKeySchema primaryKey)
{
//	string className = TableCollection(primaryKey.ForeignKeyTable);
	string className = primaryKey.ForeignKeyTable.Name;
	string thiskey = primaryKey.PrimaryKeyMemberColumns[0].Name;
	string primarykey = primaryKey.ForeignKeyMemberColumns[0].Name;

	string differentiator = primarykey.Replace(thiskey, "").Replace("ID","");

	return MakePlural(differentiator + className);
}
public string CollectionMemberName(TableKeySchema primaryKey)
{
	return "_" + CamelCase(CollectionName(primaryKey));
}
public string CollectionNameAtt(TableKeySchema primaryKey)
{
	string className = TableCollection(primaryKey.ForeignKeyTable);

	string thiskey = primaryKey.PrimaryKeyMemberColumns[0].Name;
	string primarykey = primaryKey.ForeignKeyMemberColumns[0].Name;

	string differentiator = primarykey.Replace(thiskey, "");

	return String.Format(" name=\"{0}\"", CollectionName(primaryKey));
}
public string CollectionType(TableKeySchema primaryKey)
{
	return "IList";
}
public string NewCollectionType(TableKeySchema primaryKey)
{
	return "new ArrayList()";
}
public string CollectionKeyColumnAtt(TableKeySchema primaryKey)
{
	ColumnSchema column = primaryKey.PrimaryKeyMemberColumns[0];
	return String.Format(" column=\"{0}\"", SqlIdentifier(column.Name));
}
public string CollectionSelfKeyColumnAtt(TableKeySchema primaryKey)
{
	ColumnSchema column = primaryKey.ForeignKeyMemberColumns[0];
	return String.Format(" column=\"{0}\"", SqlIdentifier(column.Name));
}
public string CollectionOneToManyClass(TableKeySchema primaryKey)
{
	return TableClass(primaryKey.ForeignKeyTable);
}
public string CollectionOneToManyClassAtt(TableKeySchema primaryKey)
{
	return String.Format(" class=\"{0}\"", TableClassFull(primaryKey.ForeignKeyTable));
}
public string CollectionManyToManyName(TableKeySchema primaryKey)
{
//	string className = String.Empty;

//	foreach(TableKeySchema tableKey in primaryKey.ForeignKeyTable.ForeignKeys)
//	{
//		className = TableCollection(tableKey.ForeignKeyTable);
//		if (tableKey.PrimaryKeyTable != SourceTable)
//		{
//			className = TableCollection(tableKey.PrimaryKeyTable);
//		}
//	}

//	string thiskey = primaryKey.PrimaryKeyMemberColumns[0].Name;
	string primarykey = primaryKey.ForeignKeyMemberColumns[0].Name;

//	string differentiator = primarykey.Replace(thiskey, "");
	
	string otherkey = String.Empty;
	foreach(ColumnSchema column in primaryKey.ForeignKeyTable.PrimaryKey.MemberColumns)
	{
		if (column.Name != primarykey)
		{
			otherkey = column.Name;
		}
	}
	
	string returnName = MakePlural(primarykey.Replace("ID","")+otherkey.Replace("ID",""));

	return returnName;
}
public string CollectionManyToManyMemberName(TableKeySchema primaryKey)
{
	return "_" + CamelCase(CollectionManyToManyName(primaryKey));
}
public string CollectionManyToManyNameAtt(TableKeySchema primaryKey)
{
	return String.Format(" name=\"{0}\"", CollectionManyToManyName(primaryKey));
}
public string CollectionManyToManyClass(TableKeySchema primaryKey)
{
	return TableClass(primaryKey.ForeignKeyTable);
}
public string CollectionManyToManyClassAtt(TableKeySchema primaryKey)
{
	return String.Format(" class=\"{0}\"", TableClassFull(primaryKey.PrimaryKeyTable));
}
public string CollectionTableAtt(TableKeySchema primaryKey)
{
	return String.Format(" table=\"{0}\"", SqlIdentifier(primaryKey.ForeignKeyTable.Name));
}
// script for gen with core module

string[] coreTable =    { 
                            "cuyahoga_category",
                            "cuyahoga_contentitem",
                            "cuyahoga_menu",
                            "cuyahoga_fileresource",
                            "cuyahoga_moduletype",
                            "cuyahoga_contentitem",
                            "cuyahoga_node",
                            "cuyahoga_right",
                            "cuyahoga_role",
                            "cuyahoga_section",
                            "cuyahoga_site",
                            "cuyahoga_sitealias",
                            "cuyahoga_template",
                            "cuyahoga_user",
							
							"Suntech_Layouts",
							"Suntech_ModuleService",
							"Suntech_ModuleSetting",
							"Suntech_ModuleType",
							"Suntech_Node",
							"Suntech_NodeRole",
							"Suntech_Role",
							"Suntech_sectionconnection",
							"Suntech_Site",
							"Suntech_Sitealias",
							"Suntech_Themes",
							"Suntech_User",
							"Suntech_UserRole",
							"Suntech_Version",
							"Suntech_Widget",
							"Suntech_WidgetLayout",
							"Suntech_WidgetRole",
							"Suntech_WidgetSetting"
/*
							"AdminAssignPermission",
							"AdminCategory",
							"AdminCategoryType",
							"AdminGroup",
							"AdminGroupRole",
							"AdminGroupUser",
							"AdminLoginHistory",
							"AdminOrganization",
							"AdminPermission",
							"AdminRolePermission"							
*/							
                            };
string[] coreObject =   {
                            "Category",
                            "ContentItem",
                            "CustomMenu",
                            "FileResource",
                            "ModuleType",
                            "ContentItem",
                            "Node",
                            "Right",
                            "Role",
                            "Section",
                            "Site",
                            "SiteAlias",
                            "Template",
                            "User",
							
							"Layout",
							"ModuleService",
							"ModuleSetting",
							"ModuleType",
							"Node",
							"NodeRole",
							"Role",
							"Sectionconnection",
							"Site",
							"Sitealias",
							"Theme",
							"User",
							"UserRole",
							"Version",
							"Widget",
							"WidgetLayout",
							"WidgetRole",
							"WidgetSetting"
/*							
							"AdminAssignPermission",
							"AdminCategory",
							"AdminCategoryType",
							"AdminGroup",
							"AdminGroupRole",
							"AdminGroupUser",
							"AdminLoginHistory",
							"AdminOrganization",
							"AdminPermission",
							"AdminRolePermission"
*/							
                            };
string[] columnName = {
							"Name",
							"Title",
							"Url",
							"Username",
							"Fullname",
							"Firstname",
							"Lastname",
							"Email",
							"Subject",
							"ShortTitle",
							"Symbol",
							"Sname"							
					  };
string[] coreEmployeeTable = {
/*
							"Employee",
							"EmployeeAnniversary",
							"EmployeeContract",
							"EmployeeFamily",
							"EmployeeLanguage",
							"EmployeePriseBlame",
							"EmployeeQualification",
							"EmployeeSecondment",
							"EmployeeSkill",
							"EmploymentHistory"
*/							
						};
string[] coreEmployeeObject = {
/*
							"Employee",
							"EmployeeAnniversary",
							"EmployeeContract",
							"EmployeeFamily",
							"EmployeeLanguage",
							"EmployeePriseBlame",
							"EmployeeQualification",
							"EmployeeSecondment",
							"EmployeeSkill",
							"EmploymentHistory"
*/							
						};
public string GetFiledNameForRefKey(TableSchema table, string[] columntRefer )
{
	string columName = string.Empty;
	// search equals
	for(int i = 0; i < columntRefer.Length; i++)
	{
		foreach(ColumnSchema column in table.NonKeyColumns){
			columName = PropertyName(column);
			if (columntRefer[i].ToLower().Equals(columName.ToLower()))
			{
				return columName;
			}
		}
	}
	for(int i = 0; i < columntRefer.Length; i++)
	{	
		foreach(ColumnSchema column in table.NonKeyColumns){
			columName = PropertyName(column);
			if (columName.ToLower().IndexOf(columntRefer[i].ToLower())>=0)
			{
				return columName;
			}
		}
	}
	return "Id";
}
public string GetConstFiledNameForRefKeyTemp(TableSchema table, string[] columntRefer )
{
	string columName = string.Empty;
	// search equals
	foreach(ColumnSchema column in table.NonKeyColumns){
		columName = PropertyName(column);
		for(int i = 0; i < columntRefer.Length; i++)
		{
			if (columntRefer[i].ToLower().Equals(columName.ToLower()))
			{
				return "COLUMN_"+PropertyName(column).ToUpper();
			}
		}
	}
	foreach(ColumnSchema column in table.NonKeyColumns){
		columName = PropertyName(column);
		for(int i = 0; i < columntRefer.Length; i++)
		{
			if (columName.ToLower().IndexOf(columntRefer[i].ToLower())>=0)
			{
				return "COLUMN_"+PropertyName(column).ToUpper();
			}
		}
	}	
	return "COLUMN_ID";
}
public string GetConstFiledNameForRefKey(TableSchema table, string[] columntRefer )
{
	string columName = string.Empty;
	// search equals
	for(int i = 0; i < columntRefer.Length; i++)
	{	
		foreach(ColumnSchema column in table.NonKeyColumns){
			columName = PropertyName(column);
			if (columntRefer[i].ToLower().Equals(columName.ToLower()))
			{
				return "COLUMN_"+PropertyName(column).ToUpper();
			}	
		}
	}
	for(int i = 0; i < columntRefer.Length; i++)
	{	
		foreach(ColumnSchema column in table.NonKeyColumns){
			columName = PropertyName(column);	
			if (columName.ToLower().IndexOf(columntRefer[i].ToLower())>=0)
			{
				return "COLUMN_"+PropertyName(column).ToUpper();
			}
		}
	}
	return "COLUMN_ID";
}

string coreNamespace = "Cuyahoga.Core.Domain";
string coreAssembly = "Cuyahoga.Core";
string coreEmployeeAssembly = "Suntech.Web.Modules.Employees";
string coreEmployeeNamespace = "Suntech.Web.Modules.Employees.Domain";
public int isCoreTable(string tableName)
{
    for (int i = 0; i < coreTable.Length; i++)
    {
        if (coreTable[i].ToLower().Equals(tableName.ToLower()))
        {
            return i;
        }
    }            
    return -1;
}
public bool IsDefaultRequireField(ColumnSchema column)
{
	for(int i = 0 ; i < columnName.Length; i++)
	{
		if(columnName[i].ToLower().Equals(column.Name.ToLower())||column.Name.ToLower().IndexOf(columnName[i].ToLower())>0)
		{
			return true;
		}
	}
	return false;
}

public int isEmployeeTable(string tableName)
{
    for (int i = 0; i < coreEmployeeTable.Length; i++)
    {
        if (coreEmployeeTable[i].ToLower().Equals(tableName.ToLower()))
        {
            return i;
        }
    }            
    return -1;
}
public string GetFunctionName(TableSchema table, TableKeySchema key)
{
	
	string className = TableClass(table);
	string referTable = TableClass(key.PrimaryKeyTable);
	string columnrefe = ManyToOneName(key);
	if(referTable.ToLower().Equals(columnrefe.ToLower()))
	{
		return className+"GetAll"+"By"+referTable;
	}
	else
	{
		return className+"GetAll"+"By"+referTable+char.ToUpper(columnrefe[0]) + columnrefe.Substring(1);
	}
}
public string GetFunctionName(TableSchema table)
{
	string className = TableClass(table);
	return className+"GetAll";
}

public string SearchFunctionName(TableSchema table)
{
	string className = TableClass(table);
	return className+"SearchAll";
}
public string CSharpControlType(ColumnSchema column)
{
	if (column.Name.EndsWith("TypeCode")) return column.Name;

	switch (column.DataType)
	{
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
		case DbType.Int16:
		case DbType.Int32:
		case DbType.Int64:
		case DbType.Single:
		case DbType.String:
		case DbType.StringFixedLength:
		case DbType.UInt16:
		case DbType.UInt32:
		case DbType.UInt64:
		case DbType.VarNumeric:
		case DbType.Decimal:
		case DbType.Double:
		case DbType.Byte:// return "byte";
		case DbType.Currency:// return "decimal";
			return "TextBox";
		
		case DbType.Binary:// return "byte[]";
			return "FileUpload";
		
		case DbType.Boolean://return "bool";
			return "CheckBox";
			
		case DbType.Time:// return "TimeSpan";
		case DbType.Date:// return "DateTime";
		case DbType.DateTime:// return "DateTime";
			return "TextBox";
			
		case DbType.Guid:// return "Guid";
		case DbType.Object:// return "object";
		case DbType.SByte:// return "sbyte";
		
		default:
		{
			return "TextBox";
		}
	}
}

public string CSharpControlTypeForView(ColumnSchema column)
{
	if (column.Name.EndsWith("TypeCode")) return column.Name;

	switch (column.DataType)
	{
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
		case DbType.Int16:
		case DbType.Int32:
		case DbType.Int64:
		case DbType.Single:
		case DbType.String:
		case DbType.StringFixedLength:
		case DbType.UInt16:
		case DbType.UInt32:
		case DbType.UInt64:
		case DbType.VarNumeric:
		case DbType.Decimal:
		case DbType.Double:
		case DbType.Byte:// return "byte";
		case DbType.Currency:// return "decimal";
			return "Label";
		
		case DbType.Binary:// return "byte[]";
			return "FileUpload";
		
		case DbType.Boolean://return "bool";
			return "CheckBox";
			
		case DbType.Time:// return "TimeSpan";
		case DbType.Date:// return "DateTime";
		case DbType.DateTime:// return "DateTime";
			return "Label";
			
		case DbType.Guid:// return "Guid";
		case DbType.Object:// return "object";
		case DbType.SByte:// return "sbyte";
		
		default:
		{
			return "Label";
		}
	}
}
/*
public string CSharpControlTypeForView(ColumnSchema column)
{
	if (column.Name.EndsWith("TypeCode")) return column.Name;

	switch (column.DataType)
	{
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
		case DbType.Int16:
		case DbType.Int32:
		case DbType.Int64:
		case DbType.Single:
		case DbType.String:
		case DbType.StringFixedLength:
		case DbType.UInt16:
		case DbType.UInt32:
		case DbType.UInt64:
		case DbType.VarNumeric:
		case DbType.Decimal:
		case DbType.Double:
		case DbType.Byte:// return "byte";
		case DbType.Currency:// return "decimal";
			return "Label";
		
		case DbType.Binary:// return "byte[]";
			return "FileUpload";
		
		case DbType.Boolean://return "bool";
			return "CheckBox";
			
		case DbType.Time:// return "TimeSpan";
		case DbType.Date:// return "DateTime";
		case DbType.DateTime:// return "DateTime";
			return "Label";
			
		case DbType.Guid:// return "Guid";
		case DbType.Object:// return "object";
		case DbType.SByte:// return "sbyte";
		
		default:
		{
			return "Label";
		}
	}
}
*/
public string CSharpControlPre(ColumnSchema column)
{
	if (column.Name.EndsWith("TypeCode")) return column.Name;

	switch (column.DataType)
	{
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
		case DbType.Int16:
		case DbType.Int32:
		case DbType.Int64:
		case DbType.Single:
		case DbType.String:
		case DbType.StringFixedLength:
		case DbType.UInt16:
		case DbType.UInt32:
		case DbType.UInt64:
		case DbType.VarNumeric:
		case DbType.Decimal:
		case DbType.Double:
		case DbType.Byte:// return "byte";
		case DbType.Currency:// return "decimal";
			return "txt";
		
		case DbType.Binary:// return "byte[]";
			return "dlg";
		
		case DbType.Boolean: //return "bool";
			return "chk";
			
		case DbType.Time: //return "TimeSpan";
		case DbType.Date: //return "DateTime";
		case DbType.DateTime: //return "DateTime";
			return "txt";
			
		case DbType.Guid: //return "Guid";
		case DbType.Object: //return "object";
		case DbType.SByte: //return "sbyte";
		
		default:
		{
			return "txt";
		}
	}
}

public string CSharpControlAddedInforPorEdit(ColumnSchema column)
{
	if(CSharpControlPre(column)=="txt" && column.Size > 500)
		return "TextMode=\"MultiLine\" Columns=\"50\" Rows=\"10\"";
	else
		return string.Empty;
}

public string CSharpControlPreForView(ColumnSchema column)
{
	if (column.Name.EndsWith("TypeCode")) return column.Name;

	switch (column.DataType)
	{
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
		case DbType.Int16:
		case DbType.Int32:
		case DbType.Int64:
		case DbType.Single:
		case DbType.String:
		case DbType.StringFixedLength:
		case DbType.UInt16:
		case DbType.UInt32:
		case DbType.UInt64:
		case DbType.VarNumeric:
		case DbType.Decimal:
		case DbType.Double:
		case DbType.Byte:// return "byte";
		case DbType.Currency:// return "decimal";
			return "lbl";
		
		case DbType.Binary:// return "byte[]";
			return "dlg";
		
		case DbType.Boolean: //return "bool";
			return "chk";
			
		case DbType.Time: //return "TimeSpan";
		case DbType.Date: //return "DateTime";
		case DbType.DateTime: //return "DateTime";
			return "lbl";
			
		case DbType.Guid: //return "Guid";
		case DbType.Object: //return "object";
		case DbType.SByte: //return "sbyte";
		
		default:
		{
			return "lbl";
		}
	}
}
public string CSharpControlConvertToObject(ColumnSchema column)
{
	if (column.Name.EndsWith("TypeCode")) return column.Name;

	switch (column.DataType)
	{
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
		case DbType.Single:
		case DbType.String:
		case DbType.StringFixedLength:
			return CSharpControlPre(column)+PropertyName(column)+".Text";
		case DbType.Int16:
			return "Convert.ToInt16("+CSharpControlPre(column)+PropertyName(column)+".Text)";
		case DbType.Int32:
			return "Convert.ToInt32("+CSharpControlPre(column)+PropertyName(column)+".Text)";
		case DbType.Int64:
			return "Convert.ToInt64("+CSharpControlPre(column)+PropertyName(column)+".Text)";
		case DbType.UInt16:
			return "Convert.ToUInt16("+CSharpControlPre(column)+PropertyName(column)+".Text)";
		case DbType.UInt32:
			return "Convert.ToUInt32("+CSharpControlPre(column)+PropertyName(column)+".Text)";
		case DbType.UInt64:
			return "Convert.ToUInt64("+CSharpControlPre(column)+PropertyName(column)+".Text)";
		case DbType.VarNumeric:
			
		case DbType.Decimal:
			return "Convert.ToDecimal("+CSharpControlPre(column)+PropertyName(column)+".Text)";
		case DbType.Double:
			return "Convert.ToDouble("+CSharpControlPre(column)+PropertyName(column)+".Text)";
		case DbType.Byte:// return "byte";			
		case DbType.Currency:// return "decimal";
			return "Convert.ToDecimal("+CSharpControlPre(column)+PropertyName(column)+".Text)";
			
		case DbType.Binary:// return "byte[]";
			return "dlg";
		
		case DbType.Boolean: //return "bool";
			return CSharpControlPre(column)+PropertyName(column)+".Checked";
			
		case DbType.Time: //return "TimeSpan";
		case DbType.Date: //return "DateTime";
		case DbType.DateTime: //return "DateTime";
			//return "Convert.ToDateTime("+CSharpControlPre(column)+PropertyName(column)+".Text,\"dd/mm/yyyy\")";
			return "DateTime.Now";
			
		case DbType.Guid: //return "Guid";
		case DbType.Object: //return "object";
		case DbType.SByte: //return "sbyte";
		
		default:
		{
			return CSharpControlPre(column)+PropertyName(column)+".Text";
		}
	}
}

public string CSharpObjectAsignToControl(ColumnSchema column)
{
	if (column.Name.EndsWith("TypeCode")) return column.Name;

	switch (column.DataType)
	{
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
		case DbType.Single:
		case DbType.String:
		case DbType.StringFixedLength:
			return CSharpControlPre(column)+PropertyName(column)+".Text";
		case DbType.Int16:
			return CSharpControlPre(column)+PropertyName(column)+".Text";
		case DbType.Int32:
			return CSharpControlPre(column)+PropertyName(column)+".Text";
		case DbType.Int64:
			return CSharpControlPre(column)+PropertyName(column)+".Text";
		case DbType.UInt16:
			return CSharpControlPre(column)+PropertyName(column)+".Text";
		case DbType.UInt32:
			return CSharpControlPre(column)+PropertyName(column)+".Text";
		case DbType.UInt64:
			return CSharpControlPre(column)+PropertyName(column)+".Text";
		case DbType.VarNumeric:
			
		case DbType.Decimal:
			return CSharpControlPre(column)+PropertyName(column)+".Text";
		case DbType.Double:
			return CSharpControlPre(column)+PropertyName(column)+".Text";
		case DbType.Byte:// return "byte";			
		case DbType.Currency:// return "decimal";
			return CSharpControlPre(column)+PropertyName(column)+".Text";
			
		case DbType.Binary:// return "byte[]";
			return "dlg";
		
		case DbType.Boolean: //return "bool";
			return CSharpControlPre(column)+PropertyName(column)+".Checked";
			
		case DbType.Time: //return "TimeSpan";
		case DbType.Date: //return "DateTime";
		case DbType.DateTime: //return "DateTime";
			return CSharpControlPre(column)+PropertyName(column)+".Text";
			
		case DbType.Guid: //return "Guid";
		case DbType.Object: //return "object";
		case DbType.SByte: //return "sbyte";
		
		default:
		{
			return CSharpControlPre(column)+PropertyName(column)+".Text";
		}
	}
}

public string CSharpObjectAsignToControlForView(ColumnSchema column)
{
	if (column.Name.EndsWith("TypeCode")) return column.Name;

	switch (column.DataType)
	{
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
		case DbType.Single:
		case DbType.String:
		case DbType.StringFixedLength:
			return CSharpControlPreForView(column)+PropertyName(column)+"Value.Text";
		case DbType.Int16:
			return CSharpControlPreForView(column)+PropertyName(column)+"Value.Text";
		case DbType.Int32:
			return CSharpControlPreForView(column)+PropertyName(column)+"Value.Text";
		case DbType.Int64:
			return CSharpControlPreForView(column)+PropertyName(column)+"Value.Text";
		case DbType.UInt16:
			return CSharpControlPreForView(column)+PropertyName(column)+"Value.Text";
		case DbType.UInt32:
			return CSharpControlPreForView(column)+PropertyName(column)+"Value.Text";
		case DbType.UInt64:
			return CSharpControlPreForView(column)+PropertyName(column)+"Value.Text";
		case DbType.VarNumeric:
			
		case DbType.Decimal:
			return CSharpControlPreForView(column)+PropertyName(column)+"Value.Text";
		case DbType.Double:
			return CSharpControlPreForView(column)+PropertyName(column)+"Value.Text";
		case DbType.Byte:// return "byte";			
		case DbType.Currency:// return "decimal";
			return CSharpControlPreForView(column)+PropertyName(column)+"Value.Text";
			
		case DbType.Binary:// return "byte[]";
			return "dlg";
		
		case DbType.Boolean: //return "bool";
			return CSharpControlPreForView(column)+PropertyName(column)+"Value.Checked";
			
		case DbType.Time: //return "TimeSpan";
		case DbType.Date: //return "DateTime";
		case DbType.DateTime: //return "DateTime";
			return CSharpControlPreForView(column)+PropertyName(column)+"Value.Text";
			
		case DbType.Guid: //return "Guid";
		case DbType.Object: //return "object";
		case DbType.SByte: //return "sbyte";
		
		default:
		{
			return CSharpControlPreForView(column)+PropertyName(column)+"Value.Text";
		}
	}
}

public string CSharpObjectToStringOrNot(ColumnSchema column)
{
	if (column.Name.EndsWith("TypeCode")) return column.Name;

	switch (column.DataType)
	{
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
		case DbType.Single:
		case DbType.String:
		case DbType.StringFixedLength:
			return string.Empty;
		case DbType.Int16:
			
		case DbType.Int32:
			
		case DbType.Int64:
			
		case DbType.UInt16:
			
		case DbType.UInt32:
			
		case DbType.UInt64:
			
		case DbType.VarNumeric:
			
		case DbType.Decimal:
			
		case DbType.Double:
			return ".ToString()";
		case DbType.Byte:// return "byte";			
		case DbType.Currency:// return "decimal";
			return ".ToString()";			
		case DbType.Binary:// return "byte[]";
			return "dlg";
		
		case DbType.Boolean: //return "bool";
			return string.Empty;
			
		case DbType.Time: //return "TimeSpan";
		case DbType.Date: //return "DateTime";
		case DbType.DateTime: //return "DateTime";
			return ".ToString()";
			
		case DbType.Guid: //return "Guid";
		case DbType.Object: //return "object";
		case DbType.SByte: //return "sbyte";
		
		default:
		{
			return CSharpControlPre(column)+PropertyName(column)+".Text";
		}
	}
}

public bool IsDateColumn(ColumnSchema column)
{
	if (column.Name.EndsWith("TypeCode")) 
		return false;
	switch (column.DataType)
	{
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
		case DbType.Int16:
		case DbType.Int32:
		case DbType.Int64:
		case DbType.Single:
		case DbType.String:
		case DbType.StringFixedLength:
		case DbType.UInt16:
		case DbType.UInt32:
		case DbType.UInt64:
		case DbType.VarNumeric:
		case DbType.Decimal:
		case DbType.Double:
		case DbType.Byte:// return "byte";
		case DbType.Currency:// return "decimal";
			//return "TextBox";
		
		case DbType.Binary:// return "byte[]";
			//return "FileUpload";
		
		case DbType.Boolean://return "bool";
			//return "CheckBox";
			return false;
		case DbType.Time:// return "TimeSpan";
		case DbType.Date:// return "DateTime";
		case DbType.DateTime:// return "DateTime";
			return true;
			
		case DbType.Guid:// return "Guid";
		case DbType.Object:// return "object";
		case DbType.SByte:// return "sbyte";
		
		default:
		{
			return false;
		}
	}
}


public bool IsNumberColumn(ColumnSchema column)
{
	if (column.Name.EndsWith("TypeCode")) 
		return false;
	switch (column.DataType)
	{
		case DbType.Int16:
		case DbType.Int32:
		case DbType.Int64:
		case DbType.UInt16:
		case DbType.UInt32:
		case DbType.UInt64:
		case DbType.VarNumeric:
		case DbType.Decimal:
		case DbType.Double:
			return true;
		default:
		{
			return false;
		}
	}
}


/// <summary>
/// Determines whether base DataObjectBase is a string type, and not a blob column of text or ntext
/// </summary>
public bool CanCheckLength(SchemaExplorer.DataObjectBase column)
{
	switch (column.DataType)
	{
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
		case DbType.String:
		case DbType.StringFixedLength:
			return (column.NativeType != "text" && column.NativeType != "ntext" && column.Size > 0);		
		default:
			return false;
	}
}
public bool HaveIsDeletedColumn(TableSchema table)
{
	for(int i = 0; i < table.Columns.Count; i++)
	{
		if(table.Columns[i].Name.ToLower().Equals("IsDeleted".ToLower()))
		{
			return true;
		}
	}
	return false;
}

public string GetIsDeletedColumnName(TableSchema table)
{
	foreach(ColumnSchema column in table.NonKeyColumns) 
	{
		if(PropertyName(column).ToLower().Equals("IsDeleted".ToLower()))
		{
			return "COLUMN_"+PropertyName(column).ToUpper();	
		}
	}	
	return string.Empty;
}
public void sortSourceDatabase(TableSchemaCollection SourceDatabase)
{
	TableSchema tb;
	for(int i = 0 ; i < SourceDatabase.Count; i++)
	{			
		for(int j=i; j < SourceDatabase.Count; j++)
		{
			tb = SourceDatabase[i];
			if(SourceDatabase[i].Name.ToLower().CompareTo(SourceDatabase[j].Name.ToLower())>0)
			{
				SourceDatabase[i] = SourceDatabase[j];
				SourceDatabase[j] = tb;
			}				
		}
	}
	/*
	for(int i = 0 ; i < SourceDatabase.Count; i++)
	{
		Response.WriteLine(SourceDatabase[i].Name);
	}
	*/
}
public string ParseStringToWord(string str)
{
	string strReturn = string.Empty;
	if(str == null || str == string.Empty)
	{
		return string.Empty;
	}
	bool plusWhitepace = false;
	for(int i = 0; i < str.Length; i++)
	{
		if(char.ToUpper(str[i]).Equals(str[i]))
		{
			if(!plusWhitepace)
			{
				strReturn += str[i].ToString();
				plusWhitepace = true;
			}
			else
			{
				strReturn += " "+ char.ToLower(str[i]);				
			}
		}
		else
		{
			strReturn += str[i].ToString();
		}
	}
	return strReturn;
}

// Define columns that not gen for Edit. Example CreatedDate, ModifiedDate, CreatedBy, MofifiedBy
string [] ungenColumnForEdit = {	"CreatedDate",
									"ModifiedDate",
									"CreatedBy",
									"ModifiedBy"
								};
public bool IsUngenColumnForEdit(string columnName)
{
	for(int i = 0; i  < ungenColumnForEdit.Length; i++)
	{
		if(columnName.ToLower().Equals(ungenColumnForEdit[i].ToLower()))
		{
			return true;
		}
	}
	return false;
}

// count number of text column in table;
public int NumberOfTexColumn(TableSchema table)
{
	int numberTextColumn = 0;
	for(int i = 0; i < table.Columns.Count; i++)
	{
		switch (table.Columns[i].DataType)
		{
			case DbType.AnsiString:
			case DbType.AnsiStringFixedLength:
			case DbType.Single:
			case DbType.String:
			case DbType.StringFixedLength:
				numberTextColumn ++;
				break;
			default:
				break;
		}
	}
	return numberTextColumn;
}
public bool IsTextColumn(ColumnSchema column)
{
	switch(column.DataType)
	{
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
		case DbType.Single:
		case DbType.String:
		case DbType.StringFixedLength:
			return true;
		default:
			return false;
	}
}

public bool IsBoolColumn(ColumnSchema column)
{
	switch(column.DataType)
	{
		case DbType.Boolean:
			return true;
		default:
			return false;
	}
}

public string GetColumnDescription(ColumnSchema column)
{
	if(!string.IsNullOrEmpty(column.Description))
	{
		return column.Description.Replace("\n", " ");
	}
	else
	{
		return this.GetColumnNameString(column);	
	}
}

public string GetSQLDataType(ColumnSchema column)
{
	switch (column.DataType)
	{
		case DbType.String:
		case DbType.StringFixedLength:
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
			return "VARCHAR2";
			
		case DbType.Int16:
		case DbType.Int32:
		case DbType.Int64:
		case DbType.Single:

		case DbType.UInt16:
		case DbType.UInt32:
		case DbType.UInt64:
		case DbType.VarNumeric:
		case DbType.Decimal:
		case DbType.Double:
		case DbType.Byte:
			return "NUMBER";
		
		case DbType.Currency:
			return column.DataType.ToString();
		
		case DbType.Binary:
			return column.DataType.ToString();
		
		case DbType.Boolean:	//return "bool";
			return column.DataType.ToString();
			
		case DbType.Time:		// return "TimeSpan";
		case DbType.Date:		// return "DateTime";
		case DbType.DateTime:	// return "DateTime";
			return "TIMESTAMP";
		
		case DbType.Object:		// return "object";
			if(column.Name.ToUpper().Contains("TIME") || column.Name.ToUpper().Contains("DATE"))
				return "TIMESTAMP";
			return column.DataType.ToString();
		case DbType.Guid:		// return "Guid";
		
		case DbType.SByte:		// return "sbyte";
		
		default:
		{
			return column.DataType.ToString();
		}
	}
}

public string GetColumnDataType(ColumnSchema column)
{
	switch (column.DataType)
	{
		case DbType.String:
		case DbType.StringFixedLength:
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
			return "String";
			
		case DbType.Int16:
		case DbType.Int32:
		case DbType.Int64:
		case DbType.Single:

		case DbType.UInt16:
		case DbType.UInt32:
		case DbType.UInt64:
		case DbType.VarNumeric:
		case DbType.Decimal:
		case DbType.Double:
		case DbType.Byte:
			return "BigDecimal";
		
		case DbType.Currency:
			return column.DataType.ToString();
		
		case DbType.Binary:
			return column.DataType.ToString();
		
		case DbType.Boolean:	//return "bool";
			return column.DataType.ToString();
			
		case DbType.Time:		// return "TimeSpan";
		case DbType.Date:		// return "DateTime";
		case DbType.DateTime:	// return "DateTime";
			return "Date";
		
		case DbType.Object:		// return "object";
			if(column.Name.ToUpper().Contains("TIME") || column.Name.ToUpper().Contains("DATE"))
				return "Timestamp";
			return column.DataType.ToString();
		case DbType.Guid:		// return "Guid";
		
		case DbType.SByte:		// return "sbyte";
		
		default:
		{
			return column.DataType.ToString();
		}
	}
}


public string GetFrontColumnDataType(ColumnSchema column)
{
	switch (column.DataType)
	{
		case DbType.String:
		case DbType.StringFixedLength:
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
			return "String";
			
		case DbType.Int16:
		case DbType.Int32:
		case DbType.Int64:
		case DbType.Single:

		case DbType.UInt16:
		case DbType.UInt32:
		case DbType.UInt64:
		case DbType.VarNumeric:
		case DbType.Decimal:
		case DbType.Double:
		case DbType.Byte:
			return "BigDecimal";
		
		case DbType.Currency:
			return column.DataType.ToString();
		
		case DbType.Binary:
			return column.DataType.ToString();
		
		case DbType.Boolean:	//return "bool";
			return column.DataType.ToString();
			
		case DbType.Time:		// return "TimeSpan";
		case DbType.Date:		// return "DateTime";
		case DbType.DateTime:	// return "DateTime";
			return "Date";
		
		case DbType.Object:		// return "object";
			if(column.Name.ToUpper().Contains("TIME") || column.Name.ToUpper().Contains("DATE"))
				return "Date";
			return column.DataType.ToString();
		case DbType.Guid:		// return "Guid";
		
		case DbType.SByte:		// return "sbyte";
		
		default:
		{
			return column.DataType.ToString();
		}
	}
}

public string GetOracleDataType(ColumnSchema column)
{
	switch (column.DataType)
	{
		case DbType.String:
		case DbType.StringFixedLength:
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
			return "OracleTypes.VARCHAR";
			
		case DbType.Int16:
		case DbType.Int32:
		case DbType.Int64:
		case DbType.Single:

		case DbType.UInt16:
		case DbType.UInt32:
		case DbType.UInt64:
		case DbType.VarNumeric:
		case DbType.Decimal:
		case DbType.Double:
		case DbType.Byte:
			return "OracleTypes.NUMBER";
		
		case DbType.Currency:
			return column.DataType.ToString();
		
		case DbType.Binary:
			return column.DataType.ToString();
		
		case DbType.Boolean:	//return "bool";
			return column.DataType.ToString();
			
		case DbType.Time:		// return "TimeSpan";
		case DbType.Date:		// return "DateTime";
		case DbType.DateTime:	// return "DateTime";
			return "Date";
		
		case DbType.Object:		// return "object";
			if(column.Name.ToUpper().Contains("TIME") || column.Name.ToUpper().Contains("DATE"))
				return "OracleTypes.TIMESTAMP";
			return column.DataType.ToString();
		case DbType.Guid:		// return "Guid";
		
		case DbType.SByte:		// return "sbyte";
		
		default:
		{
			return column.DataType.ToString();
		}
	}
}

public string GetSqlColumnType(ColumnSchema column)
{
	switch (column.DataType)
	{
		case DbType.String:
		case DbType.StringFixedLength:
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
			return "Types.VARCHAR";
			
		case DbType.Int16:
		case DbType.Int32:
		case DbType.Int64:
		case DbType.Single:

		case DbType.UInt16:
		case DbType.UInt32:
		case DbType.UInt64:
		case DbType.VarNumeric:
		case DbType.Decimal:
		case DbType.Double:
		case DbType.Byte:
			return "Types.NUMERIC";
		
		case DbType.Currency:
			return column.DataType.ToString();
		
		case DbType.Binary:
			return column.DataType.ToString();
		
		case DbType.Boolean:	//return "bool";
			return column.DataType.ToString();
			
		case DbType.Time:		// return "TimeSpan";
		case DbType.Date:		// return "DateTime";
		case DbType.DateTime:	// return "DateTime";
			return "Types.TIMESTAMP";
		
		case DbType.Object:		// return "object";
			if(column.Name.ToUpper().Contains("TIME") || column.Name.ToUpper().Contains("DATE"))
				return "Types.TIMESTAMP";
			return column.DataType.ToString();
		case DbType.Guid:		// return "Guid";
		
		case DbType.SByte:		// return "sbyte";
		
		default:
		{
			return column.DataType.ToString();
		}
	}
}

public string GetColumnNameParam(ColumnSchema column)
{
	string ret = this.GetColumnName(column);
	
	ret = ret.Substring(0,1).ToLower() + ret.Substring(1, ret.Length - 1);
	
	return ret;
}

public bool IsExceptedColumn(ColumnSchema column, string exceptedColumn)
{
	string patern=column.Name+";";
	if(exceptedColumn.Contains(patern))
	{
		return true;
	}
	
	return false;
}

public string GetAnswerOutputName(string pk, string fc)
{
	return pk.Substring(0,1).ToUpper() + pk.Substring(1,pk.Length - 1)+fc + "AnswerOutput";
}

public string GetContextName(string pk, string fc)
{
	return pk.Substring(0,1).ToUpper() + pk.Substring(1,pk.Length - 1)+fc + "Context";
}

public string GetControlName(string pk, string fc)
{
	return pk.Substring(0,1).ToUpper() + pk.Substring(1,pk.Length - 1)+fc + "Control";
}

public string GetInputDataName(string pk, string fc)
{
	return pk.Substring(0,1).ToUpper() + pk.Substring(1,pk.Length - 1)+fc + "InputData";
}

public string GetRowDataName(string pk, string fc)
{
	return pk.Substring(0,1).ToUpper() + pk.Substring(1,pk.Length - 1)+fc + "RowData";
}


public string GetResultDataName(string pk, string fc)
{
	return pk.Substring(0,1).ToUpper() + pk.Substring(1,pk.Length - 1)+fc + "ResultData";
}

public string GetChangeInputName(string pk, string fc)
{
	return pk.Substring(0,1).ToUpper() + pk.Substring(1,pk.Length - 1)+fc + "ChangeInput";
}

public string GetConfirmName(string pk, string fc)
{
	return pk.Substring(0,1).ToUpper() + pk.Substring(1,pk.Length - 1)+fc + "Confirm";
}

public string GetConstName(string pk, string fc)
{
	return pk.Substring(0,1).ToUpper() + pk.Substring(1,pk.Length - 1)+fc + "Const";
}

public string GetFrameName(string pk, string fc)
{
	return pk.Substring(0,1).ToUpper() + pk.Substring(1,pk.Length - 1)+fc + "Frame";
}

public string GetInputName(string pk, string fc)
{
	return pk.Substring(0,1).ToUpper() + pk.Substring(1,pk.Length - 1)+fc + "Input";
}

public string GetPanelName(string pk, string fc)
{
	return pk.Substring(0,1).ToUpper() + pk.Substring(1,pk.Length - 1)+fc + "Panel";
}

public string GetResultName(string pk, string fc)
{
	return pk.Substring(0,1).ToUpper() + pk.Substring(1,pk.Length - 1)+fc + "Result";
}

public string[] GetKeysColumn(string keys)
{
	return keys.Split(';');
}

public string GetKeyColumn(string key)
{
	string ret = "";
	switch(key)
	{
		case "COLUMN1":
			ret = "Column1";
			break;
		case "COLUMN2":
			ret = "Column2";
			break;
		case "COLUMN3":
			ret = "Column3";
			break;
		case "COLUMN4":
			ret = "Column4";
			break;
		case "COLUMN5":
			ret = "Column5";
			break;
		case "COLUMN6":
			ret = "Column6";
			break;
		case "COLUMN7":
			ret = "Column7";
			break;
		case "COMPANY_CD":
			ret = "CompanyCd";
			break;
		case "DEL_CD":
			ret = "DelCd";
			break;
		case "REG_DATE_TIME":
			ret = "RegDateTime";
			break;
		case "REG_USER_ID":
			ret = "RegUserId";
			break;
		case "UPD_DATE_TIME":
			ret = "UpdDateTime";
			break;
		case "UPD_USER_ID":
			ret = "UpdUserId";
			break;
		case "COUNTRY_CD":
			ret ="CountryCd";
			break;
		case "MARKET_CD":
			ret = "MarketCd";
			break;
		case "BRANCH_CD":
			ret = "BranchCd";
			break;
		
		case "TRANSACTION_CD":
			ret = "TransactionCd";
			break;
			
		case "USER_ID":
			ret = "UserID";
			break;
	}
	
	if(ret =="")
	{
		ret = key;
	}
	
	return ret;
}

public string GetKeyColumnParam(string key)
{
	string ret = GetKeyColumn(key);
	
	ret = ret.Substring(0,1).ToLower() + ret.Substring(1, ret.Length - 1);
	
	return ret;
}

public string GetTableDescription(TableSchema table)
{
	string ret = table.Description;
	if(string.IsNullOrEmpty(ret))
	{
		ret = this.GetTablename(table);
	}
	
	return ret;
}

public string GetColumnName(ColumnSchema column)
{
	string ret = "";
	
	switch(column.Name)
	{
		case "COLUMN1":
			ret = "Column1";
			break;
		case "COLUMN2":
			ret = "Column2";
			break;
		case "COLUMN3":
			ret = "Column3";
			break;
		case "COLUMN4":
			ret = "Column4";
			break;
		case "COLUMN5":
			ret = "Column5";
			break;
		case "COLUMN6":
			ret = "Column6";
			break;
		case "COLUMN7":
			ret = "Column7";
			break;
		case "COMPANY_CD":
			ret = "CompanyCd";
			break;
		case "DEL_CD":
			ret = "DelCd";
			break;
		case "REG_DATE_TIME":
			ret = "RegDateTime";
			break;
		case "REG_USER_ID":
			ret = "RegUserId";
			break;
		case "UPD_DATE_TIME":
			ret = "UpdDateTime";
			break;
		case "UPD_USER_ID":
			ret = "UpdUserId";
			break;
		case "COUNTRY_CD":
			ret ="CountryCd";
			break;
		case "MARKET_CD":
			ret = "MarketCd";
			break;
		case "BRANCH_CD":
			ret = "BranchCd";
			break;
		
		case "TRANSACTION_CD":
			ret = "TransactionCd";
			break;
			
		case "USER_ID":
			ret = "UserID";
			break;
			
		default: 
			ret ="";
			break;
	}
	
	if(ret == "")
	{
		ret = this.GetColumnNameString(column).Replace(" ","");
	}
	
	if(ret == "")
	{
		ret = column.Name;
	}
	
	return ret;
}

public string GetCurrentDate()
{
	return DateTime.Today.ToString("yyyy/MM/dd");
}

public string GetColumnNameString(ColumnSchema column)
{
	string ret = "";
	string[] strArray = column.Name.Split('_');
	foreach( string str in strArray)
	{
		if(!string.IsNullOrEmpty(str) && str != " ")
		{
			ret += str.Substring(0,1) + str.Substring(1, str.Length - 1).ToLower() + " ";
		}
	}
	
	return ret.Trim();
}

public string GetTablename(TableSchema table)
{
	switch(table.Name)
	{
		case "MSTTSECURITIES_COMPANY":
			return "MstTSecurities_Company";
		
		case "MSTTMARKET":
			return "MstTMarket";
			
		case "MSTTPARAMETER_ADDITION":
			return "MstTParameter_Addition";
			
		case "MSTTPARAMETER":
			return "MstTParameter";
			
		case "MSTTSECURITIES":
			return "MstTSecurities";
			
		case "MSTTTRANSFERACCOUNT":
			return "MstTTransferAccount";
			
		case "MSTTTRANSFERCONTRACT":
			return "MstTTransferContract";
			
		case "MSTTPARAMETER_BANK":
			return "MstTParameter_Bank";
		
		case "MSTTFIELD_NAME":
			return "MstTField_Name";
		
		case "MSTTCUSTODIAN":
			return "MstTCustodian";
		
		case "TDTIME_DEPOSIT":
			return "TdTime_Deposit";
		
		case "TDTIME_DEPOSIT_DETAIL":
			return "TdTime_Deposit_Detail";
			
		case "MSTTCURRENCY":
			return "MstTCurrency";
			
		case "TDTTDP_CONTRACT":
			return "TdTTdp_Contract";
		
		case "TDTTIME_DEPOSIT":
			return "TdTTime_Deposit";
			
		case "TDTTIME_DEPOSIT_DETAIL":
			return "TdTTime_Deposit_Detail";
		
		case "MSTTBANK":
			return "MstTBank";
			
		case "MSTTBRANCH":
			return "MstTBranch";
		
		case "MSTTCODE":
			return "MstTCode";
			
		case "MSTTHOLIDAY":
			return "MstTHoliday";
		
		case "MSTTPARAMETER_BANK_DETAIL":
			return "MstTParameter_Bank_Detail";
		
		case "TDTTDP_PAYMENT":
			return "TdTTdp_Payment";
			
		case "MSTTCOUNTRY":
			return "MstTCountry";	
		
		case "DPTTCONTRACT":
			return "DptTContract";
		
		case "DPTTPAYMENT":
			return "DptTPayment";
			
		case "DPTTTIME_DEPOSIT_DETAIL":
			return "DptTTime_Deposit_Detail";
			
		case "DPTTTIME_DEPOSIT":
			return "DptTTime_Deposit";
			
		case "CORTAPPROVEMENT":
			return "CorTApprovement";
		
		case "CORTCASH_BALANCE_HISTORY":
			return "CorTCash_Balance_History";
			
		case "CORTCASH_BALANCE_TODAY":
			return "CorTCash_Balance_Today";
			
		case "CORTCASH_MOVEMENT_HISTORY":
			return "CorTCash_Movement_History";
			
		case "CORTCASH_MOVEMENT":
			return "CorTCash_Movement";
			
		case "CORTCASH_SUMMARY_TODAY":
			return "CorTCash_Summary_Today";
			
		case "CORTCASH_SUMMARY_HISTORY":
			return "CorTCash_Summary_History";
			
		case "CORTSEC_BALANCE_HISTORY":
			return "CorTSec_Balance_History";
			
		case "CORTSEC_BALANCE_TODAY":
			return "CorTSec_Balance_Today";
			
		case "CORTSEC_MOVEMENT_HISTORY":
			return "CorTSec_Movement_History";
			
		case "CORTSEC_MOVEMENT":
			return "CorTSec_Movement";
			
		case "MSTTUTILITY":
			return "MstTUtility";
			
		case "MSTTUTILITY_CASH":
			return "MstTUtility_Cash";
			
		case "PATPAY_ADVANCE":
			return "PATPAY_ADVANCE";
			
		case "CORTADOPT_CUSTOMER_CODE":
			return "CorTAdopt_Customer_Code";
			
		case "CORTCUSTOMER":
			return "CorTCustomer";
			
		case "CORTCUSTOMER_ADDRESS":
			return "CorTCustomer_Address";
			
		case "CORTCUSTOMER_ATTRIBUTE":
			return "CorTCustomer_Attribute";
			
		case "TRATTRANSFER_CONTRACT":
			return "TraTTransfer_Contract";
			
		case "TRATTRANSFER_CONTRACT_BANK":
			return "TraTTransfer_Contract_Bank";
			
		case "TRATTRANSFER_BANK":
			return "TraTTransfer_Bank";
			
		case "TRATTRANSFER_LOCAL":
			return "TraTTransfer_Local";
			
		case "CORTCASH_TRANSACTION":
			return "CorTCash_Transaction";
			
		case "CORTSEC_TRANSACTION":
			return "CorTSec_Transaction";
			
		case "PADTPAY_ADVANCE_HISTORY":
			return "PadTPay_Advance_History";
			
		case "PADTPAY_ADVANCE":
			return "PadTPay_Advance";
			
		case "MSTTADOPT_CUSTOMER_CODE":
			return "MstTAdopt_Customer_Code";
			
		case "ORDTMATCH_ORDER":
			return "OrdTMatch_Order";
			
		case "TRATTRANSFER_CONTRACT_LOCAL":
			return "TraTTransfer_Contract_Local";
			
		case "RHTTRIGHT_INFO":
			return "RhtTRight_Info";
			
		case "RHTTSTOCK_RETENTION":
			return "RhtTStock_Rentention";
		
		case "MSTTUTILITY_SEC":
			return "MstTUtility_Sec";
			
		case "RHTTCUSTOMER_EXTERNAL":
			return "RhtTCustomer_External";
			
		case "INFT0UAUTHUSER":
			return "InfT0UAuthUser";
			
		case "CORTCUSTOMER_AGREEMENT":
			return "CorTCustomer_Agreement";
		
		case "CORTCUSTOMER_BANK":
			return "CorTCustomer_Bank";
			
		case "CORTCUSTOMER_ENTRUST":
			return "CorTCustomer_Entrust";
			
		case "CORTCUSTOMER_ENTRUST_DETAIL":
			return "CorTCustomer_Entrust_Detail";
			
		case "CORTCUSTOMER_INSIDER":
			return "CorTCustomer_Insider";
		
		case "CORTCUSTOMER_PENDING":
			return "CorTCustomer_Pending";
			
		case "CORTCUSTOMER_RESTRICTION":
			return "CorTCustomer_Restriction";
			
		case "CORTCUSTOMER_SIGNER":
			return "CorTCustomer_Signer";
			
		case "DPTTUNFIXED_INTEREST":
			return "DptTUnfixed_Interest";
			
		case "DPTTDEPOSIT_UNFIX":
			return "DptTDeposit_Unfix";
			
		case "DPTTDEPOSIT_DETAIL_UNFIX":
			return "DptTDeposit_Detail_Unfix";
			
		case "RHTTCASH_DIVIDEND":
			return "RhtTCash_Dividend";
			
		case "KPTTCUSTODIAN_FEE_CONFIG":
			return "KptTCustodian_Fee_Config";
			
		case "KPTTCUSTODIAN_FEE":
			return "KptTCustodian_Fee";
			
		case "KPTTCUSTODIAN_FEE_DETAIL":
			return "KptTCustodian_Fee_Detail";
			
		case "KPTTSEC_ACCEPTANCE":
			return "KptTSec_Acceptance";
			
		case "KPTTSEC_DELIVERY":
			return "KptTSec_Delivery";
			
		case "KPTTODD_SELL":
			return "KptTOdd_Sell";
			
		case "RHTTSTOCK_DIVIDEND":
			return "RhtTStock_Dividend";
			
		case "KPTTCOMPANY_MOVEMENT":
			return "KptTCompany_Movement";
			
		case "KPTTCOM_MOVE_DETAIL":
			return "KptTCom_Move_Detail";
			
		case "CORTCASH_MOVEMENT_PREVIEW":
			return "CorTCash_Movement_Preview";
			
		case "CORTSEC_MOVEMENT_PREVIEW":
			return "CorTSec_Movement_Preview";
			
		case "MSTTUTILITY_MAPPING":
			return "MstTUtility_Mapping";
		
		case "CORTCUSTOMER_GROUP":
			return "CorTCustomer_Group";
		
		case "CORTCUSTOMER_GROUP_DETAIL":
			return "CorTCustomer_Group_Detail";
		
		case "CORTUSER":
			return "CorTUser";
			
		case "CORTUSER_CUSTOMERGROUP":
			return "CorTUser_CustomerGroup";	
		
		case "CORTUSER_GROUP":
			return "CorTUser_Group";
		
		case "CORTUSER_USERGROUP":
			return "CorTUser_UserGroup";
			
		case "CORTUSER_GROUP_DETAIL":
			return "CorTUser_Group_Detail";
			
		case "PADTPAY_ADVANCE_RATE":
			return "PadTPay_Advance_Rate";
			
		case "CORTCUSTOMER_BLOCK":
			return "CorTCustomer_Block";
			
		case "RHTTSTOCK_MERGE":
			return "RhtTStock_Merge";
		
		case "DPTTDEPOSIT_UNFIX_DETAIL":
			return "DptTDeposit_Unfix_Detail";
			
		case "RHTTSTOCK_SPLIT":
			return "RhtTStock_Split";
		
		case "CORTBUSINESS_ROLE":
			return "CorTBusiness_Role";
		
		case "CORTBUSINESS_ROLE_GROUP":
			return "CorTBusiness_Role_Group";
		
		case "CORTBUSINESS_ROLE_USER":
			return "CorTBusiness_Role_User";
		
		case "ORDTTRADE_FEE":
			return "OrdTTrade_Fee";
		
		case "ORDTTRADE_FEE_RATE":
			return "OrdTTrade_Fee_Rate";
		
		case "ORDTTRADE_FEE_RATE_DETAIL":
			return "OrdTTrade_Fee_Rate_Detail";
		
		case "ORDTTRADE_FEE_SPECIAL":
			return "OrdTTrade_Fee_Special";
		
		case "RHTTDELISTING":
			return "RhtTDelisting";
			
		case "RHTTCAPITAL_INCREASE":
			return "RhtTCapital_Increase";
		
		case "RHTTCAPITAL_INCREASE_APP":
			return "RhtTCapital_Increase_App";

		case "RHTTCAPITAL_INCREASE_TRANSFER":
			return "RhtTCapital_Increase_Transfer";
			
		case "RHTTBOND_CONVERTION":
			return "RhtTBond_Convertion";
		
		case "RHTTBOND_CONVERTION_APP":
			return "RhtTBond_Convertion_App";
			
		case "CORTBUSINESS_DATE":
			return "CorTBusiness_Date";
		
		case "ORDTSETTLE_CONFIG":
			return "OrdTSettle_Config";
		
		case "ORDTSETTLE_CONFIG_DETAIL":
			return "OrdTSettle_Config_Detail";
		
		case "ORDTSETTLEMENT":
			return "OrdTSettlement";
			
		case "RHTTSTOCK_CHANGE":
			return "RhtTStock_Change";
			
		case "BRKTBROKER":
			return "BrkTBroker";
		
		case "BRKTBROKER_MANAGE_FEE":
			return "BrkTBroker_Manage_Fee";
			
		case "CORTCUSTOMER_GROUP_RESTRICTION":
			return "CorTCustomer_Group_Restriction";
			
		case "TRATTRANSFER_SECURITIES":
			return "TraTTransfer_Securities";
		
		case "DPTTDEBT_RATE":
			return "DptTDebt_Rate";
			
		case "DPTTDEBT_RATE_CUSTOMER":
			return "DptTDebt_Rate_Customer";
			
		case "DPTTDEBT_RATE_DETAIL":
			return "DptTDebt_Rate_Detail";
		
		case "RHTTSTOCK_REGISTER":
			return "RhtTStock_Register";
			
		case "BRKTBROKER_TRADE_DETAIL":
			return "BrkTBroker_Trade_Detail";
			
		case "BRKTBROKER_INCOME_DETAIL":
			return "BrkTBroker_Income_Detail";
		
		case "DPTTDEBT_CONTRACT":
			return "DptTDebt_Contract";
			
		case "DPTTDEBT_PAYMENT":
			return "DptTDebt_Payment";
		
		case "BRKTBROKER_FEE":
			return "BrkTBroker_Fee";
			
		case "BRKTBROKER_FEE_DETAIL":
			return "BrkTBroker_Fee_Detail";
		
		case "BRKTBROKER_SEC":
			return "BrkTBroker_Sec";
		
		case "KPTTDEPOSIT_TRANSFER":
			return "KptTDeposit_Transfer";
		
		case "KPTTDEPOSIT_TRANSFER_DETAIL":
			return "KptTDeposit_Transfer_Detail";
			
		case "MRGTMARGIN_DEBTTYPE":
			return "MrgTMargin_DebtType";

		case "MRGTMARGIN_INTEREST":
			return "MrgTMargin_Interest";
		
		case "MRGTMARGIN_SECURITIES":
			return "MrgTMargin_Securities";
		
		case "MRGTMARGIN_SEC_CUSTGROUP":
			return "MrgTMargin_Sec_CustGroup";
		
		case "MRGTMARGIN_ATTRIBUTE":
			return "MrgTMargin_Attribute";
			
		case "BRKTBROKER_LIMIT":
			return "BrkTBroker_Limit";
		
		case "MRGTMARGIN_CONTRACT":
			return "MrgTMargin_Contract";
			
		case "CORTSUB_ACCOUNT":
			return "CorTSub_Account";
			
		case "RHTTSTOCK_RETENTION_DETAIL":
			return "RhtTStock_Retention_Detail";
		
		case "SSATSECURITIES_BALANCE":
			return "SsaTSecurities_Balance";
		
		case "SSATTRANSACTION":
			return "SsaTTransaction";
		
		case "SSATORDER":
			return "SsaTOrder";
		
		case "SSATORDER_MATCH":
			return "SsaTOrder_Match";
		
		case "SSATTRANSACTION_DETAIL":
			return "SsaTTransaction_Detail";
		
		case "PRMTPROMOTION":
			return "PrmTPromotion";
		
		case "PRMTPROMOTION_PERIOD":
			return "PrmTPromotion_Period";
		
		case "PRMTPROMOTION_PRIORITY":
			return "PrmTPromotion_Priority";
		
		case "SYSTREPORT_PARAM":
			return "SysTReport_Param";
		
		case "SYSTREPORT_LOG":
			return "SysTReport_Log";
		
		case "PFLTPORTFOLIO_PRIVATE":
			return "PflTPortfolio_Private";
		
		case "INFT19ANSWER":
			return "InfT19Answer";
		
		case "SSATDEAL":
			return "SsaTDeal";
		
		case "SRVTSERVICE":
			return "SrvTService";
		
		case "SRVTSERVICE_CUSTOMER":
			return "SrvTService_Customer";
		
		case "SRVTSERVICE_CUSTOMER_DETAIL":
			return "SrvTService_Customer_Detail";
		
		case "SRVTSERVICE_DETAIL":
			return "SrvTService_Detail";
		
		case "SRVTSERVICE_FEE":
			return "SrvTService_Fee";
		
		case "SRVTCUSTOMER_FREE":
			return "SrvTCustomer_Free";
		
		case "MSTTACCOUNT_MAPPING":
			return "MstTAccount_Mapping";
		
		case "ARDTADVANCE_DIVIDEND":
			return "ArdTAdvance_Dividend";
		
		case "PRMTPROMOTION_RANGE":
			return "PrmTPromotion_Range";
		
		case "PRMTPROMOTION_CUST":
			return "PrmTPromotion_Cust";
		
		case "PRMTPROMOTION_SEC":
			return "PrmTPromotion_Sec";
		
		case "PRMTPROMOTION_RESULT":
			return "PrmTPromotion_Result";
		
		case "KPTTCUST_FINALIZE":
			return "KptTCust_Finalize";
		
		case "KPTTCUST_FINALIZE_DETAIL":
			return "KptTCust_Finalize_Detail";
		
		case "MORTSECURITIES":
			return "MorTSecurities";
		
		case "CORTAUTO_CONFIG":
			return "CorTAuto_Config";
		
		case "CORTINT_DAYS_CONFIG":
			return "CorTInt_Days_Config";
		
		case "CORTINT_DAYS_CONFIG_DETAIL":
			return "CorTInt_Days_Config_Detail";
		
		case "CORTINT_DAYS_CUSTGROUP":
			return "CorTInt_Days_CustGroup";
		
		case "MORTMORTGAGE_ATTRIBUTE":
			return "MorTMortgage_Attribute";
		
		case "MORTSECURITIES_CUSTGROUP":
			return "MorTSecurities_CustGroup";
		
		case "MORTINTEREST_CONFIG":
			return "MorTInterest_Config";
		
		case "CORTBUSINESS_LIMIT":
			return "CorTBusiness_Limit";
		
		case "MORTCONTRACT":
			return "MorTContract";
		
		case "MRGTDEBIT_CONTRACT":
			return "MrgTDebit_Contract";
		
		case "DPTTDEBT_INTEREST":
			return "DptTDebt_Interest";
		
		case "CORTINT_FIX_CONFIG":
			return "CorTInt_Fix_Config";
		
		case "CORTINT_FIX_CONFIG_DETAIL":
			return "CorTInt_Fix_Config_Detail";
		
		case "CORTINT_FIX_CUSTGROUP":
			return "CorTInt_Fix_CustGroup";
		
		case "ADMTADMIN_GROUP":
			return "AdmTAdmin_Group";
		
		case "ADMTADMIN_GROUP_DETAIL":
			return "AdmTAdmin_Group_Detail";
		
		case "ADMTADMIN_GROUP_MESSAGE":
			return "AdmTAdmin_Group_Message";
		
		case "ADMTADMIN_MESSAGE_CONFIG":
			return "AdmTAdmin_Message_Config";
		
		case "ADMTADMIN_USER":
			return "AdmTAdmin_User";
		
		case "SRVTSMS_FEE":
			return "SrvTSms_Fee";
		
		case "SRVTSMS_FEE_MONTH":
			return "SrvTSms_Fee_Month";
		
		case "ARDTADVANCE_SECURITIES":
			return "ArdTAdvance_Securities";
			
		case "IPOTINFO":
			return "IpoTInfo";
		
		case "IPOTINFO_ROLES":
			return "IpoTInfo_Roles";
		
		case "IPOTORDER":
			return "IpoTOrder";
		
		case "IPOTTRANSACTION":
			return "IpoTTransaction";
			
		case "MSTTCONTRACT":
			return "MstTContract";
			
		case "MSTTCONTRACT_ATTACH":
			return "MstTContract_Attach";
			
		case "MSTTCONTRACT_DETAIL":
			return "MstTContract_Detail";
			
		case "MSTTCONTRACT_TYPE":
			return "MstTContract_Type";
			
		case "MSTTCONTRACT_PARAM":
			return "MstTContract_Param";
		
		case "CBOTCORPORATE_INFO":
			return "CboTCorporate_Info";
			
		case "CBOTBOND_CONTRACT":
			return "CboTBond_Contract";
		
		case "CBOTBOND_INFO":
			return "CboTBond_Info";

		case "CBOTINT_PERIOD_CONFIG":
			return "CboTInt_Period_Config";

		case "CBOTINT_PERIOD_CONFIG_DETAIL":
			return "CboTInt_Period_Config_Detail";
		
		case "CBOTINTEREST":
			return "CboTInterest";
		
		case "CBOTINTEREST_TRANSACTION":
			return "CboTInterest_Transaction";
		
		case "CBOTPAYMENT_ACC_INFO":
			return "CboTPayment_Acc_Info";
		
		case "OEFTFUND_ATTRIBUTE":
			return "OefTFund_Attribute";
		
		case "OEFTFUND_NAV":
			return "OefTFund_Nav";
		
		case "OEFTFUND_FEE":
			return "OefTFund_Fee";
		
		case "OEFTFUND_FEE_DETAIL":
			return "OefTFund_Fee_Detail";

		default:
		{
			return table.Name;
		}
	}
}

public string getConvertTableName(TableSchema table){
	string ret = table.Name.Substring(0,1) + table.Name.Substring(1,2).ToLower() + table.Name.Substring(3,1);
	string[] strArray = table.Name.Substring(4,table.Name.Length-4).Split('_');
	foreach( string str in strArray)
	{
		if(!string.IsNullOrEmpty(str) && str != " ")
		{
			ret += str.Substring(0,1) + str.Substring(1, str.Length - 1).ToLower();
		}
	}
	
	return ret.Trim();
}

public string getTableClassName(TableSchema table){
	string ret = "";
	
	string[] strArray = table.Name.Split('_');
	foreach( string str in strArray)
	{
		if(!string.IsNullOrEmpty(str) && str != " ")
		{
			ret += str.Substring(0,1) + str.Substring(1, str.Length - 1).ToLower();
		}
	}
	
	return ret.Trim();
}

public string getTableClassDescription(TableSchema table){
	string ret = "";
	
	string[] strArray = table.Name.Split('_');
	foreach( string str in strArray)
	{
		if(!string.IsNullOrEmpty(str) && str != " ")
		{
			ret += str.Substring(0,1) + str.Substring(1, str.Length - 1).ToLower() + " ";
		}
	}
	
	return ret.Trim();
}

public string GetCShapColumnDataType(ColumnSchema column)
{
	switch (column.DataType)
	{
		case DbType.String:
		case DbType.StringFixedLength:
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
			return "string";
			
		case DbType.Int16:
		case DbType.Int32:
		case DbType.Int64:
		case DbType.Single:

		case DbType.UInt16:
		case DbType.UInt32:
		case DbType.UInt64:
		case DbType.VarNumeric:
		case DbType.Decimal:
		case DbType.Double:
		case DbType.Byte:
			return "decimal";
		
		case DbType.Currency:
			return column.DataType.ToString();
		
		case DbType.Binary:
			return column.DataType.ToString();
		
		case DbType.Boolean:	//return "bool";
			return column.DataType.ToString();
			
		case DbType.Time:		// return "TimeSpan";
		case DbType.Date:		// return "DateTime";
		case DbType.DateTime:	// return "DateTime";
			return column.AllowDBNull ? "DateTime?" : "DateTime";
		
		case DbType.Object:		// return "object";
			if(column.Name.ToUpper().Contains("TIME") || column.Name.ToUpper().Contains("DATE"))
				return "Date";
			return column.DataType.ToString();
		case DbType.Guid:		// return "Guid";
		
		case DbType.SByte:		// return "sbyte";
		
		default:
		{
			return column.DataType.ToString();
		}
	}
}

public string GetSqliteColumnDataType(ColumnSchema column)
{
	switch (column.DataType)
	{
		case DbType.String:
		case DbType.StringFixedLength:
		case DbType.AnsiString:
		case DbType.AnsiStringFixedLength:
			return "System.Data.DbType.String";
			
		case DbType.Int16:
		case DbType.Int32:
		case DbType.Int64:
		case DbType.Single:

		case DbType.UInt16:
		case DbType.UInt32:
		case DbType.UInt64:
		case DbType.VarNumeric:
		case DbType.Decimal:
		case DbType.Double:
		case DbType.Byte:
			return "System.Data.DbType.Decimal";
		
		case DbType.Currency:
			return column.DataType.ToString();
		
		case DbType.Binary:
			return column.DataType.ToString();
		
		case DbType.Boolean:	//return "bool";
			return "System.Data.DbType.Boolean";
			
		case DbType.Time:		// return "TimeSpan";
		case DbType.Date:		// return "DateTime";
		case DbType.DateTime:	// return "DateTime";
			return "System.Data.DbType.DateTime";
		
		case DbType.Object:		// return "object";
			if(column.Name.ToUpper().Contains("TIME") || column.Name.ToUpper().Contains("DATE"))
				return "System.Data.DbType.DateTime";
			return column.DataType.ToString();
		case DbType.Guid:		// return "Guid";
		
		case DbType.SByte:		// return "sbyte";
		
		default:
		{
			return column.DataType.ToString();
		}
	}
}

public bool isSpecialColumn(ColumnSchema column){
	if(column.Name == "ID" || column.Name == "REG_DATE_TIME" || column.Name == "REG_USER_ID" || column.Name == "UPD_DATE_TIME" || column.Name == "UPD_USER_ID"){
		return true;
	}else{
		return false;
	}
}

public bool isUpdColumn(ColumnSchema column){
	if(column.Name == "REG_DATE_TIME" || column.Name == "REG_USER_ID" || column.Name == "UPD_DATE_TIME" || column.Name == "UPD_USER_ID"){
		return true;
	}else{
		return false;
	}
}

</script>
