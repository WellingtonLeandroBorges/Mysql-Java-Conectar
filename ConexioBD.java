package com.basedatos.conex;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//import java.sql.Date;
//import java.sql.SQLException;




public class ConexioBD {
	private Connection con;
	private Statement st;
	private ResultSet rs;
	
	public ConexioBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/chat?","root","");
			st = con.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void getDatos() {
		try {
			String query = "SELECT * FROM users_";
			rs = st.executeQuery(query);
			 while (rs.next()) {
				String codigo = rs.getString("cod_");
				String usuario = rs.getString("uses");
				String nombr = rs.getString("nombre");
				System.out.println("--\n"+codigo+"\\n\""+usuario+"\\n\""+""+nombr);
		                       }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	
	public void insDatos() {
		try {
			
			String query = "INSERT INTO users_ (uses, nombre) VALUES ('mss','pes')";
			 st.executeUpdate(query);
			System.out.println("REGISTRADO!");
	                       
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	public void actDatos() {
		try {
			
			String query = "UPDATE users_ SET uses='juan' WHERE cod_='3'";
			 st.executeUpdate(query);
			System.out.println("ACTUALIZADO!");
	                       
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	
	public void delDatos() {
		try {
			
			String query = "DELETE FROM users_  WHERE cod_=7";
			 st.executeUpdate(query);
			System.out.println("Eliminado!");
	                       
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void buscDatos(String datoIngresado) {
		try {
			
			String query = "SELECT * FROM users_ Where uses LIKE '%"+datoIngresado+"%'";
			rs = st.executeQuery(query);
			 while (rs.next()) {
				String codigo = rs.getString("cod_");
				String usuario = rs.getString("uses");
				String nombr = rs.getString("nombre");
				System.out.println("--\n"+codigo+"\\n\""+usuario+"\\n\""+""+nombr);
			 				}             
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
