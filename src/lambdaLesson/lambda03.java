package lambdaLesson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class lambda03 {
    public static void main(String[] args) {
        List<String> menu = new ArrayList<>(Arrays.asList("trileçe", "havucDilim", "güvec", "kokorec",
                "küşleme", "arabAşı", "waffle", "künefe"));

        alfByktekrsz(menu); //ARABAŞI GÜVEC HAVUCDİLİM KOKOREC KÜNEFE KÜŞLEME TRİLEÇE WAFFLE
        System.out.println();
        chrSayisitersSiraliUnique(menu); //10 7 6 5
        System.out.println();
        chrSayisiBykSirali(menu); //güvec waffle künefe trileçe kokorec küşleme arabAşı havucDilim
        System.out.println();
        harfsayisi7denAzKontrol(menu);
        System.out.println();
        wIleBaslayanElKontrol(menu);
        System.out.println();
        xIleBitenElKontrol(menu);
        System.out.println();


    }

    // Task -1 : List elemanlarini alafabetik buyuk harf ve  tekrarsiz print ediniz.

    //toUpperCase kisminda kardar buyuk harfler elde edildi.
    //sorted alfabetik siraya soktu
    //distinct tekrarsiz alim icin. 10 tane aynisida olsa birini alir
    //print icin forEach kullanilir.

    public static void alfByktekrsz(List<String> yemek) {
        yemek.
                stream().//akis basladi
                map(String::toUpperCase). //Buyuk harf
                sorted().// dogal siralandi alfabetik
                distinct(). //elemanlarin tekrarsiz olmasi icin
                forEach(t -> System.out.print(t + " "));


    }

    // Task -2 : list elelmanlarinin character sayisini ters sirali olarak tekrarsiz print ediniz.

    //unique tekrarsiz demek
    //String::length kodundan sonra list icindekiler artik character sayisiyla girildi.
    //Comparator.reverseOrder kisminda ters siralandi

    public static void chrSayisitersSiraliUnique(List<String> ikram) {
        ikram.stream(). //akis alindi
                map(String::length).//akisi guncelledim.kelimelerin uzunlugu olarak
                sorted(Comparator.reverseOrder()). //ters sirali
                distinct(). //tekrarsiz icin
                forEach(Lambda01::yazdir); //print icin.

    }

    // Task-3 : List elemanlarini character sayisina gore kckten byk e gore print ediniz..


    public static void chrSayisiBykSirali(List<String> ikram) {
        ikram.stream().
                sorted(Comparator.comparing(String::length)).// String ifadeleri karakter sayisina gore k-> ye gore siraladim.
                //forEach(t-> System.out.print(t+" "));//print 1.yol
                        forEach(Lambda01::yazdir);// print 2.yol
    }

    // ******************************************************************************************
    // *********************** anyMatch() *** allMatch() **** noneMatch() ************************
    //*******************************************************************************************

    //anyMatch() --> enaz bir eleman sarti saglarsa true aksi durumda false return eder
    //allMatch() --> tum  elemanlar sarti saglarsa true en az bir eleman sarti saglamazsa false return eder.
    //noneMatch()--> hic bir sarti SAGLAMAZSA true en az bir eleman sarti SAGLARSA false return eder.


    // Task-4 : List elemanlarinin karakter sayisini 7 ve 7 'den az olma durumunu kontrol ediniz.
    public static void harfsayisi7denAzKontrol(List<String> ikram) {
        System.out.println(ikram.
                stream().
                allMatch(t -> t.length() <= 7) ? "list elemanlari 7 ve daha az harften olusuyor" :
                "list elemanlari 7 harften buyuk");


    }

    // Task-5 : List elelmanlarinin hepsinin "w" ile baslamasını noneMatch() ile kontrol ediniz.
    public static void wIleBaslayanElKontrol(List<String> ikram) {
        System.out.println(ikram.
                stream().
                noneMatch(t -> t.startsWith("w")) ? "w ile yemek ismi mi olur" :
                "w ile yemek icat ettik");
    }

    // Task-6 : List elelmanlarinin "x" ile biten en az bir elemanı kontrol ediniz.
    public static void xIleBitenElKontrol(List<String> ikram) {
        System.out.println(ikram.stream().anyMatch(t -> t.endsWith("x")) ? "maşallah" : "x ile yemek ismi mi biter");
    }

    // Task-7 : Karakter sayisi en buyuk elemani yazdiriniz.
    public static void charSayisiEnBykElPrint(List<String> ikram) {
        Stream<String> sonIsim = ikram.
                stream(). // akış sağlandı
                        sorted(Comparator.comparing(t -> t.toString().length()).
                        reversed()). // karakter sayısına göre terden sıralandı
                        limit(1);// limit metodu kullanılarak sadece ilk eleman çağrıldı
        // limit() metodunun dönen değeri Stream<String> yapıdadır

        System.out.println(Arrays.toString(sonIsim.toArray()));
        // sonIsim.toArray() --> Stream olan akış Artray e çevrildi
        // Arrays.toString(sonIsim.toArray()) --> Arrayı string yapıya çeviriyor

    }
    // Task-8 : list elemanlarini son harfine göre siralayıp ilk eleman hariç kalan elemanlari print ediniz.
}
