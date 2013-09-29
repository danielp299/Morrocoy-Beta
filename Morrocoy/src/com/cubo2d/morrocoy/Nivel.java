package com.cubo2d.morrocoy;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;

public class Nivel {
	
	int nivelActual;
	/*Total de distancia del nivel*/
	public float distancia; 
	/*Cada cuantos metros se generan enemigos*/
	public float frecuenciaEnemigos;
	/*Cada cuantos metros se generan bonuss*/
	public float frecuenciaBonus;
	/*Cada cuantos metros se generan puntos*/
	public float frecuenciaPuntos;
	/*genera enemigo en 1 linea unica*/
	public float enemigo_solo;
	/*genera enemigo en 2 lineas*/
	public float enemigo_doble;
	/*genera enemigo en 2 lineas*/
	public float enemigo_triple;
	/*maximo de puntos del nivel no varia*/
	public float puntos;
	/*total de rapido del nivel no varia*/
	public float rapido;
	/*total de defensa del nivel no varia*/
	public float defensa;
	/*total de comida del nivel no varia*/
	public float comida;
	
	public float velocidadEnemigoMax;
	
	public float velocidadEnemigoMin;
	
	public float velocidad;
	
	public float tipoPoder;
	
	//logros
	public float logroPuntos;
	
	public float logroConejos;
	
	public float logroPoderes;
	
	//piso
	public int piso;
	
	public int nivelesDisponibles = 36;
	
	
	public Nivel() {
		// TODO Auto-generated constructor stub
		velocidadEnemigoMax = 6;
		velocidadEnemigoMin = 4;
		piso = 0;
		enemigo_triple = 0;
	}
	
	public Texture getBackground(){
		
		return null;
	}
	
	public void setNivel(int _nivel){
		nivelActual = _nivel;
		switch (nivelActual) {
		case 1:
			distancia = 800;
			puntos = 30;  
			frecuenciaEnemigos = 30;
			frecuenciaBonus = 80;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble = 0;
			rapido = 40;
			defensa = 40;
			comida = 20;
			velocidad = 4;
			logroPuntos = 10;
			logroConejos =12;
			logroPoderes = 8;
			piso = 0;
			break;
		case 2:
			distancia = 900;
			puntos = 35;
			frecuenciaEnemigos = 30;
			frecuenciaBonus = 100;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =10;
			rapido = 40;
			defensa = 40;
			comida = 20;
			velocidad = 4;
			logroPuntos = 27;
			logroConejos =15;
			logroPoderes = 8;
			piso = 0;
			break;
		case 3:
			distancia = 1000;
			puntos = 40;
			frecuenciaEnemigos = 30;
			frecuenciaBonus = 80;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =12;
			rapido = 40;
			defensa = 40;
			comida = 15;
			velocidad = 4;
			logroPuntos = 31;
			logroConejos =19;
			logroPoderes =10;
			piso = 0;
			break;
		case 4:
			distancia = 1050;
			puntos = 35;
			frecuenciaEnemigos = 30;
			frecuenciaBonus = 110;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =15;
			rapido = 20;
			defensa = 40;
			comida = 10;
			velocidad = 5;
			velocidadEnemigoMax = 4.7f;
			velocidadEnemigoMin = 3.5f;
			logroPuntos = 28;
			logroConejos =21;
			logroPoderes = 8;
			piso = 0;
			break;
		case 5:
			distancia = 1100;
			puntos = 50;
			frecuenciaEnemigos = 29;
			frecuenciaBonus = 80;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =25;
			rapido = 20;
			defensa =60;
			comida = 20;
			velocidad = 5;
			velocidadEnemigoMax = 5;
			velocidadEnemigoMin = 3.2f;
			logroPuntos = 35;
			logroConejos =31;
			logroPoderes = 12;
			piso = 0;
			break;
		case 6:
			distancia = 700;
			puntos = 50;
			frecuenciaEnemigos =22;
			frecuenciaBonus = 70;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =25;
			rapido = 40;
			defensa = 20;
			comida = 5;
			velocidad = 5;
			velocidadEnemigoMax = 4.5f;
			velocidadEnemigoMin = 3.2f;
			logroPuntos = 32;
			logroConejos =25;
			logroPoderes = 7;
			piso = 0;
			break;
		case 7:
			distancia = 1200;
			puntos = 80;
			frecuenciaEnemigos = 21;
			frecuenciaBonus = 110;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =30;
			rapido = 30;
			defensa = 20;
			comida = 20;
			velocidad = 6;
			velocidadEnemigoMax = 4.3f;
			velocidadEnemigoMin = 3.2f;
			logroPuntos = 55;
			logroConejos =42;
			logroPoderes =7;
			piso = 0;
			break;
		case 8:
			distancia = 1250;
			puntos = 65;
			frecuenciaEnemigos = 20;
			frecuenciaBonus = 150;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =30;
			rapido = 40;
			defensa = 60;
			comida = 40;
			velocidad = 6;
			velocidadEnemigoMax = 4.2f;
			velocidadEnemigoMin = 2.8f;
			logroPuntos = 42;
			logroConejos =30;
			logroPoderes = 8;
			piso = 0;
			break;
		case 9:
			distancia = 1100;
			puntos = 60;
			frecuenciaEnemigos = 19;
			frecuenciaBonus = 175;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =50;
			rapido = 50;
			defensa = 60;
			comida = 20;
			velocidad = 5;
			velocidadEnemigoMax = 4.0f;
			velocidadEnemigoMin = 2.5f;
			logroPuntos = 55;
			logroConejos =35;
			logroPoderes =5;
			piso = 0;
			break;
		case 10:
			distancia = 1000;
			puntos = 60;
			frecuenciaEnemigos = 22;
			frecuenciaBonus = 110;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 70;
			enemigo_doble =50;
			rapido = 80;
			defensa = 60;
			comida = 10;
			velocidad = 5;
			velocidadEnemigoMax = 3.9f;
			velocidadEnemigoMin = 2.4f;
			logroPuntos = 30;
			logroConejos =25;
			logroPoderes =8;
			piso = 1;
			break;
		case 11:
			distancia = 800;
			puntos = 60;
			frecuenciaEnemigos = 15;
			frecuenciaBonus = 150;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =10;
			rapido = 50;
			defensa = 60;
			comida = 2;
			velocidad = 5;
			velocidadEnemigoMax = 4.0f;
			velocidadEnemigoMin = 2.3f;
			logroPuntos = 55;
			logroConejos =30;
			logroPoderes =5;
			piso = 1;
			break;
		case 12:
			distancia = 1200;
			puntos = 60;
			frecuenciaEnemigos = 21;
			frecuenciaBonus = 100;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =80;
			rapido = 50;
			defensa = 60;
			comida = 100;
			velocidad = 5;
			velocidadEnemigoMax = 4.0f;
			velocidadEnemigoMin = 2.5f;
			logroPuntos = 30;
			logroConejos =29;
			logroPoderes =6;
			piso = 1;
			break;
		case 13:
			distancia = 1500;
			puntos = 80;
			frecuenciaEnemigos = 19;
			frecuenciaBonus = 120;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 100;
			enemigo_doble =50;
			rapido = 50;
			defensa = 60;
			comida = 2;
			velocidad = 5;
			velocidadEnemigoMax = 3.7f;
			velocidadEnemigoMin = 2.5f;
			logroPuntos = 60;
			logroConejos =32;
			logroPoderes =8;
			piso = 1;
			break;
		case 14:
			distancia = 1100;
			puntos =65;
			frecuenciaEnemigos = 20;
			frecuenciaBonus = 100;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =50;
			rapido = 50;
			defensa = 60;
			comida = 20;
			velocidad = 5;
			velocidadEnemigoMax = 4.2f;
			velocidadEnemigoMin = 2.2f;
			logroPuntos = 49;
			logroConejos =28;
			logroPoderes =8;
			piso = 1;
			break;
		case 15:
			distancia = 800;
			puntos = 60;
			frecuenciaEnemigos = 19;
			frecuenciaBonus = 125;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 120;
			enemigo_doble =50;
			rapido = 70;
			defensa = 60;
			comida = 20;
			velocidad = 4.9f;
			velocidadEnemigoMax = 3.6f;
			velocidadEnemigoMin = 2.0f;
			logroPuntos = 30;
			logroConejos =22;
			logroPoderes =5;
			piso = 1;
			break;
		case 16:
			distancia = 1200;
			puntos = 70;
			frecuenciaEnemigos = 20;
			frecuenciaBonus = 90;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 75;
			enemigo_doble =50;
			rapido = 10;
			defensa = 80;
			comida = 30;
			velocidad = 5;
			velocidadEnemigoMax = 4.0f;
			velocidadEnemigoMin = 2.2f;
			logroPuntos = 50;
			logroConejos =31;
			logroPoderes =12;
			piso = 1;
			break;
		case 17:
			distancia = 1200;
			puntos = 60;
			frecuenciaEnemigos = 19;
			frecuenciaBonus = 150;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 80;
			enemigo_doble =50;
			rapido = 10;
			defensa = 60;
			comida =40;
			velocidad = 5;
			velocidadEnemigoMax = 3.5f;
			velocidadEnemigoMin = 2.5f;
			logroPuntos = 50;
			logroConejos =40;
			logroPoderes =7;
			piso = 1;
			break;
		case 18:
			distancia = 1300;
			puntos = 50;
			frecuenciaEnemigos = 25;
			frecuenciaBonus = 175;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =50;
			rapido = 50;
			defensa = 60;
			comida = 2;
			velocidad = 5;
			velocidadEnemigoMax = 3.0f;
			velocidadEnemigoMin = 1.7f;
			logroPuntos = 40;
			logroConejos =25;
			logroPoderes =5;
			piso = 1;
			break;
		case 19:
			distancia = 990;
			puntos = 60;
			frecuenciaEnemigos = 22;
			frecuenciaBonus = 70;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =50;
			rapido = 50;
			defensa = 60;
			comida = 2;
			velocidad = 4.7f;
			velocidadEnemigoMax = 3.5f;
			velocidadEnemigoMin = 2.2f;
			logroPuntos = 45;
			logroConejos =25;
			logroPoderes =7;
			piso = 2;
			break;
		case 20:
			distancia = 1000;
			puntos = 80;
			frecuenciaEnemigos = 20f;
			frecuenciaBonus = 100;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 70;
			enemigo_doble =50;
			rapido = 100;
			defensa = 60;
			comida = 40;
			velocidad = 4.7f;
			velocidadEnemigoMax = 3.5f;
			velocidadEnemigoMin = 2.5f;
			logroPuntos = 45;
			logroConejos =30;
			logroPoderes =9;
			piso = 2;
			break;
		case 21:
			distancia = 1100;
			puntos = 60;
			frecuenciaEnemigos = 14.5f;
			frecuenciaBonus = 90;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =50;
			rapido = 80;
			defensa = 60;
			comida = 30;
			velocidad = 5;
			velocidadEnemigoMax = 3.0f;
			velocidadEnemigoMin = 2.0f;
			logroPuntos = 45;
			logroConejos =20;
			logroPoderes =9;
			piso = 2;
			break;
		case 22:
			distancia = 1100;
			puntos = 60;
			frecuenciaEnemigos = 22;
			frecuenciaBonus = 175;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =90;
			rapido = 50;
			defensa = 60;
			comida = 2;
			velocidad = 5;
			velocidadEnemigoMax = 3.6f;
			velocidadEnemigoMin = 2.1f;
			logroPuntos = 48;
			logroConejos =30;
			logroPoderes =6;
			piso = 1;
			break;
		case 23:
			distancia = 900;
			puntos = 80;
			frecuenciaEnemigos = 18;
			frecuenciaBonus = 150;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =50;
			rapido = 100;
			defensa = 60;
			comida = 5;
			velocidad = 5;
			velocidadEnemigoMax = 3.9f;
			velocidadEnemigoMin = 2.5f;
			logroPuntos = 65;
			logroConejos =25;
			logroPoderes =4;
			piso = 1;
			break;
		case 24:
			distancia = 800;
			puntos = 60;
			frecuenciaEnemigos = 18;
			frecuenciaBonus = 80;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =100;
			rapido = 50;
			defensa = 80;
			comida = 30;
			velocidad = 5;
			velocidadEnemigoMax = 4.0f;
			velocidadEnemigoMin = 2.5f;
			logroPuntos = 32;
			logroConejos =30;
			logroPoderes =6;
			piso = 2;
			break;
		case 25:
			distancia = 1100;
			puntos = 60;
			frecuenciaEnemigos = 19;
			frecuenciaBonus = 120;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =90;
			rapido = 50;
			defensa = 60;
			comida = 30;
			velocidad = 5;
			velocidadEnemigoMax = 4.0f;
			velocidadEnemigoMin = 2.5f;
			logroPuntos = 40;
			logroConejos =35;
			logroPoderes =5;
			piso = 2;
			break;
		case 26:
			distancia = 1100;
			puntos = 60;
			frecuenciaEnemigos = 19;
			frecuenciaBonus = 160;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =50;
			rapido = 50;
			defensa = 60;
			comida = 2;
			velocidad = 5;
			velocidadEnemigoMax = 4.0f;
			velocidadEnemigoMin = 2.5f;
			logroPuntos = 45;
			logroConejos =25;
			logroPoderes =6;
			piso = 2;
			break;
		case 27:
			distancia = 1000;
			puntos = 70;
			frecuenciaEnemigos = 17;
			frecuenciaBonus = 120;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 100;
			enemigo_doble =20;
			rapido = 50;
			defensa = 70;
			comida = 20;
			velocidad = 4.5f;
			velocidadEnemigoMax = 2.8f;
			velocidadEnemigoMin = 1.8f;
			logroPuntos = 40;
			logroConejos =20;
			logroPoderes =5;
			piso = 1;
			break;
		case 28:
			distancia = 1400;
			puntos = 90;
			frecuenciaEnemigos = 15;
			frecuenciaBonus = 75;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =70;
			rapido = 60;
			defensa = 60;
			comida = 30;
			velocidad = 5;
			velocidadEnemigoMax = 4.0f;
			velocidadEnemigoMin = 2.5f;
			logroPuntos = 50;
			logroConejos =55;
			logroPoderes =15;
			piso = 3;
			break;
		case 29:
			distancia = 1500;
			puntos = 70;
			frecuenciaEnemigos = 18;
			frecuenciaBonus = 100;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =50;
			rapido = 100;
			defensa = 50;
			comida = 25;
			velocidad = 5;
			velocidadEnemigoMax = 4.0f;
			velocidadEnemigoMin = 2.5f;
			logroPuntos = 35;
			logroConejos =40;
			logroPoderes =10;
			piso = 3;
			break;
		case 30:
			distancia = 800;
			puntos = 60;
			frecuenciaEnemigos = 16;
			frecuenciaBonus = 150;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo =60;
			enemigo_doble =50;
			rapido = 50;
			defensa = 60;
			comida = 50;
			velocidad = 5;
			velocidadEnemigoMax = 3.2f;
			velocidadEnemigoMin = 1.9f;
			logroPuntos = 30;
			logroConejos =20;
			logroPoderes =4;
			piso = 0;
			break;
		case 31:
			distancia = 1050;
			puntos = 60;
			frecuenciaEnemigos = 19;
			frecuenciaBonus = 165;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =50;
			rapido = 50;
			defensa = 60;
			comida = 2;
			velocidad = 4.7f;
			velocidadEnemigoMax = 3.2f;
			velocidadEnemigoMin = 1.6f;
			logroPuntos = 55;
			logroConejos =25;
			logroPoderes =5;
			piso = 3;
			break;
		case 32:
			distancia = 1200;
			puntos = 90;
			frecuenciaEnemigos = 16;
			frecuenciaBonus = 175;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =60;
			rapido = 50;
			defensa = 60;
			comida = 50;
			velocidad = 5;
			velocidadEnemigoMax = 3.5f;
			velocidadEnemigoMin = 1.8f;
			logroPuntos = 50;
			logroConejos =32;
			logroPoderes =5;
			piso = 3;
			break;
		case 33:
			distancia = 1100;
			puntos = 60;
			frecuenciaEnemigos = 18;
			frecuenciaBonus = 175;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =50;
			rapido = 50;
			defensa = 60;
			comida = 5;
			velocidad = 5;
			velocidadEnemigoMax = 4.0f;
			velocidadEnemigoMin = 2.5f;
			logroPuntos = 35;
			logroConejos =35;
			logroPoderes =5;
			piso = 0;
			break;
		case 34:
			distancia = 900;
			puntos = 90;
			frecuenciaEnemigos = 15;
			frecuenciaBonus = 100;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =50;
			rapido = 50;
			defensa = 60;
			comida = 20;
			velocidad = 5;
			velocidadEnemigoMax = 3.2f;
			velocidadEnemigoMin = 1.9f;
			logroPuntos = 70;
			logroConejos =35;
			logroPoderes =5;
			piso = 3;
			break;
		case 35:
			distancia = 1100;
			puntos = 80;
			frecuenciaEnemigos = 19;
			frecuenciaBonus = 175;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =70;
			rapido = 50;
			defensa = 60;
			comida = 2;
			velocidad = 5;
			velocidadEnemigoMax = 3.5f;
			velocidadEnemigoMin = 2.2f;
			logroPuntos = 50;
			logroConejos =50;
			logroPoderes =5;
			piso = 3;
			break;
		case 36:
			distancia = 1500;
			puntos = 150;
			frecuenciaEnemigos = 14;
			frecuenciaBonus = 90;
			frecuenciaPuntos = (distancia-100)/puntos ;
			enemigo_solo = 50;
			enemigo_doble =50;
			rapido = 40;
			defensa = 60;
			comida = 30;
			velocidad = 4.5f;
			velocidadEnemigoMax = 2.8f;
			velocidadEnemigoMin = 1.6f;
			logroPuntos = 125;
			logroConejos =80;
			logroPoderes =15;
			piso = 3;
			break;
		
			
		
		

		default:
			distancia = 500;
			puntos = 100;
			frecuenciaEnemigos = 30;
			frecuenciaBonus = 100;
			frecuenciaPuntos = (distancia-50)/puntos;
			enemigo_solo = 50;
			enemigo_doble = 0;
			rapido = 40;
			defensa = 40;
			comida = 20;
			velocidad = 3;
			logroPuntos = 15;
			logroConejos =10;
			logroPoderes = 5;
			piso = 0;
			break;
		}
	}

	public float getDistancia(){
		return distancia;
	}
	
	public int getTipoBonus(){
		
		tipoPoder = MathUtils.random(0, rapido+defensa+comida);
		
		if(tipoPoder > rapido + defensa){ // comida
			return 1;
		}
		
		if(tipoPoder > rapido){
			return 0;
		}
		
		return 2;
	}
	
	public int getTipoEnemigo(){
		
		tipoPoder = MathUtils.random(0, enemigo_solo+enemigo_doble);
		
		if(tipoPoder > enemigo_solo){ // comida
			return 1;
		}
		
		return 0;
	}
}
