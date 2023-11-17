package UI;

import Base.Card;
import Base.Suit;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CardView extends ImageView {


    private static final Map<Card, Image> cards = new HashMap<>();
    private static final String IMAGE_LOCATION = "images/cards/";
    private static final String IMAGE_SUFFIX = ".png";

    private static final String BACK_IMAGE_NAME = "back-card";


    public ImageView getImage(Card code){
        if(code.isFaceUp()){
            Image image = cards.get(code);
            if(image == null){
                image = new Image(Objects.requireNonNull(CardView.class.getClassLoader().getResourceAsStream(IMAGE_LOCATION + code.getValue().getNumber() + code.getSuit().toString() + IMAGE_SUFFIX)));
                cards.put(code, image);
            }
            ImageView i = new ImageView(image);
            i.setFitHeight(79);
            i.setFitWidth(61);
            i.setStyle("-fx-border-radius: 2; -fx-border-color: black");
            return i;
        } else {
            return getBack();
        }
    }

    public ImageView getBack(){
        Image image = new Image(Objects.requireNonNull(CardView.class.getClassLoader().getResourceAsStream(IMAGE_LOCATION + BACK_IMAGE_NAME + IMAGE_SUFFIX)));
        ImageView back = new ImageView(image);
        back.setFitHeight(79);
        back.setFitWidth(61);
        return back;
    }

    public ImageView getFoundationImage(Suit suit){
        Image i = new Image(Objects.requireNonNull(CardView.class.getClassLoader().getResourceAsStream(IMAGE_LOCATION + suit.toString() + IMAGE_SUFFIX)));
        ImageView imageView = new ImageView(i);
        imageView.setFitHeight(79);
        imageView.setFitWidth(61);
        return imageView;
    }




}
