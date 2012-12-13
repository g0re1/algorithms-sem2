package lesson1.exercise;

import java.io.File;

import lesson1.ArrayIterator;
import lesson1.Iterator;

public final class RecursiveDirectoryTreePrinter {
	private static final String SPACES = "   ";
	
	public static void main(String[] args){
		assert  args != null : "Nie podano nazwy katalogu";
		
		if (args.length!=1){
			  System.err.println("Wywołanie: RecursiveDirectoryTreePrinter <katalog>");
			  System.exit(-1);
			}
		  print(new File(args[0]),"") ;

		}
	
	public static void print(File file, String indent){
		assert file != null : "nie określono obiektu File";
		assert indent != null : "nie określono wcięcia";
		
		System.out.print(indent);
		System.out.println(file.getName());
		if(file.isDirectory() ){
			print(file.listFiles(), indent + SPACES);
		}
		
	}
	
	public static void print(File[] files, String indent){
		assert files != null : "Nie okreslona lista plikow";
		
		Iterator it = new ArrayIterator(files);
		for(it.first(); !it.isDone(); it.next() ){
			print(files,indent);
		}
	}



}

