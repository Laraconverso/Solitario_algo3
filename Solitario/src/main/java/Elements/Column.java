package Elements;

import Base.Deck;
import Solitaire.Rules;
import Base.Card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class Column extends Deck implements Serializable {

        // column debería tener atributo index? (posicion en tableau)
        // falta chequear que esten flippeadas, creo
        public Card getCard(int pos){
                return deck.get(pos);
        }

        public Column getSequence(int upToIndex) {
                Column subColumn = new Column();
                if (!subColumn.addCards(deck.subList(0, upToIndex))) return null;
                return subColumn;
        }

        @Override
        protected boolean addCards(Card card) {
                return super.addCards(card);
        }
        
        private boolean addCards(Collection<Card> cards) {
                if (cards == null) return false;
                deck.addAll(0, cards);
                return true;
        }

        @Override
        public boolean removeCard(Card card) { return super.removeCard(card); }

        public boolean removeCard(Column cards) {
                for (int i = 0; i < cards.cardCount(); i++) {
                        if(!super.removeCard(cards.getCard(i))) return false;
                }
                return true;
        }

        @Override
        public boolean acceptCard(Rules gameRules, Card card) {
                if (gameRules.acceptsCard(this, card)) return addCards(card);
                else return false;
        }

        @Override
        public boolean acceptSequence(Rules gameRules, Column cards) {
                if (gameRules.admitsSequence(this, cards)) {
                        Collection<Card> cardsCollection = new ArrayList<>();
                        for (int i = cards.cardCount() - 1; i >= 0;  i--) {
                                cardsCollection.add(cards.getCard(i));
                        }
                        return addCards(cardsCollection);
                }
                else return false;
        }


}
