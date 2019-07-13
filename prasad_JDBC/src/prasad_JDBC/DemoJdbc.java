package prasad_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;

public class DemoJdbc {

	public static TreeMap<Integer, Object> map = new TreeMap<Integer, Object>();

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		/*
		 * Class.forName("com.mysql.jdbc.Driver"); Connection con =
		 * DriverManager.getConnection("jdbc:mysql://localhost:3306/prasad","root","");
		 * PreparedStatement st =
		 * con.prepareStatement("insert into emp  values(?,?,?,?)"); st.setInt(1,1);
		 * st.setString(2,"xxx"); st.setInt(3,234134534); st.setString(4,"sf");
		 * st.execute();
		 */

		int n, sum = 0;
		Scanner s = new Scanner(System.in);
		System.out.print("Enter no. of elements you want in array:");
		n = s.nextInt();
		int arr[] = new int[n];
		n = arr.length;

		System.out.println("Enter all the elements:");
		for (int i = 0; i < n; i++) {
			arr[i] = s.nextInt();
		}

		System.out.println("Enter your required sum.");
		sum = s.nextInt();
		System.out.println("Combinations are : ");
		printAllSubsets(arr, n, sum);
	}

	static void printAllSubsetsRec(int arr[], int n, Vector<Integer> v, int sum) {
		if (sum == 0) {
			map.put(v.size(), v);
			for (int i = 0; i < v.size(); i++)
				System.out.print(v.get(i) + " ");
			System.out.println();
			return;
		}

		if (n == 0)
			return;

		printAllSubsetsRec(arr, n - 1, v, sum);
		Vector<Integer> v1 = new Vector<Integer>(v);
		v1.add(arr[n - 1]);
		printAllSubsetsRec(arr, n - 1, v1, sum - arr[n - 1]);
	}

	static void printAllSubsets(int arr[], int n, int sum) {
		Vector<Integer> v = new Vector<Integer>();
		printAllSubsetsRec(arr, n, v, sum);
	}
}
