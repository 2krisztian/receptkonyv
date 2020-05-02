
CREATE DATABASE IF NOT EXISTS receptkonyv CHARACTER SET utf8mb4 COLLATE utf8mb4_hungarian_ci; 
USE receptkonyv;

CREATE TABLE `felhasznalok` (
  `felhID` int(11) NOT NULL,
  `fhNEV` varchar(40) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `fhJelszo` longtext COLLATE utf8mb4_hungarian_ci NOT NULL,
  `fhEmail` varchar(100) COLLATE utf8mb4_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;


INSERT INTO `felhasznalok` (`felhID`, `fhNEV`, `fhJelszo`, `fhEmail`) VALUES
(40, 'receptchef', 'recept', 'receptchef@gmail.com'),
(42, 'Teszt01', 'Teszt01', 'Teszt01@gmail.com'),
(43, 'teszt02', 'teszt02', 'teszt02@gmail.com'),
(44, 'teszt03', 'teszt03', 'teszt03@gmail.com');

CREATE TABLE `kedvencek` (
  `receptid` int(11) NOT NULL,
  `kedvenc` tinyint(1) NOT NULL,
  `fhNev` text COLLATE utf8mb4_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

INSERT INTO `kedvencek` (`receptid`, `kedvenc`, `fhNev`) VALUES
(109, 1, 'receptchef'),
(116, 1, 'teszt01'),
(115, 1, 'teszt01'),
(118, 1, 'teszt02'),
(120, 1, 'teszt03'),
(119, 1, 'teszt03');


CREATE TABLE `recept` (
  `receptid` int(5) NOT NULL,
  `nev` text COLLATE utf8mb4_hungarian_ci NOT NULL,
  `kategoria` text COLLATE utf8mb4_hungarian_ci NOT NULL,
  `leiras1` text COLLATE utf8mb4_hungarian_ci NOT NULL,
  `leiras2` text COLLATE utf8mb4_hungarian_ci DEFAULT NULL,
  `alkoto` text COLLATE utf8mb4_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;


INSERT INTO `recept` (`receptid`, `nev`, `kategoria`, `leiras1`, `leiras2`, `alkoto`) VALUES
(109, 'krumplipüre ', 'Pürék', '1 liter tej \n1 szelet margarin \n1 zacsko krumplipüre por ', '\nTej felmelegítése, később ebben a margarin elolvasztása, majd a por hozzáadása. ezt kevergetni amég be nem sűrüsödik.', 'receptchef'),
(110, 'Fasirt', 'Hús', '2 kg darálthús \n2 egész tojás \n5 kiskanál pirospaprika \ntubus fokhagyma 3 kiskanál \nfokhagymapor \ndelikát ételizesítő \nörölt kömény \nmajoranna\n6 kifli \n0,5 liter víz \ncsipet só \nolaj', 'Ellősször egy nagy tálba beletesszük a húst.  Beásztatunk egy kissebb tálban a vízben  6 kiflit, amikor jól beázott kinyomjuk belöle a vizet és belemorzsoljuk a nagy tálba a húshoz. A két egész tojást beleütjük, hozzáadjuk a pirospaprikát, a fokhagymákat, a köményt és a sót. \n\nEzeket jól átgyurjuk kézzel vagy robotgéppel. Ezután begombócozzuk tetszőleges méretre. \n\nEgy serpenyőbe beleöntjük az olajat és ebben sötétbarnára sütjük a fasitgolyókat. \nKiszedjük egy tányérra amire ellősször egy törlőpapirt teszünk, hogy a fasirtról feligya a nem szükséges olajat.\n\nÍzlés szerint tálaljuk.', 'zz'),
(115, 'MÁKOS PALACSINTA', 'Palacsinta', 'Tészta :\n150 g liszt\n100 g darálatlan mák\n2 db  tojás\n2 csomag vaníliás cukor\n1 tk cukor\n2 ek zsír\n1 dl tej\n2 dl szénsavas ásványvíz\nolaj a sütéshez\nVaníliás krém:\n1 csomag pudingpor (vaníliás)\n3 ek cukor\n2 tk vaníliás cukor\n3 dl tej\n2 dl víz\n100 g vaj vagy  margarin\nA palacsinta töltéséhez:\nszilvalekvár', 'Belekeverjük a lisztbe a mákot és a zsírt, majd felolvasztjuk. A tojásokat elkeverjük a cukrokkal, majd hozzáadjuk a korábban liszttel felolvasztott mák és zsír felét, aztán simára keverjük. Ezután hozzáadjuk a maradék lisztet, a tejet és a vizet, majd addig kevergetjük, amíg szép sima nem lesz a tészta.\n\nKikenjük olajjal a palacsintasütőt, aztán kisütjük benne a palacsintákat. Ezután a pudingport összekeverjük a cukrokkal, majd kevés tejjel csomómentesre keverjük. Ha ezzel megvagyunk, hozzáadjuk a többi tejet és a vizet is és megfőzzük. Még forrón belekeverjük a margarint. A palacsintákat megtöltjük a lekvárral és leöntjük vaníliás krémmel. ', 'Teszt01'),
(116, 'SVÉD BARACKOS PALACSINTA öntet', 'Öntet ', '6-8 palacsinta\n1 üveg vagy két doboz őszibarack kompót\n5 dkg csokoládé\n1 diónyi vaj', 'A palacsintát és a kompótot rétegesen egy üvegtálba helyezzük,  majd fél órára hűvösre tesszük. Két kanál víz hozzáadásával megolvasztjuk a csokoládét, majd a tűzről lehúzva hozzákeverjük  a diónyi vajat.\n\nForrón a palacsintákra öntjük, és azonnal tálaljuk.', 'Teszt01'),
(117, 'BIRKAPÖRKÖLT FŐTT KRUMPLIVAL', 'Pörkölt ', '4 fej vöröshagyma\n2 ek zsír\n1 db csemege fehér paprika\n1 db csípős zöldpaprika\n2 db paradicsom\nőrölt pirospaprika\n1,5 kg birkahús belsőségekkel (szív,vese,máj)\nvíz\nsó\nbors\nKörethez:\n2 kg burgonya\nsó\n2 db babérlevél\nvíz', 'Az apróra vágott vöröshagymát a felolvasztott zsíron megpirítjuk. Ezután hozzáadjuk az apróra vágott fehér- és zöldpaprikát és paradicsomot. Összesütjük egy kicsit és hozzáadjuk a pirospaprikát, majd ezzel is kicsit „sütjük” hogy finom illata legyen a fűszerpaprikának.\n\nEzután hozzáadjuk a húst a belsőségekkel és takarék lángon hagyjuk, hogy a hús levet adjon, majd ezután fokozatosan adagoljuk hozzá a vizet. Az a lényeg, hogy szép és sűrű szaftja legyen a pörköltnek mire megfő. Sóval és borssal ízesítjük ízlés szerint.\n\nAmeddig a pörkölt fő, meghámozzuk a burgonyát és enyhén sós, babérleveles vízben megfőzzük azt. A kész pörköltet a burgonyával tálaljuk. Tálaláskor savanyúsággal kínáljuk.', 'teszt02'),
(118, 'BORSÓLEVES MÁJGALUSKÁVAL', 'Levesek ', 'A leveshez:\n2 db sárgarépa\n1 db fehérrépa\n1 db vöröshagyma\n1 db karalábé\npetrezselyemzöld\nolaj\n20 dkg zöldborsó\nliszt\nsó\negész bors\nbazsalikom\nkakukkfű\nA májgaluskához:\n20 dkg sertésmáj\n2 db  tojás\n1 db vöröshagyma (reszelve)\n2 gerezd fokhagyma\n2 db zsemle\nzsemlemorzsa\n1 ek vágott petrezselyemzöld\nsó\nőrölt bors', 'A leveshez megpucoljuk és felaprítjuk a zöldségeket: a sárga- és fehérrépát, a vöröshagymát és a karalábét. A petrezselyemzöldet felaprítjuk, és egy evőkanállal félreteszünk belőle a gombócokhoz.\n\nEgy kevés olajon megdinszteljük a hagymát, amiből szintén félreteszünk egy evőkanállal a gombóchoz. Ehhez hozzáadjuk a répát, a karalábét, és ezzel együtt pirítjuk még 5 percig, majd beletesszük a borsót és a petrezselymet. A zöldségeket megszórjuk liszttel, átkeverjük és hozzáöntünk egy kevés vizet. Ízlés szerint megsózzuk, megborsozzuk, megszórjuk bazsalikommal és kaukukkfűvel, és addig főzzük, amíg meg nem puhulnak a zöldségek.\n\nKözben elkészítjük a gombócokat is. A májat lereszeljük, majd a tojással, a megpirított hagymával, az áttört fokhagymával, a beáztatott és kinyomkodott zsemlével és annyi zsemlemorzsával összekeverjük. Petrezselyemmel, sóval, borssal ízesítjük. Vizes kézzel gombócokat formázunk a masszából. (Ha túl lágy a massza, adunk még hozzá zsemlemorzsát.) Legalább 20 percig pihentetjük.\n\nAmikor megfőttek a zöldségek, a leveshez adjuk a gombócokat, és további 10 percig főzzük. Eperlevéltészta illik hozzá. ', 'teszt02'),
(119, 'TEPERTŐS-SAJTOS POGÁCSA', 'Sütemény ', '50 dkg liszt (+ a deszkához)\n3 dkg friss élesztő\n2-2,5 dl  tejföl\n1 db  tojás\n1 ek só\n1 csipet őrölt fehérbors\n15 dkg tepertő (darált)\n1 ek zsír\n1 ek tejszín\nA tetejére:\n1 ek zsír\n2 marék reszelt sajt\n1 db  tojás', 'A lisztbe belemorzsoljuk a friss élesztőt, hozzáadjuk a tejfölt, a tojást, sót, borsot, a darált tepertőt, a zsírt és a tejszínt, majd géppel sima, ruganyos, de nem kemény tésztát dagasztunk, végül meleg helyen duplájára kelesztjük.\n\nMiután megkelt, lisztezett deszkán vékonyra nyújtjuk, megkenjük olvasztott zsírral vékonyan, majd egy maréknyi reszelt sajttal megszórjuk, majd két végéről behajtjuk a tésztát (az alsó felét a közepéig, a felső részt szintén a közepéig, majd jobbról és balról is a közepéig). Konyharuhával letakarjuk és 30 percig pihentetjük.\n\nEzután újra kinyújtjuk, zsírral vékonyan átkenjük és a maradék sajttal megszórjuk, majd újra hajtogatjuk, és újabb 30 percig pihentetjük.\n\nEzután kb. újjnyi vastagra nyúhjtjuk, a tetejét bevagdossuk, majd átkenjük 1 egész felvert tojással. Pogácsaszaggatóval kiszaggatjuk, szilikonos sütőpapírra helyezzük és 25 percig a sütőlemezen pihentetjük.\nA sütőt előmelegítetjük 180 fokra, és a pogácsákat aranybarnára sütjük.', 'teszt03'),
(120, 'HATLAPOS SÜTEMÉNY', 'Sütemény', 'A tésztához:\n1/2 dl tej\n1 csomag szalalkáli\n30 dkg liszt (+ a sütéshez)\n30 dkg rétesliszt\n12 dkg margarin (+ a sütéshez)\n10 dkg porcukor\n2 db  tojás\n1 ek olvasztott méz\nA krémhez:\n30 dkg cukor\n2 dl víz\n1 l tej\n3 db  tojás\n5 ek rétesliszt\n1 ek kakaópor\n25 dkg margarin\n1 csomag vaníliás cukor', 'A tésztához forró tejben felfuttatjuk a szalalkálit, hozzáadjuk a kétféle lisztet, a margarint, a porcukrot, a tojást és a mézet. Összegyúrjuk annyi tejet adva hozzá, hogy könnyen lehessen sodorni.\n\n30 perc pihentetés után 6 cipóra osztjuk, kinyújtjuk, és jól kivajazott és kilisztezett tepsi hátán egyenként világosra sütjük.\n\nA töltelékhez megpirítjuk a cukrot, és felengedjük a vízzel. Utána a tejben elkeverjük a tojást, a réteslisztet és a kakaót. A pirított cukorhoz adjuk, és sűrűre főzzük. Még forrón belekeverjük a margarint és a vaníliás cukrot. Végül megtöltjük a krémmel a lapokat, és néhány órát pihentetjük.', 'teszt03');


ALTER TABLE `felhasznalok`
  ADD PRIMARY KEY (`felhID`);
  
ALTER TABLE `recept`
  ADD PRIMARY KEY (`receptid`);
  
ALTER TABLE `felhasznalok`
  MODIFY `felhID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=42;
  
ALTER TABLE `recept`
  MODIFY `receptid` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=115;
COMMIT;




GRANT USAGE ON *.* TO 'chef'@'localhost' IDENTIFIED BY PASSWORD '*16BBF8FDE9FB9CBDD2141FA3F6239C267C4FA466';

GRANT SELECT, INSERT, UPDATE, DELETE ON `receptkonyv`.* TO 'chef'@'localhost';