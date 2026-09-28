package monde

import monstres.EspeceMonstres

class Zone(
    var id : Int,
    var nom : String,
    var expZone : Int,
    var especesMonstres : MutableList<EspeceMonstres> = mutableListOf(),
    var zoneSuivante : Zone?,
    var zonePrecedante : Zone?

)

