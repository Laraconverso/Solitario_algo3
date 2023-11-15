package Solitaire;

import Base.Card;
import Base.Deck;
import Elements.*;

import java.util.List;


public interface Rules {
        
        boolean acceptsCard(Stock stock, Card card);
        boolean acceptsCard(Foundation foundation, Card card);
        boolean acceptsCard(Column column, Card card);
        boolean acceptsCard(Deck deck, Card card);

        boolean givesCard(Stock stock);
        boolean givesCard(Foundation foundation);
        boolean givesCard(Column column);
        boolean givesCard(Deck deck);

        boolean admitsSequence(Stock stock, Column sequence);
        boolean admitsSequence(Foundation foundation, Column sequence);
        boolean admitsSequence(Column column, Column sequence);
        boolean admitsSequence(Deck deck, Column sequence);

        Stock initStock();
        List<Column> initTableau(Stock stock);
        List<Foundation> initFoundations();
        boolean drawCardFromStock(Stock stock, List<Column> tableau);

}

