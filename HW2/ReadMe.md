* Clothing : Interface
1. getAdj : Get each clothing’s adjective.
2. getNoun : Get each clothing’s noun.
3. getDefense: Get each clothing’s defense value.
4. getAttack: Get each clothing’s attack value.
5. getType: Used as classifying different types when picking equipments in the battle.


* HeadGear / HandGear / Footwear : Concrete class
1. Three types of clothing.
2. Each character can only pick up 1 head-gear, while 2 hand-gear and footwear individually is allowed(Need to combine).


* Human : Concrete class
1. Constructor : Initialize attack value / defense value / equipment arrays.
2. pickUpHeadGear : Can only pick up 1. Compared by defense value.
3. pickUpHandGear : Can pick up 2. Names and values are combined. Compared by attack value.
4. pickUpFootwear : Can pick up 2. Names and values are combined. Total strengths(attack +  defense) are considered first, then compared by attack value over defense value
Ex: obj1(att: 4 / def: 6) is better than obj2(att: 7 / def: 1) because obj1 has higher total strengths.
Ex: obj3(att: 7 / def: 5) is better than obj2(att: 3 / def: 9) because obj3 has higher attack value while they share equal total strengths(12).
5. getBasicDefense / getBasicAttack : Get each character’s basic ability values which remain the same through the entire game.
6. getTotalDefense / getTotalAttack : Get each character’s total ability values after dressing with equipment in the battle.
7. getCurrentHeadGear / getCurrentHandGear / getCurrentFootwear : Get current equipment.


* Battle : Concrete class
1. Constructor : Create 10 items(can be repeated)(mixed) for each character to choose from.
2. startBattle : Pick up the best equipment from the arrays before battle. Them calculate the damage to decide who’s the winner.
Ex: P1(att: 20 / def: 15) wins over P2(att:17 / def: 12) because P1(20 - 12 = 8) has greater damage than P2(17 - 15 = 2).
Ex: P1(att: 20 / def: 15) has a tie with P2(att: 13 / def: 22) because P1(20 - 22 = -2) has same damage as P2(13 - 15 = -2).