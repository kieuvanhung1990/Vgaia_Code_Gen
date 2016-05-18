public string ReturnObjectClass()
{
	string stable = SourceTable.Name.ToString();
	return stable;
}

public string GetDotNetType(ColumnSchema col)
{
	if (col.DataType ==  DbType.Guid)
	{
		return "Guid";
	}
	
	if (col.NativeType == "smalldatetime" || col.NativeType == "date" || col.NativeType == "datetime" || col.NativeType == "datetime2")
	{
		return "DateTime";
	}
	
	if (col.NativeType == "bigint")
	{
		return "long";
	}
	
	if (col.NativeType == "bit")
	{
		return "bool";
	}
	
	if (col.NativeType == "decimal")
	{
		return "decimal";
	}
	
	if (col.NativeType == "float")
	{
		return "decimal";
	}
	
	if (col.NativeType == "int")
	{
		return "int";
	}
	
	if (col.NativeType == "smallint")
	{
		return "short";
	}
	
	if (col.NativeType == "tinyint")
	{
		return "byte";
	}
	
	return "string";
}	


public static string ToLowerFisrtChar(string input)
{
	if (string.IsNullOrEmpty(input))
	{
		return input;
	}
	
	if (input.Length == 1)
	{
		return input;
	}
	
	return string.Format("{0}{1}", input[0].ToString().ToLower(), input.Substring(1, input.Length-1));
}


public string GetSqlDBType(ColumnSchema col)
{
	if (col.DataType ==  DbType.Guid)
	{
		return "SqlDbType.UniqueIdentifier";
	}
	
	if (col.NativeType == "smalldatetime")
	{
		return "SqlDbType.SmallDateTime";
	}
	
	if (col.NativeType == "date" || col.NativeType == "datetime" || col.NativeType == "datetime2")
	{
		return "SqlDbType.DateTime";
	}
	
	if (col.NativeType == "bigint")
	{
		return "SqlDbType.BigInt";
	}
	
	if (col.NativeType == "bit")
	{
		return "SqlDbType.Bit";
	}
	
	if (col.NativeType == "decimal")
	{
		return "SqlDbType.Decimal";
	}
	
	if (col.NativeType == "float")
	{
		return "SqlDbType.Float";
	}
	
	if (col.NativeType == "int")
	{
		return "SqlDbType.Int";
	}
	
	if (col.NativeType == "smallint")
	{
		return "SqlDbType.SmallInt";
	}
	
	if (col.NativeType == "tinyint")
	{
		return "SqlDbType.TinyInt";
	}
	
	if (col.NativeType == "char")
	{
		return "SqlDbType.Char";
	}
	
	if (col.NativeType == "ntext")
	{
		return "SqlDbType.NText";
	}
	
	if (col.NativeType == "nvarchar")
	{
		return "SqlDbType.NVarChar";
	}
	
	if (col.NativeType == "text")
	{
		return "SqlDbType.Text";
	}
	
	if (col.NativeType == "varchar")
	{
		return "SqlDbType.VarChar";
	}
	
	return "";
}	


public void GenerateIndent(int indentLevel)
{
    for (int i = 0; i < indentLevel; i++)
	{
		Response.Write('\t');
	}
}
	

public string GetConvertTo(string inputParam, ColumnSchema col)
{
	if (col.DataType ==  DbType.Guid)
	{
		return string.Format("new Guid({0})", inputParam);
	}
	
	if (col.NativeType == "smalldatetime" || col.NativeType == "date" || col.NativeType == "datetime" || col.NativeType == "datetime2")
	{
		return string.Format("Convert.ToDateTime({0})", inputParam);
	}
	
	if (col.NativeType == "bigint")
	{
		return string.Format("Convert.ToInt64({0})", inputParam);
	}
	
	if (col.NativeType == "bit")
	{
		return string.Format("Convert.ToBoolean({0})", inputParam);
	}
	
	if (col.NativeType == "decimal")
	{
		return string.Format("Convert.ToDecimal({0})", inputParam);
	}
	
	if (col.NativeType == "float")
	{
		return string.Format("Convert.ToDecimal({0})", inputParam);
	}
	
	if (col.NativeType == "int")
	{
		return string.Format("Convert.ToInt32({0})", inputParam);
	}
	
	if (col.NativeType == "smallint")
	{
		return string.Format("Convert.ToInt16({0})", inputParam);
	}
	
	if (col.NativeType == "tinyint")
	{
		return string.Format("Convert.ToByte({0})", inputParam);
	}
	
	return inputParam;
}

public string GetToStringValue(ColumnSchema col)
{
    if (col.DataType ==  DbType.Guid)
    {
        return ".ToString()";
    } else if (col.DataType ==  DbType.Guid || 
        col.NativeType == "smalldatetime" || col.NativeType == "date" || col.NativeType == "datetime" || col.NativeType == "datetime2"
        || col.NativeType == "bit")
	{
		return string.Empty;
	}
	else if (col.NativeType == "bigint" || col.NativeType == "float" || col.NativeType == "int"
        || col.NativeType == "int" || col.NativeType == "smallint" || col.NativeType == "tinyint")
	{
		return ".ToString(\"n0\")";
	}
    else if (col.NativeType == "decimal")
	{
		return string.Format(".ToString(\"n{0}\")", col.Scale);
	}
	
	return string.Empty;
}


public string GetControlName(ColumnSchema col)
{
	if (col.NativeType == "smalldatetime" || col.NativeType == "date" || col.NativeType == "datetime" || col.NativeType == "datetime2")
	{
		return string.Format("{0}Picker", ToLowerFisrtChar(col.Name));
	}
	else if (col.NativeType == "bit")
	{
		return string.Format("{0}CheckBox", ToLowerFisrtChar(col.Name));
	}
    else if (col.NativeType == "tinyint")
    {
        return string.Format("{0}Drop", ToLowerFisrtChar(col.Name));
    }
	else
	{
		return string.Format("{0}TextBox", ToLowerFisrtChar(col.Name));
	}
}

public string GetControlType(ColumnSchema col)
{
	if (col.NativeType == "smalldatetime" || col.NativeType == "date" || col.NativeType == "datetime" || col.NativeType == "datetime2")
	{
		return "Goline.Common.UI.NullableDateTimePicker";
	}
	else if (col.NativeType == "bit")
	{
		return "System.Windows.Forms.CheckBox";
	}
	else if (col.NativeType == "bigint" || col.NativeType == "float" || col.NativeType == "int"
        || col.NativeType == "int" || col.NativeType == "smallint" || col.NativeType == "decimal")
	{
		return "Goline.Common.UI.NumericTextBox";
	}
    else if (col.NativeType == "tinyint")
    {
        return "Goline.Common.UI.GolineComboBox";
    }
    else
	{
		return "System.Windows.Forms.TextBox";
	}
}

public string GetControlValue(ColumnSchema col)
{
	if (col.NativeType == "smalldatetime" || col.NativeType == "date" || col.NativeType == "datetime" || col.NativeType == "datetime2")
	{
		return string.Format("{0}Picker.Value", ToLowerFisrtChar(col.Name));
	}
	else if (col.NativeType == "bit")
	{
		return string.Format("{0}CheckBox.Checked", ToLowerFisrtChar(col.Name));
	}
    else if (col.NativeType == "tinyint")
	{
		return string.Format("{0}Drop.SelectedValue", ToLowerFisrtChar(col.Name));
	}
	else
	{
		return string.Format("{0}TextBox.Text", ToLowerFisrtChar(col.Name));
	}
}

public string GetMangoGridValue(string objectName, ColumnSchema col)
{
	if (GetDotNetType(col) == "string")
	{
		return string.Format("Convert.ToString(r.GetValue({0}Grid.Col_{1}))", objectName, col.Name);
	}
	else
	{
		return string.Format("r.GetValue({0}Grid.Col_{1})", objectName, col.Name);
	}
}