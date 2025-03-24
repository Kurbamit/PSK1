1.1. Paspausti RUN, automatiškai surinks projektą ir paleis FE. \
1.2. Dalykinis serveris: Settings | Build, Execution, Deployment | Application Servers. \
1.3. GitHub: https://github.com/Kurbamit/PSK1 \
2.2. DB kūrimas src/main/java/lt.vu/entities esybėse. \
2.3. MyBatis mapper'iai. \
**CarMapper**: \
`resultMap` aprašo, kaip Java klasės laukai atitinka DB lentelės stulpelius. \
`association` (`OWNER_ID`) – susieja automobilį su jo savininku (`Owner`). \
`collection` (`PART_CAR`) – susieja automobilį su jo dalimis (`Part`). \
**OwnerMapper**: \
`collection` laukui `cars` naudoja `selectByOwnerId`, kuris suranda visus savininko automobilius. \
**PartMapper**: \
`collection` (`cars`) užpildo automobilių sąrašą pagal tarpinę lentelę `PART_CAR`. \
```mvn mybatis-generator:generate``` \
3.2. 

| Anotacija            | Gyvavimo laikas              | Kada naudoti?                                       |
|----------------------|------------------------------|-----------------------------------------------------|
| `@RequestScoped`     | Tik vienos užklausos metu    | Greiti, laikini duomenys (pvz., formos apdorojimas) |
| `@SessionScoped`     | Visoje vartotojo sesijoje    | Saugo vartotojo duomenis tarp puslapių              |
| `@ApplicationScoped` | Programos veikimo metu       | Bendri duomenys visiems vartotojams                 |
| `@Inject`            | Įterpia CDI komponentą       | Vietoj `new ClassName()` objektų sukūrimui          |

3.3.1 DAO ORM/JPA: 
- **JPA esybės** (pvz., `Car`, `Owner`, `Part`) – duomenų bazės lentelių atvaizdai.
- **DAO klasės** – teikia CRUD operacijas (`create`, `read,` `update`, `delete`).
- **CDI anotacijos** (`@Transactional`, `@Inject`) – valdo transakcijas ir priklausomybių įterpimą.

3.3.2. DAO MyBatis:
- DAO komponentas su **MyBatis** naudoja **mapper interfeisus** ir **XML failus**, kad bendrautų su DB.
- **DAO komponentų struktūra**:
  - **Java Entity klasės** (`Car`, `Owner`, `Part`).
  - **Mapper interface** (pvz., `CarMapper.java`).
  - **XML Mapper failas**, kuriame aprašytos SQL užklausos (pvz., `CarMapper.xml`).

### 3.4. ORM vs DataMapper:
**ORM**:
- **Pagrindinė idėja:** ORM sukuria tiesioginį ryšį tarp duomenų bazės lentelių ir programos objektų.
- **Privalumai**:
  - **Paprastumas ir greitas kūrimas** - mažiau kodo, greičiau pradėti dirbti
  - **Automatizuotas darbas** - daugelis operacijų atliekamos automatiškai
  - **Integracija** - lengvai integruojama į esamus kodo karkasus
  - **Nuoseklumas** - užtikrina vienodą duomenų manipuliavimą
- **Trūkumai**:
  - **Našumo problemos** - gali generuoti neoptimalias užklausas
  - **Nelanksčios užklausos** - kartais sunku atlikti sudėtingas užklausas
  - **Sudėtingumas su sudėtingais modeliais** - sunku valdyti labai sudėtingus modelius

**DataMapper**:
- **Pagrindinė idėja:** Atskiras sluoksnis (mapper) tvarko duomenų perkėlimą tarp duomenų bazės ir programos objektų.
- **Privalumai**:
  - **Atskyrimas** - duomenų sluoksnis griežtai atskirtas nuo verslo logikos
  - **Lankstumas** - lengviau pritaikyti specifinėms situacijoms
  - **Optimizavimas** - galima optimizuoti užklausas
- **Trūkumai**:
  - **Daugiau kodo** - reikia rašyti daugiau kodo nei su ORM
  - **Sudėtingesnis palaikymas** - daugiau kodo reiškia daugiau palaikymo
  - **Ilgesnis kūrimo laikas** - užtrunka ilgiau pradėti dirbti

### Kada ką geriau naudoti?:
**ORM tinka**:
- Mažesnėms ar vidutinio dydžio aplikacijoms
- Kai svarbiau greitai sukurti produktą
- Standartiniams CRUD veiksmams
- Prototipams ar MVP (minimum viable product)

**DataMapper tinka**:
- Didelėms, sudėtingoms sistemoms
- Kai našumas yra kritiškai svarbus
- Kai reikia sudėtingų užklausų ir operacijų
- Sistemoms su sudėtinga verslo logika
- Kai reikalingas aiškus sluoksnių atskyrimas

3.5. `@Transactional` anotacija: Užtikrina, kad metodai vyksta tranzakcijos kontekste