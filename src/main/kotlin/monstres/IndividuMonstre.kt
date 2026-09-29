package monstres

import dresseur.Entraineur
import kotlin.random.Random
import kotlin.math.pow
import kotlin.math.roundToInt

class IndividuMonstre(
    val id: Int,
    val nom: String,
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

}



