import java.util.Iterator ;

public class DemonstrateMyArrayList {

  public static void main(String[] args) {
    System.out.println("CREATE ARRAYLIST:") ;
    MyArrayList<String> A ;
    System.out.println("DEMONSTRATE BASIC OPERATIONS:") ;
    A = new MyArrayList<String>() ;
    A.add("fee") ;
    A.add("fox") ;
    A.add("fie") ;
    A.add("foo") ;
    A.add(3,"foe") ;
    A.set(4,"fum") ;
    A.remove(1) ;
    System.out.println( A.contains("fie") ) ;
    System.out.println( A.indexOf("fie") ) ;
    System.out.println( A.contains("hello") ) ;
    System.out.println( A.indexOf("hello") ) ;
    System.out.println( A.size() ) ;
    System.out.println("PROCESS WITH FOR LOOP:") ;
    for (int i=0 ; i<A.size() ; i++) { System.out.print(A.get(i) + " ") ; }
    System.out.println() ;
    System.out.println("DEMONSTRATE ITERATOR:") ;
    Iterator I = A.iterator() ;
    while ( I.hasNext() ) { if ( I.next().equals("fie") ) I.remove() ; }
    for ( String s : A ) { System.out.print( s + " " ) ; }
    System.out.println() ;
  }

}

/// End-of-File