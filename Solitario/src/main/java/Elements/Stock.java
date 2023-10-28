package Elements;

import Solitaire.Rules;
import Base.Deck;
import Base.Card;

import java.io.Serializable;
import java.util.Collections;
import java.util.Random;

public class Stock extends Deck implements Serializable {

        private boolean filled;

        public Stock () {
                super();
                this.filled = false;
        }

        public void flipCard(int index) {
                deck.get(index).flip();
        }

        public void shuffle(int seed) {
                Random rn = new Random(seed);
                Collections.shuffle(deck, rn);
        }

        public void toggleFillingState() {
                this.filled = !filled;
        }

        public boolean isFilling() {
                return this.filled;
        }

        @Override
        protected boolean addCards(Card card) {
                return super.addCards(card);
        }

        @Override
        protected boolean containsCard(Card card) {
                return super.containsCard(card);
        }

        @Override
        public boolean acceptCard(Rules gameRules, Card card) {
                if (gameRules.acceptsCard(this, card) && !containsCard(card)) return addCards(card);
                else return false;
        }

        @Override
        public boolean acceptSequence(Rules gameRules, Column cards) {
                return gameRules.admitsSequence(this, cards);
        }

        @Override
        public boolean givesCard(Rules gameRules) {
                return gameRules.givesCard(this);
        }

}
