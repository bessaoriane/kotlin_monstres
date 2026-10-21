package monde

import dresseur.Entraineur
import jeu.CombatMonstre
import monstres.EspeceMonstres
import monstres.IndividuMonstre
import kotlin.random.Random

class Zone(
    var id: Int,
    var nom: String,
    var expZone: Int,
    var especesMonstres: MutableList<EspeceMonstres> = mutableListOf(),
    var zoneSuivante: Zone?,
    var zonePrecedente: Zone?,
) {

    /**
     * Génère un individu monstre appartenant à l'une des espèces de la zone de façon aléatoire.
     * Son expérience est égale à l'expérience de la zone (+ ou - 20%).
     * @return Le monstre sauvage généré.
     */
    fun genereMonstre(): IndividuMonstre {
        val choixEspece = especesMonstres.random()
        val ecartExp = Random.nextDouble(-0.20, 0.20)
        val xpCalculee = expZone.toDouble() * (1.0 + ecartExp)

        return IndividuMonstre(
            id = Random.nextInt(1, 10000),
            nom = choixEspece.nom,
            espece = choixEspece,
            entraineur = null, // C'est un monstre sauvage, il n'a pas d'entraîneur au départ
            expInit = xpCalculee.coerceAtLeast(0.0)
        )
    }

    /**
     * Démarre un combat entre un monstre sauvage généré et le premier monstre
     * de l'équipe du joueur qui a des PV > 0.
     * @param joueur L'entraîneur (le joueur) qui affronte le monstre sauvage.
     */
    fun rencontreMonstre(joueur: Entraineur) {
        // 1. Appeler genereMonstre() et stocker dans monstreSauvage
        val monstreSauvage = genereMonstre()

        // 2. Rechercher le premier monstre du joueur avec PV > 0
        val monstreCombattant = joueur.equipeMonstre.firstOrNull { it.pv > 0 }

        if (monstreCombattant != null) {
            // 3. Créer un objet CombatMonstre
            val combat = CombatMonstre(
                monstreJoueur = monstreCombattant,
                monstreSauvage = monstreSauvage
            )

            // 4. Appeler combat.lanceCombat()
            combat.lanceCombat()
        } else {
            println("Impossible de lancer le combat : aucun monstre de l'équipe n'a de PV > 0 !")
        }
    }
}

