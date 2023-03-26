import java.util.Scanner;

public class Jeu_du_labyrinthe_KVR {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[][] map = {
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
                {'#', '.', '.', '.', '#', '.', '.', '.', '.', '#'},
                {'#', '.', '#', '.', '#', '.', '#', '#', '.', '#'},
                {'#', '.', '#', '.', '.', '.', '.', '.', '.', '#'},
                {'#', '.', '#', '#', '#', '#', '.', '#', '#', '#'},
                {'#', '.', '.', '.', '.', '#', '.', '.', '.', '#'},
                {'#', '#', '#', '#', '.', '#', '#', '#', '.', '#'},
                {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
                {'#', '.', '#', '#', '#', '#', '.', '#', '#', '#'},
                {'#', '#', '#', '#', '#', '#', 'S', '#', '#', '#'}
        };
        int playerRow = 1;
        int playerCol = 1;
        boolean Perdu = false;

        System.out.println("Bienvenue dans le jeu de labyrinthe !");

        do {
            // Affichage de la carte avec le joueur
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (i == playerRow && j == playerCol) {
                        System.out.print('O');
                    } else {
                        System.out.print(map[i][j]);
                    }
                }
                System.out.println();
            }

            // Demande de mouvement
            System.out.print("Déplacez-vous avec les touches z,q,s,d et appuyez sur Entrée : ");
            char input = sc.nextLine().charAt(0);
            int nextRow = playerRow;
            int nextCol = playerCol;

            // Déplacement du joueur
            switch (input) {
                case 'z':
                    nextRow--;
                    break;
                case 'q':
                    nextCol--;
                    break;
                case 's':
                    nextRow++;
                    break;
                case 'd':
                    nextCol++;
                    break;
            }

            // Vérification des limites de la carte et des obstacles
            if (nextRow >= 0 && nextRow < map.length && nextCol >= 0 && nextCol < map[nextRow].length) {
                if (map[nextRow][nextCol] != '#') {
                    playerRow = nextRow;
                    playerCol = nextCol;
                    if (map[nextRow][nextCol] == '.') {
                        map[nextRow][nextCol] = ' ';
                    } else if (map[nextRow][nextCol] == 'S') {
                        //le S représente la sortie
                        Perdu = true;
                    }
                }
            }

        } while (!Perdu);

        System.out.println("Bravo, vous avez trouvé la sortie !");
    }

}
