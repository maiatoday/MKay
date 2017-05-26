package net.maiatoday.mkay.model

/**
 * Location class, don't use a data class because it makes multiple constructors which confuses Room
 * Created by maia on 2017/05/26.
 */

class Location(val latitude: Float, val longitude: Float)
