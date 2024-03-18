package databaseManagement;

public class SQLStatements {
	
	public SQLStatements() {
		
	}
	
	// Create select statement for specific column
	public static String Select(String column, String table, String entry) {
		
		String select = String.format("SELECT %s FROM TCRS.%s WHERE %s='%s'", column, table, column, entry);
		
		return select;
	}
	
	// Select statement for entire row entry, '*" = column
	public static String Select(char column, String table, String entry) {
		
		String select = String.format("SELECT %s FROM TCRS.%s WHERE %s='%s'", column, table, "ACCOUNTID", entry);
		
		return select;
	}
	
	// Select statement for entire row entry, '*" = column
		public static String Select(char column, String table, int entry) {
			
			String select = String.format("SELECT %s FROM TCRS.%s WHERE %s='%s'", column, table, "ACCOUNTID", entry);
			
			return select;
		}
		
	
	// Create delete statement method using a string for the primary key
	public static String Delete(String table, String column, String entry) {
		
		String delete = String.format("DELETE FROM TCRS.%s WHERE %s='%s'", table, column, entry);
		
		return delete;
		
	}
	
	// Delete statement using an integer as the primary key
	public static String Delete(String table, String column, int entry) {
		
		String delete = String.format("DELETE FROM TCRS.%s WHERE %s='%s'", table, column, entry);
		
		return delete;
		
	}
	
}
