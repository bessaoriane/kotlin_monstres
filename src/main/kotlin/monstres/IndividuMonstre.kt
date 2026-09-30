package monstres

import dresseur.Entraineur
import kotlin.random.Random
import kotlin.math.pow
import kotlin.math.roundToInt

class IndividuMonstre(
    val id: Int,
    var nom: String,
    val espece: EspeceMonstres,
    var entraineur: Entraineur?=null,
    val expInit: Double
    ){
    var niveau: Int = 1

    var attaque: Int = espece.baseAttaque + (-2..2).random()
    var defense: Int = espece.baseDefense + (-2..2).random()
    var vitesse: Int = espece.baseVitesse + (-2..2).random()
    var attaqueSpe: Int = espece.baseAttaqueSpe + (-2..2).random()
    var defenseSpe: Int = espece.baseDefenseSpe + (-2..2).random()

    var pvMax: Int = espece.basePv + (-5..5).random()

    var potentiel: Double = Random.nextDouble(0.5, 2.0)

    var exp: Double = 0.0

    /**
     *  @property pv  Points de vie actuels.
     * Ne peut pas être inférieur à 0 ni supérieur à [pvMax].
     */
    var pv: Int = pvMax
        get() = field
        set(nouveauPv) {
            field=nouveauPv
        }

    init {
        this.exp = expInit // applique le setter et déclenche un éventuel level-up
    }

    /**
     * Calcule l'expérience totale nécessaire pour atteindre un niveau donné.
     *
     * @param niveau Niveau cible.
     * @return Expérience cumulée nécessaire pour atteindre ce niveau.
     */
    fun palierExp(niveau: Int): Double {
        return 100 * (niveau - 1).toDouble().pow(2)
    }

    fun levelUp(){
        niveau++

        attaque += (espece.modAttaque * potentiel).roundToInt() + (-2..2).random()
        defense += (espece.modDefense * potentiel).roundToInt() + (-2..2).random()
        vitesse += (espece.modVitesse * potentiel).roundToInt() + (-2..2).random()
        attaqueSpe += (espece.modAttaqueSpe * potentiel).roundToInt() + (-2..2).random()
        defenseSpe += (espece.modDefenseSpe * potentiel).roundToInt() + (-2..2).random()

        val ancienPvMax = pvMax

        pvMax += (espece.modPv * potentiel).roundToInt() + (-5..5).random()

        pv += pvMax - ancienPvMax

    }

    /**
     * Attaque un autre [IndividuMonstre] et inflige des dégâts.
     *
     * Les dégâts sont calculés de manière très simple pour le moment :
     * `dégâts = attaque - (défense / 2)` (minimum 1 dégât).
     *
     * @param cible Monstre cible de l'attaque.
     */

    fun attaquer(cible: IndividuMonstre) {
        val degatBrut = this.attaque

        var degatTotal = degatBrut - (cible.defense / 2)

        if (degatTotal < 1) {
            degatTotal = 1
        }

        val pvAvant = cible.pv

        cible.pv -= degatTotal

        val pvApres = cible.pv

        println("${this.nom} inflige ${pvAvant - pvApres} dégâts à ${cible.nom}.")
    }

    /**
     * Demande au joueur de renommer le monstre.
     * Si l'utilisateur entre un texte vide, le nom n'est pas modifié.
     */
    fun renommer() {
        println("Renommer $nom ?")
        val nouveauNom = readln()

        if (nouveauNom.isNotEmpty()) {
            nom = nouveauNom
        }
    }

    fun afficheDetail() {
        // Récupérer l'art ASCII
        val art = espece.afficheArt()
        println(espece.afficheArt())
        // Découper l'art en lignes
        val artLines = art.split("\n")

        // Construire la liste des caractéristiques
        val details = listOf(
            "Nom : $nom",
            "Niveau : $niveau",
            "PV : $pv / $pvMax",
            "Attaque : $attaque",
            "Défense : $defense",
            "Vitesse : $vitesse",
            "Attaque spéciale : $attaqueSpe",
            "Défense spéciale : $defenseSpe",
            "Potentiel : $potentiel",
            "Expérience : $exp"
        )

        // Trouver la largeur maximale de l'art
        var maxArtWidth = 0

        for (artLine in artLines) {
            if (artLine.length > maxArtWidth) {
                maxArtWidth = artLine.length
            }
        }

        // Nombre maximal de lignes à afficher
        val maxLines = maxOf(artLines.size, details.size)

        // Afficher l'art et les détails
        for (i in 0 until maxLines) {

            // Récupérer la ligne de l'art
            val artLine = if (i < artLines.size) {
                artLines[i]
            } else {
                ""
            }

            // Récupérer la ligne de détail
            val detailLine = if (i < details.size) {
                details[i]
            } else {
                ""
            }

            // Ajouter des espaces après l'art
            val paddedArt = artLine.padEnd(maxArtWidth + 4)

            // Afficher
            println( detailLine)
        }
    }
}



