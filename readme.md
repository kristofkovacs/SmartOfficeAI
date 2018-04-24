# SmartServerRoomsAI 

Az alkalmazásunk az AgentSpeak Jason libraryt használja.

Az alkalmazásban szerverek, szerverszobák teljeskörű, komplex biztonsági védelmét támogatni különböző intelligens, együttműködő ágensek segítségével. A rendszer képes megelőzni illetve jelezni az illetéktelen behatolást, valamint tűz esetén megtenni a szükséges óvintézkedéseket a szerverek és adatok biztonságának megóvása érdekében.

**Négy szerverszoba szimultán működését modellezzük**, amelyek **minden biztonsági és védelmi feladatra reagálnak és ezt kommunikálják a többi szerverszoba felé** is, hogy megtörténhessenek a szükséges óvintézkedések. 
Ha füstöt, vagy magas hőmérsékletet érzékel bármely szoba, akkor lezárja a szoba ajtajait, hogy a többi szerverszobába ne terjedjen át a tűz, illetve a szervereken tárolt adataról biztonsági mentést kezd készíteni a többi szerverszoba tárhelyére. Amikor ez kész van, akkor leállítja a szobában lévő szervereket.
Emellett értesíti a tűzoltókat és az épület gondnokát, hogy ezek a szükséges óvintézkedéseket meg tudják tenni. 
Ha valaki belép a szerverszobákba, akkor a mozgásérzékelő ezt észleli és egy 30 másodperces időlimitet hagy arra, hogy az illető a biztonsági kódját beírja és ezzel megelőzhesse a riasztó beindulását.

Szeretnénk egy grafikus kezelőfelületet készíteni, ahol a szenzorok által “észlelt” értékeket szimuláljuk TextFieldek és Checkboxok segítségével. És a rendszer reakcióját az inputokra pedig Label-ekben jelenítenénk meg.

A rendszer a következő **bemenetek**kel rendelkezik:
- Füstérzékelő
- Mozgásérzékelő
- Hőmérő
- Riasztó kezelő panel

Egy adott szerverszobához tartozó szenzor mért adatait az ágensek feldolgozzák, és ha valamilyen védelmi vagy biztonsági intézkedésre szükség van, akkor ezt közlik a többi szerverszobával, és azok is reagálnak rá a megfelelő módon.

A szobák az alábbi **ágensek**kel rendelkeznek:
- Biztonsági Rendszer (Security System)
- Védelmi rendszer (Safety System)

## Funcionalitás:

**Biztonsági rendszer (Security System)**
- Ha be van kapcsolva a riasztó és mozgás van, akkor ezt jelezzük
- Ha a kódot nem sikerül beadni 30 másodpercen belül, akkor jelzünk

**Védelmi rendszer (Safety System)**
- Ha a védelmi rendszer valami kritikus esetet észlel, akkor azt jelzi
- Figyeljük, ha füstöt érzékelünk
- Védelmi probléma esetén értesíteni képes a tűzoltókat
- Kezelni tudja az ajtók zárását és nyitását a szerverszobán
- Közölje azt, hogy melyik szobában történt az eset
- Át tudjuk menteni az adatokat egy másik szerverszoba szervereire

