package monstres

import dresseur.Entraineur

class IndividuMonstre(
    val id: Int,
    val nom: String,
    val espece: EspeceMonstres,
    var entraineur: Entraineur?=null,
    val expInit: Double
    )