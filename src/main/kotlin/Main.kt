import dresseur.Entraineur
import monde.Zone
import monstres.EspeceMonstres
import monstres.IndividuMonstre

var joueur = Entraineur(1, "Sacha", 100)
var rival = Entraineur(2, "Regis", 200)

var especeSpringleaf = EspeceMonstres(
    id = 1,
    nom = "Springleaf",
    type = "Graine",
    baseAttaque = 9,
    baseDefense = 11,
    baseVitesse = 10,
    baseAttaqueSpe = 12,
    baseDefenseSpe = 14,
    basePv = 60,
    modAttaque = 6.5,
    modDefense = 9.0,
    modVitesse = 8.0,
    modAttaqueSpe = 7.0,
    modDefenseSpe = 10.0,
    modPv = 34.0,
    description = "Petit monstre espiègle rond comme une graine, adore le soleil.",
    particularites = "Sa feuille sur la tête indique son humeur.",
    caractères = "Curieux, amical, timide"
)

var especeFlamkip = EspeceMonstres(
    id = 4,
    nom = "Flamkip",
    type = "Animal",
    baseAttaque = 12,
    baseDefense = 8,
    baseVitesse = 13,
    baseAttaqueSpe = 16,
    baseDefenseSpe = 7,
    basePv = 50,
    modAttaque = 10.0,
    modDefense = 5.5,
    modVitesse = 9.5,
    modAttaqueSpe = 9.5,
    modDefenseSpe = 6.5,
    modPv = 22.0,
    description = "Petit animal entouré de flammes, déteste le froid.",
    particularites = "Sa flamme change d’intensité selon son énergie.",
    caractères = "Impulsif, joueur, loyal"
)

var especeAquamy = EspeceMonstres(
    id = 7,
    nom = "Aquamy",
    type = "Meteo",
    baseAttaque = 10,
    baseDefense = 11,
    baseVitesse = 9,
    baseAttaqueSpe = 14,
    baseDefenseSpe = 14,
    basePv = 27,
    modAttaque = 9.0,
    modDefense = 10.0,
    modVitesse = 7.5,
    modAttaqueSpe = 12.0,
    modDefenseSpe = 12.0,
    modPv = 55.0,
    description = "Créature vaporeuse semblable à un nuage, produit des gouttes pures.",
    particularites = "Fait baisser la température en s’endormant.",
    caractères = "Calme, rêveur, mystérieux"
)

var especeLaoumi = EspeceMonstres(
    id = 8,
    nom = "Laoumi",
    type = "Animal",
    baseAttaque = 11,
    baseDefense = 10,
    baseVitesse = 9,
    baseAttaqueSpe = 8,
    baseDefenseSpe = 11,
    basePv = 22,
    modAttaque = 11.0,
    modDefense = 8.0,
    modVitesse = 7.0,
    modAttaqueSpe = 6.0,
    modDefenseSpe = 11.5,
    modPv = 58.0,
    description = "Petit ourson au pelage soyeux, aime se tenir debout.",
    particularites = "Son grognement est mignon mais il protège ses amis.",
    caractères = "Affectueux, protecteur, gourmand"
)


fun main() {

    val monstre1 = IndividuMonstre(1, "springleaf", expInit = 1500.0, espece = especeSpringleaf)
    val monstre2 = IndividuMonstre(2, "flamkip", expInit = 1500.0, espece = especeFlamkip)
    val monstre3 = IndividuMonstre(3, "aquamy", expInit = 1500.0, espece = especeAquamy)

    monstre1.afficheDetail()

    val route1 = Zone(
        id = 1,
        nom = "Route 1",
        especesMonstres = mutableListOf(especeSpringleaf, especeFlamkip),
        expZone = 200
    )
    val route2 = Zone(
        id = 2,
        nom = "Route 2",
        especesMonstres = mutableListOf(especeLaoumi, especeAquamy),
        expZone = 400

    )


    route1.zoneSuivante = route2
    route2.zonePrecedante = route1

    // Suite du programme...


    /*
   route1.zoneSuivante = route2
   route2.zonePrecedente = route1
   /*eur.afficheDetail()
   rival.afficheDetail()
   joueur.argents+=50
   joueur.afficheDetail()
   println(especeFlamkip.afficheArt())
   println(especeAquamy.afficheArt())
   println(especeSpringleaf.afficheArt())*/


 */
}

/**
 * Change la couleur du message donné selon le nom de la couleur spécifié.
 * Cette fonction utilise les codes d'échappement ANSI pour appliquer une couleur à la sortie console. Si un nom de couleur
 * non reconnu ou une chaîne vide est fourni, aucune couleur n'est appliquée.
 *
 * @param message Le message auquel la couleur sera appliquée.
 * @param couleur Le nom de la couleur à appliquer (ex: "rouge", "vert", "bleu"). Par défaut c'est une chaîne vide, ce qui n'applique aucune couleur.
 * @return Le message coloré sous forme de chaîne, ou le même message si aucune couleur n'est appliquée.
 */

fun changeCouleur(message: String, couleur: String = ""): String {
    val reset = "\u001B[0m"
    val codeCouleur = when (couleur.lowercase()) {
        "rouge" -> "\u001B[31m"
        "vert" -> "\u001B[32m"
        "jaune" -> "\u001B[33m"
        "bleu" -> "\u001B[34m"
        "magenta" -> "\u001B[35m"
        "cyan" -> "\u001B[36m"
        "blanc" -> "\u001B[37m"
        else -> "" // pas de couleur si non reconnu
    }
    return "$codeCouleur$message$reset"


}



