 /******************************************************************************************
  *  class SymbolEntry is the framework for the objects that are used to store and    *
  *  retrieve values that form the Assembler's symbol table.  As these objects are          * 
  *  instantiated, they are placed in a HashTable structure.  As references to the symbols  *
  *  are found, they are added to the SymbolEntry's vector of references.                   *
  ******************************************************************************************/
import java.io.*;
import java.util.*;

public class SymbolEntry {            
    String symbol = null;        // The symbol itself.
    String address = null;       // Where it is defined.
    // BMM FIX unchecked call to add(E)
    Vector<String> referencedAt;         // List of locations where referenced.

    SymbolEntry(String s, String a) {
      symbol = s;
      address = a;
      // BMM FIX unchecked call to add(E)
      referencedAt = new Vector<String>();
    } // SymbolEntry()
  } // SymbolEntry

