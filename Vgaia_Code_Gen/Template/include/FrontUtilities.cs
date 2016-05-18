public string GetEntityName(TableSchema table)
{
	string result ="";
	
	switch(table.Name)
	{
		case "1":
			result = "AppSettings";
			break;
		case "2":
			result = "CashBalance";
			break;
		default:
		
			break;
	}
		
	return string.Empty;
}
