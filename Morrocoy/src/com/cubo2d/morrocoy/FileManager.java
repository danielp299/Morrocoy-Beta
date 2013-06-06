package com.cubo2d.morrocoy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;

public class FileManager {
	FileHandle archivo;
	ByteArrayInputStream arrayInput;
	ByteArrayOutputStream arrayOutput;
	ObjectOutputStream objectOut;
	ObjectInputStream objectInput;
	byte [] datos;
	
	public FileManager() {
		// TODO Auto-generated constructor stub
		archivo = Gdx.files.local("file.bin");
	}

	public Perfil_jugador leer(){
		
		if(archivo.exists()){
			arrayInput = null;
			objectInput = null;
			
			arrayInput = new ByteArrayInputStream(archivo.readBytes());
			try {
				objectInput = new ObjectInputStream(arrayInput);
				Perfil_jugador  p= (Perfil_jugador) objectInput.readObject();
				//System.out.println("jugador cargado"+p.nombre);
				return p;
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			System.out.println("jugador nuevo");
		}
		return null;
	}
	
	
	public void escribir(Perfil_jugador jugador){
		
		
		
		arrayOutput = new ByteArrayOutputStream();
		try {
			objectOut = new ObjectOutputStream(arrayOutput);
			
			objectOut.writeObject(jugador);
			objectOut.flush();
			
			datos = null;
			datos = arrayOutput.toByteArray();
			// escribir en el archivo
			archivo.writeBytes(datos, false);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
