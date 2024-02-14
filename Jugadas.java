import java.util.Scanner;

public class Jugadas extends Jugador{
    boolean ganador=false;
    Scanner posiciones= new Scanner(System.in);
    boolean turno=true;
    int contador=0;
    int empate=0;


    public void iniciarJuego(){
        iniciarTablero();
    
        while (!ganador && empate<9) {
            insertaPosicion();
        }
    }



    public void buscaGanador(){
        
        empate++;
    
      for(int i =0;i<3;i++){
        if(tabla[i][0].equals("X")&&tabla[i][1].equals("X")&&tabla[i][2].equals("X")){
            ganador=true;
        }else if(tabla[i][0].equals("O")&&tabla[i][1].equals("O")&&tabla[i][2].equals("O")){
            ganador=true;
        }
      }
        
        for(int i=0; i<3;i++){
            if (tabla[0][i].equals("O")&&tabla[1][i].equals("O")&&tabla[2][i].equals("O")) {
                ganador=true;
            }else if(tabla[0][i].equals("X")&&tabla[1][i].equals("X")&&tabla[2][i].equals("X")){
                ganador=true;
        }
    }
        if (tabla[0][0].equals("X")&&tabla[1][1].equals("X")&&tabla[2][2].equals("X")) {
            ganador=true;
        }
        
        else if (tabla[0][0].equals("O")&&tabla[1][1].equals("O")&&tabla[2][2].equals("O")) {
            ganador=true;
        }
        
        else if (tabla[0][2].equals("X")&&tabla[1][1].equals("X")&&tabla[2][0].equals("X")) {
            ganador=true;
        }
        else if (tabla[0][2].equals("O")&&tabla[1][1].equals("O")&&tabla[2][0].equals("O")) {
            ganador=true;
        }

        if(empate==9 && ganador==false){
            mostrarTablero();
            System.out.println("----------------------------------");
            System.out.println("Ha habido un Empate");
            System.out.println("-----------------------------------");
            return;
        }

        if (ganador) {
            mostrarTablero();
            System.out.println("-----------------------------------");
            System.out.println("El ganador es el jugador: "+jp);
            System.out.println("-----------------------------------");
            return;
        }

    }

    public void insertaPosicion(){     
        mostrarTablero();
        if (turno){
                jp=1;

            }else{
                jp=2;
            }

        System.out.println("");
       System.out.println("");
       
        System.out.println("TURNO DE JUGADOR  "+jp);
        System.out.println("Introduzca en primer lugar la posición X  y  usando una coma para diferenciarlos en segundo lugar coloque  la posición Y. Ej:2,2");

        String texto=posiciones.nextLine();

        
        int posicionX= Integer.parseInt(Character.toString(texto.charAt(0)));
        int posicionY=Integer.parseInt(Character.toString(texto.charAt(2)));
        
        if (tabla[posicionX][posicionY]==" "){
            if (turno){
                tabla[posicionX][posicionY]="X";
                jp=1;
                turno=false;
                contador++;
                buscaGanador();

            }else{

                tabla[posicionX][posicionY]="O";
                jp=2;
                turno=true;
                contador++;
                buscaGanador();
            }

        }else{
            System.out.println("No es posible sobreescribir posiciones");
        }


    }

    public void mostrarTablero(){

        for(int i=0;i<tabla.length;i++){
            for(int j=0;j<tabla.length;j++){
                System.out.print(tabla[i][j]+" ");
            }
            System.out.println("");
        }
    }
}
