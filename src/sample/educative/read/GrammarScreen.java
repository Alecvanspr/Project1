package sample.educative.read;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sample.GoToScreens;
import sample.educative.GoToEducative;


public class GrammarScreen  extends Application {
    GoToScreens goToScreens = GoToScreens.getInstance();
    GoToEducative goToEducative = new GoToEducative();
    Pane pane = new Pane();
    Scene scene;
    int pastX = 100;
    int presentX = 300;
    int futureX = 500;
    int pastY = 65;
    int presentY = 65;
    int futureY = 65;

    @Override
    public void start(Stage stage) throws Exception {
        makeButtons(stage);
        fin(stage);
    }

    public int getPastY() {
        this.pastY += 40;
        return pastY;
    }

    public int getPresentY() {
        this.presentY += 40;
        return presentY;
    }

    public int getFutureY() {
        this.futureY += 40;
        return futureY;
    }

    public void fin(Stage stage) {
        scene = new Scene(pane, 800, 600);
        stage.setTitle("Grammar screen");
        stage.setScene(scene);
        stage.show();
    }
    public void makeButtons(Stage stage){
        makeTenseButtons(stage);
        makeIrregualarVerb(stage);
        makeBtnBack(stage);
    }

    public void makeTenseButtons(Stage stage) {
        makeBtnSimplePast(stage);
        makeBtnPresentSimple();
        makeBtnContinues(stage);
        makebtnPresentProgressive();
        makeBtnPastPerfect(stage);
        makeBtnPastPerfectProgressive();
        makeFutureWill();
        makeBtnFutureGoingTo();
        makeBtnFutureProgressive();
        makeBtnFuturePerfect();
        makebtnPresentPerfectProgressive();
        makebtnPastPerfectProgressive(stage);
    }
    public void makeIrregualarVerb(Stage stage){
        Button btnIrregularVerbs = new Button("Irregular verbs");
        btnIrregularVerbs.relocate(100, 400);
        btnIrregularVerbs.setOnAction(E -> {
            goToEducative.goIrregularVerbScreen(stage);
        });
        pane.getChildren().addAll (btnIrregularVerbs);
    }

    public void makeBtnBack(Stage stage) {
        Button btnBack = new Button("back");
        btnBack.relocate(0, 575);
        btnBack.setOnAction(E -> {
            goToScreens.goReadScreen(stage);
        });
        pane.getChildren().add(btnBack);
    }

    public void makeBtnSimplePast(Stage stage) {
        Button btnSimplePast = new Button("Past");
        btnSimplePast.setOnAction(E -> {
            goToEducative.goExplainTenseScreen(stage, 0);
        });
        btnSimplePast.relocate(pastX, getPastY());
        pane.getChildren().add(btnSimplePast);
    }

    public void makeBtnPresentSimple() {
        Button btnPresentSimple = new Button("Present");
        btnPresentSimple.relocate(presentX, getPresentY());
        pane.getChildren().add(btnPresentSimple);
    }

    public void makeBtnContinues(Stage stage) {
        Button btnContinues = new Button("Continues");
        btnContinues.setOnAction(E -> {
            goToEducative.goExplainTenseScreen(stage, 3);
        });
        btnContinues.relocate(presentX, getPresentY());
        pane.getChildren().add(btnContinues);
    }

    public void makebtnPresentProgressive(){
    Button btnPresentProgressive = new Button("Present Progressive");
        btnPresentProgressive.relocate(presentX, getPresentY());
        pane.getChildren().add(btnPresentProgressive);
    }

    public void makeBtnPastPerfectProgressive() {
        Button btnPastProgressive = new Button("Past Progressive");
        btnPastProgressive.relocate(pastX, getPastY());
        pane.getChildren().add(btnPastProgressive);
    }

    public void makebuttonPresentPerfect(){
        Button btnPresentPerfect = new Button("Present Perfect");
        btnPresentPerfect.relocate(presentX, getPresentY());
        pane.getChildren().add(btnPresentPerfect);
    }
    public void makebtnPresentPerfectProgressive() {
        Button btnPresentPerfectProgressive = new Button("Present Perfect Progressive");
        btnPresentPerfectProgressive.relocate(presentX, getPresentY());
        pane.getChildren().add(btnPresentPerfectProgressive);
    }
    public void makeBtnPastPerfect(Stage stage) {
        Button btnPastPerfect = new Button("Past perfect");
        btnPastPerfect.setOnAction(E -> {
            goToEducative.goExplainTenseScreen(stage, 1);
        });
        btnPastPerfect.relocate(pastX, getPastY());
        pane.getChildren().add(btnPastPerfect);
    }
    public void makebtnPastPerfectProgressive(Stage stage) {
        Button btnPastPerfectProgressive = new Button("Past pefect Progressive");
        btnPastPerfectProgressive.setOnAction(E -> {
            goToEducative.goExplainTenseScreen(stage, 2);
        });
        btnPastPerfectProgressive.relocate(pastX, getPastY());
        pane.getChildren().add(btnPastPerfectProgressive);
    }
    public void makeFutureWill() {
        Button btnFutureWill = new Button("Future will");
        btnFutureWill.relocate(futureX, getFutureY());
        pane.getChildren().add(btnFutureWill);
    }
    public void makeBtnFutureGoingTo() {
        Button btnFutureGoingTo = new Button("Future going to");
        btnFutureGoingTo.relocate(futureX, getFutureY());
        pane.getChildren().add(btnFutureGoingTo);
    }
    public void makeBtnFutureProgressive() {
        Button btnFutureProgressive = new Button("Future progressive");
        btnFutureProgressive.relocate(futureX, getFutureY());
        pane.getChildren().add(btnFutureProgressive);
    }
    public void makeBtnFuturePerfect() {
        Button btnFuturePerfect = new Button("Future perfect");
        btnFuturePerfect.relocate(futureX, getFutureY());
        pane.getChildren().add(btnFuturePerfect);
    }
}