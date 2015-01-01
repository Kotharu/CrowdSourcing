package TwitterFileProcessing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;


public class dbConnection {
				
				  		  
				  public static void main(String[] args) throws Exception
				  {
					  int x = 0;
					  int result1 = 0;
					  String name = null;
					  String result5;
					  String result6;
					  String result7;
					  float user_init_score = 0;
					  float search_terms = 2;
					  float r_i = 1;
					  float f;
					  float ues;
					  
					  try
					  {
						  try
					        {
					            Class.forName("com.mysql.jdbc.Driver");
					        }
					        catch (ClassNotFoundException e) {
					            System.out.println("MySQL JDBC Driver not found !!");
					            return;
					        }
					    String connectionUrl = "jdbc:mysql://localhost:3306/pervasive";
						String connectionUser = "root";
						String connectionPassword = "touchmenot";
					    Connection con = DriverManager.getConnection(connectionUrl, connectionUser, connectionPassword);
						Statement st = con.createStatement();
						String query1= "select Count(*) from newyork_copy;";
						String query2;
						String query3;
						String query4;
						String query5;
						String query6;
						String query7;
						//String query2= "select username from newyork_copy limit "+ x +","+1;
						//String query3= "select Count(*) from newyork_copy where username ='"+ name +"';";
						ResultSet rs1 = st.executeQuery(query1);
						while(rs1.next())
						{
							result1 = rs1.getInt("count(*)");							 
						}				
						rs1.close();
						
						while(x <= result1){
							query2= "select username from newyork_copy limit "+ x +","+1;
							ResultSet rs2 = st.executeQuery(query2);
							while(rs2.next())
							{
								name = rs2.getString("username");							 
							}	
							rs2.close();
							
							query3= "select Count(*) from newyork_copy where username ='"+ name +"';";
							ResultSet rs3 = st.executeQuery(query3);
							while(rs3.next())
							{
								user_init_score = rs3.getFloat("count(*)");							 
							}	
							rs3.close();
							
							System.out.println(name +"  "+ user_init_score);
							
							f = user_init_score / search_terms ;
							
							ues = f * r_i;
							
							System.out.println(f+"  "+ues);
							
							query4 = "update newyork_copy set ues ="+ues+" where username ='"+ name +"';";
							
							PreparedStatement pst = con.prepareStatement(query4);
							
							pst.executeUpdate();
				            System.out.println("Updated Successfully!");
							
							x++;
						}			
			
			//--------------------------------------  Output into files -----------------------------------------------------------------//
						
						query5 = "select distinct * from newyork_copy order by ues desc limit "+ 5+"";
						
						File file1 = new File("C:/Users/Nagendra/Desktop/Nagendra Data/Newyork files/Swarm data/output/op_5.txt");
						if (!file1.exists()) {
							file1.createNewFile();
						}

						FileWriter fw1 = new FileWriter(file1.getAbsoluteFile(),
								true);
						BufferedWriter bw1 = new BufferedWriter(fw1);
						
						ResultSet rs5 = st.executeQuery(query5);
						while(rs5.next())
						{
							result5 = rs5.getString("coordinates");		
							bw1.write(result5);
							bw1.write("\n");
							
						}		
						bw1.close();
						rs5.close();
						
						
						
						query6 = "select distinct * from newyork_copy order by ues desc limit "+ 10+"";
						File file2 = new File("C:/Users/Nagendra/Desktop/Nagendra Data/Newyork files/Swarm data/output/op_10.txt");
						if (!file2.exists()) {
							file2.createNewFile();
						}

						FileWriter fw2 = new FileWriter(file2.getAbsoluteFile(),
								true);
						BufferedWriter bw2 = new BufferedWriter(fw2);
						
						ResultSet rs6 = st.executeQuery(query6);
						while(rs6.next())
						{
							result6 = rs6.getString("coordinates");		
							bw2.write(result6);
							bw2.write("\n");							
						}		
						bw2.close();
						rs6.close();
						
						
						
						
						
						query7 = "select distinct * from newyork_copy order by ues desc";
						File file3 = new File("C:/Users/Nagendra/Desktop/Nagendra Data/Newyork files/Swarm data/output/op_all.txt");
						if (!file3.exists()) {
							file3.createNewFile();
						}

						FileWriter fw3 = new FileWriter(file3.getAbsoluteFile(),
								true);
						BufferedWriter bw3 = new BufferedWriter(fw3);
						
						ResultSet rs7 = st.executeQuery(query7);
						while(rs7.next())
						{
							result7 = rs7.getString("coordinates");		
							bw3.write(result7);
							bw3.write("\n");							
						}		
						bw3.close();
						rs7.close();
						
						
						st.close();
						con.close();
					   }
					  catch(SQLException e)
					  {
					    e.printStackTrace();	  
					  }
										

					  
				  }
				  		 

}
