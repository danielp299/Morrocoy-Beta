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
	public int EnemigoTotal;
	public int BonusTotal;
	public int puntuacionActual;
	public int EnemigoActual;
	public int BonusActual;
	public float volumen;
	public infoNivel Niveles[];// tal vez un array
	public infoRecompensa Recompensas[];
	public infoRecompensa RecompensasEquipasas[];
	public infoLogro Logros[];
	public int idioma = 0;
	
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
		Recompensas = new infoRecompensa[120];
		for(int i =0 ; i < 120; i++){
			Recompensas[i] = new infoRecompensa();
		}
		RecompensasEquipasas = new infoRecompensa[5];
		for(int i =0 ; i < 5; i++){
			RecompensasEquipasas[i] = new infoRecompensa();
		}
		Logros = new infoLogro[64];
		for(int i =0 ; i < 64; i++){
			Logros[i]=new infoLogro();
		}
		Niveles[0].bloquedo = false;
		volumen = 1;
	}
	
	public void actualizarPerfilv2(Perfil_jugador perfilV1){
		nombre = perfilV1.nombre;
		tortuga = perfilV1.tortuga;
		puntuacionTotal = puntuacionActual= perfilV1.puntuacionTotal;
		EnemigoTotal = EnemigoActual= perfilV1.puntuacionTotal;
		BonusTotal = BonusActual= perfilV1.puntuacionTotal;
		idioma = perfilV1.idioma;
		for(int i =0 ; i < 9; i++){
			Niveles[i] = perfilV1.Niveles[i];
		}
		
		
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
		boolean todosLosPuntos;
		boolean todosLosConejos;
		boolean todoslospoderes;
		
		
		
		public infoNivel() {
			// TODO Auto-generated constructor stub
			setNivel(0,true,0,false,false,false);
		}

		public void setNivel(int _nivel, boolean _bloquedo,
				int _puntos,
				boolean _todosLosPuntos,
				boolean _todosLosConejos,
				boolean _todoslospoderes){
					nivel = _nivel;
					bloquedo =_bloquedo;
					todosLosPuntos = _todosLosPuntos;
					todosLosConejos = _todosLosConejos;
					todosLosConejos = todoslospoderes;
					
				}
	}
	
	public class infoRecompensa implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int id;
		
	}
	
	public class infoLogro implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		int id;
		int rango;
		boolean bloqueado;
		
		public infoLogro() {
			// TODO Auto-generated constructor stub
			setLogro(0, 0, true);
		}
		
		public void setLogro(int id,int rango,boolean bloqueado){
			this.id = id;
			this.bloqueado = bloqueado;
			this.rango = rango;
		}
	}

}
