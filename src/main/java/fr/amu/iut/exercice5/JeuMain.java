package fr.amu.iut.exercice5;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class JeuMain extends Application {

    private Scene scene;
    private BorderPane root;
    private Obstacle carreun = new Obstacle(300,200, 100,300);
    private Obstacle carredeu = new Obstacle(600,400, 200,600);

    @Override
    public void start(Stage primaryStage) {

        root = new BorderPane();

        //Acteurs du jeu
        Personnage pacman = new Pacman();
        Personnage fantome = new Fantome();
        // on positionne le fantôme 20 positions vers la droite
        fantome.setLayoutX(20 * 10);
        //panneau du jeu
        Pane jeu = new Pane();
        jeu.setPrefSize(640, 480);
        jeu.getChildren().add(pacman);
        jeu.getChildren().add(fantome);


        jeu.getChildren().addAll(carreun,carredeu);
        root.setCenter(jeu);
        //on construit une scene 640 * 480 pixels
        scene = new Scene(root);

        //Gestion du déplacement du personnage
        deplacer(pacman, fantome);

        primaryStage.setTitle("... Pac Man ...");

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Permet de gérer les événements de type clavier, pression des touches
     * pour le j1(up,down, right, left), pour le j2( z,q,s,d)
     *
     * @param j1
     * @param j2
     */
    private void deplacer(Personnage j1, Personnage j2) {
        scene.setOnKeyPressed((KeyEvent event) -> {
                switch (event.getCode()) {
                    case LEFT:
                        j1.deplacerAGauche();
                        if (j1.estEnCollisionObs(carreun)|| j2.estEnCollisionObs(carreun) || j1.estEnCollisionObs(carredeu) || j2.estEnCollisionObs(carredeu)) {
                            System.out.println("Collision avec objet");
                            j1.deplacerADroite(scene.getWidth());
                        }
                        break;
                    case RIGHT:

                        j1.deplacerADroite(scene.getWidth());
                        if(j1.estEnCollisionObs(carreun)|| j2.estEnCollisionObs(carreun) || j1.estEnCollisionObs(carredeu) || j2.estEnCollisionObs(carredeu)) {
                        System.out.println("Collision avec objet");
                        j1.deplacerAGauche();
                    }
                        break;
                    case DOWN:
                        j1.deplacerEnBas(scene.getHeight());
                        if(j1.estEnCollisionObs(carreun)|| j2.estEnCollisionObs(carreun) || j1.estEnCollisionObs(carredeu) || j2.estEnCollisionObs(carredeu)) {
                            System.out.println("Collision avec objet");
                            j1.deplacerEnHaut();
                        }
                        break;
                    case UP:
                        j1.deplacerEnHaut();
                        if(j1.estEnCollisionObs(carreun)|| j2.estEnCollisionObs(carreun) || j1.estEnCollisionObs(carredeu) || j2.estEnCollisionObs(carredeu)) {
                            System.out.println("Collision avec objet");
                            j1.deplacerEnBas(scene.getHeight());
                        }
                        break;
                    case Z:
                        j2.deplacerEnHaut();
                        if(j1.estEnCollisionObs(carreun)|| j2.estEnCollisionObs(carreun) || j1.estEnCollisionObs(carredeu) || j2.estEnCollisionObs(carredeu)) {
                            System.out.println("Collision avec objet");
                            j2.deplacerEnBas(scene.getHeight());
                        }
                        break;
                    case S:
                        j2.deplacerEnBas(scene.getHeight());
                        if(j1.estEnCollisionObs(carreun)|| j2.estEnCollisionObs(carreun) || j1.estEnCollisionObs(carredeu) || j2.estEnCollisionObs(carredeu)) {
                            System.out.println("Collision avec objet");
                            j2.deplacerEnHaut();
                        }
                        break;
                    case Q:
                        j2.deplacerAGauche();
                        if (j1.estEnCollisionObs(carreun)|| j2.estEnCollisionObs(carreun) || j1.estEnCollisionObs(carredeu) || j2.estEnCollisionObs(carredeu)) {
                            System.out.println("Collision avec objet");
                            j2.deplacerADroite(scene.getWidth());
                        }
                        break;
                    case D:
                        j2.deplacerADroite(scene.getWidth());
                        if(j1.estEnCollisionObs(carreun)|| j2.estEnCollisionObs(carreun) || j1.estEnCollisionObs(carredeu) || j2.estEnCollisionObs(carredeu)) {
                            System.out.println("Collision avec objet");
                            j2.deplacerAGauche();
                        }
                        break;
                }
            if (j1.estEnCollision(j2)) {
                System.out.println("Collision....");
                Platform.exit();
            }
            if (j1.estEnCollisionObs(carreun)|| j2.estEnCollisionObs(carreun) || j1.estEnCollisionObs(carredeu) || j2.estEnCollisionObs(carredeu)) {
                System.out.println("Collision....");
            }

        });
    }


}
