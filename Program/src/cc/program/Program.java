/**
*
* @author Ýlknur Kaya ilknur.kaya3@ogr.sakarya.edu.tr
* @since 20 Mart 2022
* <p>
* 1. Öðretim C Grubu
* </p>
*/
package cc.program;
import java.io.IOException;

public class Program extends Lexical {

	public static void main(String[] args) throws IOException
	{
		
		String dosyaadi="Deneme.java";
		//dosyaadi=args[0]; // komut satirindan bir dosya okutalacagi icin direk args[0] verildi.
		Lexical l=new Lexical(); // Lexical sinifindan nesne olusturuldu.
		l.hesap(dosyaadi); // komut satirindan alinan dosya adý parametresi hesap fonksiyonuna gönderildi ve hesap fonksiyonu cagirildi.
		l.bilgiGöster(); // ekrana yazdiran fonksiyon cagirildi.
	
	}

}
