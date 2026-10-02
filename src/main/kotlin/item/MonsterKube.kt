package item

import dresseur.Entraineur
import joueur
import monstres.IndividuMonstre
import kotlin.random.Random

class MonsterKube(
    id: Int,
    nom: String,
    description: String,
    var chanceCapture: Double,
) : Item(id, nom, description), Utilisable {
    override fun utiliser(cible: IndividuMonstre): Boolean {
        println("vous lancer le MonsterKube")

        if (cible.entraineur != null) {
            println("Le monstre ne peut pas etre capturer")
        }

        val nbAleatoire = Random.nextDouble(0.0, 100.0)
        if (nbAleatoire <= chanceCapture) {
            println("Le monstre est capturé !")

            println("Entrer un nouveau nom :")
            val nouveauNom = readln()

            if (nouveauNom.isNotEmpty()) {
                cible.nom = nouveauNom
            }

            if (joueur.equipeMonstre.size >= 6) {
                joueur.boiteMonstre.add(cible)
            } else {
                joueur.equipeMonstre.add(cible)
            }

            cible.entraineur = joueur
        } else {
            println("Presque ! Le Kube n'a pas pu capturer le monstre !")
            return false
        }

    }
}

