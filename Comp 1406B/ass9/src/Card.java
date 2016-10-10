public class Card extends AbstractCard implements Comparable<Card>{
    
    private final String[] ranksInOrder = new String[]{
        "Joker", "", "Two", "Three", "Four", "Five", "Six", "Seven", 
        "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"
        };
  
  public Card(String suit, String rank){
      super(suit, 0);
      this.rank = indexInArray(rank, ranksInOrder);
  }
  public Card(String suit, int rank){
      super(suit, rank);
  }
  
  
  @Override
  public int compareTo(Card other){
      if (this.rank!=0 && other.rank!=0){
        if (indexInArray(this.suit, AbstractCard.SUITS)<indexInArray(other.suit, AbstractCard.SUITS)){
            return 1;
        }
        else if (indexInArray(this.suit, AbstractCard.SUITS)>indexInArray(other.suit, AbstractCard.SUITS)){
            return -1;
        }
        else{
            if (this.rank>other.rank){
                return 1;
            }else if (this.rank<other.rank){
                return -1;
            }
        }
        return 0;
      }else{
          if (this.rank==0){
              if (other.rank==0){
                  return 0;
              }else{
                  return -1;
              }
          }else{
              if (this.rank==0){
                  return 1;
              }else{
                  return 0;
              }
          }
      }
  }
  
  private int indexInArray(String s, String[] a){
      int i = 0;
      for (String x:a){
          if (x.equals(s)){
              return i;
          }
          i++;
      }
      return 0;
  }
  
  @Override
  public String toString(){
      StringBuilder sb = new StringBuilder();
      sb.append(this.ranksInOrder[this.rank]).append(" of ").append(this.suit);
      return sb.toString();
  }  
}