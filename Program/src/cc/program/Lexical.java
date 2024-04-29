/**
*
* @author Ýlknur Kaya ilknur.kaya3@ogr.sakarya.edu.tr
* @since 20 Mart 2022
* <p>
* 1. Öðretim C Grubu
* </p>
*/
package cc.program;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
public class Lexical {
	//operatorleri tutmasi icin arraylistler tanimlandi.
	ArrayList<String>tekli_op=new ArrayList<String>();
	ArrayList<String>ikili_op=new ArrayList<String>();
	ArrayList<String>iliskisel_op=new ArrayList<String>();
	ArrayList<String>mantiksal_op=new ArrayList<String>();
	// yorum satirlarini bulmak için tanimlandi.
	ArrayList<String>yorum_=new ArrayList<String>();
    // regex ifadeler ile operator ve yorum satirlari tanimlandi.
	Pattern mantiksal=Pattern.compile("&{2}|!\\s|\\|{2}");
	Pattern tekli=Pattern.compile("[+]{2}|[-]{2}");
	Pattern ikili=Pattern.compile("[\\w|\\s][+][\\w|\\s]|[\\w|\\s][-][\\w|\\s]|[\\w|\\s][*][\\w|\\s]|[\\w|\\s][/][\\w|\\s]|[\\w|\\s][%][\\w|\\s]|[\\w|\\s][&][\\w|\\s]|[\\w|\\s][|][\\w|\\s]|[\\w|\\s][=][\\w|\\s]|[\\w|\\s][%][=][\\w|\\s]|[\\w|\\s][&][=][\\w|\\s]|[\\w|\\s][|][=][\\w|\\s]|[\\w|\\s]\\^[\\w|\\s]|[\\w|\\s]\\^[=][\\w|\\s]");
	Pattern iliskisel=Pattern.compile("[\\w|\\s][<][\\w|\\s]|[\\w|\\s][<][=][\\w|\\s]|[\\w|\\s][>][\\w|\\s]|[\\w|\\s][>][=][\\w|\\s]|[\\w|\\s][=]{2}[\\w|\\s]|[\\w|\\s][!][=][\\w|\\s]");
	Pattern yorum=Pattern.compile("[/]{2}|/[*]|^[*]");
    //komut satirindan gelecek dosya adi ile dosya okuma ve hesaplama fonksiyonu olusturuldu
	public void hesap(String dosyaad) throws IOException {
		try {File dosya=new File(dosyaad);
		BufferedReader oku=new BufferedReader(new FileReader(dosya));
		String satir=null;
			while((satir=oku.readLine())!=null) { // satir satir okuma islemine baslandi
				// satirlardan bosluklar silinerek matcherlar yazildi.
				Matcher mantiksal_matcher=mantiksal.matcher(satir.trim()); 
				Matcher tekli_matcher=tekli.matcher(satir.trim());
				Matcher ikili_matcher=ikili.matcher(satir.trim());
				Matcher yorum_matcher=yorum.matcher(satir.trim());
				Matcher iliskisel_matcher=iliskisel.matcher(satir.trim());
				// eger yorum satiri bulunduysa if e gir.
				if(yorum_matcher.find()) {
					String yorum1=yorum_matcher.group();
					if(yorum1.length()!=0) {
						yorum_.add(yorum1);
					
					}
					// dongudeki diger kodlari yapmadan dongu basina dön
					continue;
					
					
				}
				// eger yorum satiri yoksa else e gir 
				else {
					// mantiksal operator bulan dongu
				while(mantiksal_matcher.find()) {
					String mantýk=mantiksal_matcher.group();
					if(mantýk.length()!=0) {
						mantiksal_op.add(mantýk);
					}
				}
				
				//tekli operator bulan dongu
				while(tekli_matcher.find()) {
					String tek=tekli_matcher.group();
					if(tek.length()!=0) {
						tekli_op.add(tek);
					}
				}
				//ikili operator bulan dongu
				while(ikili_matcher.find()) {
					String iki=ikili_matcher.group();
					if(iki.length()!=0) {
						ikili_op.add(iki);
					}
				}
				//iliskisel operator bulan dongu
				while(iliskisel_matcher.find()) {
					String iliski=iliskisel_matcher.group();
					if(iliski.length()!=0) {
						iliskisel_op.add(iliski);
					}
				}
			}
				
				
				
			}
			//dosya okumayi kapat
			oku.close();
			} 
		// eger okunacak dosya bulunmazsa hata ver
		catch (FileNotFoundException ex) 
        {
            System.out.println("Dosya bulunamadi.");
        }     
		
	}
	// hesap sonuclarini ekrana yazdir
	public void bilgiGöster() {
		System.out.println("Operatör Bilgisi:");
		System.out.println("\tTekli Operatör Sayýsý:"+ tekli_op.size()); // arraylist uzunlugu
		System.out.println("\tÝkili Operatör Sayýsý:" + ikili_op.size());
		System.out.println("\tSayýsal Operatör Sayýsý:" + (ikili_op.size()+tekli_op.size()));
		System.out.println("\tÝliskisel Operatör Sayýsý:" + iliskisel_op.size());
		System.out.println("\tMantýksal Operatör Sayýsý:" + mantiksal_op.size());
		System.out.println("Operand Bilgisi:");
		System.out.println("\tToplam Operand Sayýsý:"+(2*(ikili_op.size()+iliskisel_op.size()+mantiksal_op.size())+tekli_op.size())); //operand hesaplayan islem
		
	}

}
