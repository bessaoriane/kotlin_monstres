package monde

import monstres.EspeceMonstres

class Zone(
    var id : Int,
    var nom : String,
    var expZone : Int,
    var especesMonstres : MutableList<EspeceMonstres> = mutableListOf(),
    var zoneSuivante : Zone?=null,
    var zonePrecedante : Zone?=null
){
    fun genererMonstre(){

    }

    fun rancontreMonstre(){


  }
}

