package com.prueba.prueba_tecnica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.swing.*;
import java.sql.*;

@SpringBootApplication
public class PruebaTecnicaApplication {

	public static void main(String[] args) {

		String BD = "jdbc:postgresql://localhost:5432/prueba_tecnica";
		String usuario = "postgres";
		String pass = "Luparo11";

		try {
			Connection cn = DriverManager.getConnection(BD, usuario, pass);
			JOptionPane.showMessageDialog(null, "Succesfull");
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Fail" + e);
		}

		SpringApplication.run(PruebaTecnicaApplication.class, args);
	}

}
