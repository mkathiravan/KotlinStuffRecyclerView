package net.kathir.myapplication

class PersonModel
{
    var name: String? = null

    fun getNames():String
    {
        return name.toString()
    }

    fun setNames(name: String)
    {
        this.name = name;
    }

}