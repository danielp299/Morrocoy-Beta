package com.cubo2d.morrocoy;

public class Idioma {

	public int actual;
	
	public String Atras;
	public String Si;
	public String No;
	
	//Memu
	public String mJugar;
	public String mAcerca;
	public String mOpciones;
	public String mSalir;
	
	//Seleccion de niveles

	public String sNivel;
	
	//Contenido Acerca

	public String cAcerca;
	
	//Menu Opciones

	public String oBorrarcuenta;
	public String oIdioma;
	public String oSonido;
	
	//Menu en el Juego

	public String jMenu;
	public String jAyuda;
	public String jRepetir;
	
	//Ayuda
	public String aPagina1;
	public String aPagina2;
	public String aPagina3;
	
	//Resultados
	public String rFelicitacion;
	public String rCompletado;
	public String rTotal;
	public String rSiguiente;
	
	public static String listaIdiomas[] = {"ES","EN","PT","FR"};
	
	public Idioma(int actual) {
		// TODO Auto-generated constructor stub
		cambiarLenguage(actual);
	}
	
	public void cambiarLenguage(int nuevo){
		
		actual = nuevo;
		if(nuevo == 0){
			System.out.println("Es es");
			Si = "Si";
			No = "No";
			Atras = "Atras";
			
			
			//Memu
			mJugar  = "Jugar";
			mAcerca = "Acerca";
			mOpciones = "Opciones";
			mSalir = "Salir";
			
			//Seleccion de niveles

			sNivel = "Nivel";
			
			//Contenido Acerca

			cAcerca = "Elaborado Por:\nDaniel Pernia & Cubo2D\ndanielp299@gmail.com\nMusica:\nhttp://www.freesfx.co.uk\nTodos los derechos reservados\nVenezuela 2013";
			
			//Menu Opciones

			oBorrarcuenta = "Borrar:\nPerfil";
			oIdioma = "Idioma:";
			oSonido = "Sonido";
			
			//Menu en el Juego

			jMenu = "Menu";
			jAyuda = "Ayuda";
			jRepetir ="Repetir";
			
			//Ayuda
			aPagina1 = "";
			aPagina1 = "-Ayuda a morrocoy a llegar a la meta \n-Deslizando el dedo hacia arriba o abajo\n para no tocar la cola de los conejos.\n";
			aPagina1+= "-Atrapa y acumula estrellas.\n";
			aPagina1+= "-Atrapa efectos que te facilitaran el camino.";
			
			aPagina2 = "";
			aPagina2 = "-Puedes sacar los conejos del camino empujandolos.\n";
			aPagina2+= "-Debes adelantarlos para empujarlos con facilidad.\n";
			aPagina2+= " (No quieres que te pongan las patitas en la cara o si?).\n\n";
			aPagina2+= "-Poder ROJO nada te detiene.\n";
			aPagina2+= "-Poder AZUL solo veran el polvo.\n";
			aPagina2+= "-Poder VERDE come algo y recuperate.\n";
			
			aPagina3 = "";
			aPagina3 = "-Tambien puedes desbloquear logros de nivel\n";
			aPagina3+= " y ganaras un icono que lo demuestre.";
			
			//Resultados
			rFelicitacion = "Felicitaciones!";
			rCompletado = "Completado";
			rTotal = "Total de estrellas del nivel";
			rSiguiente = "Siguiente";
			
		}
		if(nuevo == 1){
			//System.out.println("Es en");
			Si = "Yes";
			No = "No";
			Atras = "Back";
			
			
			//Memu
			mJugar  = "Play";
			mAcerca = "About";
			mOpciones = "Options";
			mSalir = "Exit";
			
			//Seleccion de niveles

			sNivel = "Level";
			
			//Contenido Acerca

			cAcerca = "Developer: \nDaniel Pernia & Cubo2D \ndanielp299@gmail.com\nMusic:\nhttp://www.freesfx.co.uk\n All rights reserved \nVenezuela 2013";
			
			//Menu Opciones

			oBorrarcuenta = "Delete:\n Profile";
			oIdioma = "Language:";
			oSonido = "Sound";
			
			//Menu en el Juego

			jMenu = "Menu";
			jAyuda = "Help";
			jRepetir ="Repeat";
			
			//Ayuda
			aPagina1 = "";
			aPagina1 = "-Helps Morrocoy(tortoise) to reach the target \n-Slide your finger up or down \n not to touch the tail of rabbits. \n";
			aPagina1+= "-Catch and Collects stars.\n";
			aPagina1+= "-Catch powers that will facilitate the way.";
			
			aPagina2 = "";
			aPagina2 = "-You can take the road pushing them rabbits.\n";
			aPagina2+= "-You have to push them easily overtake.\n";
			aPagina2+= " (Do you want to have the legs on the face or?).\n\n";
			aPagina2+= "-RED nothing holding you back.\n";
			aPagina2+= "-BLUE will only see dust.\n";
			aPagina2+= "-GREEN to eat something and be happy.\n";
			
			aPagina3 = "";
			aPagina3 = "-You can also unlock achievements level\n";
			aPagina3+= " and earn an icon to prove it.";
			
			//Resultados
			rFelicitacion = "Congratulations!";
			rCompletado = "Completed";
			rTotal = "Total level star";
			rSiguiente = "Next";
			
		}else if(nuevo == 2){
			Si = "Se";
			No = "Não";
			Atras = "Atrás";
			
			
			//Memu
			mJugar  = "Jogar";
			mAcerca = "Sobre";
			mOpciones = "Opções";
			mSalir = "Deixar";
			
			//Seleccion de niveles

			sNivel = "Nível";
			
			//Contenido Acerca

			cAcerca = "Desenvolvedor: \nDaniel Pernia & Cubo2D \ndanielp299@gmail.com\nMusica:\nhttp://www.freesfx.co.uk\nTodos os direitos reservados \nVenezuela 2013";
			//Menu Opciones

			oBorrarcuenta = "Apagar:\nPerfil";
			oIdioma = "Linguagem:";
			oSonido = "Parecer";
			
			//Menu en el Juego

			jMenu = "Menu";
			jAyuda = "Ajudar";
			jRepetir ="Repetir";
			
			//Ayuda
			aPagina1 = "";
			aPagina1 = "-Ajuda tartaruga para atingir a meta \n-Deslize o dedo para cima ou para baixo \n não tocar na cauda de coelhos\n";
			aPagina1+= "-Captura e acumula estrelas.\n";
			aPagina1+= "-Captura poderes que irão facilitar o caminho.";
			
			aPagina2 = "";
			aPagina2 = "-Você pode pegar a estrada empurrando-os coelhos.\n";
			aPagina2+= "-Deves adiantá-los para empurrá-los com facilidade.\n";
			aPagina2+= " (Você não vai querer colocá-lo para fora na cara dele?).\n\n";
			aPagina2+= "-Poder VERMELHO nada te detém!\n";
			aPagina2+= "-Poder AZUL só veran o pó.\n";
			aPagina2+= "-Poder VERDE come algo e recuperate.\n";
			
			aPagina3 = "";
			aPagina3 = "-Tambien podes desbloquear lucros de nível\n";
			aPagina3+= " e ganhasses um ícone que o demonstre.";
			
			//Resultados
			rFelicitacion = "Felicitaciones!";
			rCompletado = "Completado";
			rTotal = "Total de estrelas do nível";
			rSiguiente = "Segue";
		}else if(nuevo == 3){
			Si = "Soi";
			No = "Núm";
			Atras = "Retour";
			
			
			//Memu
			mJugar  = "Jouer";
			mAcerca = "Sur";
			mOpciones = "Options";
			mSalir = "Quitter";
			
			//Seleccion de niveles

			sNivel = "Niveau";
			
			//Contenido Acerca

			cAcerca = "Développeur: \nDaniel Pernia & Cubo2D \ndanielp299@gmail.com\nMusique:\nhttp://www.freesfx.co.uk\n Tous droits réservés \nVenezuela 2013";
			//Menu Opciones

			oBorrarcuenta = "Supprimer:\n Profil";
			oIdioma = "Langue:";
			oSonido = "Sonner";
			
			//Menu en el Juego

			jMenu = "Menu";
			jAyuda = "Aide";
			jRepetir ="Répéter";
			
			//Ayuda
			aPagina1 = "";
			aPagina1 = "-Aide à Morrocoy (tortue) pour atteindre la cible \n-Faites glisser votre doigt vers le haut ou vers le bas \n de ne pas toucher la queue de lapin. \n ";
			aPagina1+= "-Catch et collectionne des étoiles.\n";
			aPagina1+= "-Catch pouvoirs qui faciliteront la manière.";
			
			aPagina2 = "";
			aPagina2 = "-Vous pouvez prendre la route en les poussant lapins.\n";
			aPagina2+= "-Vous devez pousser facilement dépasser.\n";
			aPagina2+= " (Voulez-vous d'avoir les pieds sur le visage ou?)\n\n";
			aPagina2+= "-Pouvoir ROJO rien t'arrête.\n";
			aPagina2+= "-Pouvoir BLEU seulement veran la poussière.\n";
			aPagina2+= "-Pouvoir VERT mange quelque chose et recuperate.\n";
			
			aPagina3 = "";
			aPagina3 = "-Vous pouvez également débloquer le niveau des réalisations\n";
			aPagina3+= " et gagner une icône pour le prouver.";
			
			//Resultados
			rFelicitacion = "Congratulations!";
			rCompletado = "Terminé";
			rTotal = "Étoiles totale de niveau";
			rSiguiente = "Suivant";
			
		}else if(nuevo == -1){
			
		}
	}

}
