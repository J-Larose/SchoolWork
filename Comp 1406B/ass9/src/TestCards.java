import java.util.Arrays;

public class TestCards{
  
  public static void main(String[] args){
    Card[] hand = new Card[52];
    
    // generate a full deck of cards no joker
    int count = 0;
    for(int suit=0; suit<AbstractCard.SUITS.length; suit+=1){
      for(int rank=1; rank<14; rank+=1){
        hand[count++] = new Card(AbstractCard.SUITS[suit], AbstractCard.RANKS[rank]);
      }
    }
    System.out.println( Arrays.toString(hand) );
    System.out.println(hand[0].toString());
    System.out.println(hand[13].toString());
    
    System.out.println(hand[0].compareTo(hand[13]));
    
    // shuffe the deck
    for(int i=0; i<hand.length; i++){
      int k = (int) (Math.random()*(hand.length-i));
      // swap card i with card i+k
      Card tmp = hand[i];
      hand[i] = hand[i+k];
      hand[i+k] = tmp;
    }
    System.out.println( Arrays.toString(hand) );
    
    // Sort the deck using the Arrays.sort method.
    // Calling the sort method like this only works because the Card
    // class implements Comparable (it expects to find a compareTo method)
    Arrays.sort(hand);
    System.out.println( Arrays.toString(hand) );
    
    Card c = new Card("Hearts", "blue");
    System.out.println(c.toString());
    
    
  }
}