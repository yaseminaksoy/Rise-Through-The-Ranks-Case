# Rise-Through-The-Ranks-Case
<b>Docker ile derleme:</b>

case-Kartaca projesinde komut isteminde case-Kartaca\src\main\resources dizinine gidilir. </br>
Ardından docker-compose -f docker-compose.yml up -d komutu çalıştırılarak kafka ve mongodb için gerekli image lar projeye yüklenir. 

<b>Servislere istek atma:</b>

Proje çalıştırıldıktan sonra postmande http://localhost:8080/personals adresine istenilen GET,POST,PUT ve DELETE istekleri atılabilmektedir. POST ve PUT istekleri için parametre yazmaya gerek yoktur. Her bir istek sonucunda string mesaj(örneğin get için 'get personal was called') dönülmektedir. </br>Atılan istekler sonucunda Kafka'ya gönderilen log bilgileri konsolda yazdırılır, ayrıca MongoDb kullanılarak veritabanına kaydedilmektedir.


<b>Özel anahtar kodu : </b>
gAAAAABgZssqIUrKbVhp31fMgkfifmvCcozwLCGHubfadMomQed0ZwFG2lED7gqbZurZULCHzkZWQCzgysnuRayzHOmHABoHJK9kwxQIz5YJx8Q7IpM0Z7uNHthtBcrT8zZ-VCkH_kJg1HAYIqURh0UGKa2wHvx0k44uxvmPEhu_y1sj3iFimPiKuhM_iE4DHaM9joZIvZ4guvGAuiCet0OONpAjaNWxGQ==

