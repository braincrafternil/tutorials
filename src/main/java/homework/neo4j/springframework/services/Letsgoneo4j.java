/**
 * 
 */
package homework.neo4j.springframework.services;

import org.neo4j.driver.v1.*;
import java.util.*;
import static org.neo4j.driver.v1.Values.parameters;
/**
 * @author n0j00am
 *
 */
public class Letsgoneo4j {

	static Driver driver;
	
	/**
	 * 
	 */
	public Letsgoneo4j() {
		// TODO Auto-generated constructor stub
	}

	
	  // 1
    // Create a Session in the Sandbox DB.
	public static Driver CreateSession(String uri, String user, String password)
	    {
	        driver = GraphDatabase.driver(uri, AuthTokens.basic(user, password));
	        //System.out.println("Creating Connection");
	        return driver;
	    }
	
	// 2
		// Create a Session in the Sandbox DB.
		public void close()
		    {
		        // Closing a driver.
		        driver.close();
		        System.out.println("Closing Connection");
		    }
	

		// 3
		// Create a Employee Node in the Sandbox DB.
		private static void createNode(String name, int empid)
	    {
	        // Sessions are lightweight and disposable connection wrappers.
	        try (Session session = driver.session())
	        {
	            // Wrapping Cypher in an explicit transaction provides atomicity
	            // and makes handling errors much easier.
	            try (Transaction tx = session.beginTransaction())
	            {
	            	tx.run(
	            			"CREATE (a:Employee {name: {x}, emp_id: {y}})", parameters("x", name, "y", empid)
	            			);
	            	// Write Transaction successful.
	            	tx.success();  
	            }
	        }
	    }

		
		private static void deleteNode(String name)
	    {
	        // Sessions are lightweight and disposable connection wrappers.
	        try (Session session = driver.session())
	        {
	            // Wrapping Cypher in an explicit transaction provides atomicity
	            // and makes handling errors much easier.
	            try (Transaction tx = session.beginTransaction())
	            {
	            	      tx.run(
	            	    		  "MATCH (a: Employee {name:{x}}) DELETE a", parameters("x", name)
	            	    		  //"MATCH (a {name:{x}) DELETE a", parameters("x", name) 
	                		);
	                tx.success();  // Mark this write as successful.
	            }
	        }
	    }	
		
		
		// Return all Nodes
		private static StatementResult returnAllNode()
		{
			StatementResult summary ;
			//List<String> summary ;
			   System.out.println("Inside Return All Node");
	        // Sessions are lightweight and disposable connection wrappers.
	        try (Session session = driver.session())
	        {
	       	 summary = session.run( "MATCH (a1) RETURN a1" );   	
	        }                      
	        return summary;
		}
		
		private static void QueryResult(String parametername)
		{				
			try (Session session = driver.session())
			{
				// Auto-commit transactions are a quick and easy way to wrap a read.
				StatementResult result = session.run(
								"MATCH (a:Employee) WHERE a.name = {x} RETURN a.name AS name", parameters("x", parametername));
			    // Each Cypher execution returns a stream of records.
			    while (result.hasNext())
			    {
			    	System.out.println("Inside Query Result");
			    	Record record = result.next();
			        // Values can be extracted from a record by index or name.
			        System.out.println(record.get("name").asString());
			    }
			}
		}
		
		
		
		/**
		 * @param args
		 */
		/*public static void main(String[] args) {
			
			 System.out.println("Print-1");
			  Driver arunSandConnect = CreateSession("bolt://52.3.220.225:33122", "neo4j", "spar-authorizations-wrenches");
			 
		    // Letsgoneo4j.createNode("Ilyssa",1);
			// Letsgoneo4j.createNode("Chris",2);
			// Letsgoneo4j.createNode("Gopal",3);
			// Letsgoneo4j.createNode("Ross",4);
			// Letsgoneo4j.createNode("Arun",5);
			 
			 System.out.println("Print-2");
			// StatementResult allNodes; 
			// System.out.println("Print-3");
			 
			// List<String> allNodes= returnAllNode();
			 
			// Display result of query
			QueryResult("Chris");
						
			System.out.println("Print-3");

				 
			 System.out.println("Print-5");			 
			 
			// Letsgoneo4j.deleteNode("Ilyssa");
			 System.out.println("Print-6");
				 
			 arunSandConnect.close();
		   
		}*/

		
		
		
		
		
		



}
