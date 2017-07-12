package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = {
      if ( c == 0 || r == 0 || c == r ) return 1
      return pascal(c-1, r-1) + pascal(c, r-1)
    }
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = {
      def count(a: Int, chars: List[Char]): Int = {
        if ( chars.isEmpty ) return 0
        if ( a < 0 ) return a
        if ( chars.head == '(' ) {
          count(a+1, chars.tail) + 1
        } else if ( chars.head == ')' ) {
          count(a-1, chars.tail) - 1
        } else {
          count(a, chars.tail)
        }
      }
      return count(0, chars) == 0
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if ( money < 0 ) return 0
      if ( coins.isEmpty ) return 0
      if ( money == 0 ) return 1
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    }
  }
