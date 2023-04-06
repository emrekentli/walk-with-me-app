

![Logo](https://i.hizliresim.com/jbmz4fr.png)

    
# Doggo Walk With Me App

Öncelikle projem, 2 Mikroservis (Eureka ve Gateway hariç.) 8 adet tablodan oluşmaktadır.   
**Animal Type**  
Bu tablo hayvanların ismini tutmak için bulunuyor. İçerisinde Name alanı bulunuyor. Bu alanı biz Köpek olarak doldurabiliriz.  
**Animal**  
Bu tablo, hayvanımızın adını, cinsini, sahibinin id’sini, kilosunu ve animal type tablosuyla eşlediğimiz animal_type_id’sini tutuyor.  
Bu tablo müşterilerin hayvanlarını sisteme ekleyebilmesi için bulunuyor.  
**User**  
Bu tablo müşterilerin ve yürütücülerin ortak bilgilerinin bulunduğu, sisteme giriş yapacakları bilgileri bulunduruyor.  
**Customer ve Walker**   
Bu tablolar içlerinde kullanıcıların id’sini bulunduruyor. Customer Müşteriyi, Walker yürütücüyü temsil ediyor.  
**Reservation Request**  
Bu tablo müşterilerin hayvanları için yürüyüş isteklerini tutar. Burada müşteri başlangıç ve bitiş vaktini girip, hayvanının id’sini girdikten sonra kayıt oluşturur.  
**Reservation**  
Bu tablo, walkerların, reservation requesti seçip onayladıktan sonra oluşan rezervasyonları bulundurur.  
**Walk**
Bu tablo ise walker’ın rezervasyona 5 dakika kala onayla butonuna bastıktan sonra başlayan yürüyüş kayıtlarını tutar. 

# Kullanılan Pathler : 
•	Reservations  
•	Reservation-requests  
•	Walkers  
•	Walks  
•	Customers  
•	Users  
•	Animals  
•	Animal-types  

**Bu pathlerde kullanılan HTTP Metodları**  
Tüm pathlerde GET, POST , PUT ve DELETE Olmalıdır.
