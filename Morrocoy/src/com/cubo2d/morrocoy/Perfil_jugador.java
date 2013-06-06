package com.cubo2d.morrocoy;


import java.io.Serializable;

public class Perfil_jugador implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String nombre;
	public String tortuga;
	public int puntuacionTotal;
	public infoNivel Niveles[];// tal vez un array
	
	public Perfil_jugador() {
		// TODO Auto-generated constructor stub
		nuevo();
	}
	
	public void nuevo(){
		nombre = "Jugador";
		tortuga = "Morrocoy";
		puntuacionTotal = 0;
		Niveles = new infoNivel[Assets.totalNiveles];
		for(int i =0 ; i < Assets.totalNiveles; i++){
			Niveles[i] = new infoNivel();
		}
		Niveles[0].bloquedo = false;
		
	}
	
	
	//---------------------------------------------------------------------------------------
	public class infoNivel implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int nivel;
		boolean bloquedo;
		int puntos;
		int todosLosPuntos;
		int todosLosConejos;
		int todoslospoderes;
		
		
		
		public infoNivel() {
			// TODO Auto-generated constructor stub
			setNivel(0,true,0,0,0,0);
		}

		public void setNivel(int _nivel, boolean _bloquedo,
				int _puntos,
				int _todosLosPuntos,
				int _todosLosConejos,
				int _todoslospoderes){
					nivel = _nivel;
					bloquedo =_bloquedo;
					todosLosPuntos = _todosLosPuntos;
					todosLosConejos = _todosLosConejos;
					todosLosConejos = todoslospoderes;
					
				}
		
		
	
		
	}

}
