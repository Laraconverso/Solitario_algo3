package UI;

import Base.Suit;
import Elements.Foundation;
import Elements.Visitable;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;


public class FoundationView extends StackPane implements Clickable {

    CardView cardView = new CardView();
    Suit suit;
    Foundation foundation;
    private boolean clickState;
    private int number;

    public FoundationView(Foundation foundation) {
        this.suit = foundation.getSuit();
        this.foundation = foundation;
        this.clickState = false;
        buildFoundation();
        setOnMouseClicked(this::handleFoundationClick);
    }

    private void buildFoundation(){
        if(foundation.isEmpty()) {
            ImageView image = cardView.getFoundationImage(suit);
            image.setStyle("-fx-opacity: 10%");
            getChildren().add(image);
        } else {
            ImageView image = cardView.getImage(foundation.getLast());
            getChildren().add(image);
        }
    }

    public void toggleFoundationClick() { clickState = !clickState; }

    private void handleFoundationClick(MouseEvent event) {
        toggleFoundationClick();
        System.out.println("Foundation Clicked! index: " + getIndex());
    }

    public Foundation getFoundation() {
        return foundation;
    }

    public boolean isClicked(){
        return clickState;
    }

    @Override
    public void handleClick(MouseEvent event) {
        toggleFoundationClick();
    }

    @Override
    public boolean estaClickeado() {
        return isClicked();
    }

    //@Override
//    public Visitable getDeck() {
//        return foundation;
//    }

    @Override
    public void setIndex(int id) {
        this.number = id;
    }

    @Override
    public int getIndex() {
        return number;
    }
}
