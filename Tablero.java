
public abstract class Tablero {
    String[][] tabla;

    public Tablero(){
        tabla= new String[3][3];
    }

    public void iniciarTablero(){
        tabla= new String[3][3];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                tabla[i][j]=" ";
            }
        }
    }
}
